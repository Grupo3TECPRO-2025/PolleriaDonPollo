package Gestiones;

import DatosPersonales.Persona;

public class Usuario {
	private String user, contraseña,rol;

	
	public Usuario(String user, String contraseña, String rol) {
		this.user = user;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
	
}
