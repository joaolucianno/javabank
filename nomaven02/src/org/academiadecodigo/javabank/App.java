package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.DBCustomer;

public class App {

    public static void main(String[] args) {

        DBCustomer dbCustomer = new DBCustomer();

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        dbCustomer.getCustomers().put(c1.getId(), c1);
        dbCustomer.getCustomers().put(c2.getId(), c2);
        dbCustomer.getCustomers().put(c3.getId(), c3);


        BankApplication bankApplication = new BankApplication(dbCustomer);
        bankApplication.start();
    }
}
