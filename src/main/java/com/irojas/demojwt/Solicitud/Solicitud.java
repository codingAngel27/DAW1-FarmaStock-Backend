package com.irojas.demojwt.Solicitud;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {

	@Id
	public int id;
	public int idPro;
	public int cantidad;
	public int idProveedor;
	public String correo;
	public Date fecha;
	public String descripcion;
	
	
}
