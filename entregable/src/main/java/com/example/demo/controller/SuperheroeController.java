package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Superheroe;
import com.example.demo.service.SuperheroeService;

@RestController
public class SuperheroeController {

	private SuperheroeService superheroeService;

	public SuperheroeController(SuperheroeService superheroeService) {
		
		this.superheroeService = superheroeService;
	}
	@GetMapping(value = "/superheroe/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Superheroe obtenerSuperheroe(@PathVariable(value = "nombre") String nombre) {
		return superheroeService.buscarSuperHeroe(nombre);
	}
	
}
