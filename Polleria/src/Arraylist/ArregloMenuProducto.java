package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import CartaPolleria.MenuProducto;
import Inventario.PlatoConsumo;

public class ArregloMenuProducto {
	public static void registrarPlato(MenuProducto plato) {
	    try {
	        CallableStatement cs = ConexionSQL.getConexion().prepareCall("{call RegistrarPlato(?, ?, ?, ?)}");
	        cs.setString(1, plato.getIdProducto());
	        cs.setString(2, plato.getNombre());
	        cs.setString(3, plato.getDescripcion());
	        cs.setDouble(4, plato.getPrecioUnitario());
	        
	        
	        cs.executeUpdate();

	        for (PlatoConsumo consumo : plato.getListaDeConsumos()) {
	        	registrarMateriaXPlato(plato, consumo);			
			}
	        
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static String generarNuevoIDDesdeNombre(String nombrePlato) {
	    String prefijo = nombrePlato.trim().toUpperCase().substring(0, 2);

	    String nuevoID = "";

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL ContarProductosPorPrefijo(?)}");
	        cs.setString(1, prefijo);
	        ResultSet rs = cs.executeQuery();

	        int contador = 1; // por defecto

	        if (rs.next()) {
	            contador = rs.getInt("Cantidad") + 1;
	        }

	        nuevoID = prefijo + contador;

	        
	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return nuevoID;
	}
	
	public static void registrarMateriaXPlato(MenuProducto plato, PlatoConsumo consumo) {
	    try {
	        CallableStatement cs = ConexionSQL.getConexion().prepareCall("{call InsertarMateriaXPlato(?, ?, ?)}");
	        cs.setString(1, plato.getIdProducto());
	        cs.setInt(2, consumo.getInsumo().getMateriaid());
	        cs.setInt(3, consumo.getCantidad());
	        cs.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static boolean existePlatoPorNombre(String nombre) {
	    boolean existe = false;

	    try {
	        CallableStatement cs = ConexionSQL.getConexion().prepareCall("{call ExistePlatoPorNombre(?)}");
	        cs.setString(1, nombre);
	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            int cantidad = rs.getInt("Existe");
	            existe = (cantidad > 0);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return existe;
	}



}
