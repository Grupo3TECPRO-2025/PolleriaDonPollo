package Arraylist;

import java.net.CacheRequest;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DatosPersonales.Persona;
import Gestiones.Usuario;

public class ArregloUsuario {
	static public Usuario VerificarLogin(String usuario, String contraseña){
		Usuario usuariologeado = null;
	
		try {
	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL VerificarLogin(?, ?)}");

	        csta.setString(1, usuario);
	        csta.setString(2, contraseña);

	        ResultSet rs = csta.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("NombreApellido");
	            String direccion = rs.getString("Direccion");
	            int telefono = rs.getInt("Telefono");
	            String dni = rs.getString("DNI"); // puede ser null
	            String rol = rs.getString("Rol");

	            Persona persona;

	            // 👇 Si DNI es null, usar constructor de 3 parámetros
	            if (dni == null || dni.trim().isEmpty()) {
	                persona = new Persona(telefono, nombre, direccion);
	            } else {
	                persona = new Persona(telefono, nombre, dni, direccion);
	            }

	            usuariologeado = new Usuario(usuario, contraseña, rol, persona);
	        }

	        rs.close();
	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
		return usuariologeado;
	}
	
	
	static public Usuario verificarUsuario(String usuario) {
		Usuario usuariologeado = null;
		
		try {
	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL VerificarUsuario(?)}");

	        csta.setString(1, usuario);

	        ResultSet rs = csta.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("NombreApellido");
	            String direccion = rs.getString("Direccion");
	            int telefono = rs.getInt("Telefono");
	            String dni = rs.getString("DNI"); // puede ser null
	            String rol = rs.getString("Rol");
	            String contraseña = rs.getString("Contraseña");

	            Persona persona;

	            // 👇 Si DNI es null, usar constructor de 3 parámetros
	            if (dni == null || dni.trim().isEmpty()) {
	                persona = new Persona(telefono, nombre, direccion);
	            } else {
	                persona = new Persona(telefono, nombre, dni, direccion);
	            }

	            usuariologeado = new Usuario(usuario, contraseña, rol, persona);
	        }

	        rs.close();
	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
		return usuariologeado;
	}
	
	static public boolean VerificarSucursalKey(String llave) {
		boolean existe = false;

		try {
		    CallableStatement csta = ConexionSQL.getConexion()
		            .prepareCall("{CALL VerificarSucursalKey(?)}");

		    csta.setString(1, llave);

		    ResultSet rs = csta.executeQuery();

		    // Si hay al menos un resultado, existe
		    if (rs.next()) {
		         existe = true;
		    }

		      rs.close();
		      csta.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return existe;
	}
		
	public static boolean RegistrarCliente(Usuario usuario) {
	    try {
	        Persona p = usuario.getPersona();

	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL RegistrarCliente(?, ?, ?, ?, ?, ?)}");

	        csta.setString(1, usuario.getUser());
	        csta.setString(2, usuario.getContraseña());
	        csta.setString(3, p.getNombreCompleto());
	        csta.setString(4, p.getDNI());
	        csta.setString(5, p.getDireccion());
	        csta.setString(6, String.valueOf(p.getTelefono()));

	        csta.execute();
	        csta.close();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

		
	public static boolean RegistrarAdministrador(Usuario admin, String sucursalKey) {
	    try {
	        Persona p = admin.getPersona();

	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL RegistrarAdministrador(?, ?, ?, ?, ?, ?, ?)}");

	        csta.setString(1, admin.getUser());
	        csta.setString(2, admin.getContraseña());
	        csta.setString(3, p.getNombreCompleto());
	        csta.setString(4, p.getDNI());
	        csta.setString(5, p.getDireccion());
	        csta.setString(6, String.valueOf(p.getTelefono()));
	        csta.setString(7, sucursalKey);

	        csta.execute();
	        csta.close();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

		
	public static boolean RegistrarProveedor(Usuario proveedor, String ruc, String empresa) {
	    try {
	        Persona p = proveedor.getPersona();

	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL RegistrarProveedor(?, ?, ?, ?, ?, ?, ?, ?)}");

	        csta.setString(1, proveedor.getUser());
	        csta.setString(2, proveedor.getContraseña());
	        csta.setString(3, p.getNombreCompleto());
	        csta.setString(4, p.getDNI());
	        csta.setString(5, p.getDireccion());
	        csta.setString(6, String.valueOf(p.getTelefono()));
	        csta.setString(7, ruc);
	        csta.setString(8, empresa);

	        csta.execute();
	        csta.close();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

		

}
