package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.DBCustomer;
import org.academiadecodigo.javabank.model.domain.account.Account;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CustomerHandler implements CustomerService{
    //Fields
    //private AccountManager accountManager;
    private DBCustomer dbCustomer;
    private AccountHandler accountHandler;

    //Constructor
    public CustomerHandler(DBCustomer dbCustomer) {
        this.dbCustomer = dbCustomer;
    }

    //Custom Methods
    private int nextId(){
        return dbCustomer.getCustomers().isEmpty() ? 1 : dbCustomer.getCustomers().size() + 1;
    }


    @Override
    public Customer get(Integer id) {
        return dbCustomer.getCustomers().get(id);
    }

    @Override
    public List<Customer> list() {
        List<Customer> listCustomers = new LinkedList<>();
        for (Integer integer : dbCustomer.getCustomers().keySet()) {
            listCustomers.add(dbCustomer.getCustomers().get(integer));
        }

        return listCustomers;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return dbCustomer.getCustomers().get(id).getAccounts();
    }

    @Override
    public double getBalance(int customerId) {
        return accountHandler.getDbAccount().getAccounts().get(customerId).getBalance();
    }

    public double getTotalBalance() {
        double balance = 0;
        for (Account account : accountHandler.getDbAccount().getAccounts().values()) {
            balance += account.getBalance();
        }
        return balance;
    }

    @Override
    public void addCustomer(Customer customer) {
        dbCustomer.getCustomers().put(nextId(), customer);
    }
}
