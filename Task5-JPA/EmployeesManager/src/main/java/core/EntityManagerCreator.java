package core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Natallia_Rakitskaya.
 */
public class EntityManagerCreator {
    public static EntityManager createEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-App-Client");
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory is unavailable");
        }

        EntityManager entityManager = emf.createEntityManager();
        if (entityManager == null) {
            throw new IllegalStateException("EntityManager is unavailable");
        }
        return entityManager;
    }
}
