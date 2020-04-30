package com.tobias.saul.ConfigServerGit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter{
	
	// starting from 2.0 >
	// need in order to access encrypt end point
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
			.authorizeRequests().mvcMatchers(HttpMethod.POST, "/encrypt/**")
			.permitAll();
	}

}
