package CartaPolleria;

import java.util.ArrayList;

import Inventario.PlatoConsumo;

public class MenuProducto {
	private String idProducto, nombre, descripcion;
	private double precioUnitario;
	ArrayList<PlatoConsumo> listaDeConsumos;
	
	public MenuProducto(String idProducto, String nombre, String descripcion, double precioUnitario) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		listaDeConsumos = new ArrayList<PlatoConsumo>();
	}

	public String getIdProducto() {
		return idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<PlatoConsumo> getListaDeConsumos() {
		return listaDeConsumos;
	}

	public void setListaDeConsumos(ArrayList<PlatoConsumo> listaDeConsumos) {
		this.listaDeConsumos = listaDeConsumos;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	
	
	
}
