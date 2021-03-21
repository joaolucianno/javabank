package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.GenericDao;

import javax.persistence.EntityManagerFactory;

/**
 * A JPA {@link AccountService} implementation
 */
public class AccountServiceImp extends AbstractService<Account> implements AccountService {

    /**
     *
     * @param dao
     */
    public AccountServiceImp(GenericDao dao) {
        super(dao);
    }

    /**
     *
     * @param id     the id of the account
     * @param amount the amount to deposit
     */
    public void deposit(Integer id, double amount) {
        Account acc = dao.get(id);
        acc.credit(amount);
        dao.save(acc);

    }

    /**
     *
     * @param id     the id of the account
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(Integer id, double amount) {
        Account acc = dao.get(id);
        acc.debit(amount);
        dao.save(acc);

    }

    /**
     * @see AccountService#transfer(Integer, Integer, double)
     */
    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

    }

    @Override
    public Account add(Account account) {
        return dao.save(account);
    }
}
