package com.irojas.demojwt.Proveedor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Proveedor")
public class Proveedor {
	
	@Id
	private int id;
	private String ruc;
	private String nomProvee;
	private String email;
	private String telefono;
	private String direccion;
	

	
	
}
