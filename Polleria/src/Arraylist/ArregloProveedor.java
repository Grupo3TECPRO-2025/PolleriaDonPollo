package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import DatosPersonales.Proveedor;

public class ArregloProveedor {

	public static boolean modificarProveedorPorNombre(String nombreActual, Proveedor pro) {
	    boolean actualizado = false;

	    try (Connection conn = ConexionSQL.getConexion()) {

	        CallableStatement cstmt = conn.prepareCall("{CALL ModificarProveedorPorNombre(?, ?, ?, ?)}");

	        cstmt.setString(1, nombreActual);
	        cstmt.setString(2, pro.getNombreEmpresa());
	        cstmt.setString(3, pro.getDireccion());
	        cstmt.setString(4, ""+pro.getTelefono());
	        int filas = cstmt.executeUpdate();

	        if (filas > 0) {
	            actualizado = true;
	        }

	        cstmt.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return actualizado;
	}
	
	public static boolean EliminarProveedor(String nombreEmpresa) {
	    boolean eliminado = false;

	    try (Connection conn = ConexionSQL.getConexion()) {
	        CallableStatement cs = conn.prepareCall("{CALL EliminarProveedor(?)}");
	        cs.setString(1, nombreEmpresa);

	        int filasAfectadas = cs.executeUpdate(); // Devuelve cantidad de filas afectadas
	        eliminado = (filasAfectadas > 0);

	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return eliminado;
	}

	public static void RegistrarProveedor(Proveedor proveedor) {


		try {
			Connection conn = ConexionSQL.getConexion();
			CallableStatement stmt = conn.prepareCall("{call RegistrarProveedor(?, ?, ?, ?)}");

			stmt.setString(1, proveedor.getRUC());
			stmt.setString(2, proveedor.getNombreEmpresa());
			stmt.setString(3, proveedor.getDireccion());
			stmt.setString(4, ""+proveedor.getTelefono());

			stmt.execute();
			System.out.println("Proveedor registrado correctamente en la base de datos.");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar el proveedor: " + e.getMessage());
		} 
		
	}
	
	 static  public ArrayList<Proveedor> listarProveedores() {
	        ArrayList<Proveedor> lista = new ArrayList<>();

	        try {
	            Connection cn = ConexionSQL.getConexion();
	            CallableStatement cs = cn.prepareCall("{CALL ListarProveedores()}");
	            ResultSet rs = cs.executeQuery();

	            while (rs.next()) {
	                String ruc = rs.getString("RUC");
	                String nombre = rs.getString("EmpresaNombre");
	                String direccion = rs.getString("Direccion");
	                int telefono = rs.getInt("Telefono");

	                Proveedor p = new Proveedor(ruc, nombre, direccion, telefono);
	                lista.add(p);
	            }

	            rs.close();
	            cs.close();
	            cn.close();

	        } catch (Exception e) {
	            System.out.println("Error al listar proveedores: " + e.getMessage());
	        }

	        return lista;
	    }
	
	

}
