package Gestiones;

import Inventario.MateriaPrima;

public class DetalleOrdenCompra {
	private OrdenCompra orden;
	MateriaPrima materiaPrima;
	private int cantidad;
	public DetalleOrdenCompra(OrdenCompra orden, MateriaPrima materiaPrima, int cantidad) {
		this.orden = orden;
		this.materiaPrima = materiaPrima;
		this.cantidad = cantidad;
	}
	public OrdenCompra getOrden() {
		return orden;
	}
	public void setOrden(OrdenCompra orden) {
		this.orden = orden;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	
	

}
