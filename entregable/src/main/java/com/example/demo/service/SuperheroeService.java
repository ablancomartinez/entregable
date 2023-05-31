package com.example.demo.service;

import java.util.List;

import com.example.demo.entidades.Superheroe;

public interface SuperheroeService {

	Superheroe buscarSuperHeroe (String nombre);
	
	Superheroe BuscarSuperheroeID (Integer id);
	
	List<Superheroe> buscarSuperheroeContiene (String nombre);
}
