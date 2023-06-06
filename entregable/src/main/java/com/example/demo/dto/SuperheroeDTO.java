package com.example.demo.dto;

import java.io.Serializable;
import java.util.Set;

import com.example.demo.entidades.Poder;
import com.example.demo.entidades.Universo;

public class SuperheroeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String estado;
	private Universo universo;
	private Set<Poder> poder;
	
	
	
	public SuperheroeDTO() {
		super();
	}
	public SuperheroeDTO(String nombre, String estado, Universo universo, Set<Poder> poder) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.universo = universo;
		this.poder = poder;
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
	public Set<Poder> getPoder() {
		return poder;
	}
	public void setPoder(Set<Poder> poder) {
		this.poder = poder;
	}
	
}
