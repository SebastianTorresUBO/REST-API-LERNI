package uelbosque.lerni.service;

import java.util.Collection;
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
import uelbosque.lerni.DAO.Registro_Notas_kpiDAO;
import uelbosque.lerni.DTO.Registro_notas_kpi_historico;
import uelbosque.lerni.model.ErrorObject;
import uelbosque.lerni.model.Estudiante;
import uelbosque.lerni.model.Registro_notas_kpi;



@RestController
@RequestMapping("/kpi")
public class Kpi_indicadores_rendimientoService {

	@Autowired
	 Registro_Notas_kpiDAO registro_Notas_kpiDAO;
	
	@Operation(
			summary = "Ingreso de nuevo KPI",
			description = "Ingreso de nuevo KPI",
			tags = "Registro_notas_KPI"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Registro_notas_kpi.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "400",
					 description = "Bad request, El objeto JSON viene null o vacio ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 ),
			 @ApiResponse(
					 responseCode = "500",
					 description = "Internal server error, Violacion de restriccion foranea en la insercion de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
			 
	 }
	)
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-kpi")
	public ResponseEntity<Registro_notas_kpi> crearKpi(@Valid @RequestBody Registro_notas_kpi pro){
		if(!pro.equals(null)){
			registro_Notas_kpiDAO.save(pro);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@Operation(
			summary = "Consulta de todos los KPI",
			description = "Consulta de KPI's",
			tags = "Registro_notas_KPI"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Registro_notas_kpi.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, no hay KPI's en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* tomar todos los kpi*/
	@GetMapping("/kpis")
	public ResponseEntity<List<Registro_notas_kpi>> getAllKpis(){
		if(registro_Notas_kpiDAO.findAll().equals(null) || registro_Notas_kpiDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		} else {	
			return ResponseEntity.ok().body(registro_Notas_kpiDAO.findAll());
		}
	}
	
	@Operation(
			summary = "Consulta de KPI en particular",
			description = "Consulta de KPI's por id",
			tags = "Registro_notas_KPI"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Registro_notas_kpi.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, no existe el KPI's en especifico en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* obtener kpi por ID*/
	@GetMapping ("/kpis/{id}")
	public ResponseEntity<Registro_notas_kpi> getKpiById(@PathVariable(value="id") Long empid){
		
		Registro_notas_kpi pro= registro_Notas_kpiDAO.finOne(empid);
		if(pro==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(pro);
	}
	
	@Operation(
			summary = "Actualizacion de un KPI en particular",
			description = "Actualizacion de KPI's",
			tags = "Registro_notas_KPI"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Registro_notas_kpi.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "404",
					 description = "Not found, no existe el KPI a actualizar  ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* actualizar kpi por id*/
	@PutMapping("/kpi/{id}")
	public ResponseEntity<Registro_notas_kpi> updateKpi(@PathVariable(value="id") Long empid, @Valid @RequestBody Registro_notas_kpi kpiDetalle){
		Registro_notas_kpi kpi = registro_Notas_kpiDAO.finOne(empid);
		if(kpi==null){
			return ResponseEntity.notFound().build();
		}
		kpi.setId_nota_kpi(kpiDetalle.getId_nota_kpi());
		kpi.setId_estudiante(kpiDetalle.getId_estudiante());
		kpi.setId_calificacion(kpiDetalle.getId_calificacion());
		kpi.setCod_actividad(kpiDetalle.getCod_actividad());
		kpi.setFecha_inicio(kpiDetalle.getFecha_inicio());
		kpi.setFecha_fin(kpiDetalle.getFecha_fin());
		kpi.setCedula_profesor(kpiDetalle.getCedula_profesor());
		
		Registro_notas_kpi actualizar= registro_Notas_kpiDAO.save(kpi);
		return ResponseEntity.ok().body(kpi);	
	}
	
	@Operation(
			summary = "Borrado de un KPI en particular",
			description = "Borrado de KPI's",
			tags = "Registro_notas_KPI"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Registro_notas_kpi.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, no existe el KPI a borrar  ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@DeleteMapping("/kpi/{id}")
	public ResponseEntity<Registro_notas_kpi> deleteKpis(@PathVariable(value="id") Long empid){
		Registro_notas_kpi ciu=registro_Notas_kpiDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		registro_Notas_kpiDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
	@Operation(
			summary = "Consulta de historico de KPI ",
			description = "Consulta de historico de KPI que trae el detalle en los registros",
			tags = "Registro_notas_KPI"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Registro_notas_kpi_historico.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, no existe el historico de KPI's en especifico en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* tomar todos los kpi*/
	@GetMapping("/history-kpis")
	public ResponseEntity<List<Registro_notas_kpi_historico>> getAllhistoryKpis(){
		if(registro_Notas_kpiDAO.findAllNative().equals(null) || registro_Notas_kpiDAO.findAllNative().size()==0){
			return ResponseEntity.noContent().build();
		} else {	
			
			return ResponseEntity.ok().body(registro_Notas_kpiDAO.findAllNative());
			 
			 
		}
	}
	
	@Operation(
			summary = "Consulta de historico de KPI de un estudiante en particular ",
			description = "Consulta de historico de KPI que trae el detalle en los registros",
			tags = "Registro_notas_KPI"
	)
	@ApiResponses(
	 value= {
			 @ApiResponse(
					 responseCode = "200",
					 description = "successful operation",
					 content= @Content(
							 array= @ArraySchema(
									 schema=@Schema( implementation = Registro_notas_kpi_historico.class)
							 )
					 )
			 ),
			 @ApiResponse(
					 responseCode = "204",
					 description = "No content, no existe el historico de KPI's en especifico en la base de datos ",
					 content= @Content(
							 schema = @Schema(implementation = ErrorObject.class)
							 )
			 )
	 }
	)
	@CrossOrigin(origins ="*")
	/* tomar todos los kpi*/
	@GetMapping("/history-kpis/{id_estudiante}")
	public ResponseEntity<List<Registro_notas_kpi_historico>> getIdhistoryKpi(@PathVariable(value="id_estudiante") int id_estudiante){
		if(registro_Notas_kpiDAO.findIdEstudiante(id_estudiante).equals(null) || registro_Notas_kpiDAO.findIdEstudiante(id_estudiante).size()==0){
			return ResponseEntity.noContent().build();
		} else {	
			return ResponseEntity.ok().body(registro_Notas_kpiDAO.findIdEstudiante(id_estudiante));
		}
	}
	
	
}
