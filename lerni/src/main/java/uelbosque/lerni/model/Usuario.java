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
	
	
		
}
