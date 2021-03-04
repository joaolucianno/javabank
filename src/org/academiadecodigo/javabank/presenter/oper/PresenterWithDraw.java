package org.academiadecodigo.javabank.presenter.oper;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.view.ViewWithDraw;

public class PresenterWithDraw extends AbsPresenterOper {
    //Fields
    private final ViewWithDraw viewWithDraw = new ViewWithDraw();

    //Constructor
    public PresenterWithDraw(Bank bank, BankApplication bankApplication) {
        super(bank, bankApplication);
    }

    //Custom Methods

    @Override
    public void execute() {

    }
}
