package CartaPolleria;

import java.util.ArrayList;
import java.util.Iterator;

public class CuponeraLista {
	
	private ArrayList<Cupon> Lista;

	public CuponeraLista() {
		
		Lista = new ArrayList<Cupon>();
		Adicionar(new Cupon(123456, 50, "porcentaje"));
		Adicionar(new Cupon(343425, 100, "fijo"));
		Adicionar(new Cupon(322423, 20, "porcentaje"));
		
	}
	
	
	public void Adicionar(Cupon nuevo) {
		Lista.add(nuevo);
	}
	
	
	public Cupon Buscar(int id) {
		for (Cupon promocion : Lista) {
			if(promocion.getId() == id) return promocion;
		}
		return null;
	}
	
	
	

}
