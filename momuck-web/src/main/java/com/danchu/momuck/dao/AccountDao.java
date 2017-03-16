package com.danchu.momuck.dao;

import com.danchu.momuck.vo.Account;

/**
 * AccountDao
 *
 * @author genie
 */
public interface AccountDao {

    Account insertAccount(Account account);

    void deleteAccount(String email);
}
