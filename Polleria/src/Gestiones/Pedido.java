package Gestiones;

import java.awt.Menu;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import CartaPolleria.Cupon;
import DatosPersonales.Cliente;

public class Pedido {

	private int pedidoId;
	private double Monto;
	private LocalDateTime fecha;
    static private List<DetallePedido> listaProductos;
    private Cupon prom;
    private Cliente cli;
    private String tipo, MetodoPago;
    private int NumMesa;

    public Pedido(int pedidoId, String MetodoPago, Cliente cli)
    {
    	this.pedidoId = pedidoId;
        this.cli=cli;
        this.MetodoPago = MetodoPago;
        listaProductos = new ArrayList<DetallePedido>();
        fecha = LocalDateTime.now();
        
    }
    
    public Pedido(int pedidoId, String MetodoPago, int NumMesa, Cliente cli)
    {
    	this.pedidoId = pedidoId;
        this.cli=cli;
        this.NumMesa = NumMesa;
        this.MetodoPago = MetodoPago;
        listaProductos = new ArrayList<DetallePedido>();
        fecha = LocalDateTime.now();
        
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