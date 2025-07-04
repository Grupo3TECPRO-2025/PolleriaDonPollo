package DatosPersonales;

import java.util.ArrayList;

import Gestiones.Pedido;
import Gestiones.Usuario;

public class Trabajador extends Persona{
	
	Usuario user;
	static public ArrayList<Pedido> listaAtenciones;
	String direccion,TrabajorID;
	
	
	
	
	public Trabajador(String trabajorID,int telefono, String nombreCompleto, String DNI, String direccion, Usuario user) {
		super(telefono, nombreCompleto, DNI);
		this.user = user;
		this.direccion = direccion;
		TrabajorID = trabajorID;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public static ArrayList<Pedido> getListaAtenciones() {
		return listaAtenciones;
	}
	public static void setListaAtenciones(ArrayList<Pedido> listaAtenciones) {
		Trabajador.listaAtenciones = listaAtenciones;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTrabajorID() {
		return TrabajorID;
	}
	public void setTrabajorID(String trabajorID) {
		TrabajorID = trabajorID;
	}
	
	


}
