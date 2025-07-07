package Gestiones;

import java.time.LocalDateTime;
import java.util.ArrayList;

import DatosPersonales.Administrador;
import DatosPersonales.Proveedor;

public class OrdenCompra {
	private int OrdenID;
	private Proveedor proveedor;
	private Administrador administrador;
	private LocalDateTime fechaEmision;
	private ArrayList<DetalleOrdenCompra> listaDetalleOrdenCompras;
	
	
	
	
	public OrdenCompra(int ordenID, Proveedor proveedor, Administrador administrador) {
		OrdenID = ordenID;
		this.proveedor = proveedor;
		this.administrador = administrador;
		fechaEmision =LocalDateTime.now();
		listaDetalleOrdenCompras = new ArrayList<DetalleOrdenCompra>();
	}
	
	
	public ArrayList<DetalleOrdenCompra> getListaDetalleOrdenCompras() {
		return listaDetalleOrdenCompras;
	}


	public void setListaDetalleOrdenCompras(ArrayList<DetalleOrdenCompra> listaDetalleOrdenCompras) {
		this.listaDetalleOrdenCompras = listaDetalleOrdenCompras;
	}


	public int getOrdenID() {
		return OrdenID;
	}
	public void setOrdenID(int ordenID) {
		OrdenID = ordenID;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	
	

}
