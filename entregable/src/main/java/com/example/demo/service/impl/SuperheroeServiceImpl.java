package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Superheroe;
import com.example.demo.repository.SuperheroeRepository;
import com.example.demo.service.SuperheroeService;

@Service
public class SuperheroeServiceImpl implements SuperheroeService{

	private SuperheroeRepository superheroeRepository;

	public SuperheroeServiceImpl(SuperheroeRepository superheroeRepository) {
		
		this.superheroeRepository = superheroeRepository;
	}

	@Override
	public Superheroe buscarSuperHeroe(String nombre) {
		// TODO Auto-generated method stub
		return superheroeRepository.findByNombre(nombre);
	}
	
	
}
