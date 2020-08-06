package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="calificacion")
public class Calificacion {

	@Id
	private Long id_calificacion;
	private int cedula_profesor;
	private int cod_actividad;
	private int valor;
	
	public Long getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(Long id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	public int getCedula_profesor() {
		return cedula_profesor;
	}
	public void setCedula_profesor(int cedula_profesor) {
		this.cedula_profesor = cedula_profesor;
	}
	public int getCod_actividad() {
		return cod_actividad;
	}
	public void setCod_actividad(int cod_actividad) {
		this.cod_actividad = cod_actividad;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
