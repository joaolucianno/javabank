package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.account.Account;
import org.academiadecodigo.javabank.view.ViewBalance;

import java.util.Set;

public class PresenterBalance extends AbsPresenterOper {
    //Fields
    private final ViewBalance viewBalance = new ViewBalance();


    //Constructor
    public PresenterBalance(Bank bank, BankApplication bankApplication) {
        super(bank, bankApplication);
    }

    //Custom Methods
    @Override
    public void execute() {
        Set<Account> accounts = bankApplication.getBank()
                .getCustomer(bankApplication.getAccessingCustomerId())
                .getAccounts();

        viewBalance.showBalance(accounts);
    }

}
