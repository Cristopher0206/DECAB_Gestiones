package modelo;

import java.io.Serializable;

public class Equipo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String cod_lab;
	private String cod_bienes;
	private String nombre;
	private String marca;
	private String modelo;
	private String num_serie;
	private String loc_lab;
	private String rang_fun_min;
	private String rang_fun_max;
	private String unidad;
	private String clasificacion;
	private String fecha_adqu;
	private String valor_merc_sin_iva;
	private String estado;
	private String custodio;
	private String observaciones;
	
	public Equipo() {
		
	}

	public Equipo(String cod_lab, String cod_bienes, String nombre, String marca, String modelo, String num_serie,
			String loc_lab, String rang_fun_min, String rang_fun_max, String unidad, String clasificacion,
			String fecha_adqu, String valor_merc_sin_iva, String estado, String custodio, String observaciones) {
		super();
		this.cod_lab = cod_lab;
		this.cod_bienes = cod_bienes;
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.num_serie = num_serie;
		this.loc_lab = loc_lab;
		this.rang_fun_min = rang_fun_min;
		this.rang_fun_max = rang_fun_max;
		this.unidad = unidad;
		this.clasificacion = clasificacion;
		this.fecha_adqu = fecha_adqu;
		this.valor_merc_sin_iva = valor_merc_sin_iva;
		this.estado = estado;
		this.custodio = custodio;
		this.observaciones = observaciones;
	}

	public String getCod_lab() {
		return cod_lab;
	}

	public void setCod_lab(String cod_lab) {
		this.cod_lab = cod_lab;
	}

	public String getCod_bienes() {
		return cod_bienes;
	}

	public void setCod_bienes(String cod_bienes) {
		this.cod_bienes = cod_bienes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getLoc_lab() {
		return loc_lab;
	}

	public void setLoc_lab(String loc_lab) {
		this.loc_lab = loc_lab;
	}

	public String getRang_fun_min() {
		return rang_fun_min;
	}

	public void setRang_fun_min(String rang_fun_min) {
		this.rang_fun_min = rang_fun_min;
	}

	public String getRang_fun_max() {
		return rang_fun_max;
	}

	public void setRang_fun_max(String rang_fun_max) {
		this.rang_fun_max = rang_fun_max;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getFecha_adqu() {
		return fecha_adqu;
	}

	public void setFecha_adqu(String fecha_adqu) {
		this.fecha_adqu = fecha_adqu;
	}

	public String getValor_merc_sin_iva() {
		return valor_merc_sin_iva;
	}

	public void setValor_merc_sin_iva(String valor_merc_sin_iva) {
		this.valor_merc_sin_iva = valor_merc_sin_iva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCustodio() {
		return custodio;
	}

	public void setCustodio(String custodio) {
		this.custodio = custodio;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
