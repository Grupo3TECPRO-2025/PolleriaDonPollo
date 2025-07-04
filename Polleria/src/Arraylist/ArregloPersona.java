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
	
	
	public static Persona obtenerPersonaPorUsuario(String usuario) {
        Persona persona = null;

        try {
            CallableStatement cstmt = ConexionSQL.getConexion()
                .prepareCall("{CALL ObtenerDatosPersona(?)}");

            cstmt.setString(1, usuario);

            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                int telefono = rs.getInt("Telefono");
                String nombre = rs.getString("NombreApellido");
                String dni = rs.getString("DNI");
                String direccion = ""; // no está en la tabla actual
                String rol = rs.getString("Rol");

                if (dni == null || dni.trim().isEmpty()) {
                    persona = new Persona(telefono, nombre); // sin DNI
                } else {
                    persona = new Persona(telefono, nombre, dni); // con DNI
                }
            }

            rs.close();
            cstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return persona;
    }

}
