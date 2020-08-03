package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.Profesor;
import uelbosque.lerni.repository.ProfesorRepository;

@Service
public class ProfesorDAO {
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	/* guardar Profesor */
	public Profesor save(Profesor dir){
		return  profesorRepository.save(dir);
	}
	/* Buscar Profesor */
	public List<Profesor> findAll(){
		return profesorRepository.findAll();
	}
	/* Buscar Profesor por ID */
	public Profesor finOne(Long empid){
		return profesorRepository.findOne(empid);
	}
	/* borrar Profesor por ID*/
	
	public void delete(Profesor emp){
		profesorRepository.delete(emp);
	}
}
