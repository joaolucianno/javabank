package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.Set;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface CustomerService {

    /**
     * Gets the balance of the customer
     *
     * @param id the customer id
     * @return the balance of the customer with the given id
     */
    double getBalance(Integer id);

    /**
     * Gets the set of customer account ids
     *
     * @param id the customer id
     * @return the accounts of the given customer id
     */
    Set<Integer> listCustomerAccountIds(Integer id);

    /**
     *
     * @param id
     * @return
     */
    Customer getCustomer(Integer id);

    /**
     *
     * @param account
     * @return
     */
    Customer add(Customer account);
}
