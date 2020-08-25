package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="solicitudes_de_registro")
public class SolicitudesDeRegistro {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private int numDocumento;
	private String nombres;
	private String apellidos;
	private String rol;
	private String institucionEducativaVinculada;
	private String estado_de_Solicitud;
	private String username;
	private String password;
	private String titulo_profesional;
	private String universidad;
	private String correo_electronico;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(int numDocumento) {
		this.numDocumento = numDocumento;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getInstitucionEducativaVinculada() {
		return institucionEducativaVinculada;
	}
	public void setInstitucionEducativaVinculada(String institucionEducativaVinculada) {
		this.institucionEducativaVinculada = institucionEducativaVinculada;
	}
	public String getEstadoSolicitud() {
		return estado_de_Solicitud;
	}
	public void setEstadoSolicitud(String estado_de_Solicitud) {
		this.estado_de_Solicitud = estado_de_Solicitud;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitulo_profesional() {
		return titulo_profesional;
	}
	public void setTitulo_profesional(String titulo_profesional) {
		this.titulo_profesional = titulo_profesional;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	
			
	
	
}
