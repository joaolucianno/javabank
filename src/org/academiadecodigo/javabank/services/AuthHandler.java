package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;

import java.util.Set;

public class AuthHandler implements AuthService{
    //Fields
    Bank bank;

    //Constructor
    public AuthHandler(Bank bank){
        this.bank = bank;
    }

    //Custom Methods
    @Override
    public boolean authenticate(Integer id) {
        Set<Integer> ids = bank.getCustomerIds();
        for (Integer integer : ids) {
            if(id == integer){
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer getAccessingCustomer() {
        return null;
    }
}
