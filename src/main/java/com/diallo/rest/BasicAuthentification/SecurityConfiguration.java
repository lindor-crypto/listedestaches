package com.diallo.rest.BasicAuthentification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        	.csrf().disable()
	            .authorizeHttpRequests()
	            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
	            .httpBasic();
	    }
	 
	 //@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests((authz) -> authz
	                .anyRequest().authenticated()
	            )
	            .httpBasic();
	        return http.build();
	    }
	 
	 
}
