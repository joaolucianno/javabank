package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.domain.Customer;

public class AuthHandler implements AuthService{
    @Override
    public boolean authenticate(Integer id) {
        return false;
    }

    @Override
    public Customer getAccessingCustomer() {
        return null;
    }
}
