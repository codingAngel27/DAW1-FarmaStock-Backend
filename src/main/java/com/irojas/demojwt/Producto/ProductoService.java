package com.irojas.demojwt.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	@Autowired
	private IProductoRepository repoProd;
	
	public String agregarProducto(Producto p) {
		 repoProd.save(p);
		 return "sev agrego 1 producto";
	}
	public List<Producto> obtenerProductoporName(String name) {
		return repoProd.findByName(name);
	}
	//SERVICE ANALIA
		public List<Producto> listarProductos() {
			return repoProd.findAll();
		}
		
		public Producto grabarProducto(Producto p) {
			return repoProd.save(p);
		}
		
		public Producto actualizarProducto(Producto p) {
			return repoProd.save(p);
		}
		
		public Producto obtenerProducto(Integer id ) {
			//return repoProd.getById(id);
			return repoProd.findById(id).get();
		}
		
		public String borrarProducto(Integer id) {
			repoProd.deleteById(id);
			return "Producto Eliminado";
		}
	
	
}
