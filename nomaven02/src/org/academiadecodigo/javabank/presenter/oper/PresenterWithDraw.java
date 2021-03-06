package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.account.Account;
import org.academiadecodigo.javabank.view.ViewWithDraw;

import java.util.List;

public class PresenterWithDraw extends AbsPresenterOper {
    //Fields
    private final ViewWithDraw viewWithDraw = new ViewWithDraw();

    //Constructor
    public PresenterWithDraw(Bank bank, BankApplication bankApplication, Customer customer) {
        super(bank, bankApplication, customer);
    }

    //Custom Methods

    @Override
    public void execute() {
        if (!hasAccount()) {
            viewWithDraw.error(1);
            return;
        }

        //Account Validation
        Integer accountId = viewWithDraw.chooseAccount();
        if (!customer.getAccountIds().contains(accountId)) {
            viewWithDraw.error(2);
            return;
        }

        //Amount Validation
        Double amount = viewWithDraw.amount();
        if(amount > customer.getAccounts().get(accountId-1).getBalance()){
            viewWithDraw.error(3);
            return;
        }

        bank.getAccountManager().withdraw(accountId, amount);


    }
}
