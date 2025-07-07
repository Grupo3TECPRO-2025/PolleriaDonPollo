package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloAdministrador;
import Arraylist.ArregloPedido;
import Arraylist.ArregloTrabajador;
import Arraylist.ArregloUsuario;
import DatosPersonales.Administrador;
import DatosPersonales.Trabajador;
import Gestiones.DetallePedido;
import Gestiones.Pedido;
import Gestiones.Usuario;
import java.awt.Color;

public class PedidoDetalleGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField txtPedidoID;
	private JTextField txtClienteNombre;
	private JTextField txtTipo;
	private JTextField txtMonto;
	private JTextField txtTrabajador;
	private JTextField txtFecha;
	private JTextField txtMetodo;
	private JTextField txtCupon;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_10;
	private JTextField txtValorCupon;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_11;
	private JTextField txtRol;
	private int pedidoID;
	private JTextField txtCosto;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblProductosComprados;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PedidoDetalleGUI dialog = new PedidoDetalleGUI(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PedidoDetalleGUI(int pedidoID) {
		this.pedidoID = pedidoID;
		setBounds(100, 100, 895, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 64, 64));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("DETALLE PEDIDO");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
			lblNewLabel.setBounds(94, 26, 297, 32);
			contentPanel.add(lblNewLabel);
		}
		{
			panel = new JPanel();
			panel.setBackground(new Color(255, 243, 240));
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel.setBounds(29, 80, 387, 302);
			contentPanel.add(panel);
			{
				lblNewLabel_1 = new JLabel("Cliente Nombre:");
				lblNewLabel_1.setBounds(10, 52, 108, 21);
				panel.add(lblNewLabel_1);
			}
			{
				lblNewLabel_2 = new JLabel("PedidoID");
				lblNewLabel_2.setBounds(10, 20, 108, 21);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_3 = new JLabel("Tipo de Pedido: ");
				lblNewLabel_3.setBounds(10, 89, 108, 21);
				panel.add(lblNewLabel_3);
			}
			{
				lblNewLabel_4 = new JLabel("Monto:");
				lblNewLabel_4.setBounds(10, 121, 108, 21);
				panel.add(lblNewLabel_4);
			}
			{
				lblNewLabel_5 = new JLabel("Trabajador:");
				lblNewLabel_5.setBounds(10, 152, 108, 21);
				panel.add(lblNewLabel_5);
			}
			{
				lblNewLabel_6 = new JLabel("Fecha:");
				lblNewLabel_6.setBounds(10, 187, 108, 21);
				panel.add(lblNewLabel_6);
			}
			{
				lblNewLabel_7 = new JLabel("Método de Pago: ");
				lblNewLabel_7.setBounds(10, 223, 108, 21);
				panel.add(lblNewLabel_7);
			}
			{
				lblNewLabel_8 = new JLabel("Dirección:");
				lblNewLabel_8.setBounds(204, 89, 108, 21);
				panel.add(lblNewLabel_8);
			}
			{
				lblNewLabel_9 = new JLabel("Cupón:");
				lblNewLabel_9.setBounds(10, 255, 108, 21);
				panel.add(lblNewLabel_9);
			}
			{
				txtPedidoID = new JTextField();
				txtPedidoID.setBounds(108, 20, 86, 20);
				panel.add(txtPedidoID);
				txtPedidoID.setColumns(10);
			}
			{
				txtClienteNombre = new JTextField();
				txtClienteNombre.setColumns(10);
				txtClienteNombre.setBounds(108, 52, 86, 20);
				panel.add(txtClienteNombre);
			}
			{
				txtTipo = new JTextField();
				txtTipo.setColumns(10);
				txtTipo.setBounds(108, 89, 86, 20);
				panel.add(txtTipo);
			}
			{
				txtMonto = new JTextField();
				txtMonto.setColumns(10);
				txtMonto.setBounds(108, 121, 86, 20);
				panel.add(txtMonto);
			}
			{
				txtTrabajador = new JTextField();
				txtTrabajador.setColumns(10);
				txtTrabajador.setBounds(108, 152, 86, 20);
				panel.add(txtTrabajador);
			}
			{
				txtFecha = new JTextField();
				txtFecha.setColumns(10);
				txtFecha.setBounds(108, 187, 86, 20);
				panel.add(txtFecha);
			}
			{
				txtMetodo = new JTextField();
				txtMetodo.setColumns(10);
				txtMetodo.setBounds(108, 223, 86, 20);
				panel.add(txtMetodo);
			}
			{
				txtCupon = new JTextField();
				txtCupon.setColumns(10);
				txtCupon.setBounds(108, 255, 86, 20);
				panel.add(txtCupon);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(264, 89, 113, 20);
				panel.add(txtDireccion);
			}
			{
				lblNewLabel_10 = new JLabel("Valor:");
				lblNewLabel_10.setBounds(204, 255, 108, 21);
				panel.add(lblNewLabel_10);
			}
			{
				txtValorCupon = new JTextField();
				txtValorCupon.setColumns(10);
				txtValorCupon.setBounds(264, 255, 113, 20);
				panel.add(txtValorCupon);
			}
			{
				lblNewLabel_11 = new JLabel("Rol:");
				lblNewLabel_11.setBounds(204, 155, 108, 21);
				panel.add(lblNewLabel_11);
			}
			{
				txtRol = new JTextField();
				txtRol.setColumns(10);
				txtRol.setBounds(264, 152, 113, 20);
				panel.add(txtRol);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 243, 240));
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel_1.setBounds(426, 80, 436, 302);
			contentPanel.add(panel_1);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(27, 30, 386, 205);
				panel_1.add(scrollPane);
				{
					table = new JTable();
					table.setFillsViewportHeight(true);
					table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"N\u00B0", "Producto", "Precio", "Cantidad", "Costo"
						}
					));
					table.getColumnModel().getColumn(0).setPreferredWidth(30);
					table.getColumnModel().getColumn(1).setPreferredWidth(144);
					table.getColumnModel().getColumn(2).setPreferredWidth(59);
					table.getColumnModel().getColumn(3).setPreferredWidth(61);
					table.getColumnModel().getColumn(4).setPreferredWidth(54);
					scrollPane.setViewportView(table);
				}
			}
			{
				txtCosto = new JTextField();
				txtCosto.setEditable(false);
				txtCosto.setColumns(10);
				txtCosto.setBounds(300, 241, 113, 20);
				panel_1.add(txtCosto);
			}
			{
				lblNewLabel_12 = new JLabel("Total:");
				lblNewLabel_12.setBounds(239, 241, 58, 21);
				panel_1.add(lblNewLabel_12);
			}
		}
		{
			lblNewLabel_13 = new JLabel("");
			lblNewLabel_13.setBounds(29, 11, 63, 58);
			contentPanel.add(lblNewLabel_13);
			lblNewLabel_13.setIcon(new ImageIcon(new ImageIcon(ClienteGUI.class.getResource
					("/img/DonPollo.jpg")).getImage().getScaledInstance(70, 62, Image.SCALE_FAST)));
		}
		{
			lblProductosComprados = new JLabel("PRODUCTOS COMPRADOS");
			lblProductosComprados.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductosComprados.setForeground(Color.WHITE);
			lblProductosComprados.setFont(new Font("Tahoma", Font.BOLD, 28));
			lblProductosComprados.setBackground(Color.WHITE);
			lblProductosComprados.setBounds(445, 26, 387, 32);
			contentPanel.add(lblProductosComprados);
		}
		Pedido pedido = ArregloPedido.obtenerDetallePedidoPorID(pedidoID);
	    List<DetallePedido> detalles = ArregloPedido.obtenerProductosDelPedido(pedidoID);

	    llenarCamposPedido(pedido);
	    llenarTablaDetalles(detalles);
	    
	    Usuario usuario = ArregloUsuario.obtenerUsuarioTrabajadorPorPedido(pedido.getPedidoId());

	    if (usuario == null) {
	        // Si no es trabajador, intentamos con administrador
	        usuario = ArregloUsuario.obtenerUsuarioAdministradorPorPedido(pedido.getPedidoId());
	    }

	    // Mostrar usuario y rol si se encontró
	    if (usuario != null) {
	        if(usuario.getRol().equals("trabajador")) {
	        	Trabajador trabajador = ArregloTrabajador.obtenerTrabajador(usuario.getUser());
	        	txtTrabajador.setText(trabajador.getNombreCompleto());
	        }
	        else {
	        	Administrador administrador = ArregloAdministrador.obtenerAdministrador(usuario.getUser());
	        	txtTrabajador.setText(administrador.getNombreCompleto());
	        }
	        txtRol.setText(usuario.getRol());
	    }
	}
	
	
	private void llenarCamposPedido(Pedido pedido) {
	    txtPedidoID.setText(String.valueOf(pedido.getPedidoId()));
	    txtClienteNombre.setText(pedido.getCli().getNombreCompleto());
	    txtTipo.setText(pedido.getTipo());
	    txtMetodo.setText(pedido.getMetodoPago());
	    txtFecha.setText(pedido.getFecha().toString());
	    txtDireccion.setText(pedido.getDireccion());
	    txtMonto.setText(String.format("%.2f", pedido.getMonto()));

	    if (pedido.getProm() != null) {
	        txtCupon.setText(pedido.getProm().getTipo());
	        txtValorCupon.setText(String.valueOf(pedido.getProm().getDescuento()));
	    } else {
	        txtCupon.setText("Sin cupón");
	        txtValorCupon.setText("-");
	    }
	}
	
	private void llenarTablaDetalles(List<DetallePedido> detalles) {
	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0); // Limpiar tabla

	    double total = 0;
	    int nro = 1;
	    for (DetallePedido dp : detalles) {
	        modelo.addRow(new Object[]{
	            nro++,
	            dp.getProducto().getDescripcion(),
	            dp.getProducto().getPrecioUnitario(),
	            dp.getCantidad(),
	            dp.Costo()
	        });
	        total += dp.getCantidad()*dp.getProducto().getPrecioUnitario();
	    }
	    txtCosto.setText("S/."+total);
	}
	
	void totalCosto(ArrayList<DetallePedido> dt) {
	
		
	}
}
