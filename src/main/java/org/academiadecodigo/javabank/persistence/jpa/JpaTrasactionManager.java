package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.TransactionManager;

import javax.persistence.EntityManager;

public class JpaTrasactionManager implements TransactionManager {
    //Fields
    private SessionManager sm;

    //Constructor
    public JpaTrasactionManager(SessionManager sm) {
        this.sm = sm;
    }

    @Override
    public void beginRead() {
        sm.startSession();
    }

    @Override
    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    @Override
    public void commit() {
        if(sm.getCurrentSession().getTransaction().isActive()){
            sm.getCurrentSession().getTransaction().commit();
        }
        sm.stopSession();
    }

    @Override
    public void rollback() {

    }

    @Override
    public EntityManager getSm(){
        return sm.getCurrentSession();
    }
}
