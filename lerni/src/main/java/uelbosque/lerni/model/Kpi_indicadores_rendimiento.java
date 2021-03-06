package uelbosque.lerni.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kpi_indicadores_rendimiento")
public class Kpi_indicadores_rendimiento {
		
	@Id
	private int id_kpi;
	private int id_estudiante;
	private int calificacion_actividad;
	private Date fecha_inicio;
	private Date fecha_fin;
	
	public int getId_kpi() {
		return id_kpi;
	}
	public void setId_kpi(int id_kpi) {
		this.id_kpi = id_kpi;
	}
	public int getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public int getCalificacion_actividad() {
		return calificacion_actividad;
	}
	public void setCalificacion_actividad(int calificacion_actividad) {
		this.calificacion_actividad = calificacion_actividad;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	
	
}
