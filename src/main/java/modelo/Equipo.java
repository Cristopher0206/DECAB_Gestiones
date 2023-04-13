package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBDD;

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
	private Double valor_merc_sin_iva;
	private String estado;
	private String custodio;
	private String observaciones;
	
	public Equipo() {
		
	}

	public Equipo(String cod_lab, String cod_bienes, String nombre, String marca, String modelo, String num_serie,
			String loc_lab, String rang_fun_min, String rang_fun_max, String unidad, String clasificacion,
			String fecha_adqu, Double valor_merc_sin_iva, String estado, String custodio, String observaciones) {
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

	public Double getValor_merc_sin_iva() {
		return valor_merc_sin_iva;
	}

	public void setValor_merc_sin_iva(Double valor_merc_sin_iva) {
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
	
	public List<Equipo> getEquipos(){
		String sql= "SELECT * FROM EQUIPO";
		Connection cnn = null;
		ResultSet rs = null;
		List<Equipo> equipos= new ArrayList<Equipo>();
		
		//2.- Conectar a la BDD 
		cnn = ConexionBDD.getConexion();
		try {
				rs = cnn.prepareStatement(sql).executeQuery();
				while(rs.next()) {
					Equipo e = new Equipo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getString(14), 
							rs.getString(15), rs.getString(16));
					equipos.add(e);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//3.- Cerrar
				ConexionBDD.cerrar(rs);
		}
		return equipos;
	}
	
	public boolean create(Equipo eq) {
		
		boolean bandera = false;
		
		String sql= "INSERT INTO EQUIPO (cod_lab,cod_bienes,nombre,marca,modelo,num_serie,loc_lab,rang_fun_min,"
				+ "rang_fun_max,unidad,clasificacion,fecha_adqu,valor_merc_sin_iva,estado,custodio,"
				+ "observaciones) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, eq.getCod_lab());
			pstm.setString(2, eq.getCod_bienes());
			pstm.setString(3, eq.getNombre());
			pstm.setString(4, eq.getMarca());
			pstm.setString(5, eq.getModelo());
			pstm.setString(6, eq.getNum_serie());
			pstm.setString(7, eq.getLoc_lab());
			pstm.setString(8, eq.getRang_fun_min());
			pstm.setString(9, eq.getRang_fun_max());
			pstm.setString(10, eq.getUnidad());
			pstm.setString(11, eq.getClasificacion());
			pstm.setString(12, eq.getFecha_adqu());
			pstm.setDouble(13, eq.getValor_merc_sin_iva());
			pstm.setString(14, eq.getEstado());
			pstm.setString(15, eq.getCustodio());
			pstm.setString(16, eq.getObservaciones());
			int filas = pstm.executeUpdate();
			System.out.println("Número de filas afectadas: " + filas);
			bandera = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexionBDD.cerrar(pstm);
		}
		return bandera;
	}
	
	public boolean update(Equipo eq) {
		boolean respuesta = false;
		
		//Variables
		String sql = "UPDATE EQUIPO SET cod_bienes = ?, nombre = ?, marca = ?, modelo = ?, num_serie = ?, loc_lab = ?, rang_fun_min = ?, rang_fun_max = ?, unidad = ?, clasificacion = ?, fecha_adqu = ?, valor_merc_sin_iva = ?, estado = ?, custodio = ?, observaciones = ? WHERE cod_lab = ?"; 
		PreparedStatement pstm = null;
		//Conectar a la BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, eq.getCod_lab());
			pstm.setString(2, eq.getCod_bienes());
			pstm.setString(3, eq.getNombre());
			pstm.setString(4, eq.getMarca());
			pstm.setString(5, eq.getModelo());
			pstm.setString(6, eq.getNum_serie());
			pstm.setString(7, eq.getLoc_lab());
			pstm.setString(8, eq.getRang_fun_min());
			pstm.setString(9, eq.getRang_fun_max());
			pstm.setString(10, eq.getUnidad());
			pstm.setString(11, eq.getClasificacion());
			pstm.setString(12, eq.getFecha_adqu());
			pstm.setDouble(13, eq.getValor_merc_sin_iva());
			pstm.setString(14, eq.getEstado());
			pstm.setString(15, eq.getCustodio());
			pstm.setString(16, eq.getObservaciones());
			int filas = pstm.executeUpdate();
			System.out.println("Número de filas ejecutadas: " + filas);
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexionBDD.cerrar(pstm);
		}
		
		return respuesta;
	}
	
	public boolean delete(String cod_lab) {
		boolean respuesta = false;	
		//Variables
		String sql = "DELETE FROM EQUIPO WHERE cod_lab = ?";
		PreparedStatement pstm = null; 
		
		//Conectar a BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, cod_lab);
			int filas = pstm.executeUpdate();
			System.out.println("Número de filas ejecutadas: " + filas);
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexionBDD.cerrar(pstm);
		}
		return respuesta;
	}
	
}
