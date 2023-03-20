package com.etraveli.weatherreport.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.etraveli.weatherreport.config.TestBeanConfig;
import com.etraveli.weatherreport.model.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
@WebAppConfiguration
public class ConfigServiceTest {

	@Test
	public void getConfigByCfgCityCfgNotificationTypeTest() {
		ArrayList<Config> foundConfig = new ArrayList<Config>();
		Config config = new Config();
		config.setCfgUseId(1);
		config.setCfgCity("Pune");
		config.setCfgNotificationType("text");
		config.setCfgTemperature(Byte.valueOf("20"));
		config.setCfgUseId(1);
		foundConfig.add(config);
		
		config = new Config();
		config.setCfgUseId(1);
		config.setCfgCity("Mumbai");
		config.setCfgNotificationType("dashboard");
		config.setCfgTemperature(Byte.valueOf("25"));
		config.setCfgUseId(1);
		foundConfig.add(config);
		
		ConfigService configService = Mockito.mock(ConfigService.class);
		when(configService.getConfigByCfgCityCfgNotificationType("Mumbai", "text")).thenReturn(foundConfig);
		assertEquals(2, foundConfig.size());
	}
	
	@Test
	public void getConfigByCfgUseIdTest() {
		ArrayList<Config> foundConfig = new ArrayList<Config>();
		Config config = new Config();
		config.setCfgUseId(1);
		config.setCfgCity("Pune");
		config.setCfgNotificationType("text");
		config.setCfgTemperature(Byte.valueOf("20"));
		config.setCfgUseId(1);
		foundConfig.add(config);
		
		config = new Config();
		config.setCfgUseId(1);
		config.setCfgCity("Mumbai");
		config.setCfgNotificationType("dashboard");
		config.setCfgTemperature(Byte.valueOf("25"));
		config.setCfgUseId(1);
		foundConfig.add(config);
		
		ConfigService configService = Mockito.mock(ConfigService.class);
		when(configService.getConfigByCfgUseId(1)).thenReturn(foundConfig);
		assertEquals(2, foundConfig.size());
	}
}
