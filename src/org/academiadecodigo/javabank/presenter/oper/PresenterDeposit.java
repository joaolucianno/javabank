package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.presenter.AbsPresenter;
import org.academiadecodigo.javabank.view.ViewDeposit;

public class PresenterDeposit extends AbsPresenterOper {
    //Fields
    private final ViewDeposit viewDeposit = new ViewDeposit();

    //Constructor
    public PresenterDeposit(Bank bank, BankApplication bankApplication) {
        super(bank, bankApplication);
    }

    //Custom Methods

    @Override
    public void execute() {

    }
}
