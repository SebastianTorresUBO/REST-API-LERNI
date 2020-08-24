package uelbosque.lerni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uelbosque.lerni.model.Usuario;

@Repository
public interface UsuarioRepositoryJPQL extends CrudRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.username=?1")
	Usuario findRegisteredUser(String user);
}
