package com.etraveli.weatherreport.service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etraveli.weatherreport.displaybean.DisplayTemperatureBean;
import com.etraveli.weatherreport.model.Config;
import com.etraveli.weatherreport.model.TemperatureDetails;
import com.etraveli.weatherreport.repository.ConfigRepository;
import com.etraveli.weatherreport.repository.TemperatureDetailsRepository;

@Service
public class DashboardService {

	@Autowired
	private ConfigRepository configRepository;
	
	@Autowired
	private TemperatureDetailsRepository temperatureDetailsRepository;
	
	public String getWeatherReport(String city) {
		String apiResponse = null;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://weatherinfo.p.rapidapi.com/api/weather/?city="+city))
				.header("X-RapidAPI-Key", "ce02a6a769msh21521688a325e82p19c62ajsn2dc755037f47")
				.header("X-RapidAPI-Host", "weatherinfo.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		//HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		apiResponse = "{\r\n"
				+ "  \"creationDate\": \"2016-05-02T04:09:37-05:00\",\r\n"
				+ "  \"creationDateLocal\": \"2 May 03:53 am CDT\",\r\n"
				+ "  \"credit\": \"http://www.weather.gov/mpx\",\r\n"
				+ "  \"currentobservation\": {\r\n"
				+ "    \"Altimeter\": \"1019.8\",\r\n"
				+ "    \"Date\": \"2 May 03:53 am CDT\",\r\n"
				+ "    \"Dewp\": \"35\",\r\n"
				+ "    \"Gust\": \"0\",\r\n"
				+ "    \"Relh\": \"83\",\r\n"
				+ "    \"SLP\": \"30.11\",\r\n"
				+ "    \"Temp\": \"33\",\r\n"
				+ "    \"Visibility\": \"10.00\",\r\n"
				+ "    \"Weather\": \"Fair\",\r\n"
				+ "    \"Weatherimage\": \"nsct.png\",\r\n"
				+ "    \"WindChill\": \"NA\",\r\n"
				+ "    \"Windd\": \"0\",\r\n"
				+ "    \"Winds\": \"0\",\r\n"
				+ "    \"elev\": \"866\",\r\n"
				+ "    \"id\": \"KMIC\",\r\n"
				+ "    \"latitude\": \"45.06\",\r\n"
				+ "    \"longitude\": \"-93.35\",\r\n"
				+ "    \"name\": \"Minneapolis, Crystal Airport\",\r\n"
				+ "    \"state\": \"MN\",\r\n"
				+ "    \"timezone\": \"CDT\"\r\n"
				+ "  }\r\n"
				+ "}";
		//System.out.println(response.body());
		JSONObject json = new JSONObject();
		List<TemperatureDetails> temperatureDetailsList =  temperatureDetailsRepository.findTemperatureDetailsByTmpCity(city);
		for(TemperatureDetails temperatureDetails : temperatureDetailsList) {
			json.put("Temperature", temperatureDetails.getTmpTemperature());
			json.put("Weather", temperatureDetails.getTmpWeather());
		}
		return json.toString();
	}
	
	public int getTemprature(String apiResponse) {
		JSONObject json = new JSONObject(apiResponse);
		return json.getInt("Temperature");
	}
	
	public String getWeather(String apiResponse) {
		JSONObject json = new JSONObject(apiResponse);
		return json.getString("Weather");
	}
	
	public List<DisplayTemperatureBean> showWeatherReport(Integer useId) {
		
		List<DisplayTemperatureBean> dashboardNotification = new ArrayList<DisplayTemperatureBean>();
		List<Config> foundConfig = configRepository.findConfigByCfgUseIdCfgNotificationType(useId, "dashboard");
		for(Config config : foundConfig) {
			DisplayTemperatureBean dtb = new DisplayTemperatureBean();
			String cfgCity = config.getCfgCity();
			String response = getWeatherReport(cfgCity);
			Integer temp = getTemprature(response);
			String weather = getWeather(response);
			
			dtb.setCity(cfgCity);
			dtb.setTemprature(Integer.valueOf(temp));
			dtb.setWeather(weather);
			dashboardNotification.add(dtb);
		}
		return dashboardNotification;
	}
}
