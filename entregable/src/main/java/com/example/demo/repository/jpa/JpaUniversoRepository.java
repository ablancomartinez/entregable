package com.example.demo.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.SynchronizationType;

import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Universo;
import com.example.demo.repository.UniversoRepository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContextType;

@Repository
public class JpaUniversoRepository implements UniversoRepository {
		
	@PersistenceContext(type = PersistenceContextType.EXTENDED)

	private EntityManager em;
	 

	public JpaUniversoRepository() {

	}

	@Override
	public Universo findById(Integer id) {
		
		//em.getEntityManagerFactory().createEntityManager();
		return em.find(Universo.class, id);
	}



}
