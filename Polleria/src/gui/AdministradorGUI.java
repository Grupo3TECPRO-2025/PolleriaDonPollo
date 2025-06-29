package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AdministradorGUI extends JFrame {

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
	private JTextField textField_6;
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
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	private JButton btnListar_1;
	private JButton btnAgregarPlato_1;
	private JButton btnActualizarPedido;
	private JButton btnVerDetalleOrden;
	private JButton btnActualizarOrden;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministradorGUI frame = new AdministradorGUI();
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
	public AdministradorGUI() {
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
			panel.setBounds(36, 237, 349, 112);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Gestion de Inventario / Stock");
				lblNewLabel.setBounds(44, 11, 255, 24);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
			}
			{
				btnListar = new JButton("Listar Inventario");
				btnListar.setBounds(42, 51, 119, 35);
				panel.add(btnListar);
			}
			{
				btnAgregarPlato = new JButton("Agregar Plato");
				btnAgregarPlato.setBounds(190, 52, 119, 35);
				panel.add(btnAgregarPlato);
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
				btnActualizarPedido = new JButton("Actualizar Datos");
				btnActualizarPedido.setBounds(532, 129, 119, 27);
				panel_1.add(btnActualizarPedido);
			}
		}
		{
			lblAdministradorPolleria = new JLabel("ADMINISTRADOR - POLLERIA DON POLLO");
			lblAdministradorPolleria.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdministradorPolleria.setBounds(15, 21, 753, 50);
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
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setColumns(10);
				txtNombre.setBounds(15, 95, 152, 20);
				panel_2.add(txtNombre);
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
				txtNumPedidos.setBounds(17, 46, 142, 20);
				panel_3.add(txtNumPedidos);
				txtNumPedidos.setColumns(10);
			}
			{
				lblNewLabel_6 = new JLabel("Producto mas Vendido:");
				lblNewLabel_6.setBounds(188, 27, 142, 14);
				panel_3.add(lblNewLabel_6);
			}
			{
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(17, 91, 142, 20);
				panel_3.add(textField_6);
			}
			{
				lblNewLabel_8 = new JLabel("Ganancias");
				lblNewLabel_8.setBounds(18, 72, 100, 14);
				panel_3.add(lblNewLabel_8);
			}
			{
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(188, 48, 107, 63);
				panel_3.add(scrollPane_1);
				{
					txtProductoModa = new JTextArea();
					scrollPane_1.setViewportView(txtProductoModa);
				}
			}
			{
				btnActualizar = new JButton("Actualizar");
				btnActualizar.setBounds(328, 28, 89, 33);
				panel_3.add(btnActualizar);
			}
			{
				btnVerCarta = new JButton("Ver Carta");
				btnVerCarta.setBounds(328, 78, 89, 33);
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
				btnActualizarOrden = new JButton("Actualizar Datos");
				btnActualizarOrden.setBounds(530, 133, 119, 27);
				panel_4.add(btnActualizarOrden);
			}
		}
		{
			panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel_5.setLayout(null);
			panel_5.setBounds(420, 237, 325, 112);
			contentPane.add(panel_5);
			{
				lblNewLabel_1 = new JLabel("Gestion de Inventario / Stock");
				lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
				lblNewLabel_1.setBounds(31, 13, 255, 24);
				panel_5.add(lblNewLabel_1);
			}
			{
				btnListar_1 = new JButton("Listar Inventario");
				btnListar_1.setBounds(29, 51, 119, 35);
				panel_5.add(btnListar_1);
			}
			{
				btnAgregarPlato_1 = new JButton("Agregar Plato");
				btnAgregarPlato_1.setBounds(177, 52, 119, 35);
				panel_5.add(btnAgregarPlato_1);
			}
		}
	}
}
