package uelbosque.lerni.DTO;

public class GraficaTorta_kpi {

	private String actividad_disciplinaria;
	private int promedio_calificacion;
	private Extra extra;
	
	
	
	public GraficaTorta_kpi(String actividad_disciplinaria, int promedio_calificacion, Extra extra) {
		super();
		this.actividad_disciplinaria = actividad_disciplinaria;
		this.promedio_calificacion = promedio_calificacion;
		this.extra = extra;
	}
	public String getActividad_disciplinaria() {
		return actividad_disciplinaria;
	}
	public void setActividad_disciplinaria(String actividad_disciplinaria) {
		this.actividad_disciplinaria = actividad_disciplinaria;
	}
	public int getPromedio_calificacion() {
		return promedio_calificacion;
	}
	public void setPromedio_calificacion(int promedio_calificacion) {
		this.promedio_calificacion = promedio_calificacion;
	}
	public Extra getExtra() {
		return extra;
	}
	public void setExtra(Extra extra) {
		this.extra = extra;
	}
	
	
}
