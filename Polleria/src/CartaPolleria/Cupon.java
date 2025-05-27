package CartaPolleria;

public class Cupon {
	private int id;
	private double descuento;
	private String tipo;
 
 
	public Cupon(int id, double descuento, String tipo) {
		this.id = id;
		this.descuento = descuento;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	public double getDescuento() {
		return descuento;
	}
	public String getTipo() {
		return tipo;
	}
 

}
