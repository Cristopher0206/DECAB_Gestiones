package modelo;

import java.io.Serializable;

public class Calibracion implements Serializable {
	private static final long serialVersionUID = 4L;

	private int id_calib;
	private String frecuencia;
	private String tipo;
	private String fecha_ult_calib;
	private String fecha_prox_calib;
	private String estado;
	private String ptos_calib;
	
	public Calibracion() {
		
	}

	public Calibracion(int id_calib, String frecuencia, String tipo, String fecha_ult_calib, String fecha_prox_calib,
			String estado, String ptos_calib) {
		super();
		this.id_calib = id_calib;
		this.frecuencia = frecuencia;
		this.tipo = tipo;
		this.fecha_ult_calib = fecha_ult_calib;
		this.fecha_prox_calib = fecha_prox_calib;
		this.estado = estado;
		this.ptos_calib = ptos_calib;
	}

	public int getId_calib() {
		return id_calib;
	}

	public void setId_calib(int id_calib) {
		this.id_calib = id_calib;
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

	public String getFecha_ult_calib() {
		return fecha_ult_calib;
	}

	public void setFecha_ult_calib(String fecha_ult_calib) {
		this.fecha_ult_calib = fecha_ult_calib;
	}

	public String getFecha_prox_calib() {
		return fecha_prox_calib;
	}

	public void setFecha_prox_calib(String fecha_prox_calib) {
		this.fecha_prox_calib = fecha_prox_calib;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPtos_calib() {
		return ptos_calib;
	}

	public void setPtos_calib(String ptos_calib) {
		this.ptos_calib = ptos_calib;
	}
	
	
	
}
