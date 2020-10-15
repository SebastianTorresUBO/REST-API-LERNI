package uelbosque.lerni.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uelbosque.lerni.DTO.CalificacionPromedio_Kpi;
import uelbosque.lerni.DTO.InformacionEstudiante;
import uelbosque.lerni.DTO.Registro_notas_kpi_historico;
import uelbosque.lerni.DTO.Series;
import uelbosque.lerni.DTO.actividadDisciplinariaNombreTorta;
import uelbosque.lerni.model.Registro_notas_kpi;


@Repository
public interface Registro_Notas_kpi_repositoryJPQL extends CrudRepository<Registro_notas_kpi, Long>{

	@Query(value = "SELECT NEW uelbosque.lerni.DTO.Registro_notas_kpi_historico (r.id_nota_kpi, r.id_estudiante, e.nombre_estudiante, e.apellidos_estudiante, e.edad,\r\n" + 
			"	e.cedula_padre_tutor, c.id_calificacion ,c.valor, c.descripcion, a.cod_actividad, a.nombre, a.recompensa_por_cumplimiento_actividad,\r\n" + 
			"	r.cedula_profesor, p.nombres, p.apellidos, r.fecha_inicio, r.fecha_fin)\r\n" + 
			"	from Registro_notas_kpi r, Estudiante e, Calificacion c, ActividadDisciplinaria a, Profesor p\r\n" + 
			"	where r.id_estudiante = e.id_estudiante\r\n" + 
			"	and r.id_calificacion=c.id_calificacion\r\n" + 
			"	and r.cod_actividad = a.cod_actividad \r\n" + 
			"	and r.cedula_profesor=p.cedula", nativeQuery = false)
	List<Registro_notas_kpi_historico> findAllHistoryNotes();
	
	@Query(value = "SELECT NEW uelbosque.lerni.DTO.Registro_notas_kpi_historico (r.id_nota_kpi, r.id_estudiante, e.nombre_estudiante, e.apellidos_estudiante, e.edad,\r\n" + 
			"	e.cedula_padre_tutor, c.id_calificacion ,c.valor, c.descripcion, a.cod_actividad, a.nombre, a.recompensa_por_cumplimiento_actividad,\r\n" + 
			"	r.cedula_profesor, p.nombres, p.apellidos, r.fecha_inicio, r.fecha_fin)\r\n" + 
			"	from Registro_notas_kpi r, Estudiante e, Calificacion c, ActividadDisciplinaria a, Profesor p\r\n" + 
			"	where r.id_estudiante = e.id_estudiante\r\n" + 
			"	and r.id_calificacion=c.id_calificacion\r\n" + 
			"	and r.cod_actividad = a.cod_actividad \r\n" + 
			"	and r.cedula_profesor=p.cedula and r.id_estudiante = ?1", nativeQuery = false)
	List<Registro_notas_kpi_historico> findIdEstudiante(int estudiante);

	@Query(value = "SELECT NEW uelbosque.lerni.DTO.Registro_notas_kpi_historico (r.id_nota_kpi, r.id_estudiante, e.nombre_estudiante, e.apellidos_estudiante, e.edad,\r\n" + 
			"	e.cedula_padre_tutor, c.id_calificacion ,c.valor, c.descripcion, a.cod_actividad, a.nombre, a.recompensa_por_cumplimiento_actividad,\r\n" + 
			"	r.cedula_profesor, p.nombres, p.apellidos, r.fecha_inicio, r.fecha_fin)\r\n" + 
			"	from Registro_notas_kpi r, Estudiante e, Calificacion c, ActividadDisciplinaria a, Profesor p\r\n" + 
			"	where r.id_estudiante = e.id_estudiante\r\n" + 
			"	and r.id_calificacion=c.id_calificacion\r\n" + 
			"	and r.cod_actividad = a.cod_actividad \r\n" + 
			"	and r.cedula_profesor=p.cedula and r.cedula_profesor = ?1", nativeQuery = false)
	List<Registro_notas_kpi_historico> findIdEstudiantebyProfesor(int cedula_profesor);
	
	@Query(value = "SELECT NEW uelbosque.lerni.DTO.Series (c.valor, r.fecha_fin)\r\n" + 
			"	from Registro_notas_kpi r, Estudiante e, Calificacion c where "
			+ "r.id_estudiante =e.id_estudiante and r.id_calificacion=c.id_calificacion and r.id_estudiante = ?1", nativeQuery = false)
	List<Series> getCalificacionyFecha(int id_estudiante);
	
	@Query(value = "SELECT DISTINCT  NEW uelbosque.lerni.DTO.InformacionEstudiante (e.nombre_estudiante,e.apellidos_estudiante )\r\n" + 
			"	from Registro_notas_kpi r, Estudiante e, Calificacion c where "
			+ "r.id_estudiante =e.id_estudiante and r.id_calificacion=c.id_calificacion and r.id_estudiante = ?1", nativeQuery = false)
	InformacionEstudiante getInformacionEstudiante(int id_estudiante);
	
	@Query(value = "SELECT NEW uelbosque.lerni.DTO.actividadDisciplinariaNombreTorta (a.nombre,c.valor)\r\n" + 
			"	from Registro_notas_kpi r, Calificacion c, ActividadDisciplinaria a where "
			+ "r.id_calificacion=c.id_calificacion and r.cod_actividad = a.cod_actividad and r.id_estudiante =?1", nativeQuery = false)
	List<actividadDisciplinariaNombreTorta> getNombreActividad(int id_estudiante);
	
	@Query(value = "SELECT r \r\n" + 
			"	from Registro_notas_kpi r, Estudiante e, Calificacion c where "
			+ "r.id_estudiante =e.id_estudiante and r.id_calificacion=c.id_calificacion and r.id_estudiante = ?1", nativeQuery = false)
	List<Registro_notas_kpi> getCalificacionDiagramaTorta(int id_estudiante);

}
