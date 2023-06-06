package com.example.demo.entidades;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import com.example.demo.dto.SuperheroeDTO;

class SuperheroeTest {

	@Test
	void bean_null_test() {
		Universo universo = new Universo();
		Set<Poder> poder = new HashSet<>();
		final SuperheroeDTO superheroeDTO = new SuperheroeDTO("test", "test", universo, poder);

		if (StringUtils.isBlank(superheroeDTO.toString())) {
			Assertions.fail();
		}
	}
}
