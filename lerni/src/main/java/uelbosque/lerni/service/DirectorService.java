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

import uelbosque.lerni.DAO.DirectorDAO;

import uelbosque.lerni.model.Director;




@RestController
@RequestMapping("/director")
public class DirectorService {

	@Autowired
	DirectorDAO directorDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-director")
	public ResponseEntity<Director> crearDirector(@Valid @RequestBody Director inv){
		if(inv!=null){
			directorDAO.save(inv);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build(); 
		}
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todos los directores*/
	@GetMapping("/directores")
	public ResponseEntity<List<Director>> getAllDirectores(){
		if (directorDAO.findAll().equals(null)|| directorDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		} else{ 
			return ResponseEntity.ok().body(directorDAO.findAll());
		}
	}
	
	@CrossOrigin(origins ="*")
	/* obtener Director por ID*/
	@GetMapping ("/directores/{id}")
	public ResponseEntity<Director> getDirectorById(@PathVariable(value="id") Long empid){
		
		Director ciu= directorDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar Director por id*/
	@PutMapping("/director/{id}")
	public ResponseEntity<Director> updateDirector(@PathVariable(value="id") Long empid, @Valid @RequestBody Director directorDetalle){
		Director dir = directorDAO.finOne(empid);
		if(dir==null){
			return ResponseEntity.notFound().build();
		}
		
		dir.setCedula(directorDetalle.getCedula());
		dir.setNombres(directorDetalle.getNombres());
		dir.setApellidos(directorDetalle.getApellidos());
		dir.setCod_usuario(directorDetalle.getCod_usuario());
		
		Director actualizar= directorDAO.save(dir);
		return ResponseEntity.ok().body(dir);
		
	}
	
	@DeleteMapping("/director/{id}")
	public ResponseEntity<Director> deleteDirector(@PathVariable(value="id") Long empid){
		Director ciu=directorDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		directorDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
