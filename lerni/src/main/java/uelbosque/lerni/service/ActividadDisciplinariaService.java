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

import uelbosque.lerni.DAO.ActividadDisciplinariaDAO;
import uelbosque.lerni.model.ActividadDisciplinaria;

@RestController
@RequestMapping("/actividad-disciplinaria")
public class ActividadDisciplinariaService {
	
	@Autowired
	ActividadDisciplinariaDAO actividadDisciplinariaDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/actividad")
	public ResponseEntity<ActividadDisciplinaria> crearActividad(@Valid @RequestBody ActividadDisciplinaria inv){
		if(!inv.equals(null)){
			actividadDisciplinariaDAO.save(inv);
			return ResponseEntity.ok().body(inv);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las actividades*/
	@GetMapping("/actividades")
	public ResponseEntity<List<ActividadDisciplinaria>> getAllActividades(){
		if(actividadDisciplinariaDAO.findAll().equals(null)||actividadDisciplinariaDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		} else {
		    return ResponseEntity.ok().body(actividadDisciplinariaDAO.findAll());
		}
	}
	
	@CrossOrigin(origins ="*")
	/* obtener actiidad por ID*/
	@GetMapping ("/actividades/{id}")
	public ResponseEntity<ActividadDisciplinaria> getActividadId(@PathVariable(value="id") Long empid){
		
		ActividadDisciplinaria ciu= actividadDisciplinariaDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar actividad por id*/
	@PutMapping("/actividad/{id}")
	public ResponseEntity<ActividadDisciplinaria> updateActividad(@PathVariable(value="id") Long empid, @Valid @RequestBody ActividadDisciplinaria actividadDetalle){
		ActividadDisciplinaria act = actividadDisciplinariaDAO.finOne(empid);
		if(act==null){
			return ResponseEntity.notFound().build();
		}
		
		act.setCod_actividad(actividadDetalle.getCod_actividad());
		act.setNombre(actividadDetalle.getNombre());
		act.setDescripcion_actividad(actividadDetalle.getDescripcion_actividad());
		act.setRecompensa_por_cumplimiento_actividad(actividadDetalle.getRecompensa_por_cumplimiento_actividad());
		
		
		ActividadDisciplinaria actualizar= actividadDisciplinariaDAO.save(act);
		return ResponseEntity.ok().body(act);
		
	}
	
	@DeleteMapping("/actividad/{id}")
	public ResponseEntity<ActividadDisciplinaria> deleteActividad(@PathVariable(value="id") Long empid){
		ActividadDisciplinaria ciu=actividadDisciplinariaDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		actividadDisciplinariaDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
