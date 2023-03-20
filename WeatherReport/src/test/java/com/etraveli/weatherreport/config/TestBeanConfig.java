package com.etraveli.weatherreport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.developerstack")
@Configuration
@EnableWebMvc
public class TestBeanConfig {

}
