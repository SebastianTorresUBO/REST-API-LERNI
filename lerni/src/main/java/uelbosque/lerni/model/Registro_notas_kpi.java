package uelbosque.lerni.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registro_notas_kpi")
public class Registro_notas_kpi {
		
	@Id
	private Long id_nota_kpi;
	private int id_estudiante;
	private int id_calificacion;
	private int cod_actividad;
	private Date fecha_inicio;
	private Date fecha_fin;
	private int cedula_profesor;
	
	
	
	public Long getId_nota_kpi() {
		return id_nota_kpi;
	}
	public void setId_nota_kpi(Long id_nota_kpi) {
		this.id_nota_kpi = id_nota_kpi;
	}
	public int getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public int getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(int id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	public int getCod_actividad() {
		return cod_actividad;
	}
	public void setCod_actividad(int cod_actividad) {
		this.cod_actividad = cod_actividad;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public int getCedula_profesor() {
		return cedula_profesor;
	}
	public void setCedula_profesor(int cedula_profesor) {
		this.cedula_profesor = cedula_profesor;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	
	
}
