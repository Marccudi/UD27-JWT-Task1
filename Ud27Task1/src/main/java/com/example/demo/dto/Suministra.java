package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	@Column
	private int precio;
	
	@ManyToOne
    @JoinColumn(name = "codigopieza")
    Pieza codigopieza;
 
    @ManyToOne
    @JoinColumn(name = "proveedorid")
    Proveedor proveedorid;

	public Suministra() {
	}
	public Suministra(int id, Pieza codigopieza, Proveedor proveedorid) {
		this.id = id;
		this.codigopieza = codigopieza;
		this.proveedorid = proveedorid;
	}
	public int getId() {
		return id;
	}
	public int getPrecio() {
		return precio;
	}
	public Pieza getCodigopieza() {
		return codigopieza;
	}
	public Proveedor getProveedorid() {
		return proveedorid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setCodigopieza(Pieza codigopieza) {
		this.codigopieza = codigopieza;
	}
	public void setProveedorid(Proveedor proveedorid) {
		this.proveedorid = proveedorid;
	}
	@Override
	public String toString() {
		return "Suministra [id=" + id + ", precio=" + precio + ", codigopieza=" + codigopieza + ", proveedorid="
				+ proveedorid + "]";
	}
	
    
    
}
