package org.academiadecodigo.javabank.presenter;

import org.academiadecodigo.javabank.model.domain.Bank;

public abstract class AbsPresenter {
    //Fields
    protected Bank bank;

    public AbsPresenter(Bank bank){
        this.bank = bank;
    }

}
