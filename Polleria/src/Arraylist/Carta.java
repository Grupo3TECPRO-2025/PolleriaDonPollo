package Arraylist;

import java.awt.Component;
import java.awt.Menu;
import java.io.Console;
import java.lang.System.Logger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import CartaPolleria.MenuProducto;
import gui.ClienteGUI;

public class Carta {
	static private List<MenuProducto> menu;

	static public ArrayList<MenuProducto> VerCarta() {
        ArrayList<MenuProducto> menuList = new ArrayList<>();

        try {
            CallableStatement csta = ConexionSQL.getConexion()
                .prepareCall("{CALL VerCarta()}");

            ResultSet rs = csta.executeQuery();

            while (rs.next()) {
                String productoID = rs.getString("ProductoID");
                String descripcion = rs.getString("Descripcion");
                double precio = rs.getDouble("PrecioUnitario");

                MenuProducto item = new MenuProducto(productoID, descripcion, precio);
                menuList.add(item);
            }

            rs.close();
            csta.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        menu = menuList;
        return menuList;
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
