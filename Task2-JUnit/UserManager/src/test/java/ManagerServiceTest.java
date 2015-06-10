import dao.ManagerDao;
import exception.UserManagerException;
import model.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import service.ManagerServiceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Natallia_Rakitskaya on 09.06.2015.
 */
public class ManagerServiceTest {
    @InjectMocks
    private ManagerServiceImpl managerService;
    @Mock
    private ManagerDao managerDao;

    private static User user1;
    private static User user2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        user1 = new User(1, "New");
        user2 = new User(1, "Updated");
    }

    @Test
    public void testAddUser_NewUser() {
        managerService.addUser(user1);
        when(managerDao.findUserById(1)).thenReturn(user1);

        assertEquals("New", managerService.findUserById(1).getLogin());
        verify(managerDao, times(1)).addUser(user1);
        verify(managerDao, never()).updateUser(user1);
    }

    @Test
    public void testAddUser_ExistingUser() {
        when(managerDao.findUserById(1)).thenReturn(user1);
        managerService.addUser(user2);
        when(managerDao.findUserById(1)).thenReturn(user2);

        assertEquals("Updated", managerService.findUserById(1).getLogin());
        verify(managerDao).updateUser(user2);
    }

    @Test
    public void testFindUserById() {
        stub(managerDao.findUserById(1)).toReturn(user1);

        User foundUser = managerService.findUserById(1);
        assertNotNull(foundUser);
        assertEquals("New", managerService.findUserById(1).getLogin());
        verify(managerDao, atLeastOnce()).findUserById(1);
    }

    @Test
    public void testFindUserById_NonExistingId() {
        User foundUser = managerService.findUserById(1);
        assertNull(foundUser);

        verify(managerDao, atLeast(1)).findUserById(1);
    }

    @Test
    public void testRemoveUserWithId() {
        doReturn(user1).when(managerDao).findUserById(1);
        managerService.removeUserWithId(1);
        doReturn(null).when(managerDao).findUserById(1);

        User foundUser = managerService.findUserById(1);
        assertNull(foundUser);
        verify(managerDao, times(1)).removeUserWithId(1);
    }

    @Test(expected = UserManagerException.class)
    public void testRemoveUserWithId_NonExistingId() {
        managerService.removeUserWithId(1);
    }

}
