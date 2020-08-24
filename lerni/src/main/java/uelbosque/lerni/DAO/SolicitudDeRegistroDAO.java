package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.SolicitudesDeRegistro;
import uelbosque.lerni.repository.SolicitudUsuarioRepositoryJPQL;
import uelbosque.lerni.repository.SolicitudesDeRegistroRepository;

@Service
public class SolicitudDeRegistroDAO {

	@Autowired
	SolicitudesDeRegistroRepository solicitudUsuarioRepository;
	
	@Autowired
	SolicitudUsuarioRepositoryJPQL solicitudUsuarioRepositoryJPQL;
	
	/* guardar Solicitud */
	public SolicitudesDeRegistro save(SolicitudesDeRegistro sol){
		return  solicitudUsuarioRepository.save(sol);
	}
	/* Buscar Solicitud */
	public List<SolicitudesDeRegistro> findAll(){
		return solicitudUsuarioRepository.findAll();
	}
	/* Buscar Solicitud por ID */
	public SolicitudesDeRegistro finOne(Long empid){
		return solicitudUsuarioRepository.findOne(empid);
	}
	/* borrar Solicitud por ID*/
	
	public void delete(SolicitudesDeRegistro emp){
		solicitudUsuarioRepository.delete(emp);
	}
	/* Buscar Solicitud por username */
	public SolicitudesDeRegistro finOneByUsername(String username){
		return solicitudUsuarioRepositoryJPQL.findRegisterRequest(username);
	}
	
}
