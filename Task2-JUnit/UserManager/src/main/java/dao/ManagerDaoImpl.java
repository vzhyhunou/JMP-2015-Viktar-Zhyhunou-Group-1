package dao;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {

    private EntityManager entityManager;

    public ManagerDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-App-Client");
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory is unavailable");
        }

        entityManager = emf.createEntityManager();
        if (entityManager == null) {
            throw new IllegalStateException("EntityManager is unavailable");
        }
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUserWithId(int id) {
        User user = findUserById(id);
        if (user != null)
            entityManager.remove(user);
    }
}
