package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.UserTest;
import com.example.demo.service.RESTControllerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Api(value = "CRUD Users")
@RestController
@Validated
public class RESTController {
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@Autowired
	private RESTControllerService restControllerService;
	
	@RequestMapping(method = RequestMethod.GET, value= "/hello")
	@ResponseBody
	public String mensaje() {
		return restControllerService.mostrar();
		}

    @ApiResponses( {
    	 @ApiResponse(code = 200, message = "ok")
    } )
    @ApiOperation(value ="Mostrar usuarios")
	@RequestMapping(method = RequestMethod.GET, value= "/users")
	@ResponseBody
	public List<UserTest> getUser(){
		return restControllerService.getAllUser();
		}
    
    @ApiOperation(value ="Mostrar usuario por id")
   	@RequestMapping(method = RequestMethod.GET, value= "/users/{id}")
   	@ResponseBody
   	public Optional <UserTest> getUserById(@PathVariable int id){
   		return restControllerService.findById(id);
   		}
    
    @ApiOperation(value ="Borrar usuario por id")
	@RequestMapping(method = RequestMethod.DELETE, value= "/users/{id}")
	@ResponseBody
	public UserTest deleteUserById(@PathVariable int id){
		return restControllerService.deleteId(id);
		}
    
    @ApiOperation(value ="Añade usuario nuevo o actualiza usuario ya existente")
	@RequestMapping(method = RequestMethod.POST, value= "/users")
	@ResponseBody
	public UserTest saveAndUpate(@RequestBody UserTest ut){
		return restControllerService.insert(ut);
		}
    
}