package com.irojas.demojwt.Solicitud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/solicitud")
@CrossOrigin(origins ="http://localhost:4200" )
public class SolicitudController {

	@Autowired
	private SolicitudService service;
	
	@PostMapping
	public Solicitud garbarSolicitud(@RequestBody Solicitud s) {
		return service.gabarSolicitud(s);
	}
	
	@GetMapping
	public ResponseEntity<List<Solicitud> > listarSolicitud(){
		return ResponseEntity.ok(service.listarSolicitud());
	}
}
