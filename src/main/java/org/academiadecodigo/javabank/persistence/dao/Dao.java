package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.Model;

import java.util.List;

public interface Dao<T extends Model>{
    List<T> List();
    T get(Integer id);
    T save(T save);
    void delete(Integer id);

}
