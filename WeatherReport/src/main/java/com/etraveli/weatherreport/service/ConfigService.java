package com.etraveli.weatherreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.etraveli.weatherreport.model.Config;
import com.etraveli.weatherreport.repository.ConfigRepository;

@Service
public class ConfigService {

	@Autowired
	private ConfigRepository configRepository;
	
	public Model saveConfig(Config config, Integer useId, Model model) {
		config.setCfgRecordStatus("approved");
		config.setCfgUseId(useId);
		List<Config> configList = configRepository.findConfigByCriteria(config);
		if(configList != null && configList.size() > 0) {
			return model.addAttribute("errorMessage", "Preference is already present");
		}
		
		config.setCfgRecordStatus("approved");
		config.setCfgUseId(useId);
		configRepository.saveConfig(config);
		return model.addAttribute("responseMessage", "Record Successfully Added");
		
	}
	
	public List<Config> getConfigByCfgCityCfgNotificationType(String city, String cfgNotificationType) {
		return configRepository.findConfigByCfgCityCfgNotificationType(city, cfgNotificationType);
	}
	
	public List<Config> getConfigByCfgUseId(Integer useId) {
		return configRepository.findConfigByCfgUseId(useId);
	}
}
