package com.irojas.demojwt.Solicitud;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.irojas.demojwt.Producto.Producto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {

	@Id
	@GeneratedValue
	public int id;
	public Integer idPro;
	public int cantidad;
	public int idProveedor;
	public String correo;
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date fecha;
	public String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idPro", insertable = false, updatable = false)
	private Producto objProducto;
}
