package com.danchu.momuck.service;

import javax.mail.MessagingException;
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

	public void sendEmail(String email, String htmlMsg, String subject) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");
			helper.setTo(email);
			helper.setSubject(subject);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
			LOG.error(e.getStackTrace().toString());
			throw new RuntimeException(e);
		}
	}

	public void sendVerifyEmail(Account account) {

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

			sendEmail(account.getEmail(), htmlMsg, "MOMUCK 인증 메일");

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

	public int updatePassword(Account account) {

		int idx = 0;
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 6; i++) {
			idx = (int) (charSet.length * Math.random());
			sb.append(charSet[idx]);
		}

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		account.setPassword(bCryptPasswordEncoder.encode(sb.toString()));

		int updateCount = accountDao.updateAccountPassword(account);

		if (updateCount == 1) {
			String htmlMsg = "<p>임시 비밀번호는 " + sb.toString() + " 입니다</p>";
			sendEmail(account.getEmail(), htmlMsg, "MOMUCK 임시 비밀번호 메일");
		}

		return updateCount;

	}
}
