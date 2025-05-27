package CartaPolleria;

public class MenuProducto {
	private String idProducto,descripcion;
	private double precioUnitario;
	
	public MenuProducto(String idProducto, String descripcion, double precioUnitario) {
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

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	
	
	
}
