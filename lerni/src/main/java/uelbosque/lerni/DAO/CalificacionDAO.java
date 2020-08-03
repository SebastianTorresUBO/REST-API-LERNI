package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uelbosque.lerni.model.Calificacion;
import uelbosque.lerni.repository.CalificacionRepository;

@Service
public class CalificacionDAO {

	@Autowired
	CalificacionRepository calificacionRepository;
	
	/* guardar calificacion */
	public Calificacion save(Calificacion dir){
		return  calificacionRepository.save(dir);
	}
	/* Buscar calificacion */
	public List<Calificacion> findAll(){
		return calificacionRepository.findAll();
	}
	/* Buscar calificacion por ID */
	public Calificacion finOne(Long empid){
		return calificacionRepository.findOne(empid);
	}
	/* borrar calificacion por ID*/
	
	public void delete(Calificacion emp){
		calificacionRepository.delete(emp);
	}
	
}
