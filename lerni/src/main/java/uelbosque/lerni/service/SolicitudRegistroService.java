package uelbosque.lerni.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
import uelbosque.lerni.DAO.DirectorDAO;
import uelbosque.lerni.DAO.Padre_tutorDAO;
import uelbosque.lerni.DAO.ProfesorDAO;
import uelbosque.lerni.DAO.SolicitudDeRegistroDAO;
import uelbosque.lerni.DAO.UsuarioDAO;
import uelbosque.lerni.model.Administrador;
import uelbosque.lerni.model.Director;
import uelbosque.lerni.model.Padre_tutor;
import uelbosque.lerni.model.Profesor;
import uelbosque.lerni.model.SolicitudesDeRegistro;
import uelbosque.lerni.model.Tipo_usuario;
import uelbosque.lerni.model.Usuario;

@RestController
@RequestMapping("/solicitud-usuario")
public class SolicitudRegistroService {

	@Autowired
	SolicitudDeRegistroDAO solicitudUsuarioDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	ProfesorDAO profesorDAO;
	
	@Autowired
	AdministradorDAO administradorDao;
	
	@Autowired
	DirectorDAO directorDao;
	
	@Autowired
	Padre_tutorDAO padre_tutorDAO;
	
	private List<Tipo_usuario> tiposDeUsuario= new ArrayList();
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nueva-solicitud")
	public ResponseEntity<SolicitudesDeRegistro> crearSolicitudUsuario(@Valid @RequestBody SolicitudesDeRegistro inv){
	/*	SolicitudesDeRegistro existUsername=solicitudUsuarioDAO.finOneByUsername(inv.getUsername());
		if(!existUsername.equals(null)) {
			if(inv.getUsername().equalsIgnoreCase(existUsername.getUsername())) {
				SolicitudesDeRegistro solicitudesDeRegistro = new SolicitudesDeRegistro();
				solicitudesDeRegistro.setUsername("El Username ingresado ya esta siendo utilizado en Lerni");
				return ResponseEntity.badRequest().body(solicitudesDeRegistro);
			}
		}
	*/
		if(!inv.equals(null)){
		  String encryptedPassword = hashPassword(inv.getPassword());
		  inv.setPassword(encryptedPassword);
		  solicitudUsuarioDAO.save(inv);
		  return ResponseEntity.ok().build();
		} else {
		  return ResponseEntity.badRequest().build();	
		}
		
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las Solicitudes de usuarios*/
	@GetMapping("/solicitudes")
	public ResponseEntity<List<SolicitudesDeRegistro>> getAllSolicitudesDeUsuario(){
		if(solicitudUsuarioDAO.findAll().equals(null)||solicitudUsuarioDAO.findAll().size()==0){ 
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(solicitudUsuarioDAO.findAll());
		}
	}
	
	@CrossOrigin(origins ="*")
	/* obtener solicitud por ID*/
	@GetMapping ("/solicitud/{id}")
	public ResponseEntity<SolicitudesDeRegistro> getSolicitudesDeUsuarioById(@PathVariable(value="id") Long empid){
		
		SolicitudesDeRegistro ciu= solicitudUsuarioDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar solicitud por id*/
	@PutMapping("/solicitud/{id}")
	public ResponseEntity<SolicitudesDeRegistro> updateSolicitudesDeUsuario(@PathVariable(value="id") Long empid, @Valid @RequestBody SolicitudesDeRegistro solicitudDetalle){
		SolicitudesDeRegistro sol = solicitudUsuarioDAO.finOne(empid);
		if(sol==null){
			return ResponseEntity.notFound().build();
		}
		if(solicitudDetalle.getEstadoSolicitud().equalsIgnoreCase("A")) {
			
			sol.setEstadoSolicitud(solicitudDetalle.getEstadoSolicitud());	
			SolicitudesDeRegistro actualizar= solicitudUsuarioDAO.save(sol);
			
			Usuario usu = new Usuario();
			usu.setCod_usuario(solicitudDetalle.getId());
			usu.setNombres(solicitudDetalle.getNombres());
			usu.setApellidos(solicitudDetalle.getApellidos());
			usu.setInstitucion_educativa_vinculada(solicitudDetalle.getInstitucionEducativaVinculada());
			usu.setUsername(solicitudDetalle.getUsername());
			usu.setPassword(solicitudDetalle.getPassword());
			
			tiposDeUsuario.add(0,null);
			
			for(int i=1; i<=4; i++) {
				Tipo_usuario tip=new Tipo_usuario();
				switch (i) {
					case 1:
						tip.setCod_tipo_usuario(Long.valueOf(i));
						tip.setDescripcion("Director");
						tiposDeUsuario.add(1, tip);
						break;
					case 2:
						tip.setCod_tipo_usuario(Long.valueOf(i));
						tip.setDescripcion("Profesor");
						tiposDeUsuario.add(2,tip);
						break;
					case 3:	
						tip.setCod_tipo_usuario(Long.valueOf(i));
						tip.setDescripcion("Padre/Tutor");
						tiposDeUsuario.add(3,tip);
						break;
					case 4:
						tip.setCod_tipo_usuario(Long.valueOf(i));
						tip.setDescripcion("Administrador");
						tiposDeUsuario.add(4,tip);
						break;
				}	
			}
			
			for(int i=0; i<tiposDeUsuario.size(); i++) {
				try {
					if(solicitudDetalle.getRol().equalsIgnoreCase(tiposDeUsuario.get(i).getDescripcion())) {
						usu.setCod_tipo_usuario(i);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			tiposDeUsuario.clear();
			usuarioDAO.save(usu);
			Usuario usuario=usuarioDAO.findRegisteredUser(usu.getUsername());
			
			Director dir = new Director();
			Padre_tutor par_tut=new Padre_tutor();
			Administrador admin = new Administrador();
			Profesor pro= new Profesor();
			
			switch(usu.getCod_tipo_usuario()) {
				case 1:
					dir.setCedula(Long.valueOf(solicitudDetalle.getNumDocumento()));
					dir.setNombres(usu.getNombres());
					dir.setApellidos(usu.getApellidos());
					dir.setCod_usuario(usuario.getCod_usuario().intValue());
					directorDao.save(dir);	
				break;	
				case 2:
					pro.setCedula(Long.valueOf(solicitudDetalle.getNumDocumento()));
					pro.setNombres(usu.getNombres());
					pro.setApellidos(usu.getApellidos());
					pro.setTitulo_profesional(solicitudDetalle.getTitulo_profesional());
					pro.setUniversidad(solicitudDetalle.getUniversidad());
					pro.setCod_usuario(usuario.getCod_usuario().intValue());
					profesorDAO.save(pro);
				break;
				case 3:
					par_tut.setCedula(Long.valueOf(solicitudDetalle.getNumDocumento()));
					par_tut.setNombre(usu.getNombres());
					par_tut.setApellidos(usu.getApellidos());
					par_tut.setCod_usuario(usuario.getCod_usuario().intValue());
					padre_tutorDAO.save(par_tut);
				break;	
				case 4:
					admin.setCedula(Long.valueOf(solicitudDetalle.getNumDocumento()));
					admin.setNombres(usu.getNombres());
					admin.setApellidos(usu.getApellidos());
					admin.setCod_usuario(usuario.getCod_usuario().intValue());
					administradorDao.save(admin);
				break;	
			}
			return ResponseEntity.ok().body(sol);
			
		}
		sol.setEstadoSolicitud(solicitudDetalle.getEstadoSolicitud());
		
		SolicitudesDeRegistro actualizar= solicitudUsuarioDAO.save(sol);
		return ResponseEntity.ok().body(sol);
		
	}
	
	@DeleteMapping("/solicitud/{id}")
	public ResponseEntity<SolicitudesDeRegistro> deleteSolicitudesDeUsuario(@PathVariable(value="id") Long empid){
		SolicitudesDeRegistro ciu=solicitudUsuarioDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		solicitudUsuarioDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(10);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}
	
	
}
