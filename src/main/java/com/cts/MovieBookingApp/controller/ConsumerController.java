package com.cts.MovieBookingApp.controller;

import com.cts.MovieBookingApp.model.UserDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("call/consumer")
@CrossOrigin(origins = "*")
public class ConsumerController{
	@PostMapping(value="/login")
	public ResponseEntity<?> consumeLogin(@RequestBody UserDTO userdto) throws RestClientException,Exception{

		//http://50.112.35.136:8084/auth/v1/login
		String baseUrl ="http://localhost:8084/auth/v1/login";
		RestTemplate restTemplate = new RestTemplate();
	
		ResponseEntity<Map<String,String>> result =null;
	try{
		result=restTemplate.exchange(baseUrl, HttpMethod.POST, getHeaders(userdto),
				new ParameterizedTypeReference<Map<String,String>>(){});
	}catch(Exception e){
		return new ResponseEntity<String>("Login was not successful", HttpStatus.UNAUTHORIZED);
	}
	return new ResponseEntity<Map<String,String>>(result.getBody(), HttpStatus.OK);
	}
	
	private static HttpEntity<UserDTO> getHeaders(UserDTO userdto) {
		HttpHeaders header = new HttpHeaders();
		
		header.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		header.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<UserDTO>(userdto, header);
	}

}










