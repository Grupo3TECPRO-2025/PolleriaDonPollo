package DatosPersonales;

import java.util.ArrayList;
import java.util.List;

import Gestiones.Pedido;

public class Cliente extends Persona{

    private static List<Pedido> listaPedidos;
    
    
	public Cliente(int telefono, String nombreCompleto, String direccion,String DNI) {
		super(telefono, nombreCompleto, DNI, direccion);
		listaPedidos = new ArrayList<Pedido>();
	}
	
	public Cliente(int telefono, String nombreCompleto, String direccion) {
		super(telefono, nombreCompleto, direccion);
		listaPedidos = new ArrayList<Pedido>();

	}

	
	public List<Pedido> ListarPedidos() {
		return listaPedidos;
	}

}
