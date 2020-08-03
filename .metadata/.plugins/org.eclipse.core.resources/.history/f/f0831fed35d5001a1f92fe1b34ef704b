package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.SolicitudesDeRegistro;
import uelbosque.lerni.repository.SolicitudesDeRegistroRepository;

@Service
public class SolicitudDeRegistroDAO {

	@Autowired
	SolicitudesDeRegistroRepository solicitudUsuarioRepository;
	
	
	/* guardar Persona */
	public SolicitudesDeRegistro save(SolicitudesDeRegistro sol){
		return  solicitudUsuarioRepository.save(sol);
	}
	/* Buscar Persona */
	public List<SolicitudesDeRegistro> findAll(){
		return solicitudUsuarioRepository.findAll();
	}
	/* Buscar Persona por ID */
	public SolicitudesDeRegistro finOne(Long empid){
		return solicitudUsuarioRepository.findOne(empid);
	}
	/* borrar Persona por ID*/
	
	public void delete(SolicitudesDeRegistro emp){
		solicitudUsuarioRepository.delete(emp);
	}
	
}
