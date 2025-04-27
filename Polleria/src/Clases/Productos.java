package Clases;

public class Productos {

	double precioUnitario;
	String id, nombre;
	
	int cantidad;

	public Productos(double precioUnitario, String id, String nombre, int cantidad) {	
		this.precioUnitario = precioUnitario;
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	
	public String getId() {
		return id;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
		
}
