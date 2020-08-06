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

import uelbosque.lerni.DAO.EstudianteDAO;
import uelbosque.lerni.model.ActividadDisciplinaria;
import uelbosque.lerni.model.Estudiante;


@RestController
@RequestMapping("/estudiante")
public class EstudianteService {
	
	@Autowired
	EstudianteDAO estudianteDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-estudiante")
	public ResponseEntity<Estudiante> crearEstudiante(@Valid @RequestBody Estudiante inv){
		if(!inv.equals(null)){
			estudianteDAO.save(inv);
			return ResponseEntity.ok().build();
		}else{
			return ResponseEntity.badRequest().build();
		}
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todos los estudiantes*/
	@GetMapping("/estudiantes")
	public ResponseEntity<List<Estudiante>> getAllEstudiantes(){
		 if(estudianteDAO.findAll().equals(null)||estudianteDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		 } else {
			return ResponseEntity.ok().body(estudianteDAO.findAll());
		 }
	}
	
	@CrossOrigin(origins ="*")
	/* obtener estudiante por ID*/
	@GetMapping ("/estudiantes/{id}")
	public ResponseEntity<Estudiante> getEstudianteById(@PathVariable(value="id") Long empid){
		
		Estudiante ciu= estudianteDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar estudiante por id*/
	@PutMapping("/estudiante/{id}")
	public ResponseEntity<Estudiante> updateEstudiante(@PathVariable(value="id") Long empid, @Valid @RequestBody Estudiante estudianteDetalle){
		Estudiante est = estudianteDAO.finOne(empid);
		if(est==null){
			return ResponseEntity.notFound().build();
		}
		est.setId_estudiante(estudianteDetalle.getId_estudiante());
		est.setNombre(estudianteDetalle.getNombre());
		est.setApellidos(estudianteDetalle.getApellidos());
		est.setEdad(estudianteDetalle.getEdad());
		est.setCod_usuario(estudianteDetalle.getCod_usuario());
		est.setId_kpi(estudianteDetalle.getId_kpi());
		est.setCedula_padre_tutor(estudianteDetalle.getCedula_padre_tutor());
		est.setCod_curso(estudianteDetalle.getCod_curso());
		
		Estudiante actualizar= estudianteDAO.save(est);
		return ResponseEntity.ok().body(est);
		
	}
	
	@DeleteMapping("/estudiante/{id}")
	public ResponseEntity<Estudiante> deleteEstudiante(@PathVariable(value="id") Long empid){
		Estudiante ciu=estudianteDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		estudianteDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
