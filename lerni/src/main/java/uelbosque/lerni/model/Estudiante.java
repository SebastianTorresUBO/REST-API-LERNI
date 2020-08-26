package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {

	@Id
	private Long id_estudiante;
	private String nombre;
	private String apellidos;
	private String edad;
	private int cedula_padre_tutor;
	private int cod_curso;
	
	public Long getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Long id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
		
	public int getCedula_padre_tutor() {
		return cedula_padre_tutor;
	}
	public void setCedula_padre_tutor(int cedula_padre_tutor) {
		this.cedula_padre_tutor = cedula_padre_tutor;
	}
	public int getCod_curso() {
		return cod_curso;
	}
	public void setCod_curso(int cod_curso) {
		this.cod_curso = cod_curso;
	}
	
	
}
