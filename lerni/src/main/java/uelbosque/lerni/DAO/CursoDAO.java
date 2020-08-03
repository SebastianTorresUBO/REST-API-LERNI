package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.Curso;

import uelbosque.lerni.repository.CursoRepository;

@Service
public class CursoDAO {

	@Autowired
	CursoRepository cursoRepository;
	
	/* guardar curso */
	public Curso save(Curso dir){
		return  cursoRepository.save(dir);
	}
	/* Buscar curso */
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	/* Buscar curso por ID */
	public Curso finOne(Long empid){
		return cursoRepository.findOne(empid);
	}
	/* borrar curso por ID*/
	
	public void delete(Curso emp){
		cursoRepository.delete(emp);
	}
	
}
