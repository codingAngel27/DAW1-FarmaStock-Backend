package com.irojas.demojwt.Proveedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String ruc;
	@Column(nullable = false)
	private String nomProvee;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String telefono;
	@Column(nullable = false)
	private String direccion;

}
