package com.test.service.impl;

import com.test.dao.AccountDao;
import com.test.dao.impl.JdbcAccountDaoImpl;
import com.test.pojo.Account;
import com.test.service.TransferService;

public class TransferServiceImpl implements TransferService {

    private AccountDao accountDao = new JdbcAccountDaoImpl();

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        // 业务逻辑
        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);

        accountDao.updateAccountByCardNo(to);

        // 模拟异常
        int c = 1/0;
        accountDao.updateAccountByCardNo(from);


    }
}
