package org.jsp.usermvcapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private EntityManager entityManager;
	
	public User saveUser(User user) {
		EntityTransaction t = entityManager.getTransaction();
		entityManager.persist(user);
		t.begin();
		t.commit();
		return user;
	}
	
	public User updateUser(User user, int id) {
		EntityTransaction t = entityManager.getTransaction();
		User u = entityManager.find(User.class, id);
		if(u!=null) {
			u.setName(user.getName());
			u.setPhone(user.getPhone());
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			t.begin();
			t.commit();
			return u;
		}
		return null;
	}
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}
	
	public boolean deleteUserById(int id) {
		EntityTransaction t = entityManager.getTransaction();
		User user = entityManager.find(User.class, id);
		if(user!=null) {
			entityManager.remove(user);
			t.begin();
			t.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public User verifyUser(int id, String password) {
		Query q = entityManager.createQuery("select u from User u where id=?1 and password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			User user = (User) q.getSingleResult();
			return user;
		}catch(NoResultException exception) {
			return null;
		}
	}
	
	public User verifyUser(long phone, String password) {
		Query q = entityManager.createQuery("select u from User u where phone=?1 and password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			User user = (User) q.getSingleResult();
			return user;
		}catch(NoResultException exception) {
			return null;
		}
	}
	
	public User verifyUser(String email, String password) {
		Query q = entityManager.createQuery("select u from User u where email=?1 and password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			User user = (User) q.getSingleResult();
			return user;
		}catch(NoResultException exception) {
			return null;
		}
	}
}
