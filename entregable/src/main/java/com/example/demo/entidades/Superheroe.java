package com.example.demo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "superheroe")
public class Superheroe {

	// Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_superheroe")
	private Integer id;

	// nombre
	@Column(name = "nombre")
	private String nombre;
	// estado (vivo o muerto)
	@Column(name = "estado")
	private String estado;
	// Id_universo restriccion de existencia
	@Id
	@Column(name = "id_universo")
	private Integer id_universo;
	public Superheroe() {
		super();
	}
	public Superheroe(Integer id, String nombre, String estado, Integer id_universo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.id_universo = id_universo;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getId_universo() {
		return id_universo;
	}
	public void setId_universo(Integer id_universo) {
		this.id_universo = id_universo;
	}
	
}
