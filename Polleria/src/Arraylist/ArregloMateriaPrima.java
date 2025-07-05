package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Inventario.MateriaPrima;

public class ArregloMateriaPrima {
	public static ArrayList<MateriaPrima> listarMateriaPrima() {
	    ArrayList<MateriaPrima> lista = new ArrayList<>();

	    try {
	    	Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL ListarMateriaPrimas()}");
	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("MateriaPrimaID");
	            String nombre = rs.getString("Nombre");
	            int stock = rs.getInt("Stock");

	            MateriaPrima mp = new MateriaPrima(id, nombre, stock);
	            lista.add(mp);
	        }

	        rs.close();
	        cs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	static public ArrayList<MateriaPrima> consultarMateriaPrima(String nombreBuscar) {
	    ArrayList<MateriaPrima> lista = new ArrayList<>();

	    try {
	        CallableStatement cs = ConexionSQL.getConexion()
	            .prepareCall("{CALL BuscarMateriaPrima(?)}");
	        cs.setString(1, nombreBuscar);

	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("MateriaPrimaID");
	            String nombre = rs.getString("Nombre");
	            int stock = rs.getInt("Stock");

	            MateriaPrima mp = new MateriaPrima(id, nombre, stock);
	            lista.add(mp);
	        }

	        rs.close();
	        cs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	

}
