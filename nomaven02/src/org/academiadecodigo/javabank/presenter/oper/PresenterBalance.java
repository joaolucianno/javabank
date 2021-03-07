package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.account.Account;
import org.academiadecodigo.javabank.services.AccountHandler;
import org.academiadecodigo.javabank.view.ViewBalance;

import java.util.LinkedList;
import java.util.List;


public class PresenterBalance extends AbsPresenterOper {
    //Fields
    private final ViewBalance viewBalance = new ViewBalance();
    private AccountHandler accountHandler;


    //Constructor
    public PresenterBalance(Customer customer) {
        super(customer);
    }

    //Custom Methods
    @Override
    public void execute() {
        if(!hasAccount()){
            viewBalance.error();
            return;
        }
        List<Account> accountList = new LinkedList<>(accountHandler.getDbAccount().getAccounts().values());


        viewBalance.showBalance(accountList);
    }

}
