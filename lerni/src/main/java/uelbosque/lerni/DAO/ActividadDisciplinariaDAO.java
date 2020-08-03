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
	
	/* guardar Actividad disciplinaria */
	public ActividadDisciplinaria save(ActividadDisciplinaria dir){
		return  actividadDisciplinariaRepository.save(dir);
	}
	
	/* Buscar Actividad disciplinaria */
	public List<ActividadDisciplinaria> findAll(){
		return actividadDisciplinariaRepository.findAll();
	}
	
	/* Buscar Actividad disciplinaria por ID */
	public ActividadDisciplinaria finOne(Long empid){
		return actividadDisciplinariaRepository.findOne(empid);
	}
	
	/* borrar Actividad disciplinaria por ID*/
	public void delete(ActividadDisciplinaria emp){
		actividadDisciplinariaRepository.delete(emp);
	}	
	
}
