package uelbosque.lerni.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uelbosque.lerni.DTO.Registro_notas_kpi_historico;
import uelbosque.lerni.model.Registro_notas_kpi;


@Repository
public interface Registro_Notas_kpi_repositoryJPQL extends CrudRepository<Registro_notas_kpi, Long>{

	@Query(value = "SELECT NEW uelbosque.lerni.DTO.Registro_notas_kpi_historico (r.id_nota_kpi, r.id_estudiante, e.nombre_estudiante, e.apellidos_estudiante, e.edad,\r\n" + 
			"	e.cedula_padre_tutor, c.valor, c.descripcion, a.nombre, a.recompensa_por_cumplimiento_actividad,\r\n" + 
			"	r.cedula_profesor, p.nombres, p.apellidos)\r\n" + 
			"	from Registro_notas_kpi r, Estudiante e, Calificacion c, ActividadDisciplinaria a, Profesor p\r\n" + 
			"	where r.id_estudiante = e.id_estudiante\r\n" + 
			"	and r.id_calificacion=c.id_calificacion\r\n" + 
			"	and r.cod_actividad = a.cod_actividad \r\n" + 
			"	and r.cedula_profesor=p.cedula", nativeQuery = false)
	List<Registro_notas_kpi_historico> findAllHistoryNotes();

}
