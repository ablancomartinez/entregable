package com.example.demo.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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

	@Test
	void test_obtenerSuperheroe() throws Exception {

		Superheroe heroe = new Superheroe();

		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		when(service.buscarSuperHeroe("wonder woman")).thenReturn(heroe);
		// LLAMADA A MÉTODO A TESTEAR
		SuperheroeDTO currentResult = controller.obtenerSuperheroe("wonder woman");

		// COMPROBACIONES DEL RESULTADO ESPERADO;
		assertThat(currentResult).isNotNull();

	}
}
