package com.etraveli.weatherreport.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.etraveli.weatherreport.model.TemperatureDetails;

@Repository
public class TemperatureDetailsRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer saveTemperatureDetails(TemperatureDetails temperatureDetails) {
		return (Integer) hibernateTemplate.save(temperatureDetails);
	}
	
	public List<TemperatureDetails> findTemperatureDetailsByTmpCity(String tmpCity) {
		String queryString =" FROM " + TemperatureDetails.class.getName() + " e WHERE e.tmpCity=:tmpCity "
				+ " AND tmpRecordStatus='approved'";
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("tmpCity", tmpCity);
		return query.list();
	}
}
