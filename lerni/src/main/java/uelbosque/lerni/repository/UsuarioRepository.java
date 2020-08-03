package uelbosque.lerni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uelbosque.lerni.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
