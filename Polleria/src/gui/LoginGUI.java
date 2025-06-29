package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JMenuBar MenuBarra;
	private JMenu Menu;
	private JMenuItem itemLogin;
	private JMenuItem itemRegistrar;
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
    private ProveedorGUI ventanaProveedor;
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
		{
			MenuBarra = new JMenuBar();
			setJMenuBar(MenuBarra);
			{
				Menu = new JMenu("Sistema Menu");
				MenuBarra.add(Menu);
				{
					itemLogin = new JMenuItem("Login");
					Menu.add(itemLogin);
				}
				{
					itemRegistrar = new JMenuItem("Registrar");
					Menu.add(itemRegistrar);
					itemRegistrar.addActionListener(e -> {
					    setVisible(false);
					    inicio.ventanaRegister.setVisible(true);
					}
					    
					    
					);
				}
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(this, "Se ingresó correctamente");
		this.dispose();
		
		if(rol.equals("cliente")) {

        	if (ventanaCliente != null && ventanaCliente.isDisplayable()) {
        		ventanaCliente.dispose();
            }
        	

        	ventanaCliente = null;  
        	ventanaCliente = new ClienteGUI();
        	ventanaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaCliente.setVisible(true);
		}
		
		else if(rol.equals("administrador")) {

        	if (ventanaAdministrador != null && ventanaAdministrador.isDisplayable()) {
        		ventanaAdministrador.dispose();
            }
        	

        	ventanaAdministrador = null;  
        	ventanaAdministrador = new AdministradorGUI();
        	ventanaAdministrador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaAdministrador.setVisible(true);
		}
		
		else if(rol.equals("proveedor")) {

        	if (ventanaProveedor != null && ventanaProveedor.isDisplayable()) {
        		ventanaProveedor.dispose();
            }
        	

        	ventanaProveedor = null;  
        	ventanaProveedor = new ProveedorGUI();
        	ventanaProveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaProveedor.setVisible(true);
		}
	}
}
