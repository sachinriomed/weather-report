package com.etraveli.weatherreport.util;

import org.springframework.stereotype.Component;

@Component
public class TextUtil {

	public String generateTextMessage(String city, String temperature, String weather) {
		return "Current temperatur of "+ city +" is "+ temperature +" and weather is "+weather;
	}
	
	public String sendTextMessage(String message, String mobile) {
		System.out.println("Text message sent");
		return "Text message sent";
	}
}
