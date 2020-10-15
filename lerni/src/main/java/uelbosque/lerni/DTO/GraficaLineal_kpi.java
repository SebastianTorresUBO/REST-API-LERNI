package uelbosque.lerni.DTO;

import java.util.ArrayList;
import java.util.List;

public class GraficaLineal_kpi {
		
	private String nombre_estudiante;
	private String apellidos_estudiante;
	private List<Series> seriesList= new ArrayList<Series>();
	
	
	public GraficaLineal_kpi(String nombre_estudiante, String apellidos_estudiante,
			List<Series> seriesList) {
		super();
		this.nombre_estudiante = nombre_estudiante;
		this.apellidos_estudiante = apellidos_estudiante;
		this.seriesList = seriesList;
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
	public List<Series> getSeriesList() {
		return seriesList;
	}
	public void setSeriesList(List<Series> seriesList) {
		this.seriesList = seriesList;
	}
	
	
	
}
