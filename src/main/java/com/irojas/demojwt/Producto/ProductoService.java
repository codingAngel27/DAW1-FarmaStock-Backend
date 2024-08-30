package com.irojas.demojwt.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ProductoService {
	
	@Autowired
	private IProductoRepository repoProd;
	
	public Producto obtenerProducto(int id) {
		return repoProd.findById(id).get();
	}
	
	public String agregarProducto(Producto p) {
		 repoProd.save(p);
		 return "sev agrego 1 producto";
	}
	public List<Producto> obtenerProductoporName(String name) {
		return repoProd.findByName(name);
	}
	
	
}
