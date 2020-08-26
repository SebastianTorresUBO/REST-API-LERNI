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
	public ResponseEntity<Calificacion> crearCalificacion(@Valid @RequestBody Calificacion inv){
		if(!inv.equals(null)){
			calificacionDAO.save(inv);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las calificaciones*/
	@GetMapping("/calificaciones")
	public ResponseEntity<List<Calificacion>> getAllCalificaciones(){
		if(calificacionDAO.findAll().equals(null)|| calificacionDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.ok().body(calificacionDAO.findAll());
		}
	}
	
	@CrossOrigin(origins ="*")
	/* obtener calificacion por ID*/
	@GetMapping ("/calificaciones/{id}")
	public ResponseEntity<Calificacion> getPersonaById(@PathVariable(value="id") Long empid){
		
		Calificacion ciu= calificacionDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
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
		cal.setValor(calificacionDetalle.getValor());
		cal.setDescripcion(calificacionDetalle.getDescripcion());
		
		
		Calificacion actualizar= calificacionDAO.save(cal);
		return ResponseEntity.ok().body(cal);
		
	}
	
	@DeleteMapping("/calificacion/{id}")
	public ResponseEntity<Calificacion> deleteCalificacion(@PathVariable(value="id") Long empid){
		Calificacion ciu=calificacionDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		calificacionDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
