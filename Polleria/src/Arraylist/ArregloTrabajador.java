package Arraylist;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DatosPersonales.Trabajador;
import Gestiones.Usuario;

public class ArregloTrabajador {
	static public ArrayList<Trabajador> listarTrabajadores(){
		ArrayList<Trabajador> lista = null;
		
		try {
			
		}catch (Exception e) {
			
		}
		
		return lista;
	}
	
	static public Trabajador VerificarDNITrabajador(String dni){
		Trabajador emp = null;
		
		try {
			
		}catch (Exception e) {
			
		}
		
		return emp;
	}
	
	public static Trabajador obtenerTrabajador(String usuarioBuscado) {
        Trabajador trabajador = null;

        try {
            CallableStatement cstmt = ConexionSQL.getConexion()
                .prepareCall("{CALL ObtenerDatosTrabajador(?)}");

            cstmt.setString(1, usuarioBuscado);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                String trabajadorID = rs.getString("TrabajadorID");
                String direccion = rs.getString("Direccion");

                String nombre = rs.getString("NombreApellido");
                int telefono = rs.getInt("Telefono");
                String dni = rs.getString("DNI");

                String user = rs.getString("Usuario");
                String contrasena = rs.getString("Contraseña");
                String rol = rs.getString("Rol");

                // Crear Usuario
                Usuario usuario = new Usuario(user, contrasena, rol);

                // Crear Trabajador (hereda de Persona)
                trabajador = new Trabajador(trabajadorID, telefono, nombre, dni, direccion, usuario);


            }

            rs.close();
            cstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return trabajador;
    }
	
	static public boolean EliminarTrabajador(String dni){
		
		
		try {
			
			
			
			return true;
		}catch (Exception e) {
			
		}
		
		return false;
	}
}
