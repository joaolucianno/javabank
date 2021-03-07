package org.academiadecodigo.javabank.presenter;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.UserOptions;

import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.presenter.oper.PresenterBalance;
import org.academiadecodigo.javabank.presenter.oper.PresenterDeposit;
import org.academiadecodigo.javabank.presenter.oper.PresenterOpenAccount;
import org.academiadecodigo.javabank.presenter.oper.PresenterWithDraw;
import org.academiadecodigo.javabank.services.AuthHandler;
import org.academiadecodigo.javabank.view.ViewMenu;

import java.util.HashMap;
import java.util.Map;

public class PresenterMenu {
    //Fields
    private final ViewMenu viewMenu = new ViewMenu();
    private Map<Integer, Oper> operationsMap;
    private AuthHandler authHandler;


    //Constructor
    public PresenterMenu(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    //Custom Methods
    public void userChoice(){
        operationsMap = buildOperationsMap();
        int choice = viewMenu.showMenu(UserOptions.getMessages());
        if(choice == 5){
            viewMenu.quit();
            return;
        }
        operationsMap.get(choice).execute();

    }

    private Map<Integer, Oper> buildOperationsMap() {
        Customer customer = authHandler.getAccessingCustomer();
        Map<Integer, Oper> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new PresenterBalance(customer));
        map.put(UserOptions.DEPOSIT.getOption(), new PresenterDeposit(customer));
        map.put(UserOptions.WITHDRAW.getOption(), new PresenterWithDraw(customer));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new PresenterOpenAccount(customer));

        return map;
    }

}
