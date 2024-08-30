package com.irojas.demojwt.Proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/proveedor")
@CrossOrigin(origins ="http://localhost:4200" )
public class ProveedorController {
	
	@Autowired
	private ProveedorService servicio;
	
	@GetMapping
	public ResponseEntity<List<Proveedor> > listarProveedor(){
		return ResponseEntity.ok(servicio.listarPorveedor());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proveedor>  obtenerProveedor(@PathVariable int id) {
		
		return ResponseEntity.ok(servicio.obtenerProveedor(id));
	}
	@GetMapping("/buscar")
	public ResponseEntity<List<Proveedor>>  buscarProveedor(@RequestParam String name) {
		
		return ResponseEntity.ok(servicio.buscarProveedor(name));
	}
	
	@PostMapping
	public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor p) {
		Proveedor nuevo = servicio.crearProveedor(p);
		return new ResponseEntity<>(nuevo,HttpStatus.CREATED);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarProveedo(
			@PathVariable int id,
			@RequestBody Proveedor prov){
		
		Proveedor p = servicio.obtenerProveedor(id);
		p.setRuc(prov.getRuc());
		p.setNomProvee(prov.getDireccion());
		p.setEmail(prov.getEmail());
		p.setTelefono(prov.getTelefono());
		p.setDireccion(prov.getDireccion());
		servicio.actualizarProveedor(p);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarProveedor(@PathVariable int id) {
		servicio.borrarProveedor(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
}
