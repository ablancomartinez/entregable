package com.example.demo.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Universo;
import com.example.demo.repository.UniversoRepository;

@Repository
public class JpaUniversoRepository implements UniversoRepository {
	@PersistenceContext
	private EntityManager em;

	public JpaUniversoRepository() {

	}

	@Override
	public Universo findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Universo.class, id);
	}



}
