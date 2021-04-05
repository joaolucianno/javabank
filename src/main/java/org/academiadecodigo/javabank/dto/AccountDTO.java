package org.academiadecodigo.javabank.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.academiadecodigo.javabank.persistence.model.account.AccountType;

@JsonIgnoreProperties(value = {"customerId"})
public class AccountDTO {
    //Fields
    private Integer id;
    private Double balance;
    private AccountType accountType;
    private CustomerDTO customerId;

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

    public CustomerDTO getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerDTO customerId) {
        this.customerId = customerId;
    }
}
