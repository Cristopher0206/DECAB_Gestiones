package modelo;

import java.io.Serializable;


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
	
	

}
