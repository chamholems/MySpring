package com.test.service.impl;

import com.test.dao.AccountDao;
import com.test.dao.impl.JdbcAccountDaoImpl;
import com.test.pojo.Account;
import com.test.service.TransferService;
import com.test.utils.TransactionManager;

public class TransferServiceImpl implements TransferService {

//    private AccountDao accountDao = new JdbcAccountDaoImpl();
    /**
     * 仅仅声明dao层接口
     */
    private AccountDao accountDao;
//    private TransactionManager transactionManager;

    /**
     * 提供set方法供外部注入dao层实现类对象
     * @param accountDao
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

//        try{
//            // 开启事务(关闭事务的自动提交)
//            transactionManager.beginTransaction();

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);

        accountDao.updateAccountByCardNo(to);
        int c = 1/0;
        accountDao.updateAccountByCardNo(from);

//        // 提交事务
//
//            transactionManager.commit();
//        }catch (Exception e) {
//            e.printStackTrace();
//            // 回滚事务
//            transactionManager.rollback();
//
//            // 抛出异常便于上层servlet捕获
//            throw e;
//
//        }

    }
}
