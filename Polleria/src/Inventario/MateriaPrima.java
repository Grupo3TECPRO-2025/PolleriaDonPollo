package Inventario;

public class MateriaPrima {
	  private int Materiaid;
	  private String nombre;
	  private int stock;
	  
	  
	public MateriaPrima(int materiaid, String nombre, int stock) {
		super();
		Materiaid = materiaid;
		this.nombre = nombre;
		this.stock = stock;
	}
	public int getMateriaid() {
		return Materiaid;
	}
	public void setMateriaid(int materiaid) {
		Materiaid = materiaid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	    
	  
	  
	    


}
