package com.example.demo.repository;

import com.example.demo.entidades.Universo;

public interface UniversoRepository {
	
	Universo findById(Integer id);
}
