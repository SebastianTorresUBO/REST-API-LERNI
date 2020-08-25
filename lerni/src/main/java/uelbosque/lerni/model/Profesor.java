package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {
	
	@Id
	private Long cedula;
	private String nombres;
	private String apellidos;
	private String titulo_profesional;
	private int id_calificacion;
	private int codigo_curso;
	private int cod_actividad_asignada;
	private int cod_usuario;
	private String universidad;
	private String correo_electronico;
	
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTitulo_profesional() {
		return titulo_profesional;
	}
	public void setTitulo_profesional(String titulo_profesional) {
		this.titulo_profesional = titulo_profesional;
	}
	public int getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(int id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	public int getCodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}
	public int getCod_actividad_asignada() {
		return cod_actividad_asignada;
	}
	public void setCod_actividad_asignada(int cod_actividad_asignada) {
		this.cod_actividad_asignada = cod_actividad_asignada;
	}
	public int getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	
}
