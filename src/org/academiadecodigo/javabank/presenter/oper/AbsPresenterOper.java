package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.presenter.AbsPresenter;
import org.academiadecodigo.javabank.presenter.Oper;

public abstract class AbsPresenterOper extends AbsPresenter implements Oper {
    protected BankApplication bankApplication;


    public AbsPresenterOper(Bank bank, BankApplication bankApplication) {
        super(bank);

        this.bankApplication = bankApplication;
    }
}
