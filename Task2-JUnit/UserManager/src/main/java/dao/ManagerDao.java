package dao;

import model.User;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */
public interface ManagerDao {

    public void addUser(User user);

    public User findUserById(int id);

    public void updateUser(User user);

    public void removeUserWithId(int id);
}
