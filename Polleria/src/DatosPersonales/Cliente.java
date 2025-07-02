package DatosPersonales;

import java.util.ArrayList;
import java.util.List;

import Gestiones.Pedido;

public class Cliente extends Persona{

    private static List<Pedido> listaPedidos;
    private String direccion;
    
	public Cliente(int telefono, String nombreCompleto, String direccion,String DNI) {
		super(telefono, nombreCompleto, DNI);
		this.direccion = direccion;
		listaPedidos = new ArrayList<Pedido>();
	}
	
	public Cliente(int telefono, String nombreCompleto, String direccion) {
		super(telefono, nombreCompleto, direccion);
		listaPedidos = new ArrayList<Pedido>();

	}

	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public List<Pedido> ListarPedidos() {
		return listaPedidos;
	}

}
