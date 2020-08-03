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

import uelbosque.lerni.DAO.Kpi_indicadores_rendimientoDAO;
import uelbosque.lerni.model.Kpi_indicadores_rendimiento;


@RestController
@RequestMapping("/kpi")
public class Kpi_indicadores_rendimientoService {

	@Autowired
	Kpi_indicadores_rendimientoDAO kpi_indicadores_rendimientoDAO;
	
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-kpi")
	public Kpi_indicadores_rendimiento crearPersona(@Valid @RequestBody Kpi_indicadores_rendimiento pro){
		return kpi_indicadores_rendimientoDAO.save(pro);
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las padre*/
	@GetMapping("/kpis")
	public List<Kpi_indicadores_rendimiento> getAllPersons(){
			return kpi_indicadores_rendimientoDAO.findAll();
	}
	
	@CrossOrigin(origins ="*")
	/* obtener padre por ID*/
	@GetMapping ("/kpis/{id}")
	public ResponseEntity<Kpi_indicadores_rendimiento> getPersonaById(@PathVariable(value="id") Long empid){
		
		Kpi_indicadores_rendimiento pro= kpi_indicadores_rendimientoDAO.finOne(empid);
		if(pro==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pro);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar padre por id*/
	@PutMapping("/kpi/{id}")
	public ResponseEntity<Kpi_indicadores_rendimiento> updatePersona(@PathVariable(value="id") Long empid, @Valid @RequestBody Kpi_indicadores_rendimiento kpiDetalle){
		Kpi_indicadores_rendimiento kpi = kpi_indicadores_rendimientoDAO.finOne(empid);
		if(kpi==null){
			return ResponseEntity.notFound().build();
		}
		
		kpi.setId_kpi(kpiDetalle.getId_kpi());
		kpi.setId_estudiante(kpiDetalle.getId_estudiante());
		kpi.setCalificacion_actividad(kpiDetalle.getCalificacion_actividad());
		kpi.setFecha_inicio(kpiDetalle.getFecha_inicio());
		kpi.setFecha_fin(kpiDetalle.getFecha_fin());
		
		Kpi_indicadores_rendimiento actualizar= kpi_indicadores_rendimientoDAO.save(kpi);
		return ResponseEntity.ok().body(kpi);
		
	}
	@DeleteMapping("/kpi/{id}")
	public ResponseEntity<Kpi_indicadores_rendimiento> deleteAdministrador(@PathVariable(value="id") Long empid){
		Kpi_indicadores_rendimiento ciu=kpi_indicadores_rendimientoDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.notFound().build();
		}
		kpi_indicadores_rendimientoDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
	
}
