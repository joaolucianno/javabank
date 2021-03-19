package org.academiadecodigo.javabank.factories;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.model.account.SavingsAccount;

/**
 * A factory for creating accounts of different types
 */
public class AccountFactory {

    /**
     * Creates a new {@link Account}
     *
     * @param accountType the account type
     * @return the new account
     */
    public Account createAccount(AccountType accountType, Customer customer) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount();
                if(newAccount instanceof CheckingAccount){
                    ((CheckingAccount) newAccount).setCustomer(customer);
                }

                break;
            case SAVINGS:
                newAccount = new SavingsAccount();
                break;
            default:
                newAccount = null;

        }

        return newAccount;
    }
}
