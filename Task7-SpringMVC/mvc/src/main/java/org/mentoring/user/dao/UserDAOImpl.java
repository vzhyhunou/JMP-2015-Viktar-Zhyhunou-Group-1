package org.mentoring.user.dao;

import java.util.List;

 
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.mentoring.user.form.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class UserDAOImpl implements UserDAO {
 
	static final Logger logger = Logger.getLogger(UserDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
 
	public void addUser(User user) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception :" + e.getCause());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
 
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			return session.createQuery("from User").list();
		} catch (Exception e) {
			logger.error("Exception :" + e.getCause());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
 
	public void removeUserWithId(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			User user = (User) session.load(User.class, id);
			if (null != user) {
				session.delete(user);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception :" + e.getCause());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}
}