package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.Dao;

public class JpaCustomerDao extends AbstractDao<Customer> {
    //Constructor
    public JpaCustomerDao(TransactionManager tm) {
        super(tm, Customer.class);
    }
}
