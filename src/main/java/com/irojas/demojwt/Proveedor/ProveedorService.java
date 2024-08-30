package com.irojas.demojwt.Proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {
	
	@Autowired
	private IProveedorRepository repoProvee;
	
	public List<Proveedor>listarPorveedor(){
		
		return repoProvee.findAll();
	}
	
	public Proveedor crearProveedor(Proveedor p) {
		
		
		return repoProvee.save(p);
	}
	
	public Proveedor actualizarProveedor(Proveedor p) {
		
		return repoProvee.save(p);
	}
	
	public Proveedor obtenerProveedor(int id) {
		return repoProvee.findById(id).get();
	}
	public List<Proveedor> buscarProveedor(String name) {
		return repoProvee.findByName(name);
	}
	
	public void borrarProveedor(int id) {
		repoProvee.deleteById(id);
	}

}
