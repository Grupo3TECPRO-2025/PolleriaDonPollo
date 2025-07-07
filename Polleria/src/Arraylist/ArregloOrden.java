package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import DatosPersonales.Administrador;
import DatosPersonales.Proveedor;
import Gestiones.DetalleOrdenCompra;
import Gestiones.OrdenCompra;

public class ArregloOrden {
	
	public static ArrayList<OrdenCompra> buscarOrdenesPorFecha(String fecha) {
	    ArrayList<OrdenCompra> lista = new ArrayList<>();

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall("{CALL BuscarOrdenesPorFecha(?)}")) {

	        stmt.setString(1, fecha);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	  int ordenID = rs.getInt("OrdenID");
		            String ruc = rs.getString("RUC");
		            String empresa = rs.getString("EmpresaNombre");
		            String direccion = rs.getString("Direccion");
		            int telefono = rs.getInt("Telefono");
		            String adminID = rs.getString("Administrador");
		            LocalDateTime fechaEmision = rs.getTimestamp("FechaEmision").toLocalDateTime();

		            Proveedor proveedor = new Proveedor(ruc, empresa, direccion, telefono);
		            Administrador admin = new Administrador(adminID, 0, null, null, null, null);
		            OrdenCompra orden = new OrdenCompra(ordenID, proveedor, admin);
		            orden.setFechaEmision(fechaEmision);
		            
	            lista.add(orden);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	public static ArrayList<OrdenCompra> buscarOrdenesPorRUCProveedor(String rucParcial) {
	    ArrayList<OrdenCompra> lista = new ArrayList<>();

	    String sql = "{CALL ListarOrdenesPorRUCProveedor(?)}";

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall(sql)) {

	        stmt.setString(1, rucParcial);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int ordenID = rs.getInt("OrdenID");
	            String ruc = rs.getString("RUC");
	            String empresa = rs.getString("EmpresaNombre");
	            String direccion = rs.getString("Direccion");
	            int telefono = rs.getInt("Telefono");
	            String adminID = rs.getString("Administrador");
	            LocalDateTime fecha = rs.getTimestamp("FechaEmision").toLocalDateTime();

	            Proveedor proveedor = new Proveedor(ruc, empresa, direccion, telefono);
	            Administrador admin = new Administrador(adminID, 0, null, null, null, null);
	            OrdenCompra orden = new OrdenCompra(ordenID, proveedor, admin);
	            orden.setFechaEmision(fecha);

	            lista.add(orden);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	public static ArrayList<OrdenCompra> buscarOrdenesPorNombreEmpresa(String nombreEmpresa) {
	    ArrayList<OrdenCompra> lista = new ArrayList<>();


	    try {
	    	Connection conn = ConexionSQL.getConexion();
	        CallableStatement stmt = conn.prepareCall("{CALL ListarOrdenesPorNombreEmpresa(?)}");

	        stmt.setString(1, nombreEmpresa);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int ordenID = rs.getInt("OrdenID");
	            String ruc = rs.getString("RUC");
	            String empresa = rs.getString("EmpresaNombre");
	            String direccion = rs.getString("Direccion");
	            int telefono = rs.getInt("Telefono");
	            String adminID = rs.getString("Administrador");
	            LocalDateTime fecha = rs.getTimestamp("FechaEmision").toLocalDateTime();
	            
	            
	            Proveedor proveedor = new Proveedor(ruc, empresa, direccion, telefono);
	            Administrador admin = new Administrador(adminID, 0, null, null, null, null);
	            OrdenCompra orden = new OrdenCompra(ordenID, proveedor, admin);
	            orden.setFechaEmision(fecha); 
	            lista.add(orden);
	        }

	    } catch (Exception ex) {
			// TODO: handle exception
		}
	    return lista;
	}

	static public void registrarOrdenCompra(OrdenCompra orden) {
		int OrdenID = -1;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall("{CALL RegistrarOrden(?, ?, ?)}")) {

	        stmt.setString(1, orden.getProveedor().getRUC()); // ProveedorID
	        stmt.setInt(2, Integer.parseInt(orden.getAdministrador().getAdminID())); // AdministradorID
	        stmt.setTimestamp(3, Timestamp.valueOf(orden.getFechaEmision())); // FechaEmision

	        stmt.executeUpdate();
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                OrdenID = rs.getInt(1);
            }
	        
	        for (DetalleOrdenCompra p : orden.getListaDetalleOrdenCompras()) {
	        	registrarDetalleOrdenCompra(p,OrdenID);
			}
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void registrarDetalleOrdenCompra(DetalleOrdenCompra detalle, int OrdenID) {
	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall("{CALL RegistrarDetalleOrden(?, ?, ?)}")) {

	        
	        int materiaPrimaID = detalle.getMateriaPrima().getMateriaid();
	        int cantidad = detalle.getCantidad();

	        stmt.setInt(1, OrdenID);
	        stmt.setInt(2, materiaPrimaID);
	        stmt.setInt(3, cantidad);

	        stmt.executeUpdate();
	        System.out.println("Detalle de orden registrado correctamente.");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}





}
