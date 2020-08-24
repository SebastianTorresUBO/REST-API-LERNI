package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uelbosque.lerni.model.Usuario;
import uelbosque.lerni.repository.UsuarioRepository;
import uelbosque.lerni.repository.UsuarioRepositoryJPQL;

@Service
public class UsuarioDAO {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioRepositoryJPQL usuarioRepositoryJPQL;
	
	
	/* guardar usuario */
	public Usuario save(Usuario usu){
		return  usuarioRepository.save(usu);
	}
	/* Buscar usuario */
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	/* Buscar usuario por ID */
	public Usuario finOne(Long empid){
		return usuarioRepository.findOne(empid);
	}
	/* borrar usuario por ID*/
	
	public void delete(Usuario usu){
		usuarioRepository.delete(usu);
	}
	
	public Usuario findRegisteredUser(String username) {
		return usuarioRepositoryJPQL.findRegisteredUser(username);
	}
}
