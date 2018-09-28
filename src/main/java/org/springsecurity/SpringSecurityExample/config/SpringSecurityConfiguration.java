package org.springsecurity.SpringSecurityExample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	PasswordEncoder encoder =
		     PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/hello/*").
		hasRole("ADMIN").
		and().formLogin();
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER")
			.and().withUser("admin").password(encoder.encode("password")).roles("USER", "ADMIN");
		
	}

 
}
