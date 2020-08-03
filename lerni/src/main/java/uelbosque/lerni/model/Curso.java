package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	private int codigo_curso;
	private String nombre_curso;
	private int cod_estudiante;
	private int cedula_profesor;
	private int numero_estudiantes;
	
	public int getCodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}
	public String getNombre_curso() {
		return nombre_curso;
	}
	public void setNombre_curso(String nombre_curso) {
		this.nombre_curso = nombre_curso;
	}
	public int getCod_estudiante() {
		return cod_estudiante;
	}
	public void setCod_estudiante(int cod_estudiante) {
		this.cod_estudiante = cod_estudiante;
	}
	public int getCedula_profesor() {
		return cedula_profesor;
	}
	public void setCedula_profesor(int cedula_profesor) {
		this.cedula_profesor = cedula_profesor;
	}
	public int getNumero_estudiantes() {
		return numero_estudiantes;
	}
	public void setNumero_estudiantes(int numero_estudiantes) {
		this.numero_estudiantes = numero_estudiantes;
	}
	
	
		
}
