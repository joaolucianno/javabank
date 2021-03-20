package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.Model;

import java.util.List;

public interface Dao{
    <T> List<T> List();
    <T> T get(Integer id);
    <T> T save(T save);
    void delete(Integer id);

}
