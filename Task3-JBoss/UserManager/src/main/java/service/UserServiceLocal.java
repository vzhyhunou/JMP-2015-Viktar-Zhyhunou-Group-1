package service;

import model.User;

import javax.ejb.Local;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */
@Local
public interface UserServiceLocal {

    public void addUser(User user);

    public User findUserByLogin(String login);

    public void updateUser(User user);

    public void removeUserWithLogin(String login);
}
