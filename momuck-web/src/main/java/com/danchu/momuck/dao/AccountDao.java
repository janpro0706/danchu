package com.danchu.momuck.dao;

import com.danchu.momuck.vo.Account;

/**
 * AccountDao
 *
 * @author genie
 */
public interface AccountDao {

    Account insertAccount(Account account);

    int deleteAccount(String email);

    Account selectAccount(String email);
    
    int updateAccountVerify(String email);
    
    int updateAccountPassword(Account account);
    
}
