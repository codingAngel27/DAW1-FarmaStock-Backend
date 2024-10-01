package com.irojas.demojwt.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/producto")
@CrossOrigin(origins ="http://localhost:4200" )
public class ProductoController {
	
	@Autowired
	private ProductoService servicio;
	
	@GetMapping("listado")
	public ResponseEntity<List<Producto>> listarProductos() {
		return ResponseEntity.ok(servicio.listarProductos());
	}
	
	@GetMapping("/{id}")
	public Producto obtenerProducto(@PathVariable Integer id) {
		return servicio.obtenerProducto(id);
	}
	
	@PostMapping("registrar")
	public ResponseEntity<Producto> grabarProductos(@Validated @RequestBody Producto p) {
		Producto nuevo = servicio.grabarProducto(p);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
	}
	
	@GetMapping("buscar")
	public List<Producto > obtenerProducto(@RequestParam String name) {
		return servicio.obtenerProductoporName(name);
	}
	
		@PutMapping("/{id}")
		public ResponseEntity<Producto> actualizarProducto(
				@PathVariable Integer id,
				@RequestBody Producto producto) {
			Producto p = servicio.obtenerProducto(id);
			p.setCodPro(producto.getCodPro());
			p.setNomPro(producto.getNomPro());
			p.setProveedor(producto.getProveedor());
			p.setStock(producto.getStock());
			p.setPrecio(producto.getPrecio());
			p.setFechaCompra(producto.getFechaCompra());
			servicio.actualizarProducto(p);
			return new ResponseEntity<>(p, HttpStatus.CREATED);
			
		}	
		@DeleteMapping("/{id}")
		public String borrarProducto(@PathVariable Integer id) {
			return servicio.borrarProducto(id);
		}
}
