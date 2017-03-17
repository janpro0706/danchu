package com.danchu.momuck.service;

import com.danchu.momuck.dao.AccountDao;
import com.danchu.momuck.vo.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        return accountDao.insertAccount(account);
    }
}
