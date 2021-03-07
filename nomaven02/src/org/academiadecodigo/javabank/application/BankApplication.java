package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.model.domain.Customer;
import org.academiadecodigo.javabank.model.domain.DBCustomer;
import org.academiadecodigo.javabank.presenter.PresenterLogin;
import org.academiadecodigo.javabank.presenter.PresenterMenu;
import org.academiadecodigo.javabank.services.AuthHandler;
import org.academiadecodigo.javabank.services.CustomerHandler;

import java.util.Map;

/**
 * The bank application
 */
public class BankApplication {

    private Map<Integer, Operation> operationsMap;
    //private Bank bank;
    private int accessingCustomerId;

    //Exercise
    private PresenterLogin login;
    private PresenterMenu menu;
    private AuthHandler authHandler = new AuthHandler();
    private CustomerHandler customerHandler;

    /**
     * Creates a new instance of a {@code BankApplication}, initializes it with the given {@link Bank}
     *
     * @param
     */
    public BankApplication(DBCustomer dbCustomer) {
        customerHandler = new CustomerHandler(dbCustomer);
        authHandler.setCustomerHandler(customerHandler);
        login = new PresenterLogin();
        login.setAuthHandler(authHandler);
        menu = new PresenterMenu(authHandler);


    }

    /**
     * Gets the prompt used for the UI
     *
     * @return the prompt
     */
//    public Prompt getPrompt() {
//        return prompt;
//    }

    /**
     * Gets the bank used by this application
     *
     * @return the bank
     */
//    public Bank getBank() {
//        return bank;
//    }

    /**
     * Gets the id of the customer using the Bank Application
     *
     * @return the customer id
     */
//    public int getAccessingCustomerId() {
//        return accessingCustomerId;
//    }

    /**
     * Starts the bank application
     */
    public void start() {
        accessingCustomerId = login.verifyLogin();

        menuLoop();
    }

    private void menuLoop() {

        menu.userChoice();

//        if (userChoice == UserOptions.QUIT.getOption()) {
//
//            return;
//        }


        menuLoop();
    }

//    private int scanCustomerId() {
//
//        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
//        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
//        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);
//
//        return prompt.getUserInput(scanner);
//    }

//    private MenuInputScanner buildMainMenu() {
//
//        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
//        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
//        mainMenu.setMessage(Messages.MENU_WELCOME);
//
//        return mainMenu;
//    }

//    private Map<Integer, Operation> buildOperationsMap() {
//
//        Map<Integer, Operation> map = new HashMap<>();
//        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceOperation(this));
//        map.put(UserOptions.DEPOSIT.getOption(), new DepositOperation(this));
//        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawOperation(this));
//        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new NewAccountOperation(this));
//
//        return map;
//    }
}
