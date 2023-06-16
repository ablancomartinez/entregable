package com.example.demo.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.controller.SuperheroeController;
import com.example.demo.dto.SuperheroeDTO;
import com.example.demo.entidades.Superheroe;
import com.example.demo.service.SuperheroeService;

@ExtendWith(MockitoExtension.class)
class SuperheroeControllerTest {

	@InjectMocks
	SuperheroeController controller;

	@Mock
	SuperheroeService service;
	
	Superheroe heroe = new Superheroe();
	
	@BeforeEach
	void setUp() {
		
		heroe.setNombre("ironman");	
	}

	@Test
	void test_obtenerSuperheroe() throws Exception {

		

		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		when(service.buscarSuperHeroe("ironman")).thenReturn(heroe);
		// LLAMADA A MÉTODO A TESTEAR
		SuperheroeDTO currentResult = controller.obtenerSuperheroe("ironman");

		// COMPROBACIONES DEL RESULTADO ESPERADO;
		assertThat(currentResult).isNotNull();
		assertEquals("ironman", currentResult.getNombre());

	}
	
	@Test
	void test_obtenerSuperheroeId() throws Exception {
	
		// COMPORTAMIENTO ESPERADO
		when(service.BuscarSuperheroeID(1)).thenReturn(heroe);
		SuperheroeDTO currentResult = controller.obtenerSuperheroeId(1);
		
		assertThat(currentResult).isNotNull();
		assertEquals("muerto", currentResult.getEstado()); // no tiene estado solo nombre
		
	}
}
