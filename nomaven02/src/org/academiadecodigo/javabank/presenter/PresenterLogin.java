package org.academiadecodigo.javabank.presenter;

import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.services.AuthHandler;
import org.academiadecodigo.javabank.view.ViewLogin;

import static org.academiadecodigo.javabank.application.Messages.*;

public class PresenterLogin{
    //Fields
    private final ViewLogin viewLogin = new ViewLogin();
    private AuthHandler authHandler;

    //Setters
    public void setAuthHandler(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    //Custom Methods
    public int verifyLogin(){
        int id = viewLogin.showLogin();
        if(!authHandler.authenticate(id)){
            viewLogin.showError();
            verifyLogin();
            return -1;
        }

//        if(user == null){
//            viewLogin.showError();
//            verifyLogin();
//            return -1;
//        }
        viewLogin.printMessage(authHandler.getAccessingCustomer().getName());
        return id;
    }


}
