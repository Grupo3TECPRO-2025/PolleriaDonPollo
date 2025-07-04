package DatosPersonales;

import java.util.ArrayList;
import java.util.List;

import Gestiones.Pedido;

public class Cliente extends Persona{

	private String ClienteID;
    private static List<Pedido> listaPedidos;
    
	public Cliente(String ClienteID, int telefono, String nombreCompleto,String DNI) {
		super(telefono, nombreCompleto, DNI);
		this.ClienteID = ClienteID;
		listaPedidos = new ArrayList<Pedido>();
	}
	
	public Cliente(String ClienteID,int telefono, String nombreCompleto) {
		super(telefono, nombreCompleto);
		this.ClienteID = ClienteID;
		listaPedidos = new ArrayList<Pedido>();

	}

	
	public List<Pedido> ListarPedidos() {
		return listaPedidos;
	}

	public String getClienteID() {
		return ClienteID;
	}

	public void setClienteID(String clienteID) {
		ClienteID = clienteID;
	}

}
