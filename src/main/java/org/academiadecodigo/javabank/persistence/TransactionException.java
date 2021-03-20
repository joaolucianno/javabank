package org.academiadecodigo.javabank.persistence;

public class TransactionException extends org.hibernate.TransactionException {
    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionException(String message) {
        super(message);
    }
}
