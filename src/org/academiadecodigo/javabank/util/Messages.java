package org.academiadecodigo.javabank.util;

public class Messages {
    //Static Fields
    public static final String WELCOME = "====== Java Bank ======";
    public static final String DIVISOR = "———————————————————————";
    public static final String EXIT = Color.RED + "Exit";
    public static final String ACCOUNTS = Color.BLUE + "You have the following accounts: " + Color.RESET;
    public static final String CHOOSE_ACCOUNT = Color.BLUE + "Please insert your account number: " + Color.RESET;
    public static final String AMOUNT = Color.BLUE + "Please insert amount: " + Color.RESET;
    public static final String CREATE_ACCOUNT = Color.GREEN + "\nCreated account id ";
    public static final String NO_ACCOUNT = Color.RED + "\nOpen a bank account first, please!" + Color.RESET;
    public static final String NO_CLIENTS = Color.RED + "\nCreate user first, please!" + Color.RESET;
    public static final String NO_EXIST = Color.RED + "\nCustomer does not exist" + Color.RESET;
    public static final String ERROR = Color.RED + "\nInvalid Option" + Color.RESET;
    public static final String NO_MONEY = Color.RED + "\nYou don't have enough money" + Color.RESET;
    public static final String SUCCESSFUL = Color.GREEN + "\nOperation successful" + Color.RESET;
    public static final String[] OPT_INITIAL = {
            "Sign In",
            "Sign Up",
            "Exit"
    };
    public static final String[] OPT_MENU = {
            "View Balance",
            "Make Deposit",
            "Make Withdrawal",
            "Open Account",
            "Back"
    };



}
