package com.example.demo.repository.jpa;

import javax.xml.transform.Result;

import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Superheroe;
import com.example.demo.repository.SuperheroeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;

@Repository
public class JpaSuperheroeRepository implements SuperheroeRepository {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)

	private EntityManager em;

	public JpaSuperheroeRepository() {
		
	}

	@Override
	public Superheroe findByNombre(String nombre) {
		// TODO Auto-generated method stub
		
		return em.createQuery("FROM Superheroe where nombre = :nombre",
				Superheroe.class).setParameter("nombre", nombre).getSingleResult();
	}
	 
	
}
