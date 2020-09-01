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
import uelbosque.lerni.DAO.ActividadDisciplinariaDAO;
import uelbosque.lerni.model.ActividadDisciplinaria;
import uelbosque.lerni.model.ErrorObject;
import uelbosque.lerni.model.Registro_notas_kpi;

@RestController
@RequestMapping("/actividad-disciplinaria")
public class ActividadDisciplinariaService {
	
	@Autowired
	ActividadDisciplinariaDAO actividadDisciplinariaDAO;
	
	@Operation(
			summary = "Creacion de actividades disciplinaria",
			description = "Creacion de Actividade disciplinaria",
			tags = "ActividadDisciplinaria"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = ActividadDisciplinaria.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "400",
					 description = "Bad request, El objeto JSON se envio nulo para la peticion ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	@PostMapping("/actividad")
	public ResponseEntity<ActividadDisciplinaria> crearActividad(@Valid @RequestBody ActividadDisciplinaria inv){
		if(!inv.equals(null)){
			actividadDisciplinariaDAO.save(inv);
			return ResponseEntity.ok().body(inv);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@Operation(
			summary = "Consulta de todas las actividades disciplinarias",
			description = "Consulta de Actividades disciplinarias",
			tags = "ActividadDisciplinaria"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = ActividadDisciplinaria.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, no existen actividades disciplinarias en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* tomar todas las actividades*/
	@GetMapping("/actividades")
	public ResponseEntity<List<ActividadDisciplinaria>> getAllActividades(){
		if(actividadDisciplinariaDAO.findAll().equals(null)||actividadDisciplinariaDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		} else {
		    return ResponseEntity.ok().body(actividadDisciplinariaDAO.findAll());
		}
	}
	
	@Operation(
			summary = "Consulta una actividad disciplinarias en particular",
			description = "Consulta de Actividad disciplinaria en particular",
			tags = "ActividadDisciplinaria"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = ActividadDisciplinaria.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, no existe la actividad disciplinaria en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* obtener actiidad por ID*/
	@GetMapping ("/actividades/{id}")
	public ResponseEntity<ActividadDisciplinaria> getActividadId(@PathVariable(value="id") Long empid){
		
		ActividadDisciplinaria ciu= actividadDisciplinariaDAO.finOne(empid);
		if(ciu==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(ciu);
	}
	
	@Operation(
			summary = "Actualizacion de una actividad disciplinaria en particular",
			description = "Actualizacion de una Actividad disciplinaria en particular",
			tags = "ActividadDisciplinaria"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = ActividadDisciplinaria.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "404",
					 description = "Not found, No existe la actividad disciplinaria a actualizar en la base de datos  ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* actualizar actividad por id*/
	@PutMapping("/actividad/{id}")
	public ResponseEntity<ActividadDisciplinaria> updateActividad(@PathVariable(value="id") Long empid, @Valid @RequestBody ActividadDisciplinaria actividadDetalle){
		ActividadDisciplinaria act = actividadDisciplinariaDAO.finOne(empid);
		if(act==null){
			return ResponseEntity.notFound().build();
		}
		
		act.setCod_actividad(actividadDetalle.getCod_actividad());
		act.setNombre(actividadDetalle.getNombre());
		act.setDescripcion_actividad(actividadDetalle.getDescripcion_actividad());
		act.setRecompensa_por_cumplimiento_actividad(actividadDetalle.getRecompensa_por_cumplimiento_actividad());
		
		
		ActividadDisciplinaria actualizar= actividadDisciplinariaDAO.save(act);
		return ResponseEntity.ok().body(act);
		
	}
	
	@Operation(
			summary = "borrado de una actividad disciplinaria en particular",
			description = "borrado de una Actividad disciplinaria en particular",
			tags = "ActividadDisciplinaria"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = ActividadDisciplinaria.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No Content, No existe la actividad disciplinaria a borrar en la base de datos  ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@DeleteMapping("/actividad/{id}")
	public ResponseEntity<ActividadDisciplinaria> deleteActividad(@PathVariable(value="id") Long empid){
		ActividadDisciplinaria ciu=actividadDisciplinariaDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		actividadDisciplinariaDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
}
