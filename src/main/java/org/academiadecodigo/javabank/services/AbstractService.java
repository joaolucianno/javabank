package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.GenericDao;

/**
 *
 * @param <T>
 */
public abstract class AbstractService<T extends Model> {
    //Fields
    protected GenericDao<T> dao;


    /**
     *
     * @param
     * @param
     */
    public AbstractService(GenericDao dao) {
        this.dao = dao;

    }

}
