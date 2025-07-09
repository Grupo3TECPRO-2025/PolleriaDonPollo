package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import javax.swing.JOptionPane;

import CartaPolleria.Cupon;

public class Arreglocupon {
	
	public static boolean actualizarEstadoCupon(int cuponID, String nuevoEstado) {
	    boolean actualizado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL ActualizarEstadoCupon(?, ?)}")) {

	        cs.setInt(1, cuponID);
	        cs.setString(2, nuevoEstado.toLowerCase()); // Asegura consistencia con ENUM en DB

	        int filasAfectadas = cs.executeUpdate();
	        actualizado = (filasAfectadas > 0);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return actualizado;
	}

	
	public static Cupon obtenerCuponDisponiblePorID(int cuponID) {
	    Cupon cupon = null;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL ObtenerCuponPorID(?)}")) {

	        cs.setInt(1, cuponID);
	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            // Solo se ejecutará si el cupón está disponible (filtrado desde el procedure)
	            int id = rs.getInt("CuponID");
	            double valor = rs.getDouble("Valor");
	            String tipo = rs.getString("Tipo");

	            cupon = new Cupon(id, valor, tipo);
	        }

	        rs.close();
	        cs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return cupon;
	}


}
