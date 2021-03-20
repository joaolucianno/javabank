package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.JpaBootstrap;
import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.Dao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaCustomerDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.jpa.JpaTrasactionManager;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.AccountServiceImp;
import org.academiadecodigo.javabank.services.CustomerServiceImp;

import javax.persistence.EntityManagerFactory;

public class App {

    public static void main(String[] args) {

        JpaBootstrap jpa = new JpaBootstrap();
        EntityManagerFactory emf = jpa.start();

        App app = new App();
        app.bootStrap(emf);

        jpa.stop();

    }

    private void bootStrap(EntityManagerFactory emf) {

        SessionManager sessionManager = new JpaSessionManager(emf);
        TransactionManager transactionManager = new JpaTrasactionManager(sessionManager);
        Dao accountDao = new JpaAccountDao(transactionManager);
        Dao customerDao = new JpaCustomerDao(transactionManager);

        Bootstrap bootstrap = new Bootstrap();


        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImp(accountDao, customerDao));
        bootstrap.setCustomerService(new CustomerServiceImp(accountDao, customerDao));

        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();
    }
}
