package org.academiadecodigo.javabank.model.account;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.Customer;

import javax.persistence.*;

/**
 * A generic account model entity to be used as a base for concrete types of accounts
 */
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public abstract class AbstractAccount extends AbstractModel implements Account {

    private double balance = 0;

    @ManyToOne
    private Customer customer;

    /**
     * @see Account#getBalance()
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the account costumer
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the account costumer
     *
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @see Account#getAccountType()
     */
    public abstract AccountType getAccountType();

    /**
     * Credits account if possible
     *
     * @param amount the amount to credit
     * @see Account#credit(double)
     */
    public void credit(double amount) {
        if (canCredit(amount)) {
            balance += amount;
        }
    }

    /**
     * Debits the account if possible
     *
     * @param amount the amount to debit
     * @see Account#debit(double)
     */
    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }

    /**
     * @see Account#canCredit(double)
     */
    public boolean canCredit(double amount) {
        return amount > 0;
    }

    /**
     * @see Account#canDebit(double)
     */
    public boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }

    /**
     * @see Account#canWithdraw()
     */
    public boolean canWithdraw() {
        return true;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "AbstractAccount{" +
                "balance=" + balance +
                ", customerId=" + (customer != null ? customer.getId() : null) +
                "} " + super.toString();
    }
}
