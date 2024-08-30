package com.irojas.demojwt.Solicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitudRepository  extends JpaRepository<Solicitud, Integer>{
	
	

}
