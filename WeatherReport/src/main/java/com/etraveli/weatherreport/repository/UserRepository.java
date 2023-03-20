package com.etraveli.weatherreport.repository;


import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.etraveli.weatherreport.model.User;

@Repository
public class UserRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer saveUser(User user) {
		return (Integer) hibernateTemplate.save(user);
	}
	
	public List<User> findUserByUseUsernameAndPassword(String useUsername, String usePassword) {
		
		String queryString =" FROM " + User.class.getName() + " e WHERE e.useUsername=:useUsername "
				+ " AND usePassword=:usePassword AND useActive=1";
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("useUsername", useUsername);
		query.setParameter("usePassword", usePassword);
		return query.list();
	}
	
	public List<User> findUserByUseUseId(Integer useId) {
		
		String queryString =" FROM " + User.class.getName() + " e WHERE e.useId=:useId "
				+ " AND useActive=1";
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("useId", useId);
		return query.list();
	}
}
