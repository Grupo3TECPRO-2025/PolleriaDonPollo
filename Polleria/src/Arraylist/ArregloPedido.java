package Arraylist;

import java.sql.Timestamp;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import CartaPolleria.Cupon;
import CartaPolleria.MenuProducto;
import DatosPersonales.Administrador;
import DatosPersonales.Cliente;
import DatosPersonales.ClienteCuenta;
import DatosPersonales.Trabajador;
import Gestiones.DetallePedido;
import Gestiones.Pedido;


public class ArregloPedido {
	
	public static List<Pedido> buscarPedidosPorNombreTrabajador(String nombreParcial) {
	    List<Pedido> lista = new ArrayList<>();

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL ListarPedidosPorNombreTrabajador(?)}");
	        cs.setString(1, nombreParcial);

	        ResultSet rs = cs.executeQuery();
	        while (rs.next()) {
	            int pedidoID = rs.getInt("PedidoID");
	            String metodoPago = rs.getString("MetodoPago");
	            String direccion = rs.getString("DireccionPedido");
	            String tipoPedido = rs.getString("TipoPedido");

	            // Datos del cliente
	            String nombreCliente = rs.getString("NombreCliente");
	            String dni = rs.getString("DNICliente");

	            Timestamp timestamp = rs.getTimestamp("FechaEmision");
	            LocalDateTime fecha = timestamp.toLocalDateTime();

	            Cliente cliente = new Cliente(null, 0, nombreCliente, dni);
	            Pedido pedido = new Pedido(pedidoID, metodoPago, direccion, tipoPedido, cliente, fecha);

	            lista.add(pedido);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        System.err.println("❌ Error al buscar pedidos por trabajador: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	public static List<Pedido> buscarPedidosPorFecha(String fechaString) {
	    List<Pedido> lista = new ArrayList<>();

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL BuscarPedidosPorFecha(?)}");
	        cs.setString(1, fechaString); // Ejemplo: "05-07-2025"

	        ResultSet rs = cs.executeQuery();
	        while (rs.next()) {
	            int pedidoID = rs.getInt("PedidoID");
	            String metodoPago = rs.getString("MetodoPago");
	            String direccion = rs.getString("DireccionPedido");
	            String tipoPedido = rs.getString("TipoPedido");

	            String nombre = rs.getString("NombreApellido");
	            int telefono = Integer.parseInt(rs.getString("Telefono"));
	            String dni = rs.getString("DNI");
	            String clienteID = rs.getString("ClienteID");

	            Timestamp timestamp = rs.getTimestamp("FechaEmision");
	            LocalDateTime fecha = timestamp.toLocalDateTime();

	            Cliente cli = new Cliente(clienteID, telefono, nombre, dni);
	            Pedido pedido = new Pedido(pedidoID, metodoPago, direccion, tipoPedido, cli, fecha);

	            lista.add(pedido);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	    	//
	    }

	    return lista;
	}

	
	public static List<Pedido> buscarPedidosPorDNICliente(String dniCliente) {
	    List<Pedido> lista = new ArrayList<>();

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL BuscarPedidosPorDNICliente(?)}");
	        cs.setString(1, dniCliente);

	        ResultSet rs = cs.executeQuery();
	        while (rs.next()) {
	            int pedidoID = rs.getInt("PedidoID");
	            String metodoPago = rs.getString("MetodoPago");
	            String direccion = rs.getString("DireccionPedido");
	            String tipoPedido = rs.getString("TipoPedido");

	            int telefono = Integer.parseInt(rs.getString("Telefono"));
	            String nombreCompleto = rs.getString("NombreApellido");
	            String dni = rs.getString("DNI");
	            String clienteID = rs.getString("ClienteID");

	            Timestamp timestamp = rs.getTimestamp("FechaEmision");
	            LocalDateTime fecha = timestamp.toLocalDateTime();

	            Cliente cliente = new Cliente(clienteID, telefono, nombreCompleto, dni);
	            Pedido pedido = new Pedido(pedidoID, metodoPago, direccion, tipoPedido, cliente, fecha);

	            lista.add(pedido);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}

	
	
