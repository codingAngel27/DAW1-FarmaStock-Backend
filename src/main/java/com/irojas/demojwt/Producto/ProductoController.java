package com.irojas.demojwt.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins ="http://localhost:4200" )
public class ProductoController {
	
	@Autowired
	private ProductoService servicio;
	
	@GetMapping("/{id}")
	public Producto obtenerProducto(@PathVariable int id) {
		return servicio.obtenerProducto(id);
	}
	
	@PostMapping
	public String agregarProducto(@RequestBody Producto p) {
		return servicio.agregarProducto(p);
	}
	
	@GetMapping("/buscar")
	public List<Producto > obtenerProducto(@RequestParam String name) {
		return servicio.obtenerProductoporName(name);
	}
	

}
