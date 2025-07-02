package Arraylist;

import java.net.CacheRequest;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DatosPersonales.Cliente;
import DatosPersonales.Persona;
import DatosPersonales.Proveedor;
import Gestiones.Usuario;
import gui.ClienteGUI;

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

	            String rol = rs.getString("Rol");

	            usuariologeado = new Usuario(usuario, contraseña, rol);
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

	            String rol = rs.getString("Rol");
	            String contraseña = rs.getString("Contraseña");


	            usuariologeado = new Usuario(usuario, contraseña, rol);
	        }

	        rs.close();
	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
		return usuariologeado;
	}
	

		
	public static boolean RegistrarCliente(Cliente cli) {
	    try {
	        

	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL RegistrarCliente(?, ?, ?, ?)}");

	        csta.setString(3, cli.getNombreCompleto());
	        csta.setString(4, cli.getDNI());
	        csta.setString(5, cli.getDireccion());
	        csta.setString(6, String.valueOf(cli.getTelefono()));

	        csta.execute();
	        csta.close();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	/*	
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

	 */
		
	public static boolean RegistrarProveedor(Usuario proveedor, String ruc, String empresa) {
	    Proveedor pro = null;
		try {
	    

	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL RegistrarProveedor(?, ?, ?, ?, ?, ?, ?, ?)}");

	   
	        csta.setString(3, pro.getNombreEmpresa());
	        csta.setString(4, pro.getRUC());
	        csta.setString(5, String.valueOf(pro.getTelefono()));
	        csta.setString(7, pro.getDireccion());

	        csta.execute();
	        csta.close();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

		

}
