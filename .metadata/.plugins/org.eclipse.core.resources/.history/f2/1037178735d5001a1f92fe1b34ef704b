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

import uelbosque.lerni.DAO.UsuarioDAO;
import uelbosque.lerni.model.Administrador;
import uelbosque.lerni.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-usuario")
	public Usuario crearPersona(@Valid @RequestBody Usuario inv){
		return usuarioDAO.save(inv);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas los usuarios*/
	@GetMapping("/solicitudes-usuario")
	public List<Usuario> getAllPersons(){
		 return usuarioDAO.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener usuario por ID*/
	@GetMapping ("/usuario/{id}")
	public ResponseEntity<Usuario> getPersonaById(@PathVariable(value="id") Long empid){
		
		Usuario ciu= usuarioDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar usuario por id*/
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updatePersona(@PathVariable(value="id") Long empid, @Valid @RequestBody Usuario usuarioDetalle){
		Usuario sol = usuarioDAO.finOne(empid);
		if(sol==null){
			return ResponseEntity.notFound().build();
		}
		sol.setCod_usuario(usuarioDetalle.getCod_usuario());
		sol.setCod_tip_usuario(usuarioDetalle.getCod_tipo_usuario());
		sol.setNombres(usuarioDetalle.getNombres());
		sol.setApellidos(usuarioDetalle.getApellidos());
		
		Usuario actualizar= usuarioDAO.save(sol);
		return ResponseEntity.ok().body(sol);
		
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deleteAdministrador(@PathVariable(value="id") Long empid){
		Usuario ciu=usuarioDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		usuarioDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
