package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.Administrador;
import uelbosque.lerni.repository.AdministradorRepository;


@Service
public class AdministradorDAO {

	@Autowired
	AdministradorRepository administradorRepository;
	
	/* guardar Administrador */
	public Administrador save(Administrador dir){
		return  administradorRepository.save(dir);
	}
	
	/* Buscar Administrador */
	public List<Administrador> findAll(){
		return administradorRepository.findAll();
	}
	
	/* Buscar Administrador por ID */
	public Administrador finOne(Long empid){
		return administradorRepository.findOne(empid);
	}
	
	/* borrar Administrador por ID*/
	public void delete(Administrador emp){
		administradorRepository.delete(emp);
	}	
	
}
