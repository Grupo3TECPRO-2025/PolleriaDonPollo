package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
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
	private JLabel lblNewLabel_2;
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
		setBounds(100, 100, 603, 627);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
			lblNewLabel_4.setBounds(21, 32, 197, 26);
			panel_1.add(lblNewLabel_4);
		}
		{
			lblNewLabel_5 = new JLabel("Direccion");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_5.setBounds(23, 104, 127, 17);
			panel_1.add(lblNewLabel_5);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtNombre.setColumns(10);
			txtNombre.setBounds(19, 64, 156, 26);
			panel_1.add(txtNombre);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(22, 130, 156, 26);
			panel_1.add(txtDireccion);
		}
		btnRegistrar = new JButton("Enviar");
		btnRegistrar.addActionListener(this);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(221)
							.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		{
			lblNewLabel_7 = new JLabel("DNI");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_7.setBounds(212, 29, 197, 26);
			panel_1.add(lblNewLabel_7);
		}
		{
			txtDNI = new JTextField();
			txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDNI.setColumns(10);
			txtDNI.setBounds(211, 64, 156, 26);
			panel_1.add(txtDNI);
		}
		{
			lblNewLabel_6 = new JLabel("Telefono");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_6.setBounds(210, 99, 197, 26);
			panel_1.add(lblNewLabel_6);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(210, 130, 156, 26);
			panel_1.add(txtTelefono);
		}
		{
			lblNewLabel_8 = new JLabel("RUC");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_8.setBounds(212, 169, 197, 26);
			panel_1.add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("Nombre Empresa");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_9.setBounds(21, 167, 197, 26);
			panel_1.add(lblNewLabel_9);
		}
		{
			txtNombreEmpresa = new JTextField();
			txtNombreEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtNombreEmpresa.setColumns(10);
			txtNombreEmpresa.setBounds(21, 198, 156, 26);
			panel_1.add(txtNombreEmpresa);
		}
		{
			txtRUC = new JTextField();
			txtRUC.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtRUC.setColumns(10);
			txtRUC.setBounds(212, 198, 156, 26);
			panel_1.add(txtRUC);
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
			txtUsuario.setBounds(151, 28, 156, 26);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtContraseña.setColumns(10);
			txtContraseña.setBounds(151, 65, 156, 26);
			panel.add(txtContraseña);
		}
		{
			btnVerificar = new JButton("Verificar");
			btnVerificar.setBounds(361, 33, 89, 23);
			panel.add(btnVerificar);
		}
		{
			lblNewLabel_2 = new JLabel("verificar");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(339, 74, 127, 14);
			panel.add(lblNewLabel_2);
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
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(this, "Se registró correctamente");
		this.dispose();
		
		
	}
}
