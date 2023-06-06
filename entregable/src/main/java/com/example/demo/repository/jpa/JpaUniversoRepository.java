package com.example.demo.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Universo;
import com.example.demo.repository.UniversoRepository;


import jakarta.persistence.PersistenceContextType;

@Repository
public class JpaUniversoRepository implements UniversoRepository {
		
	@PersistenceContext(type = PersistenceContextType.EXTENDED)

	private EntityManager em;
	 

	public JpaUniversoRepository() {

	}

	@Override
	public Universo findById(Integer id) {
		
		return em.find(Universo.class, id);
	}



}
