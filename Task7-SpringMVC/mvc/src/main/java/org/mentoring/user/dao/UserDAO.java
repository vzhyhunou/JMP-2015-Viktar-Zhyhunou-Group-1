package org.mentoring.user.dao;

import java.util.List;

import org.mentoring.user.form.User;

public interface UserDAO {

	void addUser(User user);

	List<User> listUsers();

	void removeUserWithId(Integer id);
}