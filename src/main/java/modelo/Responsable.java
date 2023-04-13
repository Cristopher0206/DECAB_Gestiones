package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBDD;


public class Responsable implements Serializable {
	private static final long serialVersionUID = 3L;

	private int id;
	private String nombre;
	private String telf_ext;
	private String email;
	
	public Responsable(){
		
	}

	public Responsable(int id, String nombre, String telf_ext, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telf_ext = telf_ext;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelf_ext() {
		return telf_ext;
	}

	public void setTelf_ext(String telf_ext) {
		this.telf_ext = telf_ext;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Responsable> getResponsables(){
		String sql= "SELECT * FROM RESPONSABLE";
		Connection cnn = null;
		ResultSet rs = null;
		List<Responsable> responsables = new ArrayList<Responsable>();
		
		//2.- Conectar a la BDD 
		cnn = ConexionBDD.getConexion();
		try {
				rs = cnn.prepareStatement(sql).executeQuery();
				while(rs.next()) {
					Responsable rp = new Responsable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					responsables.add(rp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//3.- Cerrar
				ConexionBDD.cerrar(rs);
		}
		return responsables;
	}
	
	public boolean create(Responsable rp) {
		
		boolean bandera = false;
		
		String sql= "INSERT INTO responsable (id,nombre,telf_ext,email) VALUES (?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, rp.getNombre());
			pstm.setString(2, rp.getTelf_ext());
			pstm.setString(3, rp.getEmail());
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
	
	public boolean update(Responsable rp) {
		boolean respuesta = false;
		
		//Variables
		String sql = "UPDATE RESPONSABLE SET nombre = ?, telf_ext = ?, email = ? WHERE id = ?"; 
		PreparedStatement pstm = null;
		//Conectar a la BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setString(1, rp.getNombre());
			pstm.setString(2, rp.getTelf_ext());
			pstm.setString(3, rp.getEmail());
			pstm.setInt(4, getId());
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

	public boolean delete(int idResponsable) {
		boolean respuesta = false;	
		//Variables
		String sql = "DELETE FROM RESPONSABLE WHERE id = ?";
		PreparedStatement pstm = null; 
		
		//Conectar a BDD
		try {
			pstm = ConexionBDD.getConexion().prepareStatement(sql);
			pstm.setInt(1, idResponsable);
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
