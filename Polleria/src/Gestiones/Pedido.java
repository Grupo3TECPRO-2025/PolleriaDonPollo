package Gestiones;

import java.awt.Menu;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import CartaPolleria.Cupon;
import DatosPersonales.Administrador;
import DatosPersonales.Cliente;
import DatosPersonales.Trabajador;

public class Pedido {

	private int pedidoId;
	private double Monto;
	private LocalDateTime fecha;
    static private List<DetallePedido> listaProductos;
    private Cupon prom;
    private Cliente cli;
    private String tipo, MetodoPago, Direccion;
    


    public Pedido(int pedidoId, String MetodoPago, String Direccion, String tipo, Cliente cli, LocalDateTime Fecha)
    {
    	this.tipo = tipo;
    	this.Direccion = Direccion;
    	this.pedidoId = pedidoId;
        this.cli=cli;
        this.MetodoPago = MetodoPago;
        listaProductos = new ArrayList<DetallePedido>();
        fecha = Fecha;
        
    }
    
    public Pedido(int pedidoId, String MetodoPago, String Direccion, String tipo, Cliente cli)
    {
    	this.tipo = tipo;
    	this.Direccion = Direccion;
    	this.pedidoId = pedidoId;
        this.cli=cli;
        this.MetodoPago = MetodoPago;
        listaProductos = new ArrayList<DetallePedido>();
        fecha = LocalDateTime.now();
        
    }
    

    
    
    public String getDireccion() {
		return Direccion;
	}




	public void setDireccion(String direccion) {
		Direccion = direccion;
	}




	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}




	public void setCli(Cliente cli) {
		this.cli = cli;
	}




	public String getMetodoPago() {
		return MetodoPago;
	}


	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}


	public int getPedidoId() {
		return pedidoId;
	}

    
	public double getMonto() {
		return Monto;
	}

	public void setMonto(double Monto) {
		this.Monto = Monto;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}


	public static List<DetallePedido> getListaProductos() {
		return listaProductos;
	}



	public Cliente getCli() {
		return cli;
	}

	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Cupon getProm() {
		return prom;
	}


	public void setProm(Cupon prom) {
		this.prom = prom;
	}


	public DetallePedido Buscar(String id)
    {
        for (DetallePedido producto : listaProductos) {

            if(producto.getProducto().getIdProducto().equals(id)) return producto;
        }
        return null;
    }
    
    public int tamaño() {
    	return listaProductos.size();
    	
    }
    
    public void Eliminar(int nPedido)
    {
    	listaProductos.remove(nPedido);
    }
    
    public void Limpiar() {
    	listaProductos.removeAll(listaProductos);
    }

    public void Adicionar(DetallePedido x)
    {
    	listaProductos.add(x);
    }
    
    public DetallePedido Obtener(int x) {
    	return listaProductos.get(x);
    }
    
    public double CostoTotal() {
    	double total=0.0;
    	for(int i=0;i<listaProductos.size();i++) {
    		total+=Obtener(i).Costo();
    	}
    	return total;
    }   
    
    
    public double CostoTotal(Boolean aux) {
    	double total=0.0;
    	if(prom.getTipo().trim().toLowerCase()=="fijo") {
        	for(int i=0;i<listaProductos.size();i++) {
        		total+=Obtener(i).Costo();
        	}
        	total-=prom.getDescuento();
    	}
    	else if(prom.getTipo().trim().toLowerCase()=="porcentaje"){
            for(int i=0;i<listaProductos.size();i++) {
            		total+=Obtener(i).Costo();
            }
            total*=prom.getDescuento()/100;
    	}
    	return total;
    }
    
}