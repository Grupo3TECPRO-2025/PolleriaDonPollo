package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gestiones.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdministradorGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRegistrarPedido;
	private JButton btnHistorialRegistros;
	private JButton btnRellenarStock;
	private JButton btnRegistrarEmpleados;
	private JButton btnRegistrarProveedores;
	
	private ClienteGUI ventanaCliente;
	private JButton btnInicio;
	private RegistrosGUI ventanaRegistros;
	private ProvicionesGUI ventanaProveedor;
	
	private RegistrarTrabajadorGUI ventanaRegistrarTrabajador;
	private Usuario user;
	private JLabel lblNewLabel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministradorGUI frame = new AdministradorGUI(null);
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
	public AdministradorGUI(Usuario user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnRegistrarPedido = new JButton("Registrar Pedido");
			btnRegistrarPedido.addActionListener(this);
			btnRegistrarPedido.setBounds(208, 112, 168, 42);
			contentPane.add(btnRegistrarPedido);
		}
		{
			btnHistorialRegistros = new JButton("Historial Registros");
			btnHistorialRegistros.addActionListener(this);
			btnHistorialRegistros.setBounds(208, 184, 168, 42);
			contentPane.add(btnHistorialRegistros);
		}
		{
			btnRellenarStock = new JButton("Rellenar Stock");
			btnRellenarStock.addActionListener(this);
			btnRellenarStock.setBounds(208, 263, 168, 42);
			contentPane.add(btnRellenarStock);
		}
		{
			btnRegistrarEmpleados = new JButton("Registrar Empleados");
			btnRegistrarEmpleados.addActionListener(this);
			btnRegistrarEmpleados.setBounds(208, 334, 168, 42);
			contentPane.add(btnRegistrarEmpleados);
		}
		{
			btnRegistrarProveedores = new JButton("Registrar Proveedores");
			btnRegistrarProveedores.addActionListener(this);
			btnRegistrarProveedores.setBounds(208, 408, 168, 42);
			contentPane.add(btnRegistrarProveedores);
		}
		{
			btnInicio = new JButton("Cerrar Sesion");
			btnInicio.addActionListener(this);
			btnInicio.setBounds(10, 11, 124, 23);
			contentPane.add(btnInicio);
		}
		{
			lblNewLabel = new JLabel("ELIGE UNA OPCIÓN");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 36));
			lblNewLabel.setBounds(123, 48, 351, 48);
			contentPane.add(lblNewLabel);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrarProveedores) {
			do_btnRegistrarProveedores_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarEmpleados) {
			do_btnRegistrarEmpleados_actionPerformed(e);
		}
		if (e.getSource() == btnRellenarStock) {
			do_btnRellenarStock_actionPerformed(e);
		}
		if (e.getSource() == btnHistorialRegistros) {
			do_btnHistorialRegistros_actionPerformed(e);
		}
		if (e.getSource() == btnInicio) {
			do_btnInicio_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarPedido) {
			do_btnRegistrarPedido_actionPerformed(e);
		}
	}
	protected void do_btnRegistrarPedido_actionPerformed(ActionEvent e) {
		if (ventanaCliente != null && ventanaCliente.isDisplayable()) {
    		ventanaCliente.dispose();
        }
    	
    	ventanaCliente = null;  
    	ventanaCliente = new ClienteGUI(user);
    	ventanaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	ventanaCliente.setVisible(true);
    	
		dispose();
	}

	protected void do_btnHistorialRegistros_actionPerformed(ActionEvent e) {
		
		if (ventanaRegistros != null && ventanaRegistros.isDisplayable()) {
    		ventanaRegistros.dispose();
        }
    	

		ventanaRegistros = null;  
		ventanaRegistros = new RegistrosGUI(user);
		ventanaRegistros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaRegistros.setVisible(true);
		dispose();
	}
	protected void do_btnRellenarStock_actionPerformed(ActionEvent e) {
		
		
		if (ventanaProveedor != null && ventanaProveedor.isDisplayable()) {
			ventanaProveedor.dispose();
        }
    	

		ventanaProveedor = null;  
		ventanaProveedor = new ProvicionesGUI(user);
		ventanaProveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaProveedor.setVisible(true);
		dispose();
	}
	
	
	
	
	protected void do_btnInicio_actionPerformed(ActionEvent e) {
		InicioGUI volverInicioGUI = new InicioGUI();
		volverInicioGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volverInicioGUI.setVisible(true);
		
		this.dispose();
	}
	protected void do_btnRegistrarEmpleados_actionPerformed(ActionEvent e) {
		if (ventanaRegistrarTrabajador != null && ventanaRegistrarTrabajador.isDisplayable()) {
			ventanaRegistrarTrabajador.dispose();
        }
    	

		ventanaRegistrarTrabajador = null;  
		ventanaRegistrarTrabajador = new RegistrarTrabajadorGUI(user);
		ventanaRegistrarTrabajador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaRegistrarTrabajador.setVisible(true);
		dispose();	
	}
	protected void do_btnRegistrarProveedores_actionPerformed(ActionEvent e) {
	}
}
