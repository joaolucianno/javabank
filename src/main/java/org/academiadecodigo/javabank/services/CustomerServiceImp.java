package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.GenericDao;

import javax.persistence.EntityManagerFactory;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A JPA {@link CustomerService} implementation
 */
public class CustomerServiceImp implements CustomerService {
    //Fields
    private GenericDao<Customer> customerDao;

    /**
     * @see AbstractService#(EntityManagerFactory, Class)
     */
    public CustomerServiceImp(GenericDao custumerDao) {
        this.customerDao = custumerDao;
    }

    /**
     * @see CustomerService#getBalance(Integer)
     */
    @Override
    public double getBalance(Integer id) {
        return customerDao.get(id)
                .getAccounts()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();

    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        Customer customer = Optional.ofNullable(customerDao.get(id))
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
