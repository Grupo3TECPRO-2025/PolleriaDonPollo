package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloPedido;
import Arraylist.ArregloPersona;
import CartaPolleria.MenuProducto;
import Gestiones.DetallePedido;
import Gestiones.Pedido;
import Gestiones.Usuario;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RegistrosGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblReportes;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNumPedidos;
	private JButton btnActualizar;
	private JScrollPane scrollPane;
	private JTable tbPedidoHistorial;
	private JButton btnListar;
	private JLabel lblAdministradorPolleria;
	private JPanel panel_2;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2_1;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JPanel panel_3;
	private JTextField txtGanancias;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_1;
	private JTextArea txtProductoModa;
	private JButton btnVerCarta;
	private JButton btnVerDetallePedido;
	private JTextField textField_2;
	private JComboBox cbxPedidoH;
	private JLabel lblNewLabel_4;
	private JPanel panel_4;
	private JLabel lblOrdenesHistorial;
	private JScrollPane scrollPane_2;
	private JTextField textField_3;
	private JComboBox cbxOrdenH;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable tbOrdenHistorial;
	private JButton btnAgregarPlato;
	private JButton btnActualizarPedido;
	private JButton btnVerDetalleOrden;
	private JButton btnActualizarOrden;
	private JButton btnAgregarMateriaPrima;
	private JButton btnVolver;
	private Usuario user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrosGUI frame = new RegistrosGUI(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrosGUI(Usuario user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 810, 938);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel.setBounds(68, 236, 631, 112);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Gestion de Inventario / Stock");
				lblNewLabel.setBounds(202, 11, 255, 24);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
			}
			{
				btnListar = new JButton("Listar Inventario");
				btnListar.addActionListener(this);
				btnListar.setBounds(42, 51, 143, 35);
				panel.add(btnListar);
			}
			{
				btnAgregarPlato = new JButton("Agregar Plato");
				btnAgregarPlato.addActionListener(this);
				btnAgregarPlato.setBounds(239, 51, 130, 35);
				panel.add(btnAgregarPlato);
			}
			{
				btnAgregarMateriaPrima = new JButton("Agregar Materia Prima");
				btnAgregarMateriaPrima.setBounds(414, 51, 174, 35);
				panel.add(btnAgregarMateriaPrima);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(36, 366, 710, 224);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			contentPane.add(panel_1);
			{
				lblReportes = new JLabel("PEDIDOS HISTORIAL");
				lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
				lblReportes.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
				lblReportes.setBounds(131, 11, 197, 24);
				panel_1.add(lblReportes);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(17, 52, 478, 148);
				panel_1.add(scrollPane);
				{
					tbPedidoHistorial = new JTable();
					tbPedidoHistorial.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"N\u00B0", "Venta ID", "cliente", "fecha"
						}
					));
					tbPedidoHistorial.getColumnModel().getColumn(0).setMaxWidth(40);
					tbPedidoHistorial.getColumnModel().getColumn(1).setPreferredWidth(20);
					tbPedidoHistorial.getColumnModel().getColumn(2).setPreferredWidth(120);
					tbPedidoHistorial.getColumnModel().getColumn(3).setPreferredWidth(120);
					scrollPane.setViewportView(tbPedidoHistorial);
				}
			}
			{
				btnVerDetallePedido = new JButton("Ver Detalle");
				btnVerDetallePedido.addActionListener(this);
				btnVerDetallePedido.setBounds(532, 169, 119, 27);
				panel_1.add(btnVerDetallePedido);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(531, 97, 125, 20);
				panel_1.add(textField_2);
			}
			{
				cbxPedidoH = new JComboBox();
				cbxPedidoH.setModel(new DefaultComboBoxModel(new String[] {"Cliente Nombre", "Fecha (mes)", "Fecha (Año)", "Fecha (dd-mm-yy)"}));
				cbxPedidoH.setBounds(530, 61, 125, 22);
				panel_1.add(cbxPedidoH);
			}
			{
				lblNewLabel_4 = new JLabel("Elige una opcion para filtrar ");
				lblNewLabel_4.setBounds(525, 29, 164, 15);
				panel_1.add(lblNewLabel_4);
			}
			{
				btnActualizarPedido = new JButton("Actualizar");
				btnActualizarPedido.addActionListener(this);
				btnActualizarPedido.setBounds(532, 129, 124, 27);
				panel_1.add(btnActualizarPedido);
			}
		}
		{
			lblAdministradorPolleria = new JLabel("REGISTROS - POLLERIA DON POLLO");
			lblAdministradorPolleria.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdministradorPolleria.setBounds(134, 22, 612, 50);
			contentPane.add(lblAdministradorPolleria);
			lblAdministradorPolleria.setForeground(Color.BLACK);
			lblAdministradorPolleria.setFont(new Font("Segoe UI Black", Font.PLAIN, 34));
			lblAdministradorPolleria.setBackground(Color.BLACK);
		}
		{
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_2.setBackground(new Color(255, 250, 250));
			panel_2.setBounds(34, 83, 211, 135);
			contentPane.add(panel_2);
			{
				lblNewLabel_1_1 = new JLabel("Usuario");
				lblNewLabel_1_1.setBounds(15, 28, 108, 22);
				panel_2.add(lblNewLabel_1_1);
			}
			{
				lblNewLabel_2_1 = new JLabel("Nombre");
				lblNewLabel_2_1.setBounds(15, 72, 138, 20);
				panel_2.add(lblNewLabel_2_1);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.setEditable(false);
				txtUsuario.setColumns(10);
				txtUsuario.setBounds(15, 52, 152, 20);
				panel_2.add(txtUsuario);
				txtUsuario.setText(user.getUser());
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setColumns(10);
				txtNombre.setBounds(15, 95, 152, 20);
				panel_2.add(txtNombre);
				txtNombre.setText(ArregloPersona.obtenerPersonaPorUsuario(user.getUser()).getNombreCompleto());
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Reportes / Consultas de Ventas", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel_3.setBackground(new Color(255, 250, 250));
			panel_3.setBounds(280, 85, 466, 134);
			contentPane.add(panel_3);
			{
				lblNewLabel_5 = new JLabel("Total de Pedidos");
				lblNewLabel_5.setBounds(17, 28, 100, 14);
				panel_3.add(lblNewLabel_5);
			}
			{
				txtNumPedidos = new JTextField();
				txtNumPedidos.setEditable(false);
				txtNumPedidos.setBounds(17, 46, 86, 20);
				panel_3.add(txtNumPedidos);
				txtNumPedidos.setText(""+ArregloPedido.obtenerTotalPedidos());
				txtNumPedidos.setColumns(10);
			}
			{
				lblNewLabel_6 = new JLabel("Producto mas Vendido:");
				lblNewLabel_6.setBounds(165, 24, 142, 17);
				panel_3.add(lblNewLabel_6);
			}
			{
				txtGanancias = new JTextField();
				txtGanancias.setEditable(false);
				txtGanancias.setColumns(10);
				txtGanancias.setBounds(17, 91, 86, 20);
				txtGanancias.setText("S/"+ArregloPedido.obtenerGananciasTotalesConCupones());
			
				panel_3.add(txtGanancias);
			}
			{
				lblNewLabel_8 = new JLabel("Ganancias");
				lblNewLabel_8.setBounds(18, 72, 100, 14);
				panel_3.add(lblNewLabel_8);
			}
			{
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(128, 48, 205, 63);
				panel_3.add(scrollPane_1);
				{
					txtProductoModa = new JTextArea();
					scrollPane_1.setViewportView(txtProductoModa);
				}
			}
			{
				btnActualizar = new JButton("Actualizar");
				btnActualizar.addActionListener(this);
				btnActualizar.setBounds(350, 29, 100, 33);
				panel_3.add(btnActualizar);
			}
			{
				btnVerCarta = new JButton("Ver Carta");
				btnVerCarta.setBounds(350, 79, 100, 33);
				panel_3.add(btnVerCarta);
			}
		}
		{
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel_4.setBounds(36, 606, 710, 270);
			contentPane.add(panel_4);
			{
				lblOrdenesHistorial = new JLabel("ORDENES HISTORIAL");
				lblOrdenesHistorial.setHorizontalAlignment(SwingConstants.CENTER);
				lblOrdenesHistorial.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
				lblOrdenesHistorial.setBounds(131, 11, 197, 24);
				panel_4.add(lblOrdenesHistorial);
			}
			{
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(17, 52, 478, 148);
				panel_4.add(scrollPane_2);
				{
					tbOrdenHistorial = new JTable();
					tbOrdenHistorial.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"N\u00B0", "Nombre Empresa", "Fecha", "Precio"
						}
					));
					tbOrdenHistorial.getColumnModel().getColumn(0).setMaxWidth(40);
					tbOrdenHistorial.getColumnModel().getColumn(1).setPreferredWidth(120);
					tbOrdenHistorial.getColumnModel().getColumn(2).setPreferredWidth(120);
					tbOrdenHistorial.getColumnModel().getColumn(3).setPreferredWidth(40);
					scrollPane_2.setViewportView(tbOrdenHistorial);
				}
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(530, 102, 125, 20);
				panel_4.add(textField_3);
			}
			{
				cbxOrdenH = new JComboBox();
				cbxOrdenH.setModel(new DefaultComboBoxModel(new String[] {"Empresa Nombre", "RUC", "fecha (mes)", "fecha (año)", "fecha (dd-mm/yy)"}));
				cbxOrdenH.setBounds(529, 68, 125, 22);
				panel_4.add(cbxOrdenH);
			}
			{
				lblNewLabel_7 = new JLabel("Elige una opcion para filtrar ");
				lblNewLabel_7.setBounds(525, 29, 164, 15);
				panel_4.add(lblNewLabel_7);
			}
			{
				btnNewButton = new JButton("Confirmar Entrega");
				btnNewButton.setBounds(49, 212, 152, 30);
				panel_4.add(btnNewButton);
			}
			{
				btnNewButton_1 = new JButton("Rechazar Entrega");
				btnNewButton_1.setBounds(311, 215, 152, 30);
				panel_4.add(btnNewButton_1);
			}
			{
				btnVerDetalleOrden = new JButton("Ver Detalle");
				btnVerDetalleOrden.setBounds(530, 173, 119, 27);
				panel_4.add(btnVerDetalleOrden);
			}
			{
				btnActualizarOrden = new JButton("Actualizar");
				btnActualizarOrden.setBounds(530, 133, 125, 27);
				panel_4.add(btnActualizarOrden);
			}
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(36, 27, 101, 38);
			contentPane.add(btnVolver);
		}
		List<Pedido> listaPedidos = ArregloPedido.listarPedidosBasico();
		listarHistorialPedidos(listaPedidos);
		actualizarProductosMasVendidosEnLista();
		txtGanancias.setText("S/."+ArregloPedido.obtenerGananciasTotalesConCupones());
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregarPlato) {
			do_btnAgregarPlato_actionPerformed(e);
		}
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnVerDetallePedido) {
			do_btnVerDetallePedido_actionPerformed(e);
		}
		if (e.getSource() == btnActualizarPedido) {
			do_btnActualizarPedido_actionPerformed(e);
		}
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		this.dispose();
		AdministradorGUI volver = new AdministradorGUI(user);
		volver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volver.setVisible(true);
	}
	
	public void listarHistorialPedidos(List<Pedido> listaPedidos) {
	    DefaultTableModel modelo = (DefaultTableModel) tbPedidoHistorial.getModel();
	    modelo.setRowCount(0); // Limpiar la tabla antes de llenar

	    int nro = 1;
	    for (Pedido p : listaPedidos) {
	        modelo.addRow(new Object[]{
	            nro++, // Número correlativo
	            p.getPedidoId(),
	            p.getCli().getNombreCompleto(),
	            p.getFecha() // Este debe ser java.sql.Date
	        });
	    }
	}
	protected void do_btnActualizarPedido_actionPerformed(ActionEvent e) {
		List<Pedido> listaPedidos = ArregloPedido.listarPedidosBasico();
		listarHistorialPedidos(listaPedidos);
		txtGanancias.setText("S/"+ArregloPedido.obtenerGananciasTotalesConCupones());
		txtNumPedidos.setText(""+ArregloPedido.obtenerTotalPedidos());
	}
	protected void do_btnVerDetallePedido_actionPerformed(ActionEvent e) {
		int filaSeleccionada = tbPedidoHistorial.getSelectedRow();
	    
		if (filaSeleccionada != -1) {
	        int pedidoID = (int) tbPedidoHistorial.getValueAt(filaSeleccionada, 1);

	        // Abrir la ventana con solo el ID
	        PedidoDetalleGUI ventana = new PedidoDetalleGUI(pedidoID);
	        ventana.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona un pedido de la tabla.");
	    }
	}
	
	private void actualizarProductosMasVendidosEnLista() {
		List<MenuProducto> productosMasVendidos = ArregloPedido.obtenerProductosMasVendidos(); 

	    StringBuilder sb = new StringBuilder();
	    int index = 1;
	    for (MenuProducto producto : productosMasVendidos) {
	        sb.append(index++)
	          .append(". ")
	          .append(producto.getDescripcion()) 
	          .append("\n");
	    }
	    
	    txtProductoModa.setText(sb.toString());
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		ListarInventarioGUI listar = new ListarInventarioGUI();
		listar.setVisible(true);
	}
	protected void do_btnAgregarPlato_actionPerformed(ActionEvent e) {
	}
}
