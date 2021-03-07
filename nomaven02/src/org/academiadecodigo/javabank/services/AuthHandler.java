package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.domain.Customer;

public class AuthHandler implements AuthService{
    //Fields
    private Customer customer;
    private CustomerHandler customerHandler;

    //Setters
    public void setCustomerHandler(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @Override
    public boolean authenticate(Integer id) {
        customer = customerHandler.get(id);
        return customer != null;

    }

    @Override
    public Customer getAccessingCustomer() {
        return customer;
    }
}
