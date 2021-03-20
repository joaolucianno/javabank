package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.Dao;

import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T extends Model> implements Dao<T> {
    //Fields
    protected TransactionManager tm;
    protected Class<T> modelType;

    //Constructor
    public AbstractDao(TransactionManager tm, Class<T> modelType) {
        this.tm = tm;
        this.modelType = modelType;
    }

    //Custom Methods
    @Override
    public List<T> List() {
        CriteriaBuilder builder = tm.getSm().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery(modelType);
        criteriaQuery.from(modelType);
        return tm.getSm().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T get(Integer id) {
        try {
            return tm.getSm().find(modelType, id);
        } finally {
            tm.commit();
        }

//        Model model = tm.getSm().find(modelType, id);
//        tm.getSm().close();
//        return model;
        //return tm.getSm().find(modelType, id);
    }

    @Override
    public T save(T save) {
        try{
            tm.beginWrite();
            tm.getSm().persist(save);
            tm.commit();
        } catch (RollbackException ex){
            tm.rollback();
        }
        return save;
    }

    @Override
    public void delete(Integer id) {

    }
}
