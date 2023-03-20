package com.etraveli.weatherreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etraveli.weatherreport.model.TemperatureDetails;
import com.etraveli.weatherreport.repository.TemperatureDetailsRepository;

@Service
public class TemperatureDetailsService {

	@Autowired
	private TemperatureDetailsRepository temperatureDetailsRepository;
	
	public List<TemperatureDetails> getTemperatureDetailsByTmpCity(String tmpCity) {
		return temperatureDetailsRepository.findTemperatureDetailsByTmpCity(tmpCity);
	}
	
	public void saveTemperatureDetails(TemperatureDetails temperatureDetails) {
		temperatureDetailsRepository.saveTemperatureDetails(temperatureDetails);
	}
}
