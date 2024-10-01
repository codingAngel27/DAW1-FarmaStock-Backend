package com.irojas.demojwt.Producto;

import java.util.Date;


import com.irojas.demojwt.Proveedor.Proveedor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String codPro;
	public String nomPro;
	public int proveedor;
	public int stock;
	public double precio;
	public Date fechaCompra;

	@ManyToOne
	  @JoinColumn(name = "proveedor", insertable = false,updatable = false)
	  private Proveedor objProveedor;
}
