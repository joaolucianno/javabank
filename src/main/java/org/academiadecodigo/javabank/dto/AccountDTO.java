package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.persistence.model.account.AccountType;

public class AccountDTO {
    //Fields
    private Integer id;
    private Double balance;
    private AccountType accountType;

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
