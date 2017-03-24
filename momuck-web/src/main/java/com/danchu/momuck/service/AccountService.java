package com.danchu.momuck.service;

import com.danchu.momuck.domain.LoginResult;
import com.danchu.momuck.vo.Account;

/**
 * AccountService
 *
 * @author geine
 */
public interface AccountService {

    Account createAccount(Account account);

    LoginResult login(Account account);
}
