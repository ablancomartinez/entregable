package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Poder;
import com.example.demo.repository.PoderRepository;
import com.example.demo.service.PoderService;

@Service
public class PoderServiceImpl implements PoderService {
	
	private PoderRepository poderRepository;

	public PoderServiceImpl(PoderRepository poderRepository) {
		super();
		this.poderRepository = poderRepository;
	}

	@Override
	public List<Poder> buscarPoderNombre(String nombre) {
		// TODO Auto-generated method stub
		return poderRepository.findByNombre(nombre);
	}

	@Override
	public List<Poder> buscarPoderes() {
		// TODO Auto-generated method stub
		return poderRepository.listarPoderes();
	}
	

	
}
