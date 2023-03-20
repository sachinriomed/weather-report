package com.etraveli.weatherreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etraveli.weatherreport.model.City;
import com.etraveli.weatherreport.model.Config;
import com.etraveli.weatherreport.service.CityService;
import com.etraveli.weatherreport.service.ConfigService;

@Controller
public class ConfigController {

	@Autowired
	private ConfigService configService;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/config")
	public String config(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return "index";
		}
		Integer useId = (Integer) session.getAttribute("useId");
		if(useId == null || useId.intValue() <0 ) {
			return "index";
		}
		List<City> foundCities = cityService.findAllCities();
		List<Config> foundConfig = configService.getConfigByCfgUseId(useId);
		model.addAttribute("foundCities", foundCities);
		model.addAttribute("foundConfig", foundConfig);
		
		return "config";
	}
	
	@RequestMapping("/saveConfig")
	public String saveConfig(@ModelAttribute Config config, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return "index";
		}
		Integer useId = (Integer) session.getAttribute("useId");
		if(useId == null || useId.intValue() <0 ) {
			return "index";
		}
		configService.saveConfig(config, useId, model);
		
		List<City> foundCities = cityService.findAllCities();
		List<Config> foundConfig = configService.getConfigByCfgUseId(useId);
		model.addAttribute("foundCities", foundCities);
		model.addAttribute("foundConfig", foundConfig);
		
		return "config";
	}
}
