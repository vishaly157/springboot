package com.example.demo;

import com.example.demo.controller.ApiController;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApiController apiController;

	@LocalServerPort
	int port;

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	void contextLoader() {
		Assertions.assertNotNull(apiController);
	}

	@Test
	void testFindAll() {
		String url = "http://localhost:" + port + "/auth/user/all";
		Assertions.assertNotNull(testRestTemplate.getForObject(url, String.class));
	}

}
