package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import DatosPersonales.Cliente;

public class ArregloCliente {
	public static ArrayList<Cliente> buscarClientePorDNI(String dniParcial) {
	    ArrayList<Cliente> lista = new ArrayList<>();

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL BuscarClientePorDNI(?)}");
	        cs.setString(1, dniParcial);

	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            String clienteID = String.valueOf(rs.getInt("ClienteID"));
	            String nombre = rs.getString("NombreApellido");
	            String dni = rs.getString("DNI");
	            int telefono = Integer.parseInt(rs.getString("Telefono"));

	            Cliente cliente = new Cliente(clienteID, telefono, nombre, dni);
	            lista.add(cliente);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	public static ArrayList<Cliente> buscarClientePorNombre(String nombreParcial) {
        ArrayList<Cliente> lista = new ArrayList<>();

        try {
            Connection conn = ConexionSQL.getConexion();
            CallableStatement cs = conn.prepareCall("{CALL BuscarClientePorNombre(?)}");
            cs.setString(1, nombreParcial);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                String clienteID = String.valueOf(rs.getInt("ClienteID"));
                String nombre = rs.getString("NombreApellido");
                String dni = rs.getString("DNI");
                int telefono = Integer.parseInt(rs.getString("Telefono"));

                Cliente cliente = new Cliente(clienteID, telefono, nombre, dni);
                lista.add(cliente);
            }

            rs.close();
            cs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
	
	public static boolean RegistrarCliente(Cliente cli) {
	    try {
	        

	        CallableStatement csta = ConexionSQL.getConexion()
	            .prepareCall("{CALL RegistrarNuevoCliente(?, ?, ?, ?)}");

	        csta.setString(1, String.valueOf(cli.getTelefono()));
	        csta.setString(2, cli.getNombreCompleto());
	        csta.setString(3, cli.getDNI());
	        csta.setString(4, "cliente");

	        csta.execute();
	        csta.close();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public static Cliente ObtenerCliente(int clienteID) {
        Cliente cli = null;

        try {
            CallableStatement csta = ConexionSQL.getConexion()
                    .prepareCall("{CALL ObtenerDatosCliente(?)}");

            csta.setInt(1, clienteID);
            ResultSet rs = csta.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("NombreApellido");
                int telefono = rs.getInt("Telefono");
                String dni = rs.getString("DNI");
                String id = String.valueOf(rs.getInt("ClienteID"));

                if (dni == null || dni.trim().isEmpty()) {
                    cli = new Cliente(id, telefono, nombre);
                } else {
                    cli = new Cliente(id, telefono, nombre, dni);
                }
            }

            rs.close();
            csta.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cli;
    }

}
