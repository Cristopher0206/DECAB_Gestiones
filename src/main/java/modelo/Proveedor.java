package modelo;

import java.io.Serializable;

import modelo.conexion.ConexionBDD;

public class Proveedor implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private int id_proveedor;
	private String nombre;
	private String telefono;
	private String email;

	public Proveedor(){
		
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
		cnn = conexion.ConexionBDD.getConexion();
		try {
				r0s = cnn.prepareStatement(sql).executeQuery();
				while(rs.next()) {
					Proveedor p = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					proveedores.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//3.- Cerrar
				conexion.ConexionBDD.cerrar(rs);
		}
		return proveedores;
	}
	
	public boolean create(Proveedor p) {
		
		boolean bandera = false;
		
		String sql= "INSERT INTO proveedor"
	}
}
