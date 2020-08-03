package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import uelbosque.lerni.model.Kpi_indicadores_rendimiento;
import uelbosque.lerni.repository.Kpi_indicadores_rendimiento_repository;

@Service
public class Kpi_indicadores_rendimientoDAO {
	
	@Autowired
	Kpi_indicadores_rendimiento_repository kpi_indicadores_rendimiento_repository;
	
	/* guardar KPI */
	public Kpi_indicadores_rendimiento save(Kpi_indicadores_rendimiento dir){
		return  kpi_indicadores_rendimiento_repository.save(dir);
	}
	/* Buscar KPI */
	public List<Kpi_indicadores_rendimiento> findAll(){
		return kpi_indicadores_rendimiento_repository.findAll();
	}
	/* Buscar KPI por ID */
	public Kpi_indicadores_rendimiento finOne(Long empid){
		return kpi_indicadores_rendimiento_repository.findOne(empid);
	}
	/* borrar KPI por ID*/
	
	public void delete(Kpi_indicadores_rendimiento emp){
		kpi_indicadores_rendimiento_repository.delete(emp);
	}
}
