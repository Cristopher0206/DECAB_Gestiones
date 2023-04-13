package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBDD;

public class Proveedor implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private int id_proveedor;
	private String nombre;
	private String telefono;
	private String email;

	public Proveedor(){
		
	}

	
	public Proveedor(int id_proveedor, String nombre, String telefono, String email) {
		super();
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Proveedor> getProveedores(){
		String sql= "SELECT * FROM PROVEEDOR";
		Connection cnn = null;
		ResultSet rs = null;
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		
		//2.- Conectar a la BDD 
		cnn = ConexionBDD.getConexion();
		try {
				rs = cnn.prepareStatement(sql).executeQuery();
				while(rs.next()) {
					Proveedor p = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					proveedores.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//3.- Cerrar
				ConexionBDD.cerrar(rs);
		}
		return proveedores;
	}
	
	public boolean create(Proveedor p) {
		
		boolean bandera = false;
		
		String sql= "INSERT INTO proveedor (id_proveedor,nombre,telefono,email) VALUES (?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getTelefono());
			pstm.setString(3, p.getEmail());
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
	
	public boolean update(Proveedor p) {
		boolean respuesta = false;
		
		//Variables
		String sql = "UPDATE PROVEEDOR SET nombre = ?, telefono = ?, email = ? WHERE id_proveedor = ?"; 
		PreparedStatement pstm = null;
		//Conectar a la BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getTelefono());
			pstm.setString(3, p.getEmail());
			pstm.setInt(4, getId_proveedor());
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
	
	public boolean delete(int idProveedor) {
		boolean respuesta = false;	
		//Variables
		String sql = "DELETE FROM PROVEEDOR WHERE id_proveedor = ?";
		PreparedStatement pstm = null; 
		
		//Conectar a BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setInt(1, idProveedor);
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
