package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Arraylist.ArregloUsuario;
import DatosPersonales.Administrador;
import DatosPersonales.Cliente;
import DatosPersonales.Persona;
import DatosPersonales.Proveedor;
import Gestiones.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterGUI extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JMenuBar MenuBarra;
	private JMenu Menu;
	private JMenuItem itemLogin;
	private JMenuItem itemRegistrar;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private String rol;
	private JButton btnVerificar;
	private JLabel lblVerificar;
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_7;
	private JTextField txtDNI;
	private JLabel lblNewLabel_6;
	private JTextField txtTelefono;
	private JButton btnRegistrar;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField txtNombreEmpresa;
	private JTextField txtRUC;
	private LoginGUI login;
	
	
	private InicioGUI inicio;
	private JTextField txtClavePolleria;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_2;
	private JTextField txtProveedorClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterGUI dialog = new RegisterGUI("",null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterGUI(String rol, InicioGUI inicio) {
		
		this.rol = rol;
		this.inicio= inicio;
		setBounds(100, 100, 577, 673);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			lblNewLabel = new JLabel("Registrar al Sistema: "+rol);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		panel = new JPanel();
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
		{
			lblNewLabel_4 = new JLabel("Nombre Completo");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_4.setBounds(21, 22, 197, 26);
			panel_1.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Direccion");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_5.setBounds(23, 94, 127, 17);
			panel_1.add(lblNewLabel_5);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtNombre.setColumns(10);
			txtNombre.setBounds(19, 54, 156, 26);
			panel_1.add(txtNombre);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(22, 113, 156, 26);
			panel_1.add(txtDireccion);
		}
		btnRegistrar = new JButton("Enviar");
		btnRegistrar.addActionListener(this);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
							.addGap(49))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(64, Short.MAX_VALUE))))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(55)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(217)
					.addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
					.addGap(242))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		{
			if(rol.equals("cliente")) lblNewLabel_7 = new JLabel("DNI (opcional)");
			else lblNewLabel_7 = new JLabel("DNI");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_7.setBounds(212, 29, 197, 26);
			panel_1.add(lblNewLabel_7);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDNI.setColumns(10);
			txtDNI.setBounds(211, 54, 156, 26);
			panel_1.add(txtDNI);
		}
		{
			lblNewLabel_6 = new JLabel("Telefono");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_6.setBounds(211, 89, 197, 26);
			panel_1.add(lblNewLabel_6);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(211, 113, 156, 26);
			panel_1.add(txtTelefono);
		}
		{
			lblNewLabel_8 = new JLabel("RUC");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_8.setBounds(211, 157, 197, 26);
			panel_1.add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("Nombre Empresa");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_9.setBounds(22, 155, 197, 26);
			panel_1.add(lblNewLabel_9);
		}
		{
			txtNombreEmpresa = new JTextField();
			txtNombreEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtNombreEmpresa.setColumns(10);
			txtNombreEmpresa.setBounds(21, 181, 156, 26);
			panel_1.add(txtNombreEmpresa);
		}
		{
			txtRUC = new JTextField();
			txtRUC.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtRUC.setColumns(10);
			txtRUC.setBounds(212, 183, 156, 26);
			panel_1.add(txtRUC);
		}
		{
			lblNewLabel_2 = new JLabel("Clave de Polleria");
			lblNewLabel_2.setVisible(false);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_2.setBounds(21, 225, 156, 14);
			panel_1.add(lblNewLabel_2);
		}
		{
			txtProveedorClave = new JTextField();
			txtProveedorClave.setVisible(false);
			txtProveedorClave.setBounds(21, 246, 154, 25);
			panel_1.add(txtProveedorClave);
			txtProveedorClave.setColumns(10);
		}
		txtRUC.setVisible(false);
		txtNombreEmpresa.setVisible(false);
		lblNewLabel_9.setVisible(false);
		lblNewLabel_8.setVisible(false);
		if(rol=="proovedor") {
			
			txtRUC.setVisible(true);
			txtNombreEmpresa.setVisible(true);
			lblNewLabel_9.setVisible(true);
			lblNewLabel_8.setVisible(true);
		}
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Crea una Cuenta", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
		panel.setLayout(null);
		{
			lblNewLabel_1 = new JLabel("Usuario");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(51, 28, 108, 26);
			panel.add(lblNewLabel_1);
		}
		{
			lblNewLabel_3 = new JLabel("Contraseña");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(24, 65, 127, 17);
			panel.add(lblNewLabel_3);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtUsuario.setBounds(141, 28, 156, 26);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtContraseña.setColumns(10);
			txtContraseña.setBounds(140, 61, 156, 26);
			panel.add(txtContraseña);
		}
		{
			btnVerificar = new JButton("Verificar");
			btnVerificar.addActionListener(this);
			btnVerificar.setBounds(329, 31, 89, 23);
			panel.add(btnVerificar);
		}
		{
			lblVerificar = new JLabel("");
			lblVerificar.setForeground(Color.RED);
			lblVerificar.setHorizontalAlignment(SwingConstants.CENTER);
			lblVerificar.setBounds(322, 69, 114, 14);
			panel.add(lblVerificar);
		}
		{
			if(rol.equals("administrador")) {
				txtClavePolleria = new JTextField();
				txtClavePolleria.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtClavePolleria.setColumns(10);
				txtClavePolleria.setBounds(151, 96, 156, 26);
				panel.add(txtClavePolleria);
			}
			
		}
		{
			if(rol.equals("administrador")) {
				lblNewLabel_10 = new JLabel("Clave Polleria");
				lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNewLabel_10.setBounds(23, 100, 127, 17);
				panel.add(lblNewLabel_10);
			}
			
		}
		contentPanel.setLayout(gl_contentPanel);
		{
			MenuBarra = new JMenuBar();
			setJMenuBar(MenuBarra);
			{
				Menu = new JMenu("Sistema Menu");
				MenuBarra.add(Menu);
				{
					itemLogin = new JMenuItem("Login");
					Menu.add(itemLogin);
					itemLogin.addActionListener(e -> {
						dispose(); // Cierra la ventana actual de login

					    // Abre la ventana de registro con el mismo rol
					    setVisible(false);
					    inicio.ventanaLogin.setVisible(true);

					    
						}
					);
				}
				{
					itemRegistrar = new JMenuItem("Registrar");
					Menu.add(itemRegistrar);
					
				}
			}
		}
		
		if(rol.equals("proveedor")) MostrarProveedor();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVerificar) {
			do_btnVerificar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		
		
		try {
			
			Persona nuevaPersona;
			
			//CUENTA DATOS
			String usuario = txtUsuario.getText();
			String contraseña = txtContraseña.getText();
			
			Usuario nuevoUsuario;
			
			if(ArregloUsuario.verificarUsuario(usuario)==null) {
				//DATOS PERSONALES
				
				String nombreCompleto = txtNombre.getText();
				String DNI = txtDNI.getText();
				String direccion = txtDireccion.getText();
				int telefono = Integer.parseInt(txtTelefono.getText());
				
				
				if(rol.equals("cliente")) {
					
					if(DNI.isBlank())nuevaPersona = new Cliente(telefono, nombreCompleto, direccion);
					else nuevaPersona = new Cliente(telefono, nombreCompleto, DNI, direccion);
					
				
					
				}else if(rol.equals("administrador")) {
				
					
				}else if(rol.equals("proveedor")) {
					String nombreEmpresa = txtNombreEmpresa.getText();
					String RUC = txtRUC.getText();
					
					String claveProveedor = txtProveedorClave.getText();
					
				
				
				

				
				}
			}
			
			
			
			
			
	

			
			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Completa todos los campos");
		}
		JOptionPane.showMessageDialog(this, "Volviendo al inicio...");
		this.dispose();
		
		
	}
	protected void do_btnVerificar_actionPerformed(ActionEvent e) {
		try {
			String usuario =  txtUsuario.getText();
			
			Usuario user = ArregloUsuario.verificarUsuario(usuario);
			
			if(user == null) {
				lblVerificar.setText("Usuario Permitido");
				lblVerificar.setForeground(Color.green);
			}else {
				lblVerificar.setText("El nombre ya existe");
				lblVerificar.setForeground(Color.RED);				
			}
		}catch (Exception ex) {
			
		}
	}

	void MostrarProveedor() {
		lblNewLabel_9.setVisible(true);
		lblNewLabel_8.setVisible(true);
		lblNewLabel_2.setVisible(true);
		txtRUC.setVisible(true);
		txtNombreEmpresa.setVisible(true);
		txtProveedorClave.setVisible(true);
	}
}
