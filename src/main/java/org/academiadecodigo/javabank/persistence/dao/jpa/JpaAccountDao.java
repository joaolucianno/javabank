package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.Dao;

public class JpaAccountDao extends AbstractDao<AbstractAccount> {
    //Constructor
    public JpaAccountDao(TransactionManager tm) {
        super(tm, AbstractAccount.class);
    }
}