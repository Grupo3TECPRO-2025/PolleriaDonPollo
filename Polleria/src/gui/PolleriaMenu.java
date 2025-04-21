package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PolleriaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolleriaMenu frame = new PolleriaMenu();
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
	public PolleriaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POLLERIA DON POLLO");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
		lblNewLabel.setBounds(73, 11, 435, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 72, 318, 220);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Pedido", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION) );
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Elige el combo/pedido (ID)");
		lblNewLabel_1.setBounds(15, 27, 152, 20);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(15, 51, 167, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Elige la cantidad");
		lblNewLabel_2.setBounds(15, 87, 138, 25);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(15, 112, 167, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(15, 173, 167, 25);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Elimina N° pedido");
		lblNewLabel_2_1.setBounds(15, 148, 138, 25);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Agregar");

		btnNewButton.setBounds(199, 40, 95, 36);
		panel.add(btnNewButton);
		
		JButton btnVerCarta = new JButton("Ver Carta");
		btnVerCarta.setBounds(199, 100, 95, 36);
		panel.add(btnVerCarta);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(199, 162, 95, 36);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		panel_1.setBounds(350, 72, 200, 220);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres y Apellidos");
		lblNewLabel_1_1.setBounds(15, 27, 152, 20);
		panel_1.add(lblNewLabel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(15, 51, 167, 25);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Direccion");
		lblNewLabel_2_2.setBounds(15, 87, 138, 25);
		panel_1.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(15, 112, 167, 25);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(15, 173, 167, 25);
		panel_1.add(textField_5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DNI:");
		lblNewLabel_2_1_1.setBounds(15, 148, 138, 25);
		panel_1.add(lblNewLabel_2_1_1);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 307, 523, 188);
			contentPane.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"N\u00B0", "Detalle", "Cantidad", "Precio Unitario", "Costo"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, Integer.class, Double.class, Double.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(1).setPreferredWidth(150);
				table.getColumnModel().getColumn(2).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(4).setPreferredWidth(70);

				scrollPane.setViewportView(table);
			}
		}
		
		textField_6 = new JTextField();
		textField_6.setBounds(418, 495, 129, 29);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Costo Total");
		lblNewLabel_3.setBounds(342, 499, 68, 21);
		contentPane.add(lblNewLabel_3);
	}
}
