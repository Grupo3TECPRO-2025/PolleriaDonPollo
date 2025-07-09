package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DatosPersonales.Trabajador;
import Gestiones.Usuario;

public class ArregloTrabajador {
	
	public static boolean habilitarTrabajadorPorDNI(String dni) {
	    boolean habilitado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall("{CALL HabilitarTrabajadorPorDNI(?)}")) {

	        stmt.setString(1, dni);
	        stmt.execute();

	        habilitado = true;
	        System.out.println("✅ Trabajador habilitado correctamente.");

	    } catch (Exception e) {
	        System.err.println("❌ Error al habilitar trabajador: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return habilitado;
	}

	public static boolean eliminarTrabajadorPorDNI(String dni) {
	    boolean eliminado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall("{CALL EliminarTrabajadorPorDNI(?)}")) {

	        stmt.setString(1, dni);
	        stmt.execute();

	        eliminado = true;
	        System.out.println("✅ Trabajador deshabilitado correctamente.");

	    } catch (Exception e) {
	        System.err.println("❌ Error al deshabilitar trabajador: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return eliminado;
	}

	
	public static boolean modificarDatosTrabajador(String dni, String nombre, int telefono, String direccion) {
	    boolean modificado = false;
	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL ModificarDatosTrabajador(?, ?, ?, ?)}");
	        cs.setString(1, dni);
	        cs.setString(2, nombre);
	        cs.setInt(3, telefono);
	        cs.setString(4, direccion);

	        int rowsAffected = cs.executeUpdate();
	        modificado = (rowsAffected > 0);

	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return modificado;
	}

	
	public static ArrayList<Trabajador> buscarTrabajadoresPorNombre(String nombreParcial) {
	    ArrayList<Trabajador> lista = new ArrayList<>();

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL BuscarTrabajadoresPorNombre(?)}")) {

	        cs.setString(1, nombreParcial);
	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            String trabajadorID = String.valueOf(rs.getInt("TrabajadorID"));
	            String nombre = rs.getString("NombreApellido");
	            String dni = rs.getString("DNI");
	            int telefono = Integer.parseInt(rs.getString("Telefono"));
	            String direccion = rs.getString("Direccion");
	            String usuario = rs.getString("Usuario");
	            String contraseña = rs.getString("Contraseña");

	            Usuario user = new Usuario(usuario, contraseña, "trabajador");
	            Trabajador trabajador = new Trabajador(trabajadorID, telefono, nombre, dni, direccion, user);

	            lista.add(trabajador);
	        }

	    } catch (Exception e) {
	        System.err.println("❌ Error al buscar trabajadores por nombre: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return lista;
	}

	public static boolean registrarTrabajador(Trabajador emp) {
	    boolean registrado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL RegistrarNuevoTrabajador(?, ?, ?, ?, ?, ?)}")) {

	        cs.setString(1, String.valueOf(emp.getTelefono()));
	        cs.setString(2, emp.getNombreCompleto());
	        cs.setString(3, emp.getDNI());
	        cs.setString(4, emp.getDireccion());
	        cs.setString(5, emp.getUser().getUser());
	        cs.setString(6, emp.getUser().getContraseña());

	        cs.executeUpdate();
	        registrado = true;

	    } catch (Exception e) {
	        System.err.println("❌ Error al registrar trabajador: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return registrado;
	}

	
	public static boolean verificarTrabajadorHabilitado(String usuario) {
	    boolean habilitado = false;

	    try {
	    	 Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL VerificarTrabajadorHabilitado(?)}");

	        cs.setString(1, usuario);
	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            habilitado = true;
	        }

	    } catch (Exception e) {
	        System.err.println("❌ Error al verificar trabajador habilitado: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return habilitado;
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
	

}
