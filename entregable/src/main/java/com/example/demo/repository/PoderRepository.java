package com.example.demo.repository;

import java.util.List;

import com.example.demo.entidades.Poder;

public interface PoderRepository {
	List <Poder> findByNombre (String nombre);
	List <Poder> listarPoderes();

}
