package com.example.demo.entidades;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	// estado (vivo o muerto) se controlara en los metodos
	@Column(name = "estado")
	private String estado;
	// Id_universo restriccion de existencia
	@ManyToOne(fetch = FetchType.EAGER)
	// @Column(name = "id_universo")
	@JoinColumn(name = "id_universo")
	private Universo universo;

	  @ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	    }, fetch = FetchType.LAZY)
	    @JoinTable(name = "super_poder",
	            joinColumns = @JoinColumn(name = "id_superheroe"),
	            inverseJoinColumns = @JoinColumn(name = "id_poder")
	    )
	    private Set<Poder> poderes = new HashSet<>();

	
	
	
	public Superheroe() {
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


	public Set<Poder> getPoderes() {
		return poderes;
	}


	public void setPoderes(Set<Poder> poderes) {
		this.poderes = poderes;
	}


	
	
}
