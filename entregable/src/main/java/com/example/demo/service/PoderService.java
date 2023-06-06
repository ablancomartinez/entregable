package com.example.demo.service;

import java.util.List;

import com.example.demo.entidades.Poder;

public interface PoderService {
	List<Poder> buscarPoderNombre (String nombre); 
	List<Poder>buscarPoderes();

}
