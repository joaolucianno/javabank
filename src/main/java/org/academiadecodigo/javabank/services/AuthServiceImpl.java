package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * An {@link AuthService} implementation
 */
public class AuthServiceImpl implements AuthService {

    private EntityManagerFactory emf;
    private CustomerService customerService;
    private Customer accessingCustomer;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * @see AuthService#authenticate(Integer)
     */
    @Override
    //==================================================================================== OK
    public boolean authenticate(Integer id) {
        EntityManager em = emf.createEntityManager();

        try{
            accessingCustomer = em.find(Customer.class, id);
            System.out.println("ACESSING CUSTOMER:" + accessingCustomer);
            return accessingCustomer != null;
        } finally {
            if(em != null){
                em.close();
            }
        }

    }

    /**
     * @see AuthService#getAccessingCustomer()
     */
    @Override
    public Customer getAccessingCustomer() {
        return accessingCustomer;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
