package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link TransactionManager} implementation
 */
public class JpaTransactionManager implements TransactionManager {

    private JpaSessionManager sm;

    /**
     * Sets the session manager
     *
     * @param sm the session manager to set
     */
    @Autowired
    public void setSm(JpaSessionManager sm) {
        this.sm = sm;
    }

    /**
     * @see TransactionManager#beginRead()
     */
    @Override
    public void beginRead() {
        sm.startSession();
    }

    /**
     * @see TransactionManager#beginWrite()
     */
    @Override
    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    /**
     * @see TransactionManager#commit()
     */
    @Override
    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }

        sm.stopSession();
    }

    /**
     * @see TransactionManager#rollback()
     */
    @Override
    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }

        sm.stopSession();
    }
}

