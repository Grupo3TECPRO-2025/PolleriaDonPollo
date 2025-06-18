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
	private JButton btnEnviarDatos;
	private JLabel lblNewLabel_2_1_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_3;
	private JTextArea textArea_1;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_4;
	private JTextField textField_8;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_2;
	private JTextArea textArea;

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
		setBounds(100, 100, 783, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("PROVEEDOR - POLLERIA DON POLLO");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setBounds(57, 0, 654, 50);
			contentPane.add(lblNewLabel);
		}
		{
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel.setBackground(new Color(255, 250, 250));
			panel.setBounds(125, 49, 543, 110);
			contentPane.add(panel);
			{
				lblNewLabel_1_1 = new JLabel("Nombre:");
				lblNewLabel_1_1.setBounds(207, 11, 108, 22);
				panel.add(lblNewLabel_1_1);
			}
			{
				lblNewLabel_2 = new JLabel("Dirreción:");
				lblNewLabel_2.setBounds(26, 55, 108, 20);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_2_1 = new JLabel("Teléfono:");
				lblNewLabel_2_1.setBounds(207, 55, 138, 20);
				panel.add(lblNewLabel_2_1);
			}
			{
				lblNewLabel_2_1_1 = new JLabel("Codigo del Proveedor:");
				lblNewLabel_2_1_1.setBounds(26, 15, 138, 14);
				panel.add(lblNewLabel_2_1_1);
			}
			{
				textField = new JTextField();
				textField.setBounds(26, 35, 108, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(207, 35, 152, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(207, 78, 152, 20);
				panel.add(textField_3);
			}
			{
				btnEnviarDatos = new JButton("Enviar Datos");
				btnEnviarDatos.setBounds(408, 47, 116, 36);
				panel.add(btnEnviarDatos);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(26, 78, 152, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
		}
		{
			lblNewLabel_2_1_2 = new JLabel("Entregas Pendientes:");
			lblNewLabel_2_1_2.setBounds(10, 163, 138, 14);
			contentPane.add(lblNewLabel_2_1_2);
		}
		{
			lblNewLabel_3 = new JLabel("N° de Pedido:");
			lblNewLabel_3.setBounds(10, 184, 80, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Producto:");
			lblNewLabel_4.setBounds(162, 188, 80, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Kg:");
			lblNewLabel_5.setBounds(313, 188, 46, 14);
			contentPane.add(lblNewLabel_5);
		}
		{
			lblNewLabel_6 = new JLabel("Estado:");
			lblNewLabel_6.setBounds(465, 188, 46, 14);
			contentPane.add(lblNewLabel_6);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(10, 209, 86, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			textField_5 = new JTextField();
			textField_5.setBounds(162, 209, 86, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
		}
		{
			textField_6 = new JTextField();
			textField_6.setBounds(313, 209, 86, 20);
			contentPane.add(textField_6);
			textField_6.setColumns(10);
		}
		{
			textField_7 = new JTextField();
			textField_7.setBounds(465, 209, 113, 20);
			contentPane.add(textField_7);
			textField_7.setColumns(10);
		}
		{
			btnNewButton = new JButton("Reportar");
			btnNewButton.setBounds(622, 184, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(18, 240, 560, 210);
			contentPane.add(scrollPane);
			{
				textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
		}
		{
			btnNewButton_1 = new JButton("Confirmar Entrega");
			btnNewButton_1.setBounds(588, 252, 131, 23);
			contentPane.add(btnNewButton_1);
		}
		{
			btnNewButton_2 = new JButton("Rechazar Entrega");
			btnNewButton_2.setBounds(588, 299, 131, 23);
			contentPane.add(btnNewButton_2);
		}
		{
			lblNewLabel_1 = new JLabel("Historial de Entregas");
			lblNewLabel_1.setBounds(14, 465, 121, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			btnNewButton_3 = new JButton("Revisar");
			btnNewButton_3.setBounds(193, 461, 131, 23);
			contentPane.add(btnNewButton_3);
		}
		{
			textArea_1 = new JTextArea();
			textArea_1.setBounds(20, 486, 470, 210);
			contentPane.add(textArea_1);
		}
		{
			lblNewLabel_7 = new JLabel("Observaciones:");
			lblNewLabel_7.setBounds(500, 465, 86, 14);
			contentPane.add(lblNewLabel_7);
		}
		{
			btnNewButton_4 = new JButton("Reportar Observación:");
			btnNewButton_4.setBounds(618, 461, 143, 23);
			contentPane.add(btnNewButton_4);
		}
		{
			textField_8 = new JTextField();
			textField_8.setBounds(500, 488, 261, 25);
			contentPane.add(textField_8);
			textField_8.setColumns(10);
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(500, 524, 261, 170);
			contentPane.add(scrollPane_1);
			{
				textArea_2 = new JTextArea();
				scrollPane_1.setViewportView(textArea_2);
			}
		}
	}
}
