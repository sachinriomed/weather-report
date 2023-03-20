package com.etraveli.weatherreport.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.etraveli.weatherreport.config.TestBeanConfig;
import com.etraveli.weatherreport.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
@WebAppConfiguration
public class UserServiceTest {

	@Test
	public void getUserByUseIdTest() {
		
		UserService userService = Mockito.mock(UserService.class);
		User user = new User();
		user.setUseId(1);
		when(userService.getUserByUseId(1)).thenReturn(user);
		assertEquals(Integer.valueOf(1), user.getUseId());
	}
}
