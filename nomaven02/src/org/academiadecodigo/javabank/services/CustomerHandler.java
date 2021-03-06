package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.DBBank;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CustomerHandler implements CustomerService{
    //Fields
    //private AccountManager accountManager;
    private DBBank dbBank;
    private AccountHandler accountHandler;

    //Constructor
    public CustomerHandler(DBBank dbBank) {
        this.dbBank = dbBank;
    }

    @Override
    public Customer get(Integer id) {
        return dbBank.getCustomers().get(id);
    }

    @Override
    public List<Customer> list() {
        List<Customer> listCustomers = new LinkedList<>();
        for (Integer integer : dbBank.getCustomers().keySet()) {
            listCustomers.add(dbBank.getCustomers().get(integer));
        }

        return listCustomers;
    }

    @Override
    public List<Integer> listCustomerAccountIds(Integer id) {
        return accountHandler.getDbAccount().getAccounts();
    }

    @Override
    public double getBalance(int customerId) {

        return 0;
    }

    @Override
    public void addCustomer(Customer customer) {
        dbBank.getCustomers().put()
    }
}
