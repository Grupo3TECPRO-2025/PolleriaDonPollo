package Clases;

public class MenuProducto {
	String id_Producto,descripcion;
	Double precio_Unitario;
	
	public MenuProducto(String id_Producto, String descripcion, Double precio_Unitario) {
		this.id_Producto = id_Producto;
		this.descripcion = descripcion;
		this.precio_Unitario = precio_Unitario;
	}

	public String getId_Producto() {
		return id_Producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio_Unitario() {
		return precio_Unitario;
	}

	public void setPrecio_Unitario(Double precio_Unitario) {
		this.precio_Unitario = precio_Unitario;
	}
	
	
}
