package service;

import dao.ManagerDao;
import dao.ManagerDaoImpl;
import exception.UserManagerException;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    private static Logger LOGGER = Logger.getLogger(ManagerServiceImpl.class);

    private ManagerDao managerDao;

    public ManagerServiceImpl(){
        this.managerDao = new ManagerDaoImpl();
    }

    @Override
    public void addUser(User user) {
        LOGGER.debug("Adding user ...");
        if (findUserById(user.getId()) == null)
            managerDao.addUser(user);
        else
            updateUser(user);
    }

    @Override
    public User findUserById(int id) {
        LOGGER.debug(String.format("Searching for a user with id %s ...", id));
        return managerDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        int id = user.getId();
        LOGGER.debug(String.format("Updating user with id %s ...", id));
        managerDao.updateUser(user);
    }

    @Override
    public void removeUserWithId(int id) {
        LOGGER.debug(String.format("Removing user with id %s ...", id));
        if (findUserById(id) == null) {
            throw new UserManagerException(String.format("Can't remove - there is no user with id %s!!", id));
        }
        managerDao.removeUserWithId(id);
    }
}
