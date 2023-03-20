package com.etraveli.weatherreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etraveli.weatherreport.model.User;
import com.etraveli.weatherreport.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	public User getUserByUseId(Integer useId) {
		List<User> userList = userRepository.findUserByUseUseId(useId);
		if(userList.size() == 1) {
			return userList.get(0);
		}
		return null; 
	}
	
}
