package org.academiadecodigo.javabank.presenter;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.presenter.oper.PresenterBalance;
import org.academiadecodigo.javabank.presenter.oper.PresenterDeposit;
import org.academiadecodigo.javabank.presenter.oper.PresenterOpenAccount;
import org.academiadecodigo.javabank.presenter.oper.PresenterWithDraw;
import org.academiadecodigo.javabank.view.ViewMenu;

import java.util.HashMap;
import java.util.Map;

public class PresenterMenu extends AbsPresenter{
    //Fields
    private final ViewMenu viewMenu = new ViewMenu();
    private BankApplication bankApplication;
    private Map<Integer, Oper> operationsMap;

    //Constructor
    public PresenterMenu(Bank bank, BankApplication bankApplication){
        super(bank);
        this.bankApplication = bankApplication;
        operationsMap = buildOperationsMap();
    }

    //Custom Methods
    public void userChoice(){
        int choice = viewMenu.showMenu(UserOptions.getMessages());
        operationsMap.get(choice).execute();
    }

    private Map<Integer, Oper> buildOperationsMap() {

        Map<Integer, Oper> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new PresenterBalance(bank, bankApplication));
        map.put(UserOptions.DEPOSIT.getOption(), new PresenterDeposit(bank, bankApplication));
        map.put(UserOptions.WITHDRAW.getOption(), new PresenterWithDraw(bank, bankApplication));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new PresenterOpenAccount(bank, bankApplication));

        return map;
    }

}
