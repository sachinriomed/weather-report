package com.etraveli.weatherreport.service;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.etraveli.weatherreport.config.TestBeanConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
@WebAppConfiguration
public class DashboardServiceTest {

	@Test
	public void getTempratureTest() {
		JSONObject json = new JSONObject();
		json.put("Temperature", 20);
		json.put("Weather", "clear");
		String response = json.toString();
		DashboardService dashboardService = Mockito.mock(DashboardService.class);
		//when(dashboardService.getTemprature(response)).thenReturn(foundConfig);
		assertEquals(2, dashboardService.getTemprature(response));
	}
}
