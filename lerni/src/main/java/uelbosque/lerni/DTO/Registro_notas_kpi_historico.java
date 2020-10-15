package uelbosque.lerni.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Registro_notas_kpi_historico {

	private long id_nota_kpi;
	private int id_estudiante;
	private String nombre;
	private String apellidos_estudiante;
	private String edad;
	private int cedula_padre_tutor;
	private long id_calificacion;
	private int valor;
	private String descripcion;
	private Long cod_actividad;
	private String nombre_actividad;
	private String recompensa_por_cumplimiento_actividad;
	private int cedula_profesor;
	private String nombres;
	private String apellidos_profesor;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date fecha_inicio;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date fecha_fin;
	
	
	
	
	public Registro_notas_kpi_historico(long id_nota_kpi, int id_estudiante, String nombre, String apellidos_estudiante,
			String edad, int cedula_padre_tutor, long id_calificacion,int valor, String descripcion,long cod_actividad, String nombre_actividad,
			String recompensa_por_cumplimiento_actividad, int cedula_profesor, String nombres,
			String apellidos_profesor, Date fecha_inicio, Date fecha_fin) {
		super();
		this.id_nota_kpi = id_nota_kpi;
		this.id_estudiante = id_estudiante;
		this.nombre = nombre;
		this.apellidos_estudiante = apellidos_estudiante;
		this.edad = edad;
		this.cedula_padre_tutor = cedula_padre_tutor;
		this.id_calificacion=id_calificacion;
		this.valor = valor;
		this.descripcion = descripcion;
		this.cod_actividad=cod_actividad;
		this.nombre_actividad = nombre_actividad;
		this.recompensa_por_cumplimiento_actividad = recompensa_por_cumplimiento_actividad;
		this.cedula_profesor = cedula_profesor;
		this.nombres = nombres;
		this.apellidos_profesor = apellidos_profesor;
		this.fecha_inicio=fecha_inicio;
		this.fecha_fin=fecha_fin;
	}
	public List<Registro_notas_kpi_historico> convertObjectToDto (List<Object> obj) {
		List<Registro_notas_kpi_historico> listKpis = new ArrayList<Registro_notas_kpi_historico>(); 
		for (int i =0; i<obj.size(); i++) {
			
			String prueba= obj.get(i).toString();
			System.out.print(prueba);
			
			//this.id_nota_kpi= obj.get(i);
			//for(int j=0; j<=obj.get(i).; j++) {
		//		this.id_nota_kpi=obj.get(i).toString();
		//	}
			
		}
		System.out.println("entre");
		return listKpis;
	}
	
	
	public Long getCod_actividad() {
		return cod_actividad;
	}
	public void setCod_actividad(Long cod_actividad) {
		this.cod_actividad = cod_actividad;
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
	public long getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(long id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	public long getId_nota_kpi() {
		return id_nota_kpi;
	}
	public void setId_nota_kpi(long id_nota_kpi) {
		this.id_nota_kpi = id_nota_kpi;
	}
	public int getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos_estudiante() {
		return apellidos_estudiante;
	}
	public void setApellidos_estudiante(String apellidos_estudiante) {
		this.apellidos_estudiante = apellidos_estudiante;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public int getCedula_padre_tutor() {
		return cedula_padre_tutor;
	}
	public void setCedula_padre_tutor(int cedula_padre_tutor) {
		this.cedula_padre_tutor = cedula_padre_tutor;
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
	public String getNombre_actividad() {
		return nombre_actividad;
	}
	public void setNombre_actividad(String nombre_actividad) {
		this.nombre_actividad = nombre_actividad;
	}
	public String getRecompensa_por_cumplimiento_actividad() {
		return recompensa_por_cumplimiento_actividad;
	}
	public void setRecompensa_por_cumplimiento_actividad(String recompensa_por_cumplimiento_actividad) {
		this.recompensa_por_cumplimiento_actividad = recompensa_por_cumplimiento_actividad;
	}
	public int getCedula_profesor() {
		return cedula_profesor;
	}
	public void setCedula_profesor(int cedula_profesor) {
		this.cedula_profesor = cedula_profesor;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos_profesor() {
		return apellidos_profesor;
	}
	public void setApellidos_profesor(String apellidos_profesor) {
		this.apellidos_profesor = apellidos_profesor;
	}
	
	
	
}
