package Arraylist;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import DatosPersonales.Administrador;
import Gestiones.Usuario;

public class ArregloAdministrador {
	public static Administrador obtenerAdministrador(String usuarioBuscado) {
        Administrador admin = null;

        try {
            CallableStatement cstmt = ConexionSQL.getConexion()
                .prepareCall("{CALL ObtenerDatosAdministrador(?)}");

            cstmt.setString(1, usuarioBuscado);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                String adminID = rs.getString("AdminID");
                String direccion = rs.getString("DireccionAdmin");

                String nombre = rs.getString("NombreApellido");
                int telefono = rs.getInt("Telefono");
                String dni = rs.getString("DNI");

                String user = rs.getString("Usuario");
                String contrasena = rs.getString("Contraseña");
                String rol = rs.getString("Rol");

                // Crear Usuario
                Usuario usuario = new Usuario(user, contrasena, rol);

                // Crear Administrador
                admin = new Administrador(adminID, telefono, nombre, dni, direccion, usuario);

                // Asignar Persona al objeto Usuario (opcional)
            }

            rs.close();
            cstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }

}
