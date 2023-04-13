package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBDD;

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
	
	public List<Calibracion> getCalibraciones(){
		String sql= "SELECT * FROM CALIBRACION";
		Connection cnn = null;
		ResultSet rs = null;
		List<Calibracion> calibraciones = new ArrayList<Calibracion>();
		
		//2.- Conectar a la BDD 
		cnn = ConexionBDD.getConexion();
		try {
				rs = cnn.prepareStatement(sql).executeQuery();
				while(rs.next()) {
					Calibracion c = new Calibracion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
					calibraciones.add(c);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//3.- Cerrar
				ConexionBDD.cerrar(rs);
		}
		return calibraciones;
	}
	
	public boolean create(Calibracion c) {
		
		boolean bandera = false;
		
		String sql= "INSERT INTO Calibracion (id_calib,frecuencia,tipo,fecha_ult_calib,fecha_prox_calib,estado,ptos_calib) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, c.getFrecuencia());
			pstm.setString(2, c.getTipo());
			pstm.setString(3, c.getFecha_ult_calib());
			pstm.setString(4, c.getFecha_prox_calib());
			pstm.setString(5, c.getEstado());
			pstm.setString(6, c.getPtos_calib());
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
	
	public boolean update(Calibracion c) {
		boolean respuesta = false;
		
		//Variables
		String sql = "UPDATE CALIBRACION SET frecuencia = ?, tipo = ?, fecha_ult_calib = ?, fecha_prox_calib = ?, estado = ?, ptos_calib = ? WHERE id_calib = ?"; 
		PreparedStatement pstm = null;
		//Conectar a la BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, c.getFrecuencia());
			pstm.setString(2, c.getTipo());
			pstm.setString(3, c.getFecha_ult_calib());
			pstm.setString(4, c.getFecha_prox_calib());
			pstm.setString(5, c.getEstado());
			pstm.setString(6, c.getPtos_calib());
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
