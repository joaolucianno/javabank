package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.domain.DBAccount;
import org.academiadecodigo.javabank.model.domain.account.Account;

public class AccountHandler implements AccountService{
    //Fields
    private DBAccount dbAccount = new DBAccount();

    //Constructor
    public AccountHandler(){

    }

    //Getters
    public DBAccount getDbAccount() {
        return dbAccount;
    }


    //Setters



    //Custom Methods
    @Override
    public void add(Account account) {
        dbAccount.getAccounts().put(account.getId(), account);
    }

    @Override
    public void deposit(int id, double amount) {

    }

    @Override
    public void withdraw(int id, double amount) {

    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

    }
}
