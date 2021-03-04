package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.model.domain.Customer;

import static org.academiadecodigo.javabank.application.Messages.*;

public class ViewLogin {

    public int showLogin(){
        System.out.println(MENU_WELCOME);
        PromptIntegerIO.prepareIO(CHOOSE_ACCOUNT, ERROR_INVALID_CUSTOMER);
        return PromptIntegerIO.getUserInput();
    }

    public void showError(){
        PromptIntegerIO.error();
    }

    public void printMessage(String name){
        System.out.println(name + ", " + MENU_WELCOME + ". You are " +LOGGED);
    }






}
