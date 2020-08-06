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

import uelbosque.lerni.DAO.AdministradorDAO;

import uelbosque.lerni.model.Administrador;





@RestController
@RequestMapping("/administrador")
public class AdministradorService {

	@Autowired
	AdministradorDAO administradorDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/administrador")
	public ResponseEntity<Administrador> crearAdministrador(@Valid @RequestBody Administrador inv){
		if(!inv.equals(null)){
			administradorDAO.save(inv);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todos los administradores*/
	@GetMapping("/administradores")
	public ResponseEntity<List<Administrador>> getAllAdministradores(){
	   if(administradorDAO.findAll().equals(null)|| administradorDAO.findAll().size()==0){
		   return ResponseEntity.noContent().build();
	   } else {
		   return ResponseEntity.ok().body(administradorDAO.findAll());
	   }
	}
	
	@CrossOrigin(origins ="*")
	/* obtener administrador por ID*/
	@GetMapping ("/administradores/{id}")
	public ResponseEntity<Administrador> getAdministradorById(@PathVariable(value="id") Long empid){
		
		Administrador ciu= administradorDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar administrador por id*/
	@PutMapping("/administrador/{id}")
	public ResponseEntity<Administrador> updateAdministrador(@PathVariable(value="id") Long empid, @Valid @RequestBody Administrador administradorDetalle){
		Administrador dir = administradorDAO.finOne(empid);
		if(dir==null){
			return ResponseEntity.notFound().build();
		}
		
		dir.setCedula(administradorDetalle.getCedula());
		dir.setNombres(administradorDetalle.getNombres());
		dir.setApellidos(administradorDetalle.getApellidos());
		dir.setCod_usuario(administradorDetalle.getCod_usuario());
		
		Administrador actualizar= administradorDAO.save(dir);
		return ResponseEntity.ok().body(dir);
		
	}
	
	@DeleteMapping("/administrador/{id}")
	public ResponseEntity<Administrador> deleteAdministrador(@PathVariable(value="id") Long empid){
		Administrador ciu=administradorDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		administradorDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
	
}
