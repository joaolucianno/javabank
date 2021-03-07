package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.DBAccount;
import org.academiadecodigo.javabank.model.domain.DBCustomer;
import org.academiadecodigo.javabank.model.domain.account.Account;
import org.academiadecodigo.javabank.model.domain.account.AccountType;
import org.academiadecodigo.javabank.model.factories.AccountFactory;
import org.academiadecodigo.javabank.services.AccountHandler;
import org.academiadecodigo.javabank.view.ViewOpenAccount;

public class PresenterOpenAccount extends AbsPresenterOper {
    //Fields
    private final ViewOpenAccount viewOpenAccount = new ViewOpenAccount();
    private AccountHandler accountHandler;

    //Constructor
    public PresenterOpenAccount(Customer customer) {
        super(customer);
        accountHandler = new AccountHandler();
    }

    //Custom Methods
//    public void setAccountHandler(AccountHandler accountHandler) {
//        this.accountHandler = accountHandler;
//    }

    @Override
    public void execute() {
        Account newAcc = new AccountFactory().createAccount(AccountType.CHECKING);
        accountHandler.add(newAcc);
        viewOpenAccount.showOpenAccount(newAcc.getId());

    }
}
