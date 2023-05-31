package com.example.demo.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Poder;
import com.example.demo.repository.PoderRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
@Repository
public class JpaPoderRepository implements PoderRepository{
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)

	private EntityManager em;

	@Override
	public List<Poder> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return em.createQuery("FROM Poder where nombre like (:nombre)",
				Poder.class).setParameter("nombre", nombre).getResultList();
	}

	@Override
	public List<Poder> listarPoderes() {
		// TODO Auto-generated method stub
		List <Poder> resultList = em.createQuery("FROM Poder").getResultList();
		return  resultList;
	}

}
