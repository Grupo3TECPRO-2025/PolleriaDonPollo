package CartaPolleria;

import java.awt.Component;
import java.awt.Menu;
import java.io.Console;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gui.PolleriaMenu;

public class Carta {
	static private List<MenuProducto> menu;

	public Carta() {
		menu = new ArrayList<MenuProducto>();

		Adicionar(new MenuProducto("1/4P01","1/4 Pollo + Papas + Ensalada y Cremas", 18.00));
		Adicionar(new MenuProducto("1/4P02","1/4 Pollo + Papas + Ensalada + Gaseosa 500ml y Cremas", 21.00));
	
		Adicionar(new MenuProducto("1/2P01","1/2 Pollo + Papas + Ensalada  y Cremas", 32.00));
		Adicionar(new MenuProducto("1/2P02","1/2 Pollo + Papas + Ensalada + Gaseosa 1.5L y Cremas", 36.00));
		
		Adicionar(new MenuProducto("1/1P01","1 Pollo + Papas + Ensalada y Cremas", 55.00));
		Adicionar(new MenuProducto("1/1P02","1 Pollo + Papas + Ensalada + Gaseosa 2.5L y Cremas", 64.00));
	
		Adicionar(new MenuProducto("S01","1 Salchipapa y Cremas", 12.00));
	
	}

	public List<MenuProducto> getMenu() {
		return menu;
	}

	public void Adicionar(MenuProducto producto) {
		menu.add(producto);
	}

	public MenuProducto Obtener(int x) {
		return menu.get(x);
	}

	public MenuProducto Buscar(String id) {
		for(int i=0;i<menu.size();i++) {
			if(Obtener(i).getIdProducto().equals(id)) return menu.get(i);
		}
		return null;
	}




}
