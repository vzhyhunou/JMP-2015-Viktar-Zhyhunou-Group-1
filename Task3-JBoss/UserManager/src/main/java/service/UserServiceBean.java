package service;

import model.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */
@Stateless
@LocalBean
public class UserServiceBean implements UserServiceLocal {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserByLogin(String login) {
        Query q = entityManager.createQuery("SELECT a FROM User a WHERE a.login = :login", User.class);
        q.setParameter("login", login);
        if (q.getResultList().size()>0)
            return (User) q.getResultList().get(0);
        else
            return null;
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUserWithLogin(String login) {
        User user = findUserByLogin(login);
        if (user != null)
            entityManager.remove(user);
    }
}
