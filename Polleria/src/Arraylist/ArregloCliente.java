package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import DatosPersonales.Cliente;
import DatosPersonales.ClienteCuenta;

public class ArregloCliente {
	
	public static void registrarNuevoClienteConCuenta(ClienteCuenta cuenta) {
	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL RegistrarNuevoClienteConCuenta(?, ?, ?, ?)}")) {

	        // Datos desde el objeto cuenta y su Cliente interno
	        Cliente cliente = cuenta.getCli();

	        cs.setString(1, String.valueOf(cliente.getTelefono()));
	        cs.setString(2, cliente.getNombreCompleto());
	        cs.setString(3, cuenta.getDNI());
	        cs.setTimestamp(4, Timestamp.valueOf(cuenta.getFechaRegistro())); // LocalDateTime → Timestamp

	        cs.execute();
	        System.out.println("✅ Cliente con cuenta registrado correctamente.");

	    } catch (Exception e) {
	        System.err.println("❌ Error al registrar cliente con cuenta: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	
	public static ClienteCuenta buscarClienteRegisPorDNI(String dni) {
	    ClienteCuenta cuenta = null;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement stmt = conn.prepareCall("{CALL BuscarClienteRegisPorDNI(?)}")) {

	        stmt.setString(1, dni);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            // Obtener datos del cliente
	            String clienteID = String.valueOf(rs.getInt("ClienteID"));
	            String nombre = rs.getString("NombreApellido");
	            String telefono = rs.getString("Telefono");

	            // Crear Cliente
	            Cliente cliente = new Cliente(clienteID, Integer.parseInt(telefono), nombre, dni);

	            // Obtener fecha y puntos
	            Timestamp fechaRegistro = rs.getTimestamp("FechaRegistro");
	            int puntos = rs.getInt("PuntosCuenta");

	            // Crear ClienteCuenta
	            cuenta = new ClienteCuenta(dni, puntos, cliente);
	            cuenta.setFechaRegistro(fechaRegistro.toLocalDateTime());
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return cuenta;
	}

	
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
	
	public static boolean RegistrarClienteANTIGUO(Cliente cli) {
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
