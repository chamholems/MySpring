package com.test.dao;

import com.test.pojo.Account;

public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;

}
