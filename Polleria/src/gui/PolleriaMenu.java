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
	private JTextField txtPedidoID;
	private JTextField txtCant;
	private JTextField txtNumPedido;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtDNI;
	private JScrollPane scrollPane;
	private JTable tbPedido;
	private JTextField txtCosto;

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
		
		txtPedidoID = new JTextField();
		txtPedidoID.setBounds(15, 51, 167, 25);
		panel.add(txtPedidoID);
		txtPedidoID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Elige la cantidad");
		lblNewLabel_2.setBounds(15, 87, 138, 25);
		panel.add(lblNewLabel_2);
		
		txtCant = new JTextField();
		txtCant.setColumns(10);
		txtCant.setBounds(15, 112, 167, 25);
		panel.add(txtCant);
		
		txtNumPedido = new JTextField();
		txtNumPedido.setColumns(10);
		txtNumPedido.setBounds(15, 173, 167, 25);
		panel.add(txtNumPedido);
		
		JLabel lblNewLabel_2_1 = new JLabel("Elimina N° pedido");
		lblNewLabel_2_1.setBounds(15, 148, 138, 25);
		panel.add(lblNewLabel_2_1);
		
		JButton btnAgregar = new JButton("Agregar");

		btnAgregar.setBounds(199, 40, 95, 36);
		panel.add(btnAgregar);
		
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
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(15, 51, 167, 25);
		panel_1.add(txtNombre);
		
		JLabel lblNewLabel_2_2 = new JLabel("Direccion");
		lblNewLabel_2_2.setBounds(15, 87, 138, 25);
		panel_1.add(lblNewLabel_2_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(15, 112, 167, 25);
		panel_1.add(txtDireccion);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(15, 173, 167, 25);
		panel_1.add(txtDNI);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DNI:");
		lblNewLabel_2_1_1.setBounds(15, 148, 138, 25);
		panel_1.add(lblNewLabel_2_1_1);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 307, 523, 188);
			contentPane.add(scrollPane);
			{
				tbPedido = new JTable();
				tbPedido.setModel(new DefaultTableModel(
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
				tbPedido.getColumnModel().getColumn(0).setPreferredWidth(30);
				tbPedido.getColumnModel().getColumn(1).setPreferredWidth(150);
				tbPedido.getColumnModel().getColumn(2).setPreferredWidth(70);
				tbPedido.getColumnModel().getColumn(3).setPreferredWidth(70);
				tbPedido.getColumnModel().getColumn(4).setPreferredWidth(70);

				scrollPane.setViewportView(tbPedido);
			}
		}
		
		txtCosto = new JTextField();
		txtCosto.setBounds(418, 495, 129, 29);
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Costo Total");
		lblNewLabel_3.setBounds(342, 499, 68, 21);
		contentPane.add(lblNewLabel_3);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(24, 495, 100, 29);
		contentPane.add(btnEnviar);
	}
}
