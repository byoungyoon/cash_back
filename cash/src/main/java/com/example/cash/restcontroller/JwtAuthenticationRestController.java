package com.example.cash.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cash.auth.JwtResponse;
import com.example.cash.auth.JwtTokenUtil;
import com.example.cash.service.JwtUserDetailsService;
import com.example.cash.vo.JwtRequest;
import com.example.cash.vo.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class JwtAuthenticationRestController {
	@Autowired private JwtTokenUtil jwtTokenUtil;
	@Autowired private JwtUserDetailsService userDetailsService;
	@Autowired PasswordEncoder passwordEncoder;
	
	@PostMapping("/signup")
	public void signup(User user) {
		user.setUserPw(passwordEncoder.encode(user.getUserPw()));
		userDetailsService.signup(user);
	}
	
	@PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(
    		@ModelAttribute User user) throws Exception {
        //authenticate(jwtRequset.getUsername(), jwtRequset.getPassword());
		
		User paramUser = userDetailsService.getUserByLogin(user.getUserId());

        if(paramUser == null) {
        	log.warn("{}", "fail to login");
        	throw new Exception("LoginId Fail");
        }
        if(passwordEncoder.encode(user.getUserPw()).equals(paramUser.getUserPw())) {
        	log.warn("{}", "fail to login");
        	throw new Exception("LoginPw Fail");        	
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserId());
        final String token = jwtTokenUtil.generateToken(userDetails);
        log.info("{}", "######################"+token);
        
        return ResponseEntity.ok(new JwtResponse(token));
    }

	/*
	 * private void authenticate(String username, String password) throws Exception
	 * { try { authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(username, password)); } catch
	 * (DisabledException e) { throw new Exception("USER_DISABLED", e); } catch
	 * (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS", e);
	 * } }
	 */

}
