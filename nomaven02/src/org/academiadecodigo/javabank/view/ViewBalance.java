package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.model.domain.account.Account;

import java.text.DecimalFormat;
import java.util.*;

public class ViewBalance {
    //Fields
    private DecimalFormat df = new DecimalFormat("#.##");

    //Custom Methods
    public void showBalance(List<Account> accounts){
//        if(accounts.size() == 0){
//            System.out.println(Messages.ERROR_NO_ACCOUNT);
//            return;
//        }

        System.out.println(Color.CYAN + "\nBalance of all accounts" + Color.RESET);
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

    }

    public void error(){
        System.out.println(Messages.ERROR_NO_ACCOUNT);
    }

}
