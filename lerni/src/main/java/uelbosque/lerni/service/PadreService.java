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

import uelbosque.lerni.DAO.Padre_tutorDAO;

import uelbosque.lerni.model.Padre_tutor;

@RestController
@RequestMapping("/padre")
public class PadreService {

	@Autowired
	Padre_tutorDAO padre_tutorDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-padre")
	public ResponseEntity<Padre_tutor> crearPersona(@Valid @RequestBody Padre_tutor pro){
		if(!pro.equals(null)){
		  padre_tutorDAO.save(pro);
		  return ResponseEntity.ok().build();
		} else{
		  return ResponseEntity.badRequest().build();
		}
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todos los padres*/
	@GetMapping("/padres")
	public ResponseEntity<List<Padre_tutor>> getAllPadres(){
		if(padre_tutorDAO.findAll().equals(null)||padre_tutorDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.ok().body(padre_tutorDAO.findAll());
		}
	
	}
	
	@CrossOrigin(origins ="*")
	/* obtener padres por ID*/
	@GetMapping ("/padres/{id}")
	public ResponseEntity<Padre_tutor> getPadresById(@PathVariable(value="id") Long empid){
		
		Padre_tutor pro= padre_tutorDAO.finOne(empid);
		if(pro==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(pro);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar padre por id*/
	@PutMapping("/padre/{id}")
	public ResponseEntity<Padre_tutor> updatePadre(@PathVariable(value="id") Long empid, @Valid @RequestBody Padre_tutor padreDetalle){
		Padre_tutor pad = padre_tutorDAO.finOne(empid);
		if(pad==null){
			return ResponseEntity.notFound().build();
		}
		
		pad.setCedula(padreDetalle.getCedula());
		pad.setNombre(padreDetalle.getNombre());
		pad.setApellidos(padreDetalle.getApellidos());
		pad.setCod_usuario(padreDetalle.getCod_usuario());
		pad.setId_estudiante(padreDetalle.getId_estudiante());
		
		Padre_tutor actualizar= padre_tutorDAO.save(pad);
		return ResponseEntity.ok().body(pad);
		
	}
	
	@DeleteMapping("/padre/{id}")
	public ResponseEntity<Padre_tutor> deletePadre(@PathVariable(value="id") Long empid){
		Padre_tutor ciu=padre_tutorDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		padre_tutorDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
