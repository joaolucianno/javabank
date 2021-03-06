package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.view.ViewBalance;


public class PresenterBalance extends AbsPresenterOper {
    //Fields
    private final ViewBalance viewBalance = new ViewBalance();


    //Constructor
    public PresenterBalance(Bank bank, BankApplication bankApplication, Customer customer) {
        super(bank, bankApplication, customer);
    }

    //Custom Methods
    @Override
    public void execute() {
        if(!hasAccount()){
            viewBalance.error();
            return;
        }

        viewBalance.showBalance(customer.getAccounts());
    }

}
