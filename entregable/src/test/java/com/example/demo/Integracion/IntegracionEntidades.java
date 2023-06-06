package com.example.demo.Integracion;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.EntregableApplication;
import com.example.demo.entidades.Superheroe;

@SpringBootTest(classes = EntregableApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class IntegracionEntidades {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private String getRootUrl() {
		return "http://localhost:8080/";
	}
	@Test
	void testGetAllPoderes() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(getRootUrl() + "consulta/poderes",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	void test_KO() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(getRootUrl() + "consultas",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	void testGetPoderNombre() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(getRootUrl() + "poder/volar",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	void testGetSuperheroeNombre() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(getRootUrl() + "/superheroe/nombres/iron man",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
}
