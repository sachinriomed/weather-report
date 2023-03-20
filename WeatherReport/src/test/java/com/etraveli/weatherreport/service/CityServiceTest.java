package com.etraveli.weatherreport.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.etraveli.weatherreport.config.TestBeanConfig;
import com.etraveli.weatherreport.model.City;
import com.etraveli.weatherreport.repository.CityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
@WebAppConfiguration
public class CityServiceTest {

	@InjectMocks
	CityService cityService;
	
	@Mock
	CityRepository cityRepository;
	
	@Before
	public void setUp() {
		 MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void findAllCitiesTest() {
		ArrayList<City> foundCities = new ArrayList<City>();
		City city = new City();
		city.setCtiCity("Pune");
		foundCities.add(city);
		
		city = new City();
		city.setCtiCity("Kolhapur");
		foundCities.add(city);
		
		city = new City();
		city.setCtiCity("Mumbai");
		foundCities.add(city);
		
		//CityRepository cityRepository = Mockito.mock(CityRepository.class);
		when(cityRepository.findAllCities()).thenReturn(foundCities);
		
		//CityService cityService = Mockito.mock(CityService.class);
		List<City> cityList = cityService.findAllCities();
		assertEquals(3, cityList.size());
	}
}
