package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PoderDTO;
import com.example.demo.entidades.Poder;

import com.example.demo.service.PoderService;

@RestController
public class PoderController {

	private PoderService poderService;

	public PoderController(PoderService poderService) {
		super();
		this.poderService = poderService;
	}
	@GetMapping(value = "/poder/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PoderDTO> obtenerPoderNombre(@PathVariable(value = "nombre") String nombre) {
		List<PoderDTO> response = new ArrayList<>(); 
		List<Poder> poderesDB = poderService.buscarPoderNombre(nombre);
		poderesDB.forEach(poder -> response.add(convertPoderToDTO(poder)));
		
		return response;
		
	}
	// función de buscar todo usando el dto, como no tiene el get id solo muestra el nombre
	@GetMapping(value = "/consulta/poderes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PoderDTO> obtenerPoderLista() {
		List<PoderDTO> response = new ArrayList<>(); 
		List<Poder> poderesDB = poderService.buscarPoderes();
		
		poderesDB.forEach(poder -> response.add(convertPoderToDTO(poder)));
		return response;
	}
	private PoderDTO convertPoderToDTO (Poder poder) {
		
		return new PoderDTO(poder.getNombre());
		
	}
}
