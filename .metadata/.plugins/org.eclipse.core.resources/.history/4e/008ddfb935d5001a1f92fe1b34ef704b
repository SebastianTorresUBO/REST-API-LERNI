package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.ActividadDisciplinaria;

import uelbosque.lerni.repository.ActividadDisciplinariaRepository;

@Service
public class ActividadDisciplinariaDAO {
	
	@Autowired
	ActividadDisciplinariaRepository actividadDisciplinariaRepository;
	
	/* guardar Administrador */
	public ActividadDisciplinaria save(ActividadDisciplinaria dir){
		return  actividadDisciplinariaRepository.save(dir);
	}
	
	/* Buscar Administrador */
	public List<ActividadDisciplinaria> findAll(){
		return actividadDisciplinariaRepository.findAll();
	}
	
	/* Buscar Administrador por ID */
	public ActividadDisciplinaria finOne(Long empid){
		return actividadDisciplinariaRepository.findOne(empid);
	}
	
	/* borrar Administrador por ID*/
	public void delete(ActividadDisciplinaria emp){
		actividadDisciplinariaRepository.delete(emp);
	}	
	
}
