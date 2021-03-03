package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.util.Color;
import org.academiadecodigo.javabank.util.Menu;
import org.academiadecodigo.javabank.util.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class BankUI {
    //Fields
    private Bank bank;
    private Menu menu;
    private int id;
    private Customer user;
    private AccountManager accountManager;
    private int range;
    private Prompt prompt;
    private IntegerInputScanner scanner1;
    private StringInputScanner scanner3;


    //Constructor
    public BankUI(){
        menu = new Menu();
        accountManager = new AccountManager();
        bank = new Bank(accountManager);
        id = 1;
        range = 1;
        prompt = new Prompt(System.in, System.out);
        scanner1 = new IntegerInputScanner();
        scanner3 = new StringInputScanner();
    }


    //Setters
    public void setRange(int range) {
        this.range = range;
    }


    //Custom Methods
    public void initialMenu(){
        menu.setOPTIONS(Messages.OPT_INITIAL);
        menu.prepareMenu(Messages.WELCOME, Messages.ERROR);
        switch (menu.getUserInput()){
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            default:
                quit();
                break;
        }

    }

    public void mainMenu(){
        menu.setOPTIONS(Messages.OPT_MENU);
        menu.prepareMenu(Messages.WELCOME, Messages.ERROR);
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
                backToInitial();
                break;
        }
    }

    private void signIn(){
        if(bank.getCustomers().isEmpty()){
            System.out.println(Messages.NO_CLIENTS);
            initialMenu();
            return;
        }

        scanner1.setMessage("Please insert your id number: ");
        //int i = prompt.getUserInput(scanner1);
        user = getUser(prompt.getUserInput(scanner1));
        if(user == null){
            System.out.println(Messages.NO_EXIST);
            initialMenu();
            return;
        }
        System.out.println(Color.CYAN + "\nWelcome " + user.getName() + Color.RESET);
        mainMenu();
    }

    private void signUp(){
        scanner3.setMessage("Name: ");
        String name = prompt.getUserInput(scanner3);
        Customer newUser = new Customer(name, bank.getCustomers().size());
        newUser.setAccountManager(new AccountManager());
        bank.addCustomer(newUser);
        System.out.println(Color.GREEN + "Your ID is " + newUser.getId() + Color.RESET);
        initialMenu();
        return;
    }

    private void viewBalance(){
        if(!hasAccount()){
            mainMenu();
            return;
        }

        if(user.getHowManyAccounts() > 1){
            System.out.println(Messages.DIVISOR);
            for (int i = 1; i <= user.getHowManyAccounts(); i++) {
                System.out.println("Account " + i + ": " +
                        Color.GREEN + user.getBalance(i) + Color.RESET);
            }
            System.out.println(Messages.DIVISOR);
        }
        System.out.println("\nTotal amount: " +
                Color.GREEN + user.getBalance() + Color.RESET);
        mainMenu();
    }

    private void deposit(){
        if(!hasAccount()){
            mainMenu();
            return;
        }

        int c = 1;
        if(user.getHowManyAccounts() > 1){
            do{
                System.out.println(Messages.ACCOUNTS + user.getHowManyAccounts());
                scanner1.setMessage(Messages.CHOOSE_ACCOUNT);
                c = prompt.getUserInput(scanner1);
                if(c > user.getHowManyAccounts()) System.out.println(Messages.ERROR);
            } while (c > user.getHowManyAccounts());
        }

        scanner1.setMessage(Messages.AMOUNT);
        int amount = prompt.getUserInput(scanner1);
        user.getAccountManager().deposit(c, amount);
        mainMenu();
    }

    private void withDraw(){
        if(!hasAccount()){
            mainMenu();
            return;
        }

        int c = 1;
        if(user.getHowManyAccounts() > 1){
            do{
                System.out.println(Messages.ACCOUNTS + user.getHowManyAccounts());
                scanner1.setMessage(Messages.CHOOSE_ACCOUNT);
                c = prompt.getUserInput(scanner1);
                if(c > user.getHowManyAccounts()) System.out.println(Messages.ERROR);
            } while (c > user.getHowManyAccounts());
        }
        scanner1.setMessage(Messages.AMOUNT);
        int amount = prompt.getUserInput(scanner1);
        //System.out.println(Messages.ACCOUNTS + user.getHowManyAccounts());
        if(!user.getAccountManager().withdraw(c,amount)){
            System.out.println(Messages.NO_MONEY);
            mainMenu();
            return;
        }
        System.out.println(Messages.SUCCESSFUL);
        mainMenu();
    }

    private void openAccount(){
        int acc = user.openAccount(AccountType.CHECKING);
        System.out.println(Messages.CREATE_ACCOUNT + acc + " for " +
                user.getName() + ": " +
                user.getHowManyAccounts()  + Color.RESET);
        setRange(user.getHowManyAccounts());
        mainMenu();
    }

    private boolean hasAccount(){
        if(user.getHowManyAccounts() < 1){
            System.out.println(Messages.NO_ACCOUNT);
            //menu();
            return false;
        }
        return true;
    }

    private Customer getUser(int id){
        for(Customer c : bank.getCustomers()){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    private void quit(){
        try {
            System.out.print("\n" + Messages.EXIT);
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            System.exit(0);
        } catch (InterruptedException ignore){}
    }

    private void backToInitial(){
        initialMenu();
    }



    //Main
    public static void main(String[] args) {
        BankUI bankUI = new BankUI();
        bankUI.initialMenu();

    }
}
