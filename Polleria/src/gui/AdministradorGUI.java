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

public class AdministradorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JButton btnAgregarInsumo;
	private JPanel panel_1;
	private JLabel lblReportes;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnListar;

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
		setBounds(100, 100, 800, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(386, 36, 342, 280);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Gestion de Inventario / Stock");
				lblNewLabel.setBounds(23, 11, 255, 24);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
			}
			{
				lblNewLabel_1 = new JLabel("Nombre del Insumo:");
				lblNewLabel_1.setBounds(33, 56, 100, 14);
				panel.add(lblNewLabel_1);
			}
			{
				lblNewLabel_2 = new JLabel("Cantidad:");
				lblNewLabel_2.setBounds(33, 107, 54, 14);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_3 = new JLabel("Tipo:");
				lblNewLabel_3.setBounds(179, 71, 33, 14);
				panel.add(lblNewLabel_3);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(33, 122, 107, 20);
				panel.add(textField_1);
			}
			{
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ingrediente", "Bebida", "Descartable"}));
				comboBox.setBounds(179, 86, 86, 22);
				panel.add(comboBox);
			}
			{
				btnAgregarInsumo = new JButton("Agregar Insumo");
				btnAgregarInsumo.setBounds(23, 166, 119, 35);
				panel.add(btnAgregarInsumo);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(33, 71, 107, 20);
				panel.add(textField);
			}
			{
				btnListar = new JButton("Listar Inventario");
				btnListar.setBounds(159, 166, 119, 35);
				panel.add(btnListar);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(38, 36, 287, 280);
			contentPane.add(panel_1);
			{
				lblReportes = new JLabel("Reportes / Consultas de Ventas");
				lblReportes.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
				lblReportes.setBounds(10, 11, 270, 24);
				panel_1.add(lblReportes);
			}
			{
				lblNewLabel_5 = new JLabel("Total de Ventas:");
				lblNewLabel_5.setBounds(66, 46, 100, 14);
				panel_1.add(lblNewLabel_5);
			}
			{
				lblNewLabel_6 = new JLabel("Producto mas Vendido:");
				lblNewLabel_6.setBounds(66, 91, 142, 14);
				panel_1.add(lblNewLabel_6);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(66, 60, 142, 20);
				panel_1.add(textField_2);
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(66, 106, 142, 20);
				panel_1.add(textField_3);
			}
			{
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(66, 164, 142, 20);
				panel_1.add(textField_4);
			}
			{
				lblNewLabel_4 = new JLabel("Total de Pedidos Realizados:");
				lblNewLabel_4.setBounds(66, 147, 142, 14);
				panel_1.add(lblNewLabel_4);
			}
			{
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(66, 212, 142, 20);
				panel_1.add(textField_5);
			}
			{
				lblNewLabel_7 = new JLabel("Ganancias:");
				lblNewLabel_7.setBounds(66, 195, 142, 14);
				panel_1.add(lblNewLabel_7);
			}
			{
				btnNewButton = new JButton("Visualizar");
				btnNewButton.setBounds(90, 243, 89, 33);
				panel_1.add(btnNewButton);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 330, 692, 184);
			contentPane.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"N\u00B0", "Venta ID", "cliente", "fecha"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
	}
}
