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
	public ResponseEntity<Curso> crearCurso(@Valid @RequestBody Curso inv){
		if(!inv.equals(null)){
			cursoDAO.save(inv);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todos los cursos*/
	@GetMapping("/cursos")
	public ResponseEntity<List<Curso>> getAllCursos(){
		if(cursoDAO.findAll().equals(null)||cursoDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(cursoDAO.findAll());

		}
	}
	
	@CrossOrigin(origins ="*")
	/* obtener curso por ID*/
	@GetMapping ("/cursos/{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable(value="id") Long empid){
		
		Curso ciu= cursoDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
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
		
		
		Curso actualizar= cursoDAO.save(cur);
		return ResponseEntity.ok().body(cur);
		
	}
	@CrossOrigin(origins ="*")
	@DeleteMapping("/curso/{id}")
	public ResponseEntity<Curso> deleteCurso(@PathVariable(value="id") Long empid){
		Curso ciu=cursoDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		cursoDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
