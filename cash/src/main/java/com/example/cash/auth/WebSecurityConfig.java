package com.example.cash.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired private UserDetailsService jwtUserDetailsService;
	@Autowired JwtTokenUtil jwtTokenUtil;
    @Autowired private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        // configure AuthenticationManager so that it knows from where to load
	        // user for matching credentials
	        // Use BCryptPasswordEncoder
	        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable()
    		.authorizeRequests()
    		.antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
    		.antMatchers("/admin/**").hasRole("ADMIN")
    		.antMatchers("/**").permitAll()
    		.anyRequest().authenticated()
    		.and();
    	http.cors().configurationSource(request-> new CorsConfiguration().applyPermitDefaultValues());
    	http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
    		.and()
    		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
 
    }
	    
	@Bean
	public PasswordEncoder passwordEncoder() {
	   return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	
}
