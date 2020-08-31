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

	@Query(value = "Select id_nota_kpi, registro_notas_kpi.id_estudiante, estudiante.nombre_estudiante, estudiante.apellidos_estudiante, estudiante.edad,\r\n" + 
			"	estudiante.cedula_padre_tutor, calificacion.valor, calificacion.descripcion, actividad_disciplinaria.nombre, actividad_disciplinaria.recompensa_por_cumplimiento_actividad,\r\n" + 
			"	registro_notas_kpi.cedula_profesor, profesor.nombres, profesor.apellidos\r\n" + 
			"	from registro_notas_kpi, estudiante, calificacion, actividad_disciplinaria, profesor\r\n" + 
			"	where registro_notas_kpi.id_estudiante = estudiante.id_estudiante\r\n" + 
			"	and registro_notas_kpi.id_calificacion=calificacion.id_calificacion\r\n" + 
			"	and registro_notas_kpi.cod_actividad = actividad_disciplinaria.cod_actividad \r\n" + 
			"	and registro_notas_kpi.cedula_profesor=profesor.cedula;", nativeQuery = true)
	List<Object> findAllHistoryNotes();

}
