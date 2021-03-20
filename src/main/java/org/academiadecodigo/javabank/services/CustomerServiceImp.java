package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.Dao;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A JPA {@link CustomerService} implementation
 */
public class CustomerServiceImp extends AbstractService<Customer> implements CustomerService {

    /**
     * @see AbstractService#(EntityManagerFactory, Class)
     */
    public CustomerServiceImp(Dao accountDao, Dao custumerDao) {
        super(accountDao, custumerDao);
    }

    /**
     * @see CustomerService#getBalance(Integer)
     */
    @Override
    public double getBalance(Integer id) {
        Customer customer = customerDao.get(id);
        return customer.getAccounts().stream().mapToDouble(Account::getBalance).sum();
//        EntityManager em = emf.createEntityManager();
//
//        try {
//
//            Customer customer = Optional.ofNullable(em.find(Customer.class, id))
//                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));
//
//            return customer.getAccounts().stream()
//                    .mapToDouble(Account::getBalance)
//                    .sum();
//
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }

    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        Customer customer = (Customer) Optional.ofNullable(customerDao.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));

        return customer.getAccounts().stream()
                    .map(Account::getId)
                    .collect(Collectors.toSet());



//        EntityManager em = emf.createEntityManager();
//
//        try {
//
//            Customer customer = Optional.ofNullable(em.find(Customer.class, id))
//                    .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));
//
//            return customer.getAccounts().stream()
//                    .map(Model::getId)
//                    .collect(Collectors.toSet());
//
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
        //return null;
    }

    @Override
    public Customer getCustomer(Integer id) {
        //Customer customer = Optional.ofNullable(customerDao.get(id));
        return customerDao.get(id);
    }

    @Override
    public Customer add(Customer customer) {
        return customerDao.save(customer);
    }
}
