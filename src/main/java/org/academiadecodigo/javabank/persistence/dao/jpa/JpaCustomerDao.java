package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.TransactionManager;

public class JpaCustomerDao extends AbstractDao<Customer>{
    //Constructor
    public JpaCustomerDao(TransactionManager tm) {
        super(tm, Customer.class);
    }
}
