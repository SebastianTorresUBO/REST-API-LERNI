package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.Padre_tutor;
import uelbosque.lerni.repository.Padre_tutor_repository;

@Service
public class Padre_tutorDAO {

	@Autowired
	Padre_tutor_repository padre_tutor_repository;
	
	/* guardar padre */
	public Padre_tutor save(Padre_tutor pad){
		return  padre_tutor_repository.save(pad);
	}
	/* Buscar padre */
	public List<Padre_tutor> findAll(){
		return padre_tutor_repository.findAll();
	}
	/* Buscar padre por ID */
	public Padre_tutor finOne(Long empid){
		return padre_tutor_repository.findOne(empid);
	}
	/* borrar padre por ID*/
	
	public void delete(Padre_tutor emp){
		padre_tutor_repository.delete(emp);
	}
}
