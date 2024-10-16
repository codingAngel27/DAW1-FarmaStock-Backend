package com.irojas.demojwt.Solicitud;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irojas.demojwt.Producto.Producto;
import com.irojas.demojwt.Producto.ProductoService;



@RestController
@RequestMapping("/auth/solicitud")
@CrossOrigin(origins ="http://localhost:4200" )
public class SolicitudController {
@Autowired
private SolicitudService service;
@Autowired
private ProductoService prodService;

@PostMapping
public Solicitud enviarSolicitud(@RequestBody Solicitud s) {
	Solicitud nuevo = service.gabarSolicitud(s);
	Producto producto = prodService.obtenerProducto(s.idPro);
	sendSimpleMessage(s.correo,"Solicitud " + producto.nomPro, 
			"Se solicita el siguiente producto: " + producto.nomPro + 
			"\nCantidad: " + s.cantidad +
			"\nFecha: " + s.fecha + 
			"\nDescripcion: " + s.descripcion);
	return nuevo;
}

@GetMapping
public ResponseEntity<List<Solicitud> > listarSolicitud(
/*
 * @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date
 * date
 */){
	return ResponseEntity.ok(service.listarSolicitud());
}


@Bean
JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp-mail.outlook.com");
    mailSender.setPort(587);

    mailSender.setUsername("farmastock2024@outlook.com");
    mailSender.setPassword("holamundo21");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
}

public void sendSimpleMessage(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage(); 
    message.setFrom("farmastock2024@outlook.com");
    message.setTo(to); 
    message.setSubject(subject); 
    message.setText(text);
    
    try {
        getJavaMailSender().send(message);
        System.out.println("Correo enviado a " + to);
    } catch (MailException e) {
        System.err.println("Error al enviar el correo: " + e.getMessage());
    }
}


}
