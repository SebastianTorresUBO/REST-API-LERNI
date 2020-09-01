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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import uelbosque.lerni.DAO.UsuarioDAO;
import uelbosque.lerni.model.ErrorObject;
import uelbosque.lerni.model.Usuario;

@RestController
@RequestMapping("/usuarios")
@Tag(name="usuarios", description = "Usuarios del API")
public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Operation(
			summary = "Insertar nuevo usuario",
			description = "Inserta a usuario",
			tags = "usuarios"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Usuario.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "400",
					 description = "Bad Request, Se envia nulo el objeto de inserción de datos",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-usuario")
	public ResponseEntity<Usuario> crearPersona(@Valid @RequestBody Usuario inv){
		if(!inv.equals(null)){
			usuarioDAO.save(inv);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@Operation(
			summary = "Consultar a todos los usuarios",
			description = "Consultar a todos los usuarios",
			tags = "usuarios"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Usuario.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No hay usuarios en la base de datos",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* tomar todos los usuarios*/
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		if(usuarioDAO.findAll().equals(null) || usuarioDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(usuarioDAO.findAll());
		} 
	}
	
	@Operation(
			summary = "Consulta de usuario con id especifico",
			description = "Consulta un usuario en particular",
			tags = "usuarios"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Usuario.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No existe el usuario en la base de datos",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* obtener usuario por ID*/
	@GetMapping ("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value="id") Long empid){
		Usuario ciu= usuarioDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@Operation(
			summary = "Actualización de usuario con id especifico",
			description = "Actualiza usuario con Id especifico",
			tags = "usuarios"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Usuario.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "404",
					 description = "Not  found, No existe el usuario a actualizar en la base de datos",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* actualizar usuario por id*/
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value="id") Long empid, @Valid @RequestBody Usuario usuarioDetalle){
		Usuario sol = usuarioDAO.finOne(empid);
		if(sol==null){
			return ResponseEntity.notFound().build();
		}
		sol.setCod_usuario(usuarioDetalle.getCod_usuario());
		sol.setCod_tip_usuario(usuarioDetalle.getCod_tipo_usuario());
		sol.setNombres(usuarioDetalle.getNombres());
		sol.setApellidos(usuarioDetalle.getApellidos());
		sol.setUsername(usuarioDetalle.getUsername());
		sol.setPassword(usuarioDetalle.getPassword());
		sol.setInstitucion_educativa_vinculada(usuarioDetalle.getInstitucion_educativa_vinculada());
		
		Usuario actualizar= usuarioDAO.save(sol);
		return ResponseEntity.ok().body(sol);
	}
	
	@Operation(
			summary = "Borrado de usuario con id especifico",
			description = "Borrado de un usuario en particular",
			tags = "usuarios"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Usuario.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No existe el usuario a borrar en la base de datos",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value="id") Long empid){
		Usuario ciu=usuarioDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		usuarioDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
