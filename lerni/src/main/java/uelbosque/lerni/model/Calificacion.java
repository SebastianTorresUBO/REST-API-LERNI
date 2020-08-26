package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="calificacion")
public class Calificacion {

	@Id
	private Long id_calificacion;
	private int valor;
	private String descripcion;
	
	public Long getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(Long id_calificacion) {
		this.id_calificacion = id_calificacion;
	}

	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
