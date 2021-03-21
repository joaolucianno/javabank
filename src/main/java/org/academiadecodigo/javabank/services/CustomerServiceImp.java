package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.GenericDao;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class CustomerServiceImp extends AbstractService<Customer> implements CustomerService {

    /**
     *
     * @param dao
     */
    public CustomerServiceImp(GenericDao dao) {
        super(dao);

    }

    /**
     *
     * @param id the customer id
     * @return
     */
    @Override
    public double getBalance(Integer id) {
        Customer customer = Optional.ofNullable(dao.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));

        return customer
                .getAccounts()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();

    }

    /**
     *
     * @param id the customer id
     * @return
     */
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        Customer customer = Optional.ofNullable(dao.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));

        return customer.getAccounts().stream()
                    .map(Account::getId)
                    .collect(Collectors.toSet());

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Customer getCustomer(Integer id) {
        Customer customer = Optional.ofNullable(dao.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));
        return customer;

    }

    /**
     *
     * @param customer
     * @return
     */
    @Override
    public Customer add(Customer customer) {
        return dao.save(customer);

    }
}
