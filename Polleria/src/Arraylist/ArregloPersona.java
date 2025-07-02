package Arraylist;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import DatosPersonales.Persona;
import Gestiones.Usuario;

public class ArregloPersona {
	static public Persona VerificarDNI(String dni){
		Persona perso = null;
	
		try {
	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL VerificarDNI(?)}");

	        csta.setString(1, dni);

	        ResultSet rs = csta.executeQuery();

	        if (rs.next()) {

	        	String nombre = rs.getString("NombreApellido");
	        	int telefono = rs.getInt("Telefono");
	        	String DNI = rs.getString("DNI");

	        	if (dni == null || dni.trim().isEmpty()) {
	        	    perso = new Persona(telefono, nombre);
	        	} else {
	        	    perso = new Persona(telefono, nombre, DNI);
	        	}
	        	
	        	
	        }

	        rs.close();
	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
		return perso;
	}

}
