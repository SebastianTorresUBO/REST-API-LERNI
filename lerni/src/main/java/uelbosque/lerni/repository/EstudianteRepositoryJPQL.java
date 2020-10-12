package uelbosque.lerni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import uelbosque.lerni.model.Estudiante;




public interface EstudianteRepositoryJPQL  extends CrudRepository<Estudiante, Long> {
	
	@Query("select e from Estudiante e where e.cedula_padre_tutor=?1")
	Estudiante findEstudianteByPadreTutor(int cedula);
	
}
