package com.example.demo.entidades;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "universo")
public class Universo  {
	//Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_universo")
	private Integer id;
	
	//descripcion
	@Column (name="descripcion")
	private String descripcion;
	
	public Universo() {
		super();
	}

	public Universo(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
