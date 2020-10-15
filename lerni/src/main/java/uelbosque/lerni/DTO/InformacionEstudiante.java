package uelbosque.lerni.DTO;

public class InformacionEstudiante {
	
	private String nombre_estudiante;
	private String apellidos_estudiante;
	
	
	public InformacionEstudiante(String nombre_estudiante, String apellidos_estudiante) {
		super();
		this.nombre_estudiante = nombre_estudiante;
		this.apellidos_estudiante = apellidos_estudiante;
	}
	public String getNombre_estudiante() {
		return nombre_estudiante;
	}
	public void setNombre_estudiante(String nombre_estudiante) {
		this.nombre_estudiante = nombre_estudiante;
	}
	public String getApellidos_estudiante() {
		return apellidos_estudiante;
	}
	public void setApellidos_estudiante(String apellidos_estudiante) {
		this.apellidos_estudiante = apellidos_estudiante;
	}
	
	
	
}
