package modelo;
import java.io.Serializable;

public class Mantenimiento implements Serializable {
	private static final long serialVersionUID = 5L;

	private int id_mantenimiento;
	private String frecuencia;
	private String tipo;
	private String fecha_ult_mante;
	private String fecha_prox_mante;
	private String estado;
	private String accion;
	private String observaciones;
	private String dias_para_mantenimiento;
	
	public Mantenimiento() {
		
	}

	public Mantenimiento(int id_mantenimiento, String frecuencia, String tipo, String fecha_ult_mante,
			String fecha_prox_mante, String estado, String accion, String observaciones,
			String dias_para_mantenimiento) {
		super();
		this.id_mantenimiento = id_mantenimiento;
		this.frecuencia = frecuencia;
		this.tipo = tipo;
		this.fecha_ult_mante = fecha_ult_mante;
		this.fecha_prox_mante = fecha_prox_mante;
		this.estado = estado;
		this.accion = accion;
		this.observaciones = observaciones;
		this.dias_para_mantenimiento = dias_para_mantenimiento;
	}

	public int getId_mantenimiento() {
		return id_mantenimiento;
	}

	public void setId_mantenimiento(int id_mantenimiento) {
		this.id_mantenimiento = id_mantenimiento;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha_ult_mante() {
		return fecha_ult_mante;
	}

	public void setFecha_ult_mante(String fecha_ult_mante) {
		this.fecha_ult_mante = fecha_ult_mante;
	}

	public String getFecha_prox_mante() {
		return fecha_prox_mante;
	}

	public void setFecha_prox_mante(String fecha_prox_mante) {
		this.fecha_prox_mante = fecha_prox_mante;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDias_para_mantenimiento() {
		return dias_para_mantenimiento;
	}

	public void setDias_para_mantenimiento(String dias_para_mantenimiento) {
		this.dias_para_mantenimiento = dias_para_mantenimiento;
	}
	
	
}
