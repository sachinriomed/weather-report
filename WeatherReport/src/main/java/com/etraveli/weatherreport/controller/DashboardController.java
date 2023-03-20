package com.etraveli.weatherreport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etraveli.weatherreport.model.TemperatureDetails;
import com.etraveli.weatherreport.service.CityService;
import com.etraveli.weatherreport.service.DashboardService;
import com.etraveli.weatherreport.service.TemperatureDetailsService;

@Controller
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private TemperatureDetailsService temperatureDetailsService;
	
	@RequestMapping("/dashboard")
	public String home(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return "index";
		}
		Integer useId = (Integer) session.getAttribute("useId");
		if(useId == null || useId.intValue() <0 ) {
			return "index";
		}
		model.addAttribute("dashboardNotification", dashboardService.showWeatherReport(useId));
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return "index";
		}
		Integer useId = (Integer) session.getAttribute("useId");
		if(useId == null || useId.intValue() < 0 ) {
			return "index";
		}
		
		/*City city = new City();
		city.setCtiCity("Delhi");
		
		cityService.saveCity(city);*/
		
		/*TemperatureDetails td = new TemperatureDetails();
		td.setTmpCity("Kolhapur");
		td.setTmpTemperature(Byte.valueOf("20"));
		td.setTmpWeather("Clear");
		td.setTmpRecordStatus("approved");
		temperatureDetailsService.saveTemperatureDetails(td);*/
		return "about/about";
	}
}
