package org.academiadecodigo.javabank.persistence;

import javax.persistence.EntityManager;

public interface SessionManager {
    public void startSession();
    public void stopSession();
    public EntityManager getCurrentSession();
}
