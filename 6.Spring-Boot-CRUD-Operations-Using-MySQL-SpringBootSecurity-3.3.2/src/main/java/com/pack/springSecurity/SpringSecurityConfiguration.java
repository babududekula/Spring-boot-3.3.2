package com.pack.springSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.pack.fromDataBaseTodetails.UserDetailsServiceClass;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfiguration {

	@Bean
	public UserDetailsService userDetailsService(/* PasswordEncoder encoder */)
	{
//		UserDetails userDetails = User.withUsername("Babu").password(encoder.encode("Bhavani")).roles("ADMIN").build();
//
//		UserDetails userDetails1 = User.withUsername("Bhavani").password(encoder.encode("Babu")).roles("MANAGER")
//				.build();

		return new UserDetailsServiceClass();
	}

	@Bean
	public PasswordEncoder encoder() 
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/employee/welcome" , "/table/addUser" , "/swagger-ui.html").permitAll())
				.authorizeHttpRequests(auth1 -> auth1.requestMatchers("employee/**").authenticated())
				.formLogin(Customizer.withDefaults()).build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(encoder());
		return daoAuthenticationProvider;
	}
}
