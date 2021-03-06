package org.academiadecodigo.javabank.application;

import static org.academiadecodigo.javabank.view.Color.*;

/**
 * Messages to be used throughout the application
 */
public class Messages {

    public final static String MENU_WELCOME = "Welcome to Java Bank";
    public static final String MENU = "======== MENU ========";
    public final static String MENU_OPEN_ACCOUNT = "Open Account";
    public final static String MENU_DEPOSIT = "Make Deposit";
    public final static String MENU_WITHDRAW = "Make Withdrawal";
    public final static String MENU_GET_BALANCE = "View Balance";
    public final static String MENU_QUIT = "Quit";

    public final static String OPEN_ACCOUNTS = "You have the following accounts: ";
    public final static String CREATED_ACCOUNT = "Created account for ";
    public final static String CHOOSE_ACCOUNT = "Please insert your account number: ";
    public final static String CHOOSE_AMOUNT = "Please insert amount: ";
    public final static String CHOOSE_CUSTOMER = "Please insert your customer number: ";
    public final static String BALANCE_MESSAGE = " balance ";
    public final static String BALANCE_TOTAL_MESSAGE = "Total Balance: ";

    public static final String LOGGED = GREEN + "Logged in\n" + RESET;
    public static final String SUCCESSFUL = GREEN + "Resquest successful\n" + RESET;
    public static final String EXIT = RED + "\nExit";

    public final static String ERROR_INVALID_OPTION = RED + "That is an invalid option" + RESET;
    public final static String ERROR_INVALID_CUSTOMER = RED + "You do not seem to be a valid customer\n" + RESET;
    public final static String ERROR_NO_ACCOUNT = RED + "Open a bank account first, please!" + RESET;
    public final static String ERROR_INVALID_ACCOUNT = RED + "That is an invalid account!" + RESET;
    public final static String ERROR_INVALID_AMOUNT = RED + "That is an invalid amount!" + RESET;

}
