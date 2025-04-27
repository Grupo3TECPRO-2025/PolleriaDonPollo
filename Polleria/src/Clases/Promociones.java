package Clases;

public class Promociones {
 int id;
 double descuento;
 String tipo;
 
public Promociones(int id, double descuento, String tipo) {
	super();
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
