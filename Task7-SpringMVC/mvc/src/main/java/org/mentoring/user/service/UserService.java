package org.mentoring.user.service;

import java.util.List;

import org.mentoring.user.form.User;

public interface UserService {

	void addUser(User user);

	List<User> listUsers();

	void removeUserWithId(Integer id);
}