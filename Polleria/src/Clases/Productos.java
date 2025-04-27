package Clases;

public class Productos {

	double precio_unitario;
	String id, nombre;
	
	int cantidad;

	public Productos(double precio_unitario, String id, String nombre, int cantidad) {	
		this.precio_unitario = precio_unitario;
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	

	public double getPrecio_unitario() {
		return precio_unitario;
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
		
}
