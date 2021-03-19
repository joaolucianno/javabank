package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

/**
 * An {@link CustomerService} implementation
 */
public class CustomerServiceImpl implements CustomerService {

    private EntityManagerFactory emf;

    /**
     * @see CustomerService#get(Integer)
     */
    @Override
    //==================================================================================== OK
    public Customer get(Integer id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Customer.class, id);
        } finally {
            if(em != null){
                em.close();
            }
        }

    }

    /**
     * @see CustomerService#list()
     */
    @Override
    public List<Customer> list() {
        //return new ArrayList<>(customerMap.values());
        return null;
    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Override
    //==================================================================================== OK
    public Set<Integer> listCustomerAccountIds(Integer id) {
        EntityManager em = emf.createEntityManager();

        try{
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<AbstractAccount> criteriaQuery = builder.createQuery(AbstractAccount.class);
            Root<AbstractAccount> root = criteriaQuery.from(AbstractAccount.class);
            criteriaQuery.select(root);
            criteriaQuery.where(builder.equal(root.get("customer"), id));
            List<AbstractAccount> accountList = em.createQuery(criteriaQuery).getResultList();
            return accountList.stream()
                    .map(Model::getId)
                    .collect(Collectors.toSet());
        } catch (RollbackException ex){
            em.getTransaction().rollback();

        } finally {
            em.close();
        }

        return null;

    }

    /**
     * @see CustomerService#getBalance(int)
     */
    @Override
    //==================================================================================== OK
    public double getBalance(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            CriteriaBuilder builder = emf.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = builder.createQuery(AbstractAccount.class);
            Root<Double> root = criteriaQuery.from(AbstractAccount.class);
            criteriaQuery.select(root);
            criteriaQuery.where(builder.equal(root.get("customer"), id));
            List<Account> accounts = em.createQuery(criteriaQuery).getResultList();

            return accounts.stream()
                    .mapToDouble(Account::getBalance)
                    .sum();
        } finally {
            em.close();
        }
    }

    //==================================================================================== OK
    public List<Account> getAccounts(int id){
        EntityManager em = emf.createEntityManager();

        try{
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Account> criteriaQuery = builder.createQuery(Account.class);
            Root<AbstractAccount> root = criteriaQuery.from(AbstractAccount.class);
            criteriaQuery.select(root);
            criteriaQuery.where(builder.equal(root.get("customer"), id));
            return em.createQuery(criteriaQuery).getResultList();

        } catch (RollbackException ex){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return null;
    }

    /**
     * @see CustomerService#add(Customer)
     */
    @Override
    //==================================================================================== OK
    public void add(Customer customer) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();

        } catch (RollbackException ex){
            em.getTransaction().rollback();

        } finally {
            if(em != null){
                em.close();
            }

        }
//        if (customer.getId() == null) {
//            customer.setId(getNextId());
//        }
//
//        customerMap.put(customer.getId(), customer);
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
