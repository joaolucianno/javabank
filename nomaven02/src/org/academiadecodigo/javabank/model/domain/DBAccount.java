package org.academiadecodigo.javabank.model.domain;

import org.academiadecodigo.javabank.model.domain.account.Account;

import java.util.HashMap;
import java.util.Map;

public class DBAccount {
    //Fields
    private Map<Integer, Account> accounts = new HashMap<>();

    //Getters
    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
