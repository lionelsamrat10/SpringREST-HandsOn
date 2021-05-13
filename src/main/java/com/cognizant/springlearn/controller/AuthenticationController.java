package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader){
		LOGGER.info("Start");
		LOGGER.debug("authheader: {}", authHeader);
		Map<String, String> map = new HashMap<>();
		map.put("token", "");
		String user = getUser(authHeader);
		LOGGER.debug("user : {}", user);
		String jwtToken = generateJwt(user);
		map.put("token", jwtToken);
		LOGGER.debug("map : {} ", map);
		LOGGER.info("End");
		return map;
	}
	private String getUser(String authHeader) {
		LOGGER.info("Start");
		String encodedCredentials = authHeader.substring(6);
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		LOGGER.debug("decodedCredentials : {}", decodedCredentials);
		String user = decodedCredentials.substring(0, decodedCredentials.indexOf(":"));
		LOGGER.debug("user : {}", user);
		LOGGER.info("End");	
		return user;
	}
	private String generateJwt(String user) {
		LOGGER.info("Start");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		// Set the token issue time as current time
		builder.setIssuedAt(new Date());
		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		LOGGER.debug("jwtToken : {}", token);
		LOGGER.info("End");	
		return token;
	}
}
