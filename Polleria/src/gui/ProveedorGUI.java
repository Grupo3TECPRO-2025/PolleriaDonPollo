package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProveedorGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_7;
	private JButton btnEnviar;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_2_1_3;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2_1_2;
	private JTextField txtCant;
	private JComboBox cbxMateriaPrima;
	private JTable tbOrden;
	private JLabel lblNewLabel_5;
	private JButton btnAgregar;
	private JTextArea textArea;
	private JPanel panel_3;
	private JScrollPane scrollPane_2;
	private JTable tbOrdenHistorial;
	private JComboBox cbxOrdenH;
	private JTextField txtFiltrar;
	private JButton btnActualizarOrden;
	private JButton btnVerDetalleOrden;
	private JLabel lblNewLabel_1;
	private JTextField txtBuscar;
	private JComboBox cbxBuscar;
	private JPanel panel;
	private JLabel lblNewLabel_2_1;
	private JTextField txtRUC;
	private JTextField txtEmpresa;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JLabel lblNewLabel_6;
	private JTextField txtDireccion;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProveedorGUI frame = new ProveedorGUI();
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
	public ProveedorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("PROVEEDOR - POLLERIA DON POLLO");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 31));
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setBounds(121, 7, 590, 50);
			contentPane.add(lblNewLabel);
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Buscar Empresa", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_1.setBackground(new Color(255, 250, 250));
			panel_1.setBounds(22, 68, 264, 120);
			contentPane.add(panel_1);
			{
				lblNewLabel_2_1_3 = new JLabel("Ingresar empresa nombre:");
				lblNewLabel_2_1_3.setBounds(24, 21, 187, 14);
				panel_1.add(lblNewLabel_2_1_3);
			}
			{
				txtBuscar = new JTextField();
				txtBuscar.setBounds(24, 46, 187, 20);
				panel_1.add(txtBuscar);
				txtBuscar.setColumns(10);
			}
			{
				cbxBuscar = new JComboBox();
				cbxBuscar.setBounds(24, 77, 187, 22);
				panel_1.add(cbxBuscar);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_2.setBackground(new Color(255, 250, 250));
			panel_2.setBounds(22, 199, 689, 269);
			contentPane.add(panel_2);
			{
				lblNewLabel_3 = new JLabel("Cantidad");
				lblNewLabel_3.setBounds(22, 93, 108, 20);
				panel_2.add(lblNewLabel_3);
			}
			{
				lblNewLabel_2_1_2 = new JLabel("Provición");
				lblNewLabel_2_1_2.setBounds(22, 26, 138, 14);
				panel_2.add(lblNewLabel_2_1_2);
			}
			{
				txtCant = new JTextField();
				txtCant.setEditable(false);
				txtCant.setColumns(10);
				txtCant.setBounds(22, 112, 75, 20);
				panel_2.add(txtCant);
			}
			{
				cbxMateriaPrima = new JComboBox();
				cbxMateriaPrima.setBounds(21, 50, 103, 20);
				panel_2.add(cbxMateriaPrima);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(156, 52, 349, 192);
				panel_2.add(scrollPane);
				{
					tbOrden = new JTable();
					tbOrden.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"N\u00B0", "Producto", "Cantidad"
						}
					));
					tbOrden.getColumnModel().getColumn(0).setPreferredWidth(15);
					tbOrden.getColumnModel().getColumn(1).setPreferredWidth(80);
					scrollPane.setViewportView(tbOrden);
				}
			}
			{
				lblNewLabel_5 = new JLabel("DETALLES DE PROVICIÓN");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
				lblNewLabel_5.setBounds(195, 19, 255, 24);
				panel_2.add(lblNewLabel_5);
			}
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(this);
				btnAgregar.setBounds(22, 157, 89, 30);
				panel_2.add(btnAgregar);
			}
			{
				lblNewLabel_7 = new JLabel("Observaciones:");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_7.setBounds(526, 25, 103, 14);
				panel_2.add(lblNewLabel_7);
			}
			{
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(526, 50, 128, 137);
				panel_2.add(scrollPane_1);
				{
					textArea = new JTextArea();
					scrollPane_1.setViewportView(textArea);
				}
			}
			{
				btnEnviar = new JButton("Enviar");
				btnEnviar.setBounds(533, 209, 108, 35);
				panel_2.add(btnEnviar);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"HISTORIAL DE ORDENES", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_3.setBackground(new Color(255, 250, 250));
			panel_3.setBounds(22, 479, 688, 240);
			contentPane.add(panel_3);
			{
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(38, 36, 392, 176);
				panel_3.add(scrollPane_2);
				{
					tbOrdenHistorial = new JTable();
					scrollPane_2.setViewportView(tbOrdenHistorial);
					tbOrdenHistorial.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"N\u00B0", "OrdenID", "Fecha", "Precio"
							}
						));
					tbOrdenHistorial.getColumnModel().getColumn(0).setMaxWidth(40);
					tbOrdenHistorial.getColumnModel().getColumn(1).setPreferredWidth(120);
					tbOrdenHistorial.getColumnModel().getColumn(2).setPreferredWidth(120);
					tbOrdenHistorial.getColumnModel().getColumn(3).setPreferredWidth(70);
				}
			}
			{
				cbxOrdenH = new JComboBox();
				cbxOrdenH.setModel(new DefaultComboBoxModel(new String[] {"OrdenID", "fecha (mes)", "fecha (año)", "fecha (dd-mm-yy)"}));
				cbxOrdenH.setBounds(478, 61, 125, 22);
				panel_3.add(cbxOrdenH);
			}
			{
				txtFiltrar = new JTextField();
				txtFiltrar.setColumns(10);
				txtFiltrar.setBounds(479, 95, 125, 20);
				panel_3.add(txtFiltrar);
			}
			{
				btnActualizarOrden = new JButton("Actualizar Datos");
				btnActualizarOrden.setBounds(479, 126, 119, 27);
				panel_3.add(btnActualizarOrden);
			}
			{
				btnVerDetalleOrden = new JButton("Ver Detalle");
				btnVerDetalleOrden.setBounds(479, 166, 119, 27);
				panel_3.add(btnVerDetalleOrden);
			}
			{
				lblNewLabel_1 = new JLabel("Elige una opción para filtrar ");
				lblNewLabel_1.setBounds(475, 35, 164, 15);
				panel_3.add(lblNewLabel_1);
			}
		}
		{
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Empresa", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel.setBackground(new Color(255, 250, 250));
			panel.setBounds(304, 68, 407, 120);
			contentPane.add(panel);
			{
				lblNewLabel_2_1 = new JLabel("RUC:");
				lblNewLabel_2_1.setBounds(24, 21, 114, 14);
				panel.add(lblNewLabel_2_1);
			}
			{
				txtRUC = new JTextField();
				txtRUC.setColumns(10);
				txtRUC.setBounds(23, 40, 128, 20);
				panel.add(txtRUC);
			}
			{
				txtEmpresa = new JTextField();
				txtEmpresa.setColumns(10);
				txtEmpresa.setBounds(23, 87, 128, 20);
				panel.add(txtEmpresa);
			}
			{
				lblNewLabel_2 = new JLabel("Nombre Empresa");
				lblNewLabel_2.setBounds(23, 68, 115, 14);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_4 = new JLabel("Teléfono");
				lblNewLabel_4.setBounds(176, 21, 115, 14);
				panel.add(lblNewLabel_4);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(176, 40, 128, 20);
				panel.add(textField_2);
			}
			{
				lblNewLabel_6 = new JLabel("Dirección");
				lblNewLabel_6.setBounds(176, 68, 115, 14);
				panel.add(lblNewLabel_6);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(176, 87, 128, 20);
				panel.add(txtDireccion);
			}
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(22, 11, 103, 38);
			contentPane.add(btnVolver);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		this.dispose();
		AdministradorGUI volver = new AdministradorGUI(null);
		volver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volver.setVisible(true);
	}
}
