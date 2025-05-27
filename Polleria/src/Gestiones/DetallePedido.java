package Gestiones;

import CartaPolleria.MenuProducto;

public class DetallePedido {
	private MenuProducto producto;
	private int cantidad;
	
	public DetallePedido(MenuProducto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public MenuProducto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double Costo() {
		return producto.getPrecioUnitario()*cantidad;
	}

}
