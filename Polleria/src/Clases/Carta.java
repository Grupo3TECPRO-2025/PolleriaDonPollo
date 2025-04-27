package Clases;

import java.awt.Menu;
import java.util.ArrayList;

public class Carta {
 ArrayList<MenuProducto> menu;

public Carta(ArrayList<MenuProducto> menu) {
	this.menu = menu;
}

public ArrayList<MenuProducto> getMenu() {
	return menu;
}

public void Adicionar(MenuProducto men1) {
	menu.add(men1);
}
public MenuProducto Buscar(String id) {
	for(int i=0;i<menu.size();i++) {
		if(id==menu.get(i).getId_Producto()) {
			return menu.get(i);
		}
	}
	return null;
}

}
