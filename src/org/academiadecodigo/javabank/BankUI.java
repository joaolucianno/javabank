package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.util.Color;
import org.academiadecodigo.javabank.util.Menu;
import org.academiadecodigo.javabank.util.Messages;


public class BankUI {
    //Fields
    private Menu menu;
    private Customer user;
    private AccountManager accountManager;
    private Bank bank;
    private int range;
    private Prompt prompt;
    private IntegerInputScanner scanner1;
    private IntegerRangeInputScanner scanner2;


    //Constructor
    public BankUI(){
        menu = new Menu(Messages.OPT);
        accountManager = new AccountManager();
        user = new Customer("João");
        user.setAccountManager(accountManager);
        bank = new Bank(accountManager);
        range = 1;
        prompt = new Prompt(System.in, System.out);
        scanner1 = new IntegerInputScanner();
        scanner2 = new IntegerRangeInputScanner(1, range);
    }


    //Setters
    public void setRange(int range) {
        this.range = range;
    }


    //Custom Methods
    public void initialMenu(){
        menu.showMenu(Messages.WELCOME, Messages.ERROR);
        switch (menu.getUserInput()){
            case 1:
                viewBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withDraw();
                break;
            case 4:
                openAccount();
                break;
            default:
                quit();
                break;
        }
    }

    private void viewBalance(){
        hasAccount();
        if(user.getHowManyAccounts() > 1){
            System.out.println(Messages.DIVISOR);
            for (int i = 1; i <= user.getHowManyAccounts(); i++) {
                System.out.println("Account " + i + ": " + Color.GREEN + user.getBalance(i) + Color.RESET);
            }
            System.out.println(Messages.DIVISOR);
        }
        System.out.println("\nTotal amount: " + Color.GREEN + user.getBalance() + Color.RESET);
        initialMenu();
    }

    private void deposit(){
        hasAccount();
        int c = 1;
        if(user.getHowManyAccounts() > 1){
            System.out.println(Messages.ACCOUNTS + user.getHowManyAccounts());
            scanner2.setMessage(Messages.CHOOSE_ACCOUNT);
            c = prompt.getUserInput(scanner2);
        }

        scanner1.setMessage(Messages.AMOUNT);
        int amount = prompt.getUserInput(scanner1);
        accountManager.deposit(c, amount);
        System.out.println();
        initialMenu();
    }

    private void withDraw(){
        hasAccount();
        System.out.println(Messages.ACCOUNTS + user.getHowManyAccounts());
        //accountManager.withdraw();
    }

    private void openAccount(){
        int c = user.openAccount(AccountType.CHECKING);
        setRange(c);
        System.out.println(Messages.CREATE_ACCOUNT + user.getName() + ": " + c  + Color.RESET);
        initialMenu();
    }

    private boolean hasAccount(){
        if(user.getHowManyAccounts() < 1){
            System.out.println(Messages.NO_ACCOUNT);
            initialMenu();
            return false;
        }
        return true;
    }

    private void quit(){
        try {
            System.out.print("\n" + Messages.EXIT);
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            System.exit(0);
        } catch (InterruptedException ignore){}
    }



    //Main
    public static void main(String[] args) {
        BankUI bankUI = new BankUI();
        bankUI.initialMenu();

    }
}
