package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Arraylist.ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;


import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public LoginGUI ventanaLogin;
    public RegisterGUI ventanaRegister;
    private AdministradorGUI ventanaAdministrador;
    private ProveedorGUI ventanaProveedor;

    
    
    
    public InicioGUI() {
    	ConexionSQL.getConexion();
    	
        setTitle("Don Pollo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));

        URL iconURL = getClass().getResource("/img/DonPollo.jpg");
        if (iconURL != null) {
            Image icon = new ImageIcon(iconURL).getImage();
            setIconImage(icon);
        }

        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
        gbl_panel.columnWeights = new double[]{1.0};
        JPanel panel = new JPanel(gbl_panel);
        panel.setOpaque(false); 
        setContentPane(panel);

        try {
            URL bgURL = getClass().getResource("/img/local_desenfocado.jpg");
            if (bgURL != null) {
                ImageIcon bgIcon = new ImageIcon(bgURL);
                Image bgImage = bgIcon.getImage();
                setContentPane(new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
                    }
                });
                ((JPanel)getContentPane()).setLayout(new GridBagLayout());
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen de fondo: " + e.getMessage());
        }

        Font btnFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        Dimension btnSize = new Dimension(300, 50);
        Color btnColor = Color.WHITE;

        JLabel lblTitulo = new JLabel("BIENVENIDO A DON POLLO");
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        lblTitulo.setForeground(Color.DARK_GRAY);
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(Color.YELLOW);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setPreferredSize(new Dimension(600, 60));
        
        GridBagConstraints gbcTitulo = new GridBagConstraints();
        gbcTitulo.gridx = 0;
        gbcTitulo.gridy = 0;
        gbcTitulo.insets = new Insets(20, 20, 20, 20);
        getContentPane().add(lblTitulo, gbcTitulo);

        JButton btnCliente = new JButton("Cliente");
        btnCliente.setFont(btnFont);
        btnCliente.setPreferredSize(btnSize);
        btnCliente.setBackground(btnColor);
        
        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.gridx = 0;
        gbcCliente.gridy = 1;
        gbcCliente.insets = new Insets(20, 20, 20, 20);
        getContentPane().add(btnCliente, gbcCliente);

        JButton btnAdministrador = new JButton("Administrador");
        btnAdministrador.setFont(btnFont);
        btnAdministrador.setPreferredSize(btnSize);
        btnAdministrador.setBackground(btnColor);
        
        GridBagConstraints gbcAdmin = new GridBagConstraints();
        gbcAdmin.gridx = 0;
        gbcAdmin.gridy = 2;
        gbcAdmin.insets = new Insets(20, 20, 20, 20);
        getContentPane().add(btnAdministrador, gbcAdmin);

        JButton btnProveedor = new JButton("Proveedor");
        btnProveedor.setFont(btnFont);
        btnProveedor.setPreferredSize(btnSize);
        btnProveedor.setBackground(btnColor);
        
        GridBagConstraints gbcProveedor = new GridBagConstraints();
        gbcProveedor.gridx = 0;
        gbcProveedor.gridy = 3;
        gbcProveedor.insets = new Insets(20, 20, 20, 20);
        getContentPane().add(btnProveedor, gbcProveedor);
        
        JLayeredPane layeredPane = new JLayeredPane();
        GridBagConstraints gbc_layeredPane = new GridBagConstraints();
        gbc_layeredPane.fill = GridBagConstraints.BOTH;
        gbc_layeredPane.gridx = 0;
        gbc_layeredPane.gridy = 4;
        panel.add(layeredPane, gbc_layeredPane);

        btnCliente.addActionListener(e -> {
        	if (ventanaLogin != null && ventanaLogin.isDisplayable() && ventanaRegister != null && ventanaRegister.isDisplayable()) {
                ventanaLogin.dispose();
                ventanaRegister.dispose();
            }

            ventanaLogin = null;  
            ventanaLogin = new LoginGUI("cliente",this);
        	ventanaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaLogin.setVisible(true);
        	
        	ventanaRegister	= null;  
        	ventanaRegister = new RegisterGUI("cliente",this);
        	ventanaRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaRegister.setVisible(false);
        });

        btnAdministrador.addActionListener(e -> {

        	if (ventanaLogin != null && ventanaLogin.isDisplayable() && ventanaRegister != null && ventanaRegister.isDisplayable()) {
                ventanaLogin.dispose();
                ventanaRegister.dispose();
            }
        	

            ventanaLogin = null;  
            ventanaLogin = new LoginGUI("administrador",this);
        	ventanaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaLogin.setVisible(true);
        	
        	ventanaRegister	= null;  
        	ventanaRegister = new RegisterGUI("administrador",this);
        	ventanaRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaRegister.setVisible(false);
        });

        btnProveedor.addActionListener(e -> {
        	if (ventanaLogin != null && ventanaLogin.isDisplayable() && ventanaRegister != null && ventanaRegister.isDisplayable()) {
                ventanaLogin.dispose();
                ventanaRegister.dispose();
            }

            ventanaLogin = null;  
        	ventanaLogin = new LoginGUI("proveedor",this);
        	ventanaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaLogin.setVisible(true);
        	
        	ventanaRegister	= null;  
        	ventanaRegister = new RegisterGUI("proveedor",this);
        	ventanaRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	ventanaRegister.setVisible(false);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InicioGUI frame = new InicioGUI();
            frame.setVisible(true);
        });
    }
	public void actionPerformed(ActionEvent e) {
	}
	
	
	
	
}