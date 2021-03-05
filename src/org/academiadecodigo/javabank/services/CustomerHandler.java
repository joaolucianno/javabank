package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;

import java.util.List;
import java.util.Set;

public class CustomerHandler implements CustomerService{
    //Fields
    private Bank bank;

    //Constructor
    public CustomerHandler(Bank bank) {
        this.bank = bank;
    }

    //Custom Methods
    @Override
    public Customer get(Integer id) {
        return bank.getCustomers().get(id);
    }

    @Override
    public List<Customer> list() {
        return bank.getCustomers();
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return bank.getCustomerIds();
    }

    @Override
    public double getBalance(int customerId) {
        return bank.getBalance();
    }

    @Override
    public void add(Customer customer) {
        bank.addCustomer(customer);
    }



}
