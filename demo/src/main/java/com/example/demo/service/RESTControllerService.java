package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.example.demo.model.UserTest;
import com.example.demo.repository.TestRepository;



@Service
public class RESTControllerService {
	
	@Value("${course.message}")
	private String hello;
	
	@Autowired
	private TestRepository testRepository;
	
	public String mostrar() {
		return hello;
	}

	public List<UserTest>getAllUser() {
		return  testRepository.findAll();
	}
	
	 public Optional<UserTest> findById(int id) {

	        return testRepository.findById(id);
	    }
	
	public UserTest deleteId(int id) {
		return testRepository.deleteById(id);
	}
	
	public UserTest insert(UserTest us) throws IllegalStateException {
		return testRepository.saveAndFlush(us);
	}
	
	}