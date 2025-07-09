package Arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DatosPersonales.Cliente;
import DatosPersonales.ClienteCuenta;

public class ArregloCliente {
	
	public static boolean habilitarClienteRegisPorDNI(String dni) {
	    boolean exito = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL HabilitarClienteRegisPorDNI(?)}")) {

	        cs.setString(1, dni);
	        cs.execute();
	        exito = true;
	        System.out.println("✅ Cliente registrado habilitado correctamente.");

	    } catch (Exception e) {
	        System.err.println("❌ Error al habilitar cliente registrado: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return exito;
	}

	
	public static boolean deshabilitarClienteRegisPorDNI(String dni) {
	    boolean actualizado = false;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL EliminarClienteRegisPorDNI(?)}")) {

	        cs.setString(1, dni);
	        int filas = cs.executeUpdate(); // devuelve cuántas filas fueron afectadas

	        actualizado = (filas > 0);

	        if (actualizado) {
	            System.out.println("✅ Cliente deshabilitado correctamente.");
	        } else {
	            System.out.println("⚠ No se encontró un cliente habilitado con ese DNI.");
	        }

	    } catch (Exception e) {
	        System.err.println("❌ Error al deshabilitar cliente registrado: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return actualizado;
	}

	public static List<ClienteCuenta> buscarClientesRegisPorNombre(String nombreParcial) {
	    List<ClienteCuenta> lista = new ArrayList<>();

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL BuscarClientesRegisPorNombre(?)}")) {

	        cs.setString(1, nombreParcial);
	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            String dni = rs.getString("DNI");
	            int clienteID = rs.getInt("ClienteID");
	            String nombre = rs.getString("NombreApellido");
	            int telefono = Integer.parseInt(rs.getString("Telefono"));
	            int puntos = rs.getInt("PuntosCuenta");
	            LocalDateTime fecha = rs.getTimestamp("FechaRegistro").toLocalDateTime();

	            Cliente cliente = new Cliente(String.valueOf(clienteID), telefono, nombre, dni);
	            ClienteCuenta cuenta = new ClienteCuenta(dni, puntos, cliente);
	            cuenta.setFechaRegistro(fecha);

	            lista.add(cuenta);
	        }

	    } catch (Exception e) {
	        System.err.println("❌ Error al buscar clientes registrados por nombre: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	public static ClienteCuenta verificarClienteRegisHabilitado(String dni) {
	    ClienteCuenta cuenta = null;

	    try (Connection conn = ConexionSQL.getConexion();
	         CallableStatement cs = conn.prepareCall("{CALL VerificarClienteRegisHabilitado(?)}")) {

	        cs.setString(1, dni);
	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            // Extraer datos de ClienteRegis
	            int clienteID = rs.getInt("ClienteID");
	            String dniEncontrado = rs.getString("DNI");
	            int puntos = rs.getInt("PuntosCuenta");
	            Timestamp fecha = rs.getTimestamp("FechaRegistro");

	            // Como no devuelve datos de Persona, generamos un Cliente parcial
	            Cliente cliente = new Cliente(String.valueOf(clienteID), 0, "", dniEncontrado);

	            cuenta = new ClienteCuenta(dniEncontrado, puntos, cliente);
	            cuenta.setFechaRegistro(fecha.toLocalDateTime());
	        }

	    } catch (Exception e) {
	        System.err.println("❌ Error al verificar cliente regis habilitado: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return cuenta;
	}

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

	public static List<ClienteCuenta> listarClientesRegisHabilitados() {
	    List<ClienteCuenta> lista = new ArrayList<>();

	    try {
	    	Connection conn = ConexionSQL.getConexion();
	    
	         CallableStatement cs = conn.prepareCall("{CALL ListarClientesRegisHabilitados()}");

	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            // Datos personales
	            String dni = rs.getString("DNI");
	            int clienteID = rs.getInt("ClienteID");
	            String nombre = rs.getString("NombreApellido");
	            int telefono = Integer.parseInt(rs.getString("Telefono"));

	            // Cliente
	            Cliente cliente = new Cliente(String.valueOf(clienteID), telefono, nombre, dni);

	            // ClienteCuenta
	            int puntos = rs.getInt("PuntosCuenta");
	            LocalDateTime fecha = rs.getTimestamp("FechaRegistro").toLocalDateTime();
	            ClienteCuenta cuenta = new ClienteCuenta(dni, puntos, cliente);
	            cuenta.setFechaRegistro(fecha);

	            lista.add(cuenta);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        System.err.println("❌ Error al listar clientes con cuenta habilitados: " + e.getMessage());
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
