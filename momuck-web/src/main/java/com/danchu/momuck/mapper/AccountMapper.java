package com.danchu.momuck.mapper;

import com.danchu.momuck.dao.AccountDao;
import com.danchu.momuck.vo.Account;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

/**
 * AccountMapper
 *
 * @author geine
 */
@Repository
public class AccountMapper implements AccountDao {

	private static final Logger LOG = LoggerFactory.getLogger(AccountMapper.class);
	private static final String NAMESPACE = "User";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Account insertAccount(Account account) {
		try {
			sqlSessionTemplate.insert(NAMESPACE + ".insertUser", account);
		} catch (DuplicateKeyException e) {
			return null;
		}
		return account;
	}

	public int deleteAccount(String email) {
		return sqlSessionTemplate.delete(NAMESPACE + ".deleteUser", email);
	}

	public Account selectAccount(String email) {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".selectUserByEmail", email);
	}

	public int updateAccountVerify(String email) {
		return sqlSessionTemplate.update(NAMESPACE + ".updateUserVerify", email);
	}
}
