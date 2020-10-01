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
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import uelbosque.lerni.DAO.EstudianteDAO;
import uelbosque.lerni.model.ActividadDisciplinaria;
import uelbosque.lerni.model.ErrorObject;
import uelbosque.lerni.model.Estudiante;
import uelbosque.lerni.model.SolicitudesDeRegistro;


@RestController
@RequestMapping("/estudiante")
public class EstudianteService {
	
	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Operation(
			summary = "Ingreso de un nuevo estudiante",
			description = "Ingreso de nuevo estudiante",
			tags = "Estudiante"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Estudiante.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "400",
					 description = "Bad request, El objeto JSON de inserción viene vacio ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 ),
			 @ApiResponse(
					 responseCode = "500",
					 description = "Internal server error, Se esta violando una restriccion de la base de datos con la información ingresada",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
			 
	 }
	)
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
	
	@Operation(
			summary = "Consulta de todos los estudiantes",
			description = "Consulta de estudiantes",
			tags = "Estudiante"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Estudiante.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No hay estudiantes en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
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
	
	@Operation(
			summary = "Consulta de estudiante en particular",
			description = "Consulta de estudiante en particular",
			tags = "Estudiante"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Estudiante.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No exite el estudiante en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
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
	
	@Operation(
			summary = "Actualizacion de estudiante en particular",
			description = "Actualizacion de estudiante en particular",
			tags = "Estudiante"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Estudiante.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "404",
					 description = "Not found, No exite el estudiante a actualizar en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
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
		est.setCedula_padre_tutor(estudianteDetalle.getCedula_padre_tutor());
		est.setCod_curso(estudianteDetalle.getCod_curso());
		
		Estudiante actualizar= estudianteDAO.save(est);
		return ResponseEntity.ok().body(est);
		
	}
	
	@Operation(
			summary = "Borrado de estudiante en particular",
			description = "Borrado de estudiante en particular",
			tags = "Estudiante"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Estudiante.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, No exite el estudiante a borrar en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
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
