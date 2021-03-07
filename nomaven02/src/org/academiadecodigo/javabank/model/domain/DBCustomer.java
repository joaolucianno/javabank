package org.academiadecodigo.javabank.model.domain;

import org.academiadecodigo.javabank.model.domain.Customer;

import java.util.HashMap;

public class DBCustomer {
    //Fields
    private HashMap<Integer, Customer> customers;

    //Constructor
    public DBCustomer(){
        customers = new HashMap<>();
    }

    //Custom Methods
    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

}
