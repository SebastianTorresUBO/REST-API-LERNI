package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {

	@Id
	@GeneratedValue
	private Long id_estudiante;
	private String nombre_estudiante;
	private String apellidos_estudiante;
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
		return nombre_estudiante;
	}
	public void setNombre(String nombre) {
		this.nombre_estudiante = nombre;
	}
	public String getApellidos() {
		return apellidos_estudiante;
	}
	public void setApellidos(String apellidos) {
		this.apellidos_estudiante = apellidos;
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
