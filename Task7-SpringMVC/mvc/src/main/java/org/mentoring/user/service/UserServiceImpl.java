package org.mentoring.user.service;
import org.mentoring.user.dao.UserDAO;
import org.mentoring.user.form.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class UserServiceImpl implements UserService {
 
	   @Autowired
	    private UserDAO userDAO;
	     
	    @Transactional
	    public void addUser(User user) {
	        userDAO.addUser(user);
	    }
	 
	    @Transactional
	    public List<User> listUsers() {
	 
	        return userDAO.listUsers();
	    }
	 
	    @Transactional
	    public void removeUserWithId(Integer id) {
	        userDAO.removeUserWithId(id);
	    }
}