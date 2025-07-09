package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import DatosPersonales.Proveedor;
import Inventario.MateriaPrima;

public class ArregloProveedor {

	public static boolean habilitarProveedorPorRUC(String ruc) {
	    boolean resultado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall("{CALL HabilitarProveedorPorRUC(?)}")) {

	        stmt.setString(1, ruc);
	        stmt.execute();

	        resultado = true;
	        System.out.println("✅ Proveedor habilitado correctamente.");

	    } catch (Exception e) {
	        System.err.println("❌ Error al habilitar proveedor: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return resultado;
	}

	
	public static boolean deshabilitarProveedorPorNombre(String nombreEmpresa) {
	    boolean actualizado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL EliminarProveedor(?)}")) {

	        cs.setString(1, nombreEmpresa);
	        int filasAfectadas = cs.executeUpdate(); // usamos executeUpdate porque UPDATE devuelve cantidad de filas

	        actualizado = (filasAfectadas > 0);

	        if (actualizado) {
	            System.out.println("✅ Proveedor deshabilitado correctamente.");
	        } else {
	            System.out.println("⚠ No se encontró un proveedor habilitado con ese nombre.");
	        }

	    } catch (Exception e) {
	        System.err.println("❌ Error al deshabilitar proveedor: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return actualizado;
	}

	public static boolean verificarProveedorHabilitado(String ruc) {
	    boolean habilitado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL VerificarProveedorHabilitado(?)}")) {

	        cs.setString(1, ruc);
	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            habilitado = true;
	        }

	    } catch (Exception e) {
	        System.err.println("❌ Error al verificar proveedor habilitado: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return habilitado;
	}

	public static ArrayList<Proveedor> buscarProveedorPorNombre(String nombre) {
	    ArrayList<Proveedor> lista = new ArrayList<>();

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{call BuscarProveedorPorNombre(?)}")) {

	        cs.setString(1, nombre);
	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            int telefono = rs.getInt("Telefono");
	            String nombreEmpresa = rs.getString("EmpresaNombre");
	            String ruc = rs.getString("RUC");
	            String direccion = rs.getString("Direccion");

	            Proveedor p = new Proveedor(ruc,nombreEmpresa, direccion,telefono);
	            lista.add(p);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

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
			
			for (MateriaPrima m : proveedor.getTipoProvicion()) {
				registrarProvicion(m.getMateriaid(), proveedor.getRUC());	
			}
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar el proveedor: " + e.getMessage());
		} 
		
	}
	
	public static ArrayList<MateriaPrima> listarProvisionesPorProveedor(String proveedorID) {
	    ArrayList<MateriaPrima> lista = new ArrayList<>();

	    try {
	    	Connection conn = ConexionSQL.getConexion();
	    
	        CallableStatement stmt = conn.prepareCall("{CALL ListarProvicionesDeProveedor(?)}");

	        stmt.setString(1, proveedorID);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("MateriaPrimaID");
	            String nombre = rs.getString("NombreInsumo");
	            int stock = rs.getInt("Stock");

	            MateriaPrima mp = new MateriaPrima(id, nombre, stock);
	            lista.add(mp);
	        }

	        rs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	public static void registrarProvicion(int materiaPrimaID, String proveedorRUC) {
	    Connection conn = null;
	    CallableStatement stmt = null;

	    try {
	        conn = ConexionSQL.getConexion(); // Asegúrate de tener este método para obtener tu conexión

	        String sql = "{CALL RegistrarProvicion(?, ?)}";
	        stmt = conn.prepareCall(sql);

	        stmt.setInt(1, materiaPrimaID);
	        stmt.setString(2, proveedorRUC);

	        stmt.executeUpdate();

	        System.out.println("✔ Provisión registrada correctamente.");

	    } catch (SQLException e) {
	        System.err.println("❌ Error al registrar la provisión: " + e.getMessage());
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            System.err.println("❌ Error al cerrar conexión: " + e.getMessage());
	        }
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
