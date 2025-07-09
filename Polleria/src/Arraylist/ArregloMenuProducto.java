package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import CartaPolleria.MenuProducto;
import Inventario.MateriaPrima;
import Inventario.PlatoConsumo;

public class ArregloMenuProducto {
	
	
	
	public static ArrayList<PlatoConsumo> obtenerInsumosPorProductoID(String productoID) {
        ArrayList<PlatoConsumo> lista = new ArrayList<>();

        try {
            Connection conn = ConexionSQL.getConexion();
            CallableStatement cs = conn.prepareCall("{CALL ListarInsumosPorProductoID(?)}");
            cs.setString(1, productoID);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int materiaID = rs.getInt("MateriaPrimaID");
                String nombreInsumo = rs.getString("NombreInsumo");
                int cantidad = rs.getInt("Cantidad");

                MateriaPrima mp = new MateriaPrima(materiaID, nombreInsumo, 0); // stock no se necesita aquí
                PlatoConsumo consumo = new PlatoConsumo(mp, cantidad);
                lista.add(consumo);
            }

            rs.close();
            cs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
	
	
	public static void modificarPlato(MenuProducto pro) {
	    try {
	        CallableStatement cs = ConexionSQL.getConexion().prepareCall("{CALL ModificarMenuProducto(?, ?, ?, ?)}");
	        cs.setString(1, pro.getIdProducto());
	        cs.setString(2, pro.getNombre());
	        cs.setString(3, pro.getDescripcion());
	        cs.setDouble(4, pro.getPrecioUnitario());
	        
	        cs.executeUpdate();
	        cs.close();
	        
	        System.out.println("Plato modificado correctamente.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public static ArrayList<MenuProducto> listarMenuProductos() {
	    ArrayList<MenuProducto> lista = new ArrayList<>();

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL ListarMenuProductos()}");
	         ResultSet rs = cs.executeQuery()) {

	        while (rs.next()) {
	            String id = rs.getString("ProductoID");
	            String nombre = rs.getString("Nombre");
	            String descripcion = rs.getString("Descripcion");
	            double precio = rs.getDouble("PrecioUnitario");

	            MenuProducto mp = new MenuProducto(id, nombre, descripcion, precio);
	            lista.add(mp);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	public static ArrayList<MenuProducto> buscarPlatoPorDescripcion(String descripcion) {
	    ArrayList<MenuProducto> lista = new ArrayList<>();

	    try {
	        CallableStatement cs = ConexionSQL.getConexion().prepareCall("{call BuscarMenuPorDescripcion(?)}");
	        cs.setString(1, descripcion);
	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            String id = rs.getString("ProductoID");
	            String nombre = rs.getString("Nombre");
	            String desc = rs.getString("Descripcion");
	            double precio = rs.getDouble("PrecioUnitario");

	            MenuProducto mp = new MenuProducto(id, nombre, desc, precio);
	            lista.add(mp);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	
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
