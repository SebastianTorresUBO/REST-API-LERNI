package uelbosque.lerni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import uelbosque.lerni.model.SolicitudesDeRegistro;


public interface SolicitudUsuarioRepositoryJPQL extends CrudRepository<SolicitudesDeRegistro, Long> {
	
	
	@Query("select s from SolicitudesDeRegistro s where s.username=?1")
	SolicitudesDeRegistro findRegisterRequest(String user);

}
