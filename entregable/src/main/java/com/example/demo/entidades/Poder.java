package com.example.demo.entidades;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "poder")
public class Poder {

	// Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poder")
	private Integer id;
	// nombre
	@Column(name = "nombre")
	private String nombre;
	@ManyToMany(mappedBy = "poderes", fetch = FetchType.LAZY)
	@JsonIgnore
  public Set<Superheroe> superheroes = new HashSet<>();
	
	
	public Poder() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Superheroe> getSuperheroes() {
		return superheroes;
	}
	public void setSuperheroes(Set<Superheroe> superheroes) {
		this.superheroes = superheroes;
	}
		
	
	
}
