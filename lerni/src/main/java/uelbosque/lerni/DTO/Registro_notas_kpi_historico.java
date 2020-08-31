package uelbosque.lerni.DTO;

import java.util.ArrayList;
import java.util.List;

public class Registro_notas_kpi_historico {

	private int id_nota_kpi;
	private int id_estudiante;
	private String nombre;
	private String apellidos_estudiante;
	private int edad;
	private int cedula_padre_tutor;
	private int valor;
	private String descripcion;
	private String nombre_actividad;
	private String recompensa_por_cumplimiento_actividad;
	private String cedula_profesor;
	private String nombres;
	private String apellidos_profesor;
	
	
	
	
	public Registro_notas_kpi_historico(int id_nota_kpi, int id_estudiante, String nombre, String apellidos_estudiante,
			int edad, int cedula_padre_tutor, int valor, String descripcion, String nombre_actividad,
			String recompensa_por_cumplimiento_actividad, String cedula_profesor, String nombres,
			String apellidos_profesor) {
		super();
		this.id_nota_kpi = id_nota_kpi;
		this.id_estudiante = id_estudiante;
		this.nombre = nombre;
		this.apellidos_estudiante = apellidos_estudiante;
		this.edad = edad;
		this.cedula_padre_tutor = cedula_padre_tutor;
		this.valor = valor;
		this.descripcion = descripcion;
		this.nombre_actividad = nombre_actividad;
		this.recompensa_por_cumplimiento_actividad = recompensa_por_cumplimiento_actividad;
		this.cedula_profesor = cedula_profesor;
		this.nombres = nombres;
		this.apellidos_profesor = apellidos_profesor;
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
	public int getId_nota_kpi() {
		return id_nota_kpi;
	}
	public void setId_nota_kpi(int id_nota_kpi) {
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
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
	public String getCedula_profesor() {
		return cedula_profesor;
	}
	public void setCedula_profesor(String cedula_profesor) {
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
