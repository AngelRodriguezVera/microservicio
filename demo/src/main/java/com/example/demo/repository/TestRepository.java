package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserTest;



@Repository
public interface TestRepository extends JpaRepository<UserTest, Integer>{
	
	
	//buscar todos los usuarios
	List <UserTest> findAll();
	
	//buscar usuario por id
	Optional<UserTest> findById(int id);
	
	//guardar nuevo user
	UserTest save(UserTest ut);
	
	//insertar nuevo user o actualizar uno ya existente
	UserTest saveAndFlush(UserTest ut);
	
	//void deleteById(Integer id);
	UserTest deleteById(int id);
}