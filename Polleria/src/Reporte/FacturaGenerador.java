package Reporte;

import java.io.File;
import java.io.IOException;
import java.io.PipedOutputStream;
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
            writer.println("Tipo de Pedido: "+pedido.getTipo());
            if(pedido.getCli().getDNI()!=null) writer.println("DNI: " + pedido.getCli().getDNI());

            writer.println();
            writer.println("DETALLES DEL PEDIDO:");
            writer.println("----------------------------------");
            writer.printf("%-3s\t|%-24s\t|%-5s\t|%-7s|%-8s\n", "N", "Producto", "Cant", "Precio", "Subtotal");

            int i = 1;

            for (DetallePedido det : pedido.getListaProductos()) {
                String descripcion = det.getProducto().getDescripcion();
                int cantidad = det.getCantidad();
                double precio = det.getProducto().getPrecioUnitario();
                double subtotal = cantidad * precio;

                // Ajuste de descripción
                int maxLong = 24;  // longitud máxima por línea
                String[] partes = dividirTexto(descripcion, maxLong);

                // Imprimir la primera línea con todos los datos
                writer.printf("\n%d\t|%-24s\t|%d\t|%.2f\t|%.2f",
                    i++, partes[0], cantidad, precio, subtotal
                );

                // Imprimir líneas restantes de la descripción
                for (int j = 1; j < partes.length; j++) {
                    writer.printf("\n\t|%-24s\t|\t|\t|", partes[j]);
                }
                

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
	private static String[] dividirTexto(String texto, int maxLong) {
	    return texto.split("(?<=\\G.{" + maxLong + "})");  // divide cada maxLong caracteres
	}
    private static void crearCarpetaReportes() {
        File carpeta = new File("facturas-polleria");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }
}
