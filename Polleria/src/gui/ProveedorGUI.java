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

public class ProveedorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_7;
	private JButton btnEnviar;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_2_1_3;
	private JTextField textField_9;
	private JTextField textField_12;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2_1_2;
	private JTextField textField_5;
	private JComboBox comboBox;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JTable tbOrden;
	private JLabel lblNewLabel_5;
	private JButton btnAgregar;
	private JTextArea textArea;
	private JPanel panel_3;
	private JScrollPane scrollPane_2;
	private JTable tbOrdenHistorial;
	private JComboBox cbxOrdenH;
	private JTextField textField_6;
	private JButton btnActualizarOrden;
	private JButton btnVerDetalleOrden;
	private JLabel lblNewLabel_1;
	private JTextField textField_7;
	private JLabel lblNewLabel_6;

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
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setBounds(39, 2, 654, 50);
			contentPane.add(lblNewLabel);
		}
		{
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel.setBackground(new Color(255, 250, 250));
			panel.setBounds(22, 59, 389, 120);
			contentPane.add(panel);
			{
				lblNewLabel_1_1 = new JLabel("Nombre:");
				lblNewLabel_1_1.setBounds(205, 18, 108, 22);
				panel.add(lblNewLabel_1_1);
			}
			{
				lblNewLabel_2 = new JLabel("Dirección:");
				lblNewLabel_2.setBounds(24, 62, 108, 20);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_2_1 = new JLabel("Teléfono:");
				lblNewLabel_2_1.setBounds(205, 62, 138, 20);
				panel.add(lblNewLabel_2_1);
			}
			{
				lblNewLabel_2_1_1 = new JLabel("DNI:");
				lblNewLabel_2_1_1.setBounds(24, 22, 138, 14);
				panel.add(lblNewLabel_2_1_1);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setBounds(24, 42, 108, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(205, 42, 152, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setColumns(10);
				textField_3.setBounds(205, 85, 152, 20);
				panel.add(textField_3);
			}
			{
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setBounds(24, 85, 152, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Empresa Datos", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_1.setBackground(new Color(255, 250, 250));
			panel_1.setBounds(433, 59, 286, 120);
			contentPane.add(panel_1);
			{
				lblNewLabel_8 = new JLabel("Empresa Nombre");
				lblNewLabel_8.setBounds(24, 61, 108, 20);
				panel_1.add(lblNewLabel_8);
			}
			{
				lblNewLabel_2_1_3 = new JLabel("RUC:");
				lblNewLabel_2_1_3.setBounds(24, 21, 138, 14);
				panel_1.add(lblNewLabel_2_1_3);
			}
			{
				textField_9 = new JTextField();
				textField_9.setEditable(false);
				textField_9.setColumns(10);
				textField_9.setBounds(24, 41, 108, 20);
				panel_1.add(textField_9);
			}
			{
				textField_12 = new JTextField();
				textField_12.setEditable(false);
				textField_12.setColumns(10);
				textField_12.setBounds(24, 84, 152, 20);
				panel_1.add(textField_12);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_2.setBackground(new Color(255, 250, 250));
			panel_2.setBounds(22, 190, 689, 269);
			contentPane.add(panel_2);
			{
				lblNewLabel_3 = new JLabel("Cantidad");
				lblNewLabel_3.setBounds(22, 133, 108, 20);
				panel_2.add(lblNewLabel_3);
			}
			{
				lblNewLabel_2_1_2 = new JLabel("Provición");
				lblNewLabel_2_1_2.setBounds(22, 26, 138, 14);
				panel_2.add(lblNewLabel_2_1_2);
			}
			{
				textField_5 = new JTextField();
				textField_5.setEditable(false);
				textField_5.setColumns(10);
				textField_5.setBounds(22, 152, 75, 20);
				panel_2.add(textField_5);
			}
			{
				comboBox = new JComboBox();
				comboBox.setBounds(21, 50, 103, 20);
				panel_2.add(comboBox);
			}
			{
				lblNewLabel_4 = new JLabel("Precio / U");
				lblNewLabel_4.setBounds(22, 82, 108, 20);
				panel_2.add(lblNewLabel_4);
			}
			{
				textField_4 = new JTextField();
				textField_4.setEditable(false);
				textField_4.setColumns(10);
				textField_4.setBounds(22, 102, 75, 20);
				panel_2.add(textField_4);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(156, 52, 349, 159);
				panel_2.add(scrollPane);
				{
					tbOrden = new JTable();
					tbOrden.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"N\u00B0", "Producto", "Precio/u", "Cant", "SubTo."
						}
					));
					scrollPane.setViewportView(tbOrden);
					tbOrden.getColumnModel().getColumn(0).setPreferredWidth(10);
					tbOrden.getColumnModel().getColumn(1).setPreferredWidth(80);
					tbOrden.getColumnModel().getColumn(2).setPreferredWidth(60);
					tbOrden.getColumnModel().getColumn(3).setPreferredWidth(30);
					tbOrden.getColumnModel().getColumn(4).setPreferredWidth(60);
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
				btnAgregar.setBounds(22, 195, 89, 30);
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
			{
				textField_7 = new JTextField();
				textField_7.setBounds(397, 209, 108, 35);
				panel_2.add(textField_7);
				textField_7.setColumns(10);
			}
			{
				lblNewLabel_6 = new JLabel("Precio Total");
				lblNewLabel_6.setBounds(321, 215, 75, 25);
				panel_2.add(lblNewLabel_6);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"HISTORIAL DE ORDENES", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_3.setBackground(new Color(255, 250, 250));
			panel_3.setBounds(22, 473, 688, 240);
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
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(479, 95, 125, 20);
				panel_3.add(textField_6);
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
				lblNewLabel_1 = new JLabel("Elige una opcion para filtrar ");
				lblNewLabel_1.setBounds(475, 35, 164, 15);
				panel_3.add(lblNewLabel_1);
			}
		}
	}
}
