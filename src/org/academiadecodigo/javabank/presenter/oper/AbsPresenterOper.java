package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.presenter.AbsPresenter;
import org.academiadecodigo.javabank.presenter.Oper;

public abstract class AbsPresenterOper extends AbsPresenter implements Oper {
    protected BankApplication bankApplication;
    protected Customer customer;


    public AbsPresenterOper(Bank bank, BankApplication bankApplication, Customer customer) {
        super(bank);
        this.customer = customer;
        this.bankApplication = bankApplication;
    }

    public boolean hasAccount(){
        return bankApplication.getBank().getCustomer(bankApplication.getAccessingCustomerId())
                .getAccountIds().size() > 0;
    }
}
