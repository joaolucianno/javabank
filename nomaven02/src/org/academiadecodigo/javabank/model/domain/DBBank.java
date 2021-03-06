package org.academiadecodigo.javabank.model.domain;

import org.academiadecodigo.javabank.model.domain.Customer;

import java.util.HashMap;

public class DBBank {
    //Fields
    private HashMap<Integer, Customer> customers;

    //Constructor
    public DBBank(){
        customers = new HashMap<>();
    }

    //Custom Methods
    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

}
