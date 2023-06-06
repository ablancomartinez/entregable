package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.SuperheroeDTO;
import com.example.demo.entidades.Superheroe;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.SuperheroeService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
public class SuperheroeController {

	private SuperheroeService superheroeService;

	public SuperheroeController(SuperheroeService superheroeService) {
		
		this.superheroeService = superheroeService;
	}
	@GetMapping(value = "/superheroe/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperheroeDTO obtenerSuperheroe(@PathVariable(value = "nombre") String nombre) throws ResourceNotFoundException {
		Superheroe superDB =  superheroeService.buscarSuperHeroe(nombre);
		SuperheroeDTO response = convertSuperheroeToDTO(superDB); 
		return response ;
	}
	
	
//	@GetMapping(value = "/superheroe/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//	public Superheroe obtenerSuperheroeId(@PathVariable(value = "id") Integer id)
//	{
//		return superheroeService.BuscarSuperheroeID(id);
//	}
	@GetMapping(value = "/superheroe/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public SuperheroeDTO obtenerSuperheroeId(@PathVariable(value = "id") Integer id)
	{
		
	Superheroe superDB =  superheroeService.BuscarSuperheroeID(id);
	SuperheroeDTO response = convertSuperheroeToDTO(superDB); 

	
	 return response;
	}
	
	
	
	@GetMapping(value = "/superheroe/nombres/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperheroeDTO> obtenerSuperheroeLista(@PathVariable(value = "nombre") String nombre) {
		List<SuperheroeDTO> response = new ArrayList<>(); 
		List<Superheroe> superheroeDB = superheroeService.buscarSuperheroeContiene(nombre);
		superheroeDB.forEach(superheroe -> response.add(convertSuperheroeToDTO(superheroe)));
		return response ;
	}
	
	//metodos matar y revivir
	@PutMapping(value = "/superheroe/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Superheroe>modificarEstado (@PathVariable(value = "nombre")String nombre,
			@RequestBody Superheroe superheroeDatos) {
		 Superheroe modificarEstado = superheroeService.buscarSuperHeroe(nombre);
			
				 if (modificarEstado != null) {
					 
					 if (superheroeDatos.getEstado().equals("vivo") || superheroeDatos.getEstado().equals("muerto")  ) {
						 modificarEstado.setEstado(superheroeDatos.getEstado());
							superheroeService.modificarEstadoSuperheroe(modificarEstado);
							
							
						} else {
							System.err.println("el estado solo puede ser vivo o muerto");
							
						}
					
				}
		else {
			 throw new ResourceNotFoundException("No existe un Superheroe cuyo nombre sea  : " + nombre);
		}
				
		
		
		return ResponseEntity.ok(modificarEstado);
	}
private SuperheroeDTO convertSuperheroeToDTO (Superheroe superheroe) {
		
		return new SuperheroeDTO(superheroe.getNombre(),
				superheroe.getEstado(),
				superheroe.getUniverso(),
				superheroe.getPoderes());
		
	}
	

}
