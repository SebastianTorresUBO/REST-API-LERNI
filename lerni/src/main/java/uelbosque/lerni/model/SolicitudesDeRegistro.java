package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="solicitudes_de_registro")
public class SolicitudesDeRegistro {

	@Id
	@GeneratedValue
	private Long id;
	private int numDocumento;
	private String nombres;
	private String apellidos;
	private String rol;
	private String institucionEducativaVinculada;
	private String estado_de_Solicitud;
	
	
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
			
	
	
}
