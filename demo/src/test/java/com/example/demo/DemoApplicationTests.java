package com.example.demo;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.RESTController;
import com.example.demo.repository.TestRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private RESTController controller;
	
	 @Autowired
	 private TestRepository repository;
	
	 //Test con springboot test
	@Test
	void contextLoads() {
		Assert.assertNotNull(controller);
	}
}
