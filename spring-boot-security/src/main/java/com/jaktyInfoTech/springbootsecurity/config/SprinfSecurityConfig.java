package com.jaktyInfoTech.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SprinfSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("jaktyInfoTech").password("password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("senthil").password("senthil").roles("USER");
	}

	// Security for all API
	@Override
	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	 * 
	 * }
	 */

	// Security based on URL
	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeRequests().antMatchers("/jaktyInfoTech/authorize/**").
	 * fullyAuthenticated().and().httpBasic();
	 * 
	 * }
	 */

	// Security based on ROLE
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/jaktyInfoTech/authorize/**").hasAnyRole("ADMIN").anyRequest()
				.fullyAuthenticated().and().httpBasic();

	}
	
	

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
