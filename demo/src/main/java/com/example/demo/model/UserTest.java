package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "test")
@Validated
@ApiModel("Modelo de usuarios")
public class UserTest {
	
	@Id
	private int id;
	
	
	@ApiModelProperty(value="Nombreusuario", example="manolo", name="name")
	@NotEmpty
	private String name;
	
	
	@ApiModelProperty(value="Fecha de nacimiento", example="2000-05-10")
	@NotNull(message = "Fecha no puede estar vacia")
	private Date fecha;
	
	//Constructor vacio
	public UserTest() {
		
	}
	
	//Getter y Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}