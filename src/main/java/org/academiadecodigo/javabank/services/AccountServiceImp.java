package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.Dao;
import org.academiadecodigo.javabank.services.AbstractService;
import org.academiadecodigo.javabank.services.AccountService;

import javax.persistence.EntityManagerFactory;

/**
 * A JPA {@link AccountService} implementation
 */
public class AccountServiceImp extends AbstractService<Account> implements AccountService {

    /**
     * @see AbstractService#(EntityManagerFactory, Class)
     */
    public AccountServiceImp(Dao accountDao, Dao custumerDao) {
        super(accountDao, custumerDao);
    }

    /**
     * @see AccountService#deposit(Integer, double)
     */
    @Override
    public void deposit(Integer id, double amount) {
        Account acc = (Account) accountDao.get(id);


//        EntityManager em = emf.createEntityManager();
//
//        try {
//
//            em.getTransaction().begin();
//
//            Optional<Account> account = Optional.ofNullable(em.find(AbstractAccount.class, id));
//
//            if (!account.isPresent()) {
//                em.getTransaction().rollback();
//            }
//
//            account.orElseThrow(() -> new IllegalArgumentException("invalid account id")).credit(amount);
//
//            em.getTransaction().commit();
//
//        } catch (RollbackException ex) {
//
//            em.getTransaction().rollback();
//
//        } finally {
//
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    /**
     * @see AccountService#withdraw(Integer, double)
     */
    @Override
    public void withdraw(Integer id, double amount) {

//        EntityManager em = emf.createEntityManager();
//
//        try {
//
//            em.getTransaction().begin();
//
//            Optional<Account> account = Optional.ofNullable(em.find(AbstractAccount.class, id));
//
//            if (!account.isPresent()) {
//                em.getTransaction().rollback();
//            }
//
//            account.orElseThrow(() -> new IllegalArgumentException("invalid account id")).debit(amount);
//
//            em.getTransaction().commit();
//
//        } catch (RollbackException ex) {
//
//            em.getTransaction().rollback();
//
//        } finally {
//
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    /**
     * @see AccountService#transfer(Integer, Integer, double)
     */
    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {

//        EntityManager em = emf.createEntityManager();
//
//        try {
//
//            em.getTransaction().begin();
//
//            Optional<Account> srcAccount = Optional.ofNullable(em.find(AbstractAccount.class,srcId ));
//            Optional<Account> dstAccount = Optional.ofNullable(em.find(AbstractAccount.class,dstId ));
//
//            if (!srcAccount.isPresent() || !dstAccount.isPresent()) {
//                em.getTransaction().rollback();
//            }
//
//            srcAccount.orElseThrow(() -> new IllegalArgumentException("invalid account id"));
//            dstAccount.orElseThrow(() -> new IllegalArgumentException("invalid account id"));
//
//            // make sure transaction can be performed
//            if (srcAccount.get().canDebit(amount) && dstAccount.get().canCredit(amount)) {
//                srcAccount.get().debit(amount);
//                dstAccount.get().credit(amount);
//            }
//
//            em.getTransaction().commit();
//
//        } catch (RollbackException ex) {
//
//            em.getTransaction().rollback();
//
//        } finally {
//
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    @Override
    public Account add(Account account) {
        return (Account) accountDao.save(account);
    }
}
