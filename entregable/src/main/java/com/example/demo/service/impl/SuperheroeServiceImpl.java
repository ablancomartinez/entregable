package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Superheroe;
import com.example.demo.repository.SuperheroeRepository;
import com.example.demo.service.SuperheroeService;

import jakarta.transaction.Transactional;

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
	@Override
	public List<Superheroe> buscarSuperheroeContiene(String nombre) {
		// TODO Auto-generated method stub
		return superheroeRepository.findByContiene(nombre);
	}
	
	@Override
	public Superheroe BuscarSuperheroeID(Integer id) {
		// TODO Auto-generated method stub
		return superheroeRepository.findById(id);
	}

	@Override
	@Transactional
	public void modificarEstadoSuperheroe(Superheroe superheroe) {
		// TODO Auto-generated method stub
		 superheroeRepository.modificarEstado(superheroe);
	}
	
}
