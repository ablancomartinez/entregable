package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Universo;
import com.example.demo.repository.UniversoRepository;
import com.example.demo.service.UniversoService;

@Service
public class UniversoServiceImpl implements UniversoService {

	private UniversoRepository universoRepository;
	
	public UniversoServiceImpl(UniversoRepository universoRepository) {
		
		this.universoRepository = universoRepository;
	}

	@Override
	public Universo buscarUniverso(Integer id) {
		// TODO Auto-generated method stub
		return universoRepository.findById(id);
	}

	
}
