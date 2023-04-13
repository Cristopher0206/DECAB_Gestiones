package modelo;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBDD;

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
	
	
	public List<Mantenimiento> getMantenimientos(){
		String sql= "SELECT * FROM MANTENIMIENTO";
		Connection cnn = null;
		ResultSet rs = null;
		List<Mantenimiento> mantenimientos = new ArrayList<Mantenimiento>();
		
		//2.- Conectar a la BDD 
		cnn = ConexionBDD.getConexion();
		try {
				rs = cnn.prepareStatement(sql).executeQuery();
				while(rs.next()) {
					Mantenimiento man = new Mantenimiento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
					mantenimientos.add(man);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//3.- Cerrar
				ConexionBDD.cerrar(rs);
		}
		return mantenimientos;
	}
	
	public boolean create(Mantenimiento man) {
		
		boolean bandera = false;
		
		String sql= "INSERT INTO Mantenimiento (id_mantenimiento,frecuencia,tipo,fecha_ult_mante,fecha_prox_mante,estado,accion,observaciones,dias_para_mantenimiento) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, man.getFrecuencia());
			pstm.setString(2, man.getTipo());
			pstm.setString(3, man.getFecha_ult_mante());
			pstm.setString(4, man.getFecha_prox_mante());
			pstm.setString(5, man.getEstado());
			pstm.setString(6, man.getAccion());
			pstm.setString(7, man.getObservaciones());
			pstm.setString(8, man.getDias_para_mantenimiento());
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
	
	public boolean update(Mantenimiento man) {
		boolean respuesta = false;
		
		//Variables
		String sql = "UPDATE MANTENIMIENTO SET frecuencia = ?, tipo = ?, fecha_ult_mante = ?, fecha_prox_mante = ?, estado = ?, accion = ?, observaciones = ?, dias_para_mantenimiento = ? WHERE id_mantenimiento = ?"; 
		PreparedStatement pstm = null;
		//Conectar a la BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, man.getFrecuencia());
			pstm.setString(2, man.getTipo());
			pstm.setString(3, man.getFecha_ult_mante());
			pstm.setString(4, man.getFecha_prox_mante());
			pstm.setString(5, man.getEstado());
			pstm.setString(6, man.getAccion());
			pstm.setString(7, man.getObservaciones());
			pstm.setString(8, man.getDias_para_mantenimiento());
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
