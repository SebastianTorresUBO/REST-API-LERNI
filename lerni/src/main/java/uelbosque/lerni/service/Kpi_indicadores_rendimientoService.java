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


import uelbosque.lerni.DAO.Registro_Notas_kpiDAO;
import uelbosque.lerni.model.Registro_notas_kpi;



@RestController
@RequestMapping("/kpi")
public class Kpi_indicadores_rendimientoService {

	@Autowired
	 Registro_Notas_kpiDAO registro_Notas_kpiDAO;
	
	
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
	
	@DeleteMapping("/kpi/{id}")
	public ResponseEntity<Registro_notas_kpi> deleteKpis(@PathVariable(value="id") Long empid){
		Registro_notas_kpi ciu=registro_Notas_kpiDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		registro_Notas_kpiDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
	
	
}
