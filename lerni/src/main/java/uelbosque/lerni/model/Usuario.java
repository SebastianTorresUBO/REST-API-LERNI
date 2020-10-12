package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long cod_usuario;
	private int cod_tipo_usuario;
	private String nombres;
	private String apellidos;
	private String username;
	private String password;
	private String institucion_educativa_vinculada;
	private int cedula_usuario;
	
	
	
	public Long getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public int getCod_tipo_usuario() {
		return cod_tipo_usuario;
	}
	public void setCod_tip_usuario(int cod_tip_usuario) {
		this.cod_tipo_usuario = cod_tip_usuario;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCod_tipo_usuario(int cod_tipo_usuario) {
		this.cod_tipo_usuario = cod_tipo_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInstitucion_educativa_vinculada() {
		return institucion_educativa_vinculada;
	}
	public void setInstitucion_educativa_vinculada(String institucion_educativa_vinculada) {
		this.institucion_educativa_vinculada = institucion_educativa_vinculada;
	}
	public int getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(int cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	
	
	
	
		
}
