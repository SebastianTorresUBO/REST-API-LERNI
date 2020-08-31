package uelbosque.lerni.DAO;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.DTO.Registro_notas_kpi_historico;
import uelbosque.lerni.model.Registro_notas_kpi;

import uelbosque.lerni.repository.Registro_Notas_kpi_repository;
import uelbosque.lerni.repository.Registro_Notas_kpi_repositoryJPQL;

@Service
public class Registro_Notas_kpiDAO {
	
	@Autowired
	Registro_Notas_kpi_repository registro_Notas_kpi_repository;
	
	@Autowired
	Registro_Notas_kpi_repositoryJPQL registro_Notas_kpi_repositoryJpql;
	
	/* guardar KPI */
	public Registro_notas_kpi save(Registro_notas_kpi dir){
		return  registro_Notas_kpi_repository.save(dir);
	}
	/* Buscar KPI */
	public List<Registro_notas_kpi> findAll(){
		return registro_Notas_kpi_repository.findAll();
	}
	/* Buscar KPI por ID */
	public Registro_notas_kpi finOne(Long empid){
		return registro_Notas_kpi_repository.findOne(empid);
	}
	/* borrar KPI por ID*/
	
	public void delete(Registro_notas_kpi emp){
		registro_Notas_kpi_repository.delete(emp);
	}
	/* Buscar KPI */
	public List<Object> findAllNative(){
		return registro_Notas_kpi_repositoryJpql.findAllHistoryNotes();
	}
}
