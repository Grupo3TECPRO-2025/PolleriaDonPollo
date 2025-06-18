package DatosPersonales;

import java.util.ArrayList;
import java.util.List;

import Gestiones.Pedido;

public class Cliente {
    private int  telefono;
    private String NombreCompleto,DNI,Direccion,Metodo_Pago;
    private static List<Pedido> listaPedidos;
    
    
	public Cliente(int telefono, String nombreCompleto, String direccion,String metodo_Pago,String DNI) {
		this.telefono = telefono;
		this.NombreCompleto = nombreCompleto;
		this.DNI = DNI;
		this.Direccion = direccion;
		this.Metodo_Pago=metodo_Pago;
		listaPedidos = new ArrayList<Pedido>();
	}
	
	public Cliente(int telefono, String nombreCompleto, String direccion,String metodo_Pago) {
		this.telefono = telefono;
		this.NombreCompleto = nombreCompleto;
		this.Direccion = direccion;
		this.Metodo_Pago=metodo_Pago;
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

	public String getMetodo_Pago() {
		return Metodo_Pago;
	}

	public void setMetodo_Pago(String metodo_Pago) {
		Metodo_Pago = metodo_Pago;
	}
	
}
