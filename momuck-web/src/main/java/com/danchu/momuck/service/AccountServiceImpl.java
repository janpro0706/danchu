package com.danchu.momuck.service;

import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.danchu.momuck.dao.AccountDao;
import com.danchu.momuck.domain.LoginResult;
import com.danchu.momuck.util.AES256Util;
import com.danchu.momuck.vo.Account;

/**
 * AccountServiceImpl
 *
 * @author geine
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Value("#{systemProperties['email.secretkey']}")
    private String key;

    @Value("#{config['base_url']}")
    private String baseUrl;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AccountDao accountDao;

    public Account createAccount(Account account) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return accountDao.insertAccount(account);
    }

    public LoginResult login(Account account) {

        Account regAccount = accountDao.selectAccount(account.getEmail());

        if (regAccount == null) {
            return LoginResult.NOT_EXIST_EMAIL;
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);

        if (!bCryptPasswordEncoder.matches(account.getPassword(), regAccount.getPassword())) {
            return LoginResult.NOT_CORRECT_PASSWORD;
        }

        return LoginResult.SUCCESS;
    }

    public void sendEmail(Account account) {

        String normalString = account.getEmail() + ":" + account.getName();
        LOG.debug("sendmail", account.getEmail());

        try {
            AES256Util aes256 = new AES256Util(key);
            URLCodec codec = new URLCodec();
            String encString = codec.encode(aes256.aesEncode(normalString));

            String htmlMsg = "<p>이메일 계정을 인증받으시려면 아래 링크를 클릭해주세요</p>"
                    + "<a href=\""
                    + baseUrl
                    + "/momuck/accounts/verify/"
                    + encString
                    + "\">Verify Your Account!</a>";

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
            helper.setTo(account.getEmail());
            helper.setSubject("MOMUCK 이메일 주소 인증");
            mailSender.send(mimeMessage);

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getStackTrace().toString());
            throw new RuntimeException(e);
        }
    }

    public int verifyAccount(String verifyKey) {

        try {
            AES256Util aes256 = new AES256Util(key);
            URLCodec codec = new URLCodec();
            String decString = aes256.aesDecode(codec.decode(verifyKey));

            String[] user = decString.split(":");

            Account account = accountDao.selectAccount(user[0]);

            if (user[1].equals(account.getName())) {
                return accountDao.updateAccountVerify(account.getEmail());
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getStackTrace().toString());
            throw new RuntimeException(e);
        }

        return -1;
    }
}
