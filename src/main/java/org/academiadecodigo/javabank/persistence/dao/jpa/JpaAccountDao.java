package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link AccountDao} implementation
 */
@Repository
@Profile("prod")
public class JpaAccountDao extends GenericJpaDao<Account> implements AccountDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaAccountDao() {
        super(Account.class);
    }
}
