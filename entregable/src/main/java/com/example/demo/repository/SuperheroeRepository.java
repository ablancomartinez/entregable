package com.example.demo.repository;

import java.util.List;

import com.example.demo.entidades.Superheroe;


public interface SuperheroeRepository {

	Superheroe findByNombre(String nombre);
	
	Superheroe findById (Integer id);
	
	List<Superheroe> findByContiene	(String nombre);
	
	Superheroe modificarEstado (Superheroe superheroe);
}
