package org.academiadecodigo.javabank.view;

import static org.academiadecodigo.javabank.application.Messages.*;
import static org.academiadecodigo.javabank.application.Messages.ERROR_INVALID_AMOUNT;

public class ViewWithDraw {
    public int chooseAccount(){
        PromptIntegerIO.prepareIO(CHOOSE_ACCOUNT, ERROR_INVALID_ACCOUNT);
        return PromptIntegerIO.getUserInput();
    }

    public double amount(){
        PromptDoubleIO.prepareIO(CHOOSE_AMOUNT, ERROR_INVALID_AMOUNT);
        return PromptDoubleIO.getUserInput();
    }

    public void error(int error){
        if(error == 1){
            System.out.println(ERROR_NO_ACCOUNT);
            return;
        }
        if(error == 2){
            System.out.println(ERROR_INVALID_ACCOUNT);
            return;
        }
        System.out.println(ERROR_INVALID_AMOUNT);


    }
}
