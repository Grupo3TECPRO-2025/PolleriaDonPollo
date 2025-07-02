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
	private ProveedorGUI ventanaProveedor;
	
	private RegistrarTrabajadorGUI ventanaRegistrarTrabajador;
	private Usuario user;
	
	

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
			btnRegistrarPedido.setBounds(210, 58, 168, 42);
			contentPane.add(btnRegistrarPedido);
		}
		{
			btnHistorialRegistros = new JButton("Historial Registros");
			btnHistorialRegistros.addActionListener(this);
			btnHistorialRegistros.setBounds(210, 130, 168, 42);
			contentPane.add(btnHistorialRegistros);
		}
		{
			btnRellenarStock = new JButton("Rellenar Stock");
			btnRellenarStock.addActionListener(this);
			btnRellenarStock.setBounds(210, 209, 168, 42);
			contentPane.add(btnRellenarStock);
		}
		{
			btnRegistrarEmpleados = new JButton("Registrar Empleados");
			btnRegistrarEmpleados.addActionListener(this);
			btnRegistrarEmpleados.setBounds(210, 280, 168, 42);
			contentPane.add(btnRegistrarEmpleados);
		}
		{
			btnRegistrarProveedores = new JButton("Registrar Proveedores");
			btnRegistrarProveedores.setBounds(210, 354, 168, 42);
			contentPane.add(btnRegistrarProveedores);
		}
		{
			btnInicio = new JButton("Cerrar Sesion");
			btnInicio.addActionListener(this);
			btnInicio.setBounds(10, 11, 124, 23);
			contentPane.add(btnInicio);
		}
	}

	public void actionPerformed(ActionEvent e) {
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
    	ventanaCliente = new ClienteGUI(null);
    	ventanaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	ventanaCliente.setVisible(true);
    	
		dispose();
	}

	protected void do_btnHistorialRegistros_actionPerformed(ActionEvent e) {
		
		if (ventanaRegistros != null && ventanaRegistros.isDisplayable()) {
    		ventanaRegistros.dispose();
        }
    	

		ventanaRegistros = null;  
		ventanaRegistros = new RegistrosGUI();
		ventanaRegistros.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaRegistros.setVisible(true);
		dispose();
	}
	protected void do_btnRellenarStock_actionPerformed(ActionEvent e) {
		
		
		if (ventanaProveedor != null && ventanaProveedor.isDisplayable()) {
			ventanaProveedor.dispose();
        }
    	

		ventanaProveedor = null;  
		ventanaProveedor = new ProveedorGUI();
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
		ventanaRegistrarTrabajador = new RegistrarTrabajadorGUI();
		ventanaRegistrarTrabajador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaRegistrarTrabajador.setVisible(true);
		dispose();	
	}
}
