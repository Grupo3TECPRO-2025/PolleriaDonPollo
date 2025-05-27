package Reporte;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Gestiones.DetallePedido;
import Gestiones.Pedido;

public class FacturaGenerador {
	
	public static void generarFactura(Pedido pedido) {
        crearCarpetaReportes();

        String nombreArchivo = "Pedido_" + pedido.getPedidoId() + ".txt";
        File archivo = new File("facturas-polleria", nombreArchivo);

        try (PrintWriter writer = new PrintWriter(archivo)) {
            writer.println("------ FACTURA DON POLLO ------");
            writer.println("Número de Pedido: " + pedido.getPedidoId());
            writer.println("Cliente: " + pedido.getCli().getNombreCompleto());
            writer.println("Dirección: " + pedido.getCli().getDireccion());
            writer.println("Teléfono: " + pedido.getCli().getTelefono());
            if(pedido.getCli().getDNI()!=null) writer.println("DNI: " + pedido.getCli().getDNI());

            writer.println();
            writer.println("DETALLES DEL PEDIDO:");
            writer.println("----------------------------------");
            writer.printf("N\tProducto\t\t\t\tCant\tPrecio\tSubtotal");

            int i = 1;

            for (DetallePedido det : pedido.getListaProductos()) {
                String nombre = det.getProducto().getDescripcion();
                int cantidad = det.getCantidad();
                double precio = det.getProducto().getPrecioUnitario();
                double subtotal = cantidad * precio;
                writer.printf("\n" + (i++) + "\t"+ det.getProducto().getDescripcion() + "\t"
                		+ det.getCantidad() + "\t"
                		+ det.getProducto().getPrecioUnitario()+ "\t"
                		+ det.Costo());
                
            }
            
            if(pedido.getProm()!=null) {
            	if(pedido.getProm().getTipo().equals("fijo")) writer.println("\n\nCupon aplicado -> "+pedido.getProm().getDescuento());
            	else writer.println("\n\nCupon aplicado -> %"+pedido.getProm().getDescuento());


            }
            
            writer.println("\n----------------------------------");
            writer.println("TOTAL: S/. "+ pedido.getMonto());
            writer.println("¡Gracias por su compra!");
            writer.println("----------------------------------");

            JOptionPane.showMessageDialog(null, "Factura generada correctamente en la carpeta 'reportes'");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar la factura: " + e.getMessage());
        }
    }

    private static void crearCarpetaReportes() {
        File carpeta = new File("facturas-polleria");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }
}
