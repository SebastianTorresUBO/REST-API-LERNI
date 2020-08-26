package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	private Long codigo_curso;
	private String nombre_curso;
	
	
	public Long getCodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(Long codigo_curso) {
		this.codigo_curso = codigo_curso;
	}
	public String getNombre_curso() {
		return nombre_curso;
	}
	public void setNombre_curso(String nombre_curso) {
		this.nombre_curso = nombre_curso;
	}
	
	
	
		
}
