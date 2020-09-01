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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import uelbosque.lerni.DAO.AdministradorDAO;
import uelbosque.lerni.DAO.DirectorDAO;
import uelbosque.lerni.DAO.Padre_tutorDAO;
import uelbosque.lerni.DAO.ProfesorDAO;
import uelbosque.lerni.DAO.SolicitudDeRegistroDAO;
import uelbosque.lerni.DAO.UsuarioDAO;
import uelbosque.lerni.email.HtmlEmailSender;
import uelbosque.lerni.model.Administrador;
import uelbosque.lerni.model.Director;
import uelbosque.lerni.model.ErrorObject;
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
	
	@Operation(
			summary = "Nueva solicitud de registro de usuario",
			description = "Nueva solicitud de un usuario en particular",
			tags = "solicitudRegistro"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = SolicitudesDeRegistro.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "400",
					 description = "Bad request, Envio vacio del objeto JSON de solicitud de registro ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 ),
			 @ApiResponse(
					 responseCode = "409",
					 description = "Conflict, El username de la solicitud que se desea registrar ya esta en uso",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 ),
	 }
	)
	@CrossOrigin(origins ="*")
	@PostMapping("/nueva-solicitud")
	public ResponseEntity<SolicitudesDeRegistro> crearSolicitudUsuario(@Valid @RequestBody SolicitudesDeRegistro inv){
		SolicitudesDeRegistro existUsername=solicitudUsuarioDAO.finOneByUsername(inv.getUsername());
		try {
			if(!existUsername.equals(null)) {
				if(existUsername.getUsername().equals(inv.getUsername())) {
					return ResponseEntity.status(409).build();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!inv.equals(null)){
			
		  String encryptedPassword = hashPassword(inv.getPassword());
		  inv.setPassword(encryptedPassword);
		  solicitudUsuarioDAO.save(inv);
		  return ResponseEntity.ok().build();
		  
		} else {
		  return ResponseEntity.badRequest().build();	
		}
		
	}
	
	@Operation(
			summary = "Consulta de todas las solicitudes de registro de usuario",
			description = "Consulta de todas las solicitudes",
			tags = "solicitudRegistro"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = SolicitudesDeRegistro.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No existen solicitudes de registro de usuarios ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
			 
	 }
	)
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
	
	@Operation(
			summary = "Consulta de  una solicitud de registro de usuario en particular",
			description = "Consulta de solicitud especifica",
			tags = "solicitudRegistro"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = SolicitudesDeRegistro.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No existe la solicitud de usuario ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
			 
	 }
	)
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
	
	@Operation(
			summary = "Actualizacion de  una solicitud de registro de usuario en particular",
			description = "Actualizacion de solicitud",
			tags = "solicitudRegistro"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation, debe enviarse todo el objeto de actualizacion unicamente con la modificacion en el atributo estado solicitud en A (aceptado), P(pendiente), N(negada)",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = SolicitudesDeRegistro.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "404",
					 description = "Not found, No se encontro solicitud de registro en la base de datos para actualizar ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
			 
	 }
	)
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
					dir.setCorreo_electronico(solicitudDetalle.getCorreo_electronico());
					directorDao.save(dir);	
					sendConfirmationEmail(solicitudDetalle.getNombres(), solicitudDetalle.getCorreo_electronico());
				break;	
				case 2:
					pro.setCedula(Long.valueOf(solicitudDetalle.getNumDocumento()));
					pro.setNombres(usu.getNombres());
					pro.setApellidos(usu.getApellidos());
					pro.setTitulo_profesional(solicitudDetalle.getTitulo_profesional());
					pro.setUniversidad(solicitudDetalle.getUniversidad());
					pro.setCod_usuario(usuario.getCod_usuario().intValue());
					pro.setCorreo_electronico(solicitudDetalle.getCorreo_electronico());
					profesorDAO.save(pro);
					sendConfirmationEmail(solicitudDetalle.getNombres(), solicitudDetalle.getCorreo_electronico());
				break;
				case 3:
					par_tut.setCedula(Long.valueOf(solicitudDetalle.getNumDocumento()));
					par_tut.setNombre(usu.getNombres());
					par_tut.setApellidos(usu.getApellidos());
					par_tut.setCod_usuario(usuario.getCod_usuario().intValue());
					par_tut.setCorreo_electronico(solicitudDetalle.getCorreo_electronico());
					padre_tutorDAO.save(par_tut);
					sendConfirmationEmail(solicitudDetalle.getNombres(), solicitudDetalle.getCorreo_electronico());
				break;	
				case 4:
					admin.setCedula(Long.valueOf(solicitudDetalle.getNumDocumento()));
					admin.setNombres(usu.getNombres());
					admin.setApellidos(usu.getApellidos());
					admin.setCod_usuario(usuario.getCod_usuario().intValue());
					admin.setCorreo_electronico(solicitudDetalle.getCorreo_electronico());
					administradorDao.save(admin);
					sendConfirmationEmail(solicitudDetalle.getNombres(), solicitudDetalle.getCorreo_electronico());
				break;	
			}
			return ResponseEntity.ok().body(sol);
			
		}
		sol.setEstadoSolicitud(solicitudDetalle.getEstadoSolicitud());
		
		SolicitudesDeRegistro actualizar= solicitudUsuarioDAO.save(sol);
		return ResponseEntity.ok().body(sol);
		
	}
	
	@Operation(
			summary = "Borrado de  una solicitud de registro de usuario en particular",
			description = "Borrado de solicitud",
			tags = "solicitudRegistro"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = SolicitudesDeRegistro.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "Not found, No se encontro solicitud de registro en la base de datos para eliminar ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
			 
	 }
	)
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
	
	public void sendConfirmationEmail(String nombre, String correoDestino) {
        // SMTP server information
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "lerniapp@gmail.com";
        String password = "Milanesa22";
 
        // outgoing message information
        String mailTo = correoDestino;
        String subject = "LERNI - Registro exitoso" + " Bienvenid@ "+ nombre;
 
        // message contains HTML markups
        String message = "<!DOCTYPE html>\r\n" + 
        		"<html>\r\n" + 
        		"<style>\r\n" + 
        		"	#h1{\r\n" + 
        		"		margin-top: 22%;\r\n" + 
        		"		 font-family: cursive;\r\n" + 
        		"		 color:white;\r\n" + 
        		"	}\r\n" + 
        		"	#h3{\r\n" + 
        		"		font-family: cursive;\r\n" + 
        		"		color:white;\r\n" + 
        		"		font-weight: lighter;\r\n" + 
        		"\r\n" + 
        		"		\r\n" + 
        		"	}\r\n" + 
        		"	#body {\r\n" + 
        		"	  background-image: url('D:/ArtefactoLerni/API-REST/REST-API-LERNI/lerni/lerni.PNG');\r\n" + 
        		"	  background-repeat: no-repeat;\r\n" + 
        		"	  background-attachment: fixed;\r\n" + 
        		"	  background-size: cover;\r\n" + 
        		"	}\r\n" + 
        		"	#div{\r\n" + 
        		"	 text-align: justify;\r\n" + 
        		"	 width: fit-content;\r\n" + 
        		"	}\r\n" + 
        		"	\r\n" + 
        		"</style>\r\n" + 
        		"<body id=\"body\">\r\n" + 
        		"\r\n" + 
        		"<center><h1 id=\"h1\">Bienvenid@ "+nombre +"</h1>\r\n" + 
        		"  <div id=\"#div\">\r\n" + 
        		"	<h3 id=\"h3\">Te confirmamos que tu solicitud de registro ha finalizado correctamente, te invitamos a iniciar sesi&oacute;n\r\n" + 
        		"	en nuestra app m&oacute;vil y comenzar a conectar m&aacute;s de cerca con la educaci&oacute;n de tu hijo.</h3>\r\n" + 
        		"  </div>\r\n" + 
        		"  <br>\r\n" + 
        		"  <br>\r\n" + 
        		"  <br>\r\n" + 
        		"  <br>\r\n" + 
        		"  <br>\r\n" + 
        		"  <br>\r\n" + 
        		"  <br>\r\n" + 
        		"  <br>\r\n" + 
        		"   <h3 id=\"h3\"> Por favor no respondas este mensaje.</h3>\r\n" + 
        		"</body>\r\n" + 
        		"</html>";
 
        HtmlEmailSender mailer = new HtmlEmailSender();
 
        try {
            mailer.sendHtmlEmail(host, port, mailFrom, password, mailTo,
                    subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }
	
	
}
