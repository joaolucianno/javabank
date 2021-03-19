package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.CheckingAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.swing.text.html.parser.Entity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * An {@link AccountService} implementation
 */
public class AccountServiceImpl implements AccountService {
    //Fields
    private EntityManagerFactory emf;
    private AuthService authService;
    private Map<Integer, Account> accountMap = new HashMap<>();


    /**
     * Gets the next account id
     *
     * @return the next id
     */
//    private Integer getNextId() {
//        return accountMap.isEmpty() ? 1 : Collections.max(accountMap.keySet()) + 1;
//    }

    /**
     * @see AccountService#add(Account)
     */
    //==================================================================================== OK
    public void add(Account account) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();

        } catch (RollbackException ex){
            em.getTransaction().rollback();

        } finally {
            em.close();

        }

//        if (account.getId() == null) {
//            account.setId(getNextId());
//        }

        accountMap.put(account.getId(), account);
    }

    /**
     * @see AccountService#deposit(int, double)
     */
    //==================================================================================== OK
    public void deposit(int id, double amount) {
        EntityManager em = emf.createEntityManager();
        Account acc = em.find(AbstractAccount.class, id);

        try{
            em.getTransaction().begin();
            acc.credit(amount);
            em.merge(acc);
            em.getTransaction().commit();


        } catch (RollbackException ex){
            em.getTransaction().rollback();

        } finally {
            em.close();
        }

    }

    /**
     * @see AccountService#withdraw(int, double)
     */
    //==================================================================================== OK
    public void withdraw(int id, double amount) {
        EntityManager em = emf.createEntityManager();
        Account acc = em.find(AbstractAccount.class, id);

        try{
            em.getTransaction().begin();
            acc.debit(amount);
            em.merge(acc);
            em.getTransaction().commit();

        } catch (RollbackException ex){
            em.getTransaction().rollback();
        }

    }

    /**
     * @see AccountService#transfer(int, int, double)
     */
    public void transfer(int srcId, int dstId, double amount) {

        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
