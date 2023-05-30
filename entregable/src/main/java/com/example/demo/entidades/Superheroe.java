package com.example.demo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne(fetch = FetchType.EAGER)
	// @Column(name = "id_universo")
	@JoinColumn(name = "id_universo")
	private Universo universo;

	public Superheroe() {
		super();
	}

//	public Superheroe(Integer id, String nombre, String estado, Universo id_universo) {
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.estado = estado;
//		this.universo = universo;
//
//	}

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

	public Universo getUniverso() {
		return universo;
	}

	public void setUniverso(Universo universo) {
		this.universo = universo;
	}

}
