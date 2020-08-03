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

import uelbosque.lerni.DAO.CalificacionDAO;

import uelbosque.lerni.model.Calificacion;


@RestController
@RequestMapping("/calificacion")
public class CalificacionService {

	@Autowired
	CalificacionDAO calificacionDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/calificacion")
	public Calificacion crearCalificacion(@Valid @RequestBody Calificacion inv){
		return calificacionDAO.save(inv);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las calificaciones*/
	@GetMapping("/calificaciones")
	public List<Calificacion> getAllCalificaciones(){
		 return calificacionDAO.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener calificacion por ID*/
	@GetMapping ("/calificaciones/{id}")
	public ResponseEntity<Calificacion> getPersonaById(@PathVariable(value="id") Long empid){
		
		Calificacion ciu= calificacionDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar calificacion por id*/
	@PutMapping("/calificacion/{id}")
	public ResponseEntity<Calificacion> updateCalificacion(@PathVariable(value="id") Long empid, @Valid @RequestBody Calificacion calificacionDetalle){
		Calificacion cal = calificacionDAO.finOne(empid);
		if(cal==null){
			return ResponseEntity.notFound().build();
		}
		
		cal.setId_calificacion(calificacionDetalle.getId_calificacion());
		cal.setCedula_profesor(calificacionDetalle.getCedula_profesor());
		cal.setCod_actividad(calificacionDetalle.getCod_actividad());
		cal.setValor(calificacionDetalle.getValor());
		
		Calificacion actualizar= calificacionDAO.save(cal);
		return ResponseEntity.ok().body(cal);
		
	}
	
	@DeleteMapping("/calificacion/{id}")
	public ResponseEntity<Calificacion> deleteCalificacion(@PathVariable(value="id") Long empid){
		Calificacion ciu=calificacionDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		calificacionDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
