package org.academiadecodigo.javabank.presenter;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.NewAccountOperation;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.application.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.application.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
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
        Customer customer = bankApplication.getBank()
                .getCustomer(bankApplication.getAccessingCustomerId());
        Map<Integer, Oper> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new PresenterBalance(bank, bankApplication, customer));
        map.put(UserOptions.DEPOSIT.getOption(), new PresenterDeposit(bank, bankApplication, customer));
        map.put(UserOptions.WITHDRAW.getOption(), new PresenterWithDraw(bank, bankApplication, customer));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new PresenterOpenAccount(bank, bankApplication, customer));

        return map;
    }

}
