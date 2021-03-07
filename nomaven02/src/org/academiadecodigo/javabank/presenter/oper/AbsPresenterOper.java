package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.presenter.AbsPresenter;
import org.academiadecodigo.javabank.presenter.Oper;

public abstract class AbsPresenterOper implements Oper {
    protected Customer customer;


    public AbsPresenterOper(Customer customer) {
        this.customer = customer;
    }

    public boolean hasAccount(){
        return !customer.getAccounts().isEmpty();
    }
}
