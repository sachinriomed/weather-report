package com.etraveli.weatherreport.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etraveli.weatherreport.model.User;
import com.etraveli.weatherreport.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public Integer saveUser(User user) {
		return userRepository.saveUser(user);
	}
	
	public int login(String useUsername, String usePassword, HttpServletRequest request) {
		List<User> userList = (List<User>) userRepository.findUserByUseUsernameAndPassword(useUsername, usePassword);
		if(userList != null && userList.size() == 1) {
			User user = (User) userList.get(0);
			HttpSession session = request.getSession(false);
			session.setAttribute("useId", user.getUseId());
			return 1;
		}

		return 0;
	}
}
