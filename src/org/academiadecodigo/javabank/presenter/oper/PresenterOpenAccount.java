package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.account.AccountType;
import org.academiadecodigo.javabank.view.ViewOpenAccount;

public class PresenterOpenAccount extends AbsPresenterOper {
    //Fields
    private final ViewOpenAccount viewOpenAccount = new ViewOpenAccount();

    //Constructor
    public PresenterOpenAccount(Bank bank, BankApplication bankApplication) {
        super(bank, bankApplication);
    }

    //Custom Methods

    @Override
    public void execute() {
        Customer customer = bankApplication.getBank().getCustomer(bankApplication.getAccessingCustomerId());
        int accountId = customer.openAccount(AccountType.CHECKING);
        viewOpenAccount.showOpenAccount(accountId);


    }
}
