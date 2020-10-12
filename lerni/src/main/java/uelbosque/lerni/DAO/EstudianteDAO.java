package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.Estudiante;
import uelbosque.lerni.repository.EstudianteRepository;
import uelbosque.lerni.repository.EstudianteRepositoryJPQL;


@Service
public class EstudianteDAO {
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	EstudianteRepositoryJPQL estudianteRepositoryJPQL;
	
	/* guardar estudiante */
	public Estudiante save(Estudiante dir){
		return  estudianteRepository.save(dir);
	}
	/* Buscar estudiante */
	public List<Estudiante> findAll(){
		return estudianteRepository.findAll();
	}
	/* Buscar estudiante por ID */
	public Estudiante finOne(Long empid){
		return estudianteRepository.findOne(empid);
	}
	/* borrar estudiante por ID*/
	
	public void delete(Estudiante emp){
		estudianteRepository.delete(emp);
	}
	/* Buscar estudiante por cedula padre */
	public Estudiante finOnePadreTutor(int empid){
		return estudianteRepositoryJPQL.findEstudianteByPadreTutor(empid);
	}
}
