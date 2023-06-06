package com.example.demo.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.demo.entidades.Superheroe;
import com.example.demo.repository.SuperheroeRepository;
import com.example.demo.service.impl.SuperheroeServiceImpl;

@ExtendWith(MockitoExtension.class)
class SuperheroeServiceTest {
	@InjectMocks
	SuperheroeServiceImpl service;

	@Mock
	SuperheroeRepository repository;

	@Test
	void test_obtenerSuperheroe() throws Exception {

		Superheroe heroe = new Superheroe();

		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		when(repository.findByNombre("wonder woman")).thenReturn(heroe);
		// LLAMADA A MÉTODO A TESTEAR
		Superheroe currentResult = service.buscarSuperHeroe("wonder woman");

		// COMPROBACIONES DEL RESULTADO ESPERADO;
		assertThat(currentResult).isNotNull();

	}
}
