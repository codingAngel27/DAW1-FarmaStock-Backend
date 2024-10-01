package com.irojas.demojwt.Solicitud;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService {
	
	@Autowired
	private ISolicitudRepository reposoli;
	
	public Solicitud gabarSolicitud(Solicitud s) {
		
		return reposoli.save(s);
		
	}
	
	public List<Solicitud>listarSolicitud(){
		
		return reposoli.findAll();
	}
	
	public Solicitud obtenerSolicitud(int id) {
		return reposoli.findById(id).get();
	}

}
