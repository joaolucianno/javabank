package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.GenericDao;

import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractDao<T extends Model> implements GenericDao<T> {
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
        try{
            CriteriaBuilder builder = tm.getSm().getCriteriaBuilder();
            CriteriaQuery criteriaQuery = builder.createQuery(modelType);
            criteriaQuery.from(modelType);
            return tm.getSm().createQuery(criteriaQuery).getResultList();
        } finally {
            tm.commit();
        }
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
            T savedObject = tm.getSm().merge(save);
            //tm.getSm().persist(savedObject);
            tm.commit();
            return savedObject;
        } catch (RollbackException ex){
            tm.rollback();
        }
        return null;
    }


    @Override
    public void delete(Integer id) {

    }
}
