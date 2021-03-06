package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.domain.Customer;

public interface AuthService {
    boolean authenticate(Integer id);
    Customer getAccessingCustomer();
}
