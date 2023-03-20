package com.etraveli.weatherreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etraveli.weatherreport.model.City;
import com.etraveli.weatherreport.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> findAllCities() {
		return cityRepository.findAllCities();
	}
	
	public void saveCity(City city) {
		cityRepository.saveCity(city);
	}
}
