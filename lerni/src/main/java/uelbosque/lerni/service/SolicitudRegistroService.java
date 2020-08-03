package uelbosque.lerni.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uelbosque.lerni.DAO.SolicitudDeRegistroDAO;

import uelbosque.lerni.model.SolicitudesDeRegistro;

@RestController
@RequestMapping("/solicitud-usuario")
public class SolicitudRegistroService {

	@Autowired
	SolicitudDeRegistroDAO solicitudUsuarioDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nueva-solicitud")
	public SolicitudesDeRegistro crearSolicitudUsuario(@Valid @RequestBody SolicitudesDeRegistro inv){
		return solicitudUsuarioDAO.save(inv);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las Solicitudes de usuarios*/
	@GetMapping("/solicitudes")
	public List<SolicitudesDeRegistro> getAllSolicitudesDeUsuario(){
		 return solicitudUsuarioDAO.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener solicitud por ID*/
	@GetMapping ("/solicitud/{id}")
	public ResponseEntity<SolicitudesDeRegistro> getSolicitudesDeUsuarioById(@PathVariable(value="id") Long empid){
		
		SolicitudesDeRegistro ciu= solicitudUsuarioDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar solicitud por id*/
	@PutMapping("/solicitud/{id}")
	public ResponseEntity<SolicitudesDeRegistro> updateSolicitudesDeUsuario(@PathVariable(value="id") Long empid, @Valid @RequestBody SolicitudesDeRegistro solicitudDetalle){
		SolicitudesDeRegistro sol = solicitudUsuarioDAO.finOne(empid);
		if(sol==null){
			return ResponseEntity.notFound().build();
		}
		
		sol.setEstadoSolicitud(solicitudDetalle.getEstadoSolicitud());
		
		SolicitudesDeRegistro actualizar= solicitudUsuarioDAO.save(sol);
		return ResponseEntity.ok().body(sol);
		
	}
	
	@DeleteMapping("/solicitud/{id}")
	public ResponseEntity<SolicitudesDeRegistro> deleteSolicitudesDeUsuario(@PathVariable(value="id") Long empid){
		SolicitudesDeRegistro ciu=solicitudUsuarioDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		solicitudUsuarioDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
	
}
