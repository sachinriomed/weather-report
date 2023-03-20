package com.etraveli.weatherreport.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.etraveli.weatherreport.model.Config;
import com.etraveli.weatherreport.model.User;

@Repository
public class ConfigRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer saveConfig(Config config) {
		return (Integer) hibernateTemplate.save(config);
	}
	
	public List<Config> findConfigByCriteria(Config config) {
		
		String queryString =" FROM " + Config.class.getName() + " e WHERE e.cfgUseId=:cfgUseId "
				+ " AND e.cfgCity=:cfgCity "
				+ " AND e.cfgTemperature=:cfgTemperature AND e.cfgNotificationType=:cfgNotificationType"
				+ " AND e.cfgRecordStatus='approved'";
		
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("cfgUseId", config.getCfgUseId());
		query.setParameter("cfgCity", config.getCfgCity());
		query.setParameter("cfgTemperature", config.getCfgTemperature());
		query.setParameter("cfgNotificationType", config.getCfgNotificationType());
		return query.list();
	}
	
	public List<Config> findConfigByCfgCityCfgNotificationType(String cfgCity, String cfgNotificationType) {
		
		String queryString =" FROM " + Config.class.getName() + " e WHERE e.cfgCity=:cfgCity"
				+ " AND e.cfgNotificationType=:cfgNotificationType AND e.cfgRecordStatus='approved'";
		
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("cfgCity", cfgCity);
		query.setParameter("cfgNotificationType", cfgNotificationType);
		return query.list();
	}
	
	public List<Config> findConfigByCfgUseIdCfgNotificationType(Integer cfgUseId, String cfgNotificationType) {
		
		String queryString =" FROM " + Config.class.getName() + " e WHERE e.cfgUseId=:cfgUseId "
				+ " AND e.cfgNotificationType=:cfgNotificationType AND e.cfgRecordStatus='approved'";
		
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("cfgUseId", cfgUseId);
		query.setParameter("cfgNotificationType", cfgNotificationType);
		return query.list();
	}
	
	public List<Config> findConfigByCfgUseId(Integer cfgUseId) {

		String queryString =" FROM " + Config.class.getName() + " e WHERE e.cfgUseId=:cfgUseId "
				+ " AND e.cfgRecordStatus='approved'";

		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery(queryString);
		query.setParameter("cfgUseId", cfgUseId);
		return query.list();
	}
}
