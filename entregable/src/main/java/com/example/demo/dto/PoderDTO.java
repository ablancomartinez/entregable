package com.example.demo.dto;

import java.io.Serializable;

public class PoderDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String nombre;

	public PoderDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
