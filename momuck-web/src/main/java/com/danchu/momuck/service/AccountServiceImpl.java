package com.danchu.momuck.service;

import com.danchu.momuck.dao.AccountDao;
import com.danchu.momuck.domain.LoginResult;
import com.danchu.momuck.vo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * AccountServiceImpl
 *
 * @author geine
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

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
}
