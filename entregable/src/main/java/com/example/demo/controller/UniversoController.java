package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Universo;
import com.example.demo.service.UniversoService;

@RestController
public class UniversoController {

	private UniversoService universoService;

	public UniversoController(UniversoService universoService) {
		this.universoService = universoService;
	}

	@GetMapping(value = "/universo/{id_universo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Universo obtenerUniverso(@PathVariable(value = "id_universo") Integer id_universo) {
		return universoService.buscarUniverso(id_universo);
	}
}
