package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arraylist.ArregloUsuario;
import DatosPersonales.Trabajador;
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

public class LoginGUI extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JButton btnIngresar;
	private String rol;
	private RegisterGUI registrar;
	private InicioGUI inicio;
	
	private AdministradorGUI ventanaAdministrador;
    private ProvicionesGUI ventanaProveedor;
    private ClienteGUI ventanaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginGUI dialog = new LoginGUI("",null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginGUI(String rol,InicioGUI inicio) {
		this.rol = rol;
		this.inicio = inicio;
		setBounds(100, 100, 601, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Ingresa al Sistema: "+rol);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(45)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		panel.setLayout(null);
		{
			lblNewLabel_1 = new JLabel("Usuario");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblNewLabel_1.setBounds(87, 27, 127, 26);
			panel.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(31, 86, 46, 14);
			panel.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Contraseña");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblNewLabel_3.setBounds(64, 93, 127, 17);
			panel.add(lblNewLabel_3);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtUsuario.setBounds(224, 24, 192, 34);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtContraseña.setColumns(10);
			txtContraseña.setBounds(224, 85, 192, 34);
			panel.add(txtContraseña);
		}
		{
			btnIngresar = new JButton("Entrar");
			btnIngresar.addActionListener(this);
			btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 19));
			btnIngresar.setBounds(176, 154, 127, 49);
			panel.add(btnIngresar);
		}
		contentPanel.setLayout(gl_contentPanel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		
		
		
		if(rol.equals("trabajador")) {

			try {
				String user = txtUsuario.getText();
				String password = txtContraseña.getText();
				
				
				Usuario u = ArregloUsuario.VerificarLogin(user, password);

				if (u != null) {
				    System.out.println("Login exitoso: " + u.getUser());
				    System.out.println("Rol: " + u.getRol());
				    
				    JOptionPane.showMessageDialog(this, "Se ingresó correctamente");
				    inicio.dispose();
					this.dispose();
				    
				    if (ventanaCliente != null && ventanaCliente.isDisplayable()) {
		        		ventanaCliente.dispose();
		            }
		        	

		        	ventanaCliente = null;  
		        	ventanaCliente = new ClienteGUI(u);
		        	ventanaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	ventanaCliente.setVisible(true);
		        	
				} else {
				    System.out.println("Usuario o contraseña incorrectos.");
				    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
				}
				
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Ingresa todos los campos");
			}
			
			
        	
		}
		
		else if(rol.equals("administrador")) {

			try {
				String user = txtUsuario.getText();
				String password = txtContraseña.getText();
				
				
				Usuario u = ArregloUsuario.VerificarLogin(user, password);

				if (u != null) {
				    System.out.println("Login exitoso: " + u.getUser());
				    System.out.println("Rol: " + u.getRol());
				    
				    JOptionPane.showMessageDialog(this, "Se ingresó correctamente");
					
				    
					if (ventanaAdministrador != null && ventanaAdministrador.isDisplayable()) {
		        		ventanaAdministrador.dispose();
		            }
		        	
		        	this.dispose();
		        	inicio.dispose();

		        	ventanaAdministrador = null;  
		        	ventanaAdministrador = new AdministradorGUI(u); // <-- SE DEBE CAMBIAR
		        	ventanaAdministrador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	ventanaAdministrador.setVisible(true);
		        	
				} else {
				    System.out.println("Usuario o contraseña incorrectos.");
				    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
				}
				
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Ingresa todos los campos");
			}
		

        	
		}
		

	}
}
