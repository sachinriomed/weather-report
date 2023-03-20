package com.etraveli.weatherreport.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.etraveli.weatherreport.model.City;
import com.etraveli.weatherreport.model.Config;
import com.etraveli.weatherreport.model.User;
import com.etraveli.weatherreport.service.CityService;
import com.etraveli.weatherreport.service.ConfigService;
import com.etraveli.weatherreport.service.DashboardService;
import com.etraveli.weatherreport.service.UserService;
import com.etraveli.weatherreport.util.TextUtil;

@Component
@EnableScheduling
public class ScheduledTasks {

	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private TextUtil textUtil;
	
	@Autowired
	private UserService userService;
	
	//@Scheduled(initialDelay = 5000, fixedRate = 3000)
	public void triggerTextMessage() {
		List<City> cities = cityService.findAllCities();
		for(City city : cities) {
			List<Config> configCityList = configService.getConfigByCfgCityCfgNotificationType(city.getCtiCity(), "text");
			for(Config config : configCityList) {
				String response = dashboardService.getWeatherReport(config.getCfgCity());
				Integer temp = dashboardService.getTemprature(response);
				String weather = dashboardService.getWeather(response);
				if(temp.equals(Integer.valueOf(config.getCfgTemperature())) && config.getCfgUseId() != null) {
					User user = userService.getUserByUseId(config.getCfgUseId());
					if(user.getUseMobile() != null && user.getUseMobile().length() > 0) {
						String message = textUtil.generateTextMessage(config.getCfgCity(), String.valueOf(temp), weather);
						textUtil.sendTextMessage(message, user.getUseMobile());
					}
				}
			}
		}
	}
}
