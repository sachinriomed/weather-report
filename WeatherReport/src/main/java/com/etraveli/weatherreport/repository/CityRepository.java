package com.etraveli.weatherreport.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.etraveli.weatherreport.model.City;

@Repository
public class CityRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer saveCity(City city) {
		return (Integer) hibernateTemplate.save(city);
	}
	
	public List<City> findAllCities() {
		String queryString =" FROM " + City.class.getName();
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		return query.list();
	}
}
