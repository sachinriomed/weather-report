package com.etraveli.weatherreport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.etraveli.weatherreport.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		
		String useUsername = request.getParameter("useUsername");
		String usePassword = request.getParameter("usePassword");
		
		if(useUsername == null || useUsername.isBlank() || usePassword == null || usePassword.isBlank()) {
			model.addAttribute("errorMessage", "Please enter username and password");
			return "index";
		}
		int result = loginService.login(useUsername, usePassword, request);
		if(result != 1) {
			model.addAttribute("errorMessage", "Your username/password combination has not been recognised. Please try again.");
			return "index";
		}
		
		return "redirect:/dashboard";
			
	}

	@RequestMapping(value={"/", "/index"})
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "index";
	}
}
