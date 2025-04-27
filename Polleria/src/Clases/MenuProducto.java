package Clases;

public class MenuProducto {
	String idProducto,descripcion;
	Double precioUnitario;
	
	public MenuProducto(String idProducto, String descripcion, Double precioUnitario) {
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
}
