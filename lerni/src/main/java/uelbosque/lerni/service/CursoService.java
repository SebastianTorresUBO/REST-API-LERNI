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

import uelbosque.lerni.DAO.CursoDAO;

import uelbosque.lerni.model.Curso;



@RestController
@RequestMapping("/curso")
public class CursoService {

	@Autowired
	CursoDAO cursoDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/curso")
	public Curso crearCurso(@Valid @RequestBody Curso inv){
		return cursoDAO.save(inv);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todos los cursos*/
	@GetMapping("/cursos")
	public List<Curso> getAllCursos(){
		 return cursoDAO.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener curso por ID*/
	@GetMapping ("/cursos/{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable(value="id") Long empid){
		
		Curso ciu= cursoDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar Curso por id*/
	@PutMapping("/curso/{id}")
	public ResponseEntity<Curso> updateCurso(@PathVariable(value="id") Long empid, @Valid @RequestBody Curso cursoDetalle){
		Curso cur = cursoDAO.finOne(empid);
		if(cur==null){
			return ResponseEntity.notFound().build();
		}
		
		cur.setCodigo_curso(cursoDetalle.getCodigo_curso());
		cur.setNombre_curso(cursoDetalle.getNombre_curso());
		cur.setCod_estudiante(cursoDetalle.getCod_estudiante());
		cur.setCedula_profesor(cursoDetalle.getCedula_profesor());
		cur.setNumero_estudiantes(cursoDetalle.getNumero_estudiantes());
		
		Curso actualizar= cursoDAO.save(cur);
		return ResponseEntity.ok().body(cur);
		
	}
	
	@DeleteMapping("/curso/{id}")
	public ResponseEntity<Curso> deleteCurso(@PathVariable(value="id") Long empid){
		Curso ciu=cursoDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		cursoDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
