package DatosPersonales;

import Gestiones.Usuario;

public class Administrador extends Persona{
	String direccion;
	Usuario user;
	

	public Administrador(int telefono, String nombreCompleto, String DNI, String direccion, Usuario user) {
		super(telefono, nombreCompleto, DNI);
		this.user = user;
		this.direccion = direccion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
	
}
