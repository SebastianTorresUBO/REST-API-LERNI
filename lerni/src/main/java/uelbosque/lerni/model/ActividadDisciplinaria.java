package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actividad_disciplinaria")
public class ActividadDisciplinaria {
	
	@Id
	private int cod_actividad;
	private String nombre;
	private String descripcion_actividad;
	private int recompensa_por_cumplimiento_actividad;
	private int id_calificacion;
	
	public int getCod_actividad() {
		return cod_actividad;
	}
	public void setCod_actividad(int cod_actividad) {
		this.cod_actividad = cod_actividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion_actividad() {
		return descripcion_actividad;
	}
	public void setDescripcion_actividad(String descripcion_actividad) {
		this.descripcion_actividad = descripcion_actividad;
	}
	public int getRecompensa_por_cumplimiento_actividad() {
		return recompensa_por_cumplimiento_actividad;
	}
	public void setRecompensa_por_cumplimiento_actividad(
			int recompensa_por_cumplimiento_actividad) {
		this.recompensa_por_cumplimiento_actividad = recompensa_por_cumplimiento_actividad;
	}
	public int getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(int id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	
	
	
	
	
}
