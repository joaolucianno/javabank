package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.persistence.dao.Dao;

/**
 *
 * @param <T>
 */
public abstract class AbstractService<T extends Model> {
    //Fields
    protected Dao accountDao;
    protected Dao customerDao;


    /**
     *
     * @param accountDao
     * @param customerDao
     */
    public AbstractService(Dao accountDao, Dao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }


    /**
     * @see CRUDService#()
     *//*
    @Override
    public List<T> list() {

        EntityManager em = emf.createEntityManager();

        try {

            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
            Root<T> root = criteriaQuery.from(modelType);
            return em.createQuery(criteriaQuery).getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    *//**
     * @see CRUDService#get(Integer)
     *//*
    @Override
    public T get(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(modelType, id);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    *//**
     * @see CRUDService#save(Model)
     *//*
    @Override
    public T save(T modelObject) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            T savedObject = em.merge(modelObject);
            em.getTransaction().commit();

            return savedObject;

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    *//**
     * @see CRUDService#delete(Integer)
     *//*
    @Override
    public void delete(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.remove(em.find(modelType, id));
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }*/
}
