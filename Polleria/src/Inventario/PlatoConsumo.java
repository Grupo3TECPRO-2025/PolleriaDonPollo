package Inventario;

import CartaPolleria.MenuProducto;

public class PlatoConsumo {
	MateriaPrima insumo;
	int cantidad;
	public PlatoConsumo(MateriaPrima insumo, int cantidad) {
		this.insumo = insumo;
		this.cantidad = cantidad;
	}
	public MateriaPrima getInsumo() {
		return insumo;
	}
	public void setInsumo(MateriaPrima insumo) {
		this.insumo = insumo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
