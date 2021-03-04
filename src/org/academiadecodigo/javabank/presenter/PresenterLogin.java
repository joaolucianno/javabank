package org.academiadecodigo.javabank.presenter;

import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.view.ViewLogin;

import static org.academiadecodigo.javabank.application.Messages.*;

public class PresenterLogin extends AbsPresenter{
    //Fields
    private final ViewLogin viewLogin = new ViewLogin();;

    //Constructor
    public PresenterLogin(Bank bank){
        super(bank);
    }

    //Custom Methods
    public int verifyLogin(){
        int id = viewLogin.showLogin();
        Customer user; user = bank.getCustomer(id);
        if(user == null){
            viewLogin.showError();
            verifyLogin();
            return -1;
        }
        viewLogin.printMessage(SUCCESSFUL);
        return id;
    }


}
