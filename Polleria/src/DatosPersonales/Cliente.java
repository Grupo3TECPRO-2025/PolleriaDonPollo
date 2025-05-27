package DatosPersonales;

import java.util.ArrayList;
import java.util.List;

import Gestiones.Pedido;

public class Cliente {
    private int  telefono;
    private String NombreCompleto,DNI,Direccion;
    private static List<Pedido> listaPedidos;
    
    
	public Cliente(int telefono, String nombreCompleto, String direccion,String DNI) {
		this.telefono = telefono;
		this.NombreCompleto = nombreCompleto;
		this.DNI = DNI;
		this.Direccion = direccion;
		listaPedidos = new ArrayList<Pedido>();
	}
	
	public Cliente(int telefono, String nombreCompleto, String direccion) {
		this.telefono = telefono;
		this.NombreCompleto = nombreCompleto;
		this.Direccion = direccion;
		listaPedidos = new ArrayList<Pedido>();

	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombreCompleto() {
		return NombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}

	public String getDNI() {
		return DNI;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	public List<Pedido> ListarPedidos() {
		return listaPedidos;
	}
}
