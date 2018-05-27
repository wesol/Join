package com.join.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
			//.antMatchers("/","/contact","/about").permitAll()
			.anyRequest().permitAll()			//authenticated()
		.and()
			.formLogin();
/*		.and()
			.httpBasic();*/
	}
}
