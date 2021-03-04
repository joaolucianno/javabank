package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.account.Account;
import org.academiadecodigo.javabank.presenter.AbsPresenter;
import org.academiadecodigo.javabank.view.PromptIntegerSetIO;
import org.academiadecodigo.javabank.view.ViewDeposit;

import java.util.List;

public class PresenterDeposit extends AbsPresenterOper {
    //Fields
    private final ViewDeposit viewDeposit = new ViewDeposit();

    //Constructor
    public PresenterDeposit(Bank bank, BankApplication bankApplication, Customer customer) {
        super(bank, bankApplication, customer);
    }

    //Custom Methods
    @Override
    public void execute() {
        if (!hasAccount()) {
            viewDeposit.error(1);
            return;
        }

        Integer accountId = viewDeposit.chooseAccount();
        if (!customer.getAccountIds().contains(accountId)) {
            viewDeposit.error(2);
            return;
        }


        bank.getAccountManager().deposit(accountId, viewDeposit.amount());




    }
}