	public static List<Pedido> buscarPedidosPorNombreCliente(String nombreParcial) {
	    List<Pedido> lista = new ArrayList<>();

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL BuscarPedidosPorNombreCliente(?)}");
	        cs.setString(1, nombreParcial);

	        ResultSet rs = cs.executeQuery();
	        while (rs.next()) {
	            int pedidoID = rs.getInt("PedidoID");
	            String metodoPago = rs.getString("MetodoPago");
	            String direccion = rs.getString("DireccionPedido");
	            String tipoPedido = rs.getString("TipoPedido");

	            int telefono = Integer.parseInt(rs.getString("Telefono"));
	            String nombreCompleto = rs.getString("NombreApellido");
	            String dni = rs.getString("DNI");
	            String clienteID = rs.getString("ClienteID");

	            Timestamp timestamp = rs.getTimestamp("FechaEmision");
	            LocalDateTime fecha = timestamp.toLocalDateTime();

	            Cliente cliente = new Cliente(clienteID, telefono, nombreCompleto, dni);
	            Pedido pedido = new Pedido(pedidoID, metodoPago, direccion, tipoPedido, cliente, fecha);

	            lista.add(pedido);
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}


	 public static List<MenuProducto> obtenerProductosMasVendidos() {
	        List<MenuProducto> lista = new ArrayList<>();

	        try (Connection conn = ConexionSQL.getConexion()) {
	            CallableStatement cs = conn.prepareCall("{CALL ProductosMasVendidos()}");
	            ResultSet rs = cs.executeQuery();

	            while (rs.next()) {
	                String nombre = rs.getString("Nombre");
	                String descripcion = rs.getString("Descripcion");
	                int totalVendido = rs.getInt("TotalVendido");
	                String productoID = rs.getString("ProductoID");

	                // Aquí usamos el nombre como descripción, y opcionalmente ponemos el total vendido como "precio"
	                MenuProducto producto = new MenuProducto(productoID, nombre, descripcion, totalVendido); 
	                lista.add(producto);
	            }

	            rs.close();
	            cs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return lista;
	}
	 
	public static double obtenerGananciasTotalesConCupones() {
	    double total = 0.0;

	    try (Connection conn = ConexionSQL.getConexion()) {
	        CallableStatement cs = conn.prepareCall("{CALL CalcularGananciasTotalesConCupones()}");

	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            total = rs.getDouble("total");
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return total;
	}

	public static int obtenerTotalPedidos() {
	    int total = 0;

	    try (Connection conn = ConexionSQL.getConexion()) {
	        CallableStatement cs = conn.prepareCall("{CALL CalcularTotalPedidos()}");

	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            total = rs.getInt("total");
	        }

	        rs.close();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return total;
	}
	
	public static void RegistrarPedidoConCuenta(Pedido pedido, Trabajador trabajador, Administrador admin, ClienteCuenta cuenta) {
	    int pedidoID = -1;

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL RegistrarPedidoConCuenta(?, ?, ?, ?, ?, ?, ?, ?)}");

	        // 1. ClienteID (de ClienteRegis)
	        cs.setInt(1, Integer.parseInt(cuenta.getCli().getClienteID()));

	        // 2. CuponID
	        if (pedido.getProm() != null) {
	            cs.setInt(2, pedido.getProm().getId());
	        } else {
	            cs.setNull(2, java.sql.Types.INTEGER);
	        }

	        // 3. Metodo de Pago
	        cs.setString(3, pedido.getMetodoPago().toLowerCase());

	        // 4. Tipo de Pedido
	        cs.setString(4, pedido.getTipo().toLowerCase());

	        // 5. Fecha del pedido
	        cs.setTimestamp(5, Timestamp.valueOf(pedido.getFecha()));

	        // 6. TrabajadorID
	        if (trabajador != null) {
	            cs.setInt(6, Integer.parseInt(trabajador.getTrabajorID()));
	        } else {
	            cs.setNull(6, java.sql.Types.INTEGER);
	        }

	        // 7. AdminID
	        if (admin != null) {
	            cs.setInt(7, Integer.parseInt(admin.getAdminID()));
	        } else {
	            cs.setNull(7, java.sql.Types.INTEGER);
	        }

	        // 8. Dirección si es delivery
	        if (pedido.getTipo().equalsIgnoreCase("delivery")) {
	            cs.setString(8, pedido.getDireccion());
	        } else {
	            cs.setNull(8, java.sql.Types.VARCHAR);
	        }

	        cs.execute();
	        cs.close();

	        // Obtener ID generado
	        PreparedStatement ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            pedidoID = rs.getInt(1);
	        }

	        rs.close();
	        ps.close();

	        // Registrar detalles del pedido
	        for (DetallePedido detalle : Pedido.getListaProductos()) {
	            RegistrarDetallePedido(detalle.getProducto().getIdProducto(), pedidoID, detalle.getCantidad());
	        }

	        System.out.println("✅ Pedido registrado con cuenta de cliente correctamente.");

	    } catch (Exception e) {
	        System.err.println("❌ Error al registrar pedido con cuenta: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	
	
	public static void RegistrarPedido(Pedido pedido, Trabajador trabajador, Administrador admin) {
		int pedidoID = -1;
        try {
            Connection conn = ConexionSQL.getConexion();

            CallableStatement cs = conn.prepareCall("{CALL RegistrarPedidoCompleto(?, ?, ?, ?, ?, ?, ?, ?,?,?)}");

            // 1. Cliente Datos
            cs.setString(1, String.valueOf(pedido.getCli().getTelefono()));
            cs.setString(2, pedido.getCli().getNombreCompleto());

            if (pedido.getCli().getDNI() != null && !pedido.getCli().getDNI().isEmpty()) {
                cs.setString(3, pedido.getCli().getDNI());
            } else {
                cs.setNull(3, java.sql.Types.VARCHAR);
            }

            // Cupon
            if (pedido.getProm() != null) {
                cs.setInt(4, pedido.getProm().getId());
            } else {
                cs.setNull(4, java.sql.Types.INTEGER);
            }

            cs.setString(5, pedido.getMetodoPago().toLowerCase());
            cs.setString(6, pedido.getTipo().toLowerCase());
            cs.setTimestamp(7, Timestamp.valueOf(pedido.getFecha()));

            // Trabajador o Admin
            if (trabajador != null) {
                cs.setInt(8, Integer.parseInt(trabajador.getTrabajorID()));
            } else {
                cs.setNull(8, java.sql.Types.INTEGER);
            }

            if (admin != null) {
                cs.setInt(9, Integer.parseInt(admin.getAdminID()));
            } else {
                cs.setNull(9, java.sql.Types.INTEGER);
            }

            if (pedido.getTipo().equalsIgnoreCase("delivery")) {
                cs.setString(10, pedido.getDireccion());
            } else {
                cs.setNull(10, java.sql.Types.VARCHAR);
            }

            cs.execute();
            cs.close();

            // Obtener PedidoID generado
            PreparedStatement ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedidoID = rs.getInt(1);
            }

            rs.close();
            ps.close();

            // Registrar detalles del pedido
            for (DetallePedido detalle : Pedido.getListaProductos()) {
                RegistrarDetallePedido(detalle.getProducto().getIdProducto(), pedidoID, detalle.getCantidad());
            }

            System.out.println("Pedido completo registrado correctamente.");

        } catch (Exception e) {
            System.err.println("Error al registrar el pedido: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
	
	
	public static void RegistrarDetallePedido(String productoID, int pedidoID, int cantidad) {
	    try (Connection conn = ConexionSQL.getConexion()) {
	        CallableStatement cs = conn.prepareCall("{CALL RegistrarDetallePedido(?, ?, ?)}");

	        cs.setString(1, productoID);
	        cs.setInt(2, pedidoID);
	        cs.setInt(3, cantidad);

	        cs.execute();
	        cs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static List<Pedido> listarPedidosBasico() {
	    List<Pedido> listaPedidos = new ArrayList<>();

	    try {
	        Connection conn = ConexionSQL.getConexion();
	        CallableStatement cs = conn.prepareCall("{CALL ListarPedidosBasico()}");
	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            int pedidoID = rs.getInt("PedidoID");
	            String nombreCliente = rs.getString("NombreCliente");
	            String dni = rs.getString("DNI");
	            LocalDateTime fecha = rs.getTimestamp("FechaEmision").toLocalDateTime();
	            // Cliente básico
	            Cliente cliente = new Cliente(null, 0, nombreCliente, dni); 

	            // Crear pedido
	            Pedido pedido = new Pedido(pedidoID, null, null, null, cliente,fecha);
	

	            listaPedidos.add(pedido);
	        }

	        rs.close();
	        cs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return listaPedidos;
	}
	
	public static Pedido obtenerDetallePedidoPorID(int pedidoID) {
	    Pedido pedido = null;

	    try (Connection conn = ConexionSQL.getConexion()) {

	        CallableStatement cs = conn.prepareCall("{CALL ObtenerDatosPedido(?)}");
	        cs.setInt(1, pedidoID);
	        ResultSet rs = cs.executeQuery();

	        if (rs.next()) {
	            // Obtener datos básicos
	            String nombreCliente = rs.getString("NombreCliente");
	            String tipoPedido = rs.getString("TipoPedido");
	            String metodoPago = rs.getString("MetodoPago");
	            String direccion = rs.getString("DireccionPedido");
	            LocalDateTime fecha = rs.getTimestamp("FechaEmision").toLocalDateTime();

	            // Cliente (básico)
	            Cliente cliente = new Cliente(null, 0, nombreCliente);

	            // Pedido con constructor extendido
	            pedido = new Pedido(pedidoID, metodoPago, direccion, tipoPedido, cliente,fecha);
	
	            // Monto con descuento incluido
	            pedido.setMonto(rs.getDouble("MontoTotalConDescuento"));

	            // Cupón si existe
	            int cuponId = rs.getInt("CuponID");
	            if (!rs.wasNull()) {
	                double valorCupon = rs.getDouble("ValorCupon");
	                String tipoCupon = rs.getString("TipoCupon");

	                Cupon cupon = new Cupon(cuponId, valorCupon, tipoCupon);
	                pedido.setProm(cupon);
	            }

	            // String trabajador = rs.getString("TrabajadorUsuario");
	            // String rol = rs.getString("RolTrabajador");
	        }

	        rs.close();
	        cs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return pedido;
	}
	
	 public static List<DetallePedido> obtenerProductosDelPedido(int pedidoID) {
	        List<DetallePedido> lista = new ArrayList<>();

	        try (Connection conn = ConexionSQL.getConexion()) {
	            CallableStatement cs = conn.prepareCall("{CALL ObtenerDetallesDePedido(?)}");
	            cs.setInt(1, pedidoID);

	            ResultSet rs = cs.executeQuery();

	            while (rs.next()) {
	                String descripcion= rs.getString("Descripcion");
	                String nombre = rs.getString("Nombre");
	                double precio = rs.getDouble("PrecioUnitario");
	                int cantidad = rs.getInt("Cantidad");

	                // Creamos el MenuProducto sin ID (no viene del SELECT)
	                MenuProducto mp = new MenuProducto(null, nombre, descripcion, precio);

	                // Creamos el DetallePedido
	                DetallePedido detalle = new DetallePedido(mp, cantidad);

	                lista.add(detalle);
	            }

	            rs.close();
	            cs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return lista;
	    }


}
