package uelbosque.lerni.DAO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioDAO UsuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   Usuario usuario = UsuarioDAO.findRegisteredUser(username);
	   if(!"lerniRegisterRequest".equals(username)) {	
			if(!usuario.equals(null)) {
				if (usuario.getUsername().equals(username)) {
					return new User(usuario.getUsername(), usuario.getPassword(),
							new ArrayList<>());
				} else {
					throw new UsernameNotFoundException("User not found with username: " + username);
				}
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		} else {
			return new User("lerniRegisterRequest", "$2a$10$Obcz/iXW3ouuJsIDIITRW.pokCf/Fs/Z94qKb0o0Usw8zgqsCfWky",
									new ArrayList<>());
		}
	}

}
 