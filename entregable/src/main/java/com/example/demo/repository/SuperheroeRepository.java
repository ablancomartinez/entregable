package com.example.demo.repository;

import com.example.demo.entidades.Superheroe;


public interface SuperheroeRepository {

	Superheroe findByNombre(String nombre);
}
