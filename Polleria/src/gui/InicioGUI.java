package gui;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

import Arraylist.ConexionSQL;

public class InicioGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public LoginGUI ventanaLogin;
    private RegistrosGUI ventanaAdministrador;
    private ProvicionesGUI ventanaProveedor;
    private ClienteGUI ventanaCliente;

    private JButton btnNewButton;

    public InicioGUI() {
        ConexionSQL.getConexion();

        setTitle("Don Pollo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));

        // Cargar ícono de ventana
        URL iconURL = getClass().getResource("/img/DonPollo.jpg");
        if (iconURL != null) {
            Image icon = new ImageIcon(iconURL).getImage();
            setIconImage(icon);
        }

        // Cargar imagen de fondo
        URL bgURL = getClass().getResource("/img/local_desenfocado.jpg");
        Image bgImage = (bgURL != null) ? new ImageIcon(bgURL).getImage() : null;

        // Crear contentPane personalizado con fondo
        JPanel contentPane = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        contentPane.setLayout(new GridBagLayout());
        setContentPane(contentPane);

        // Configuraciones generales para botones
        Font btnFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        Dimension btnSize = new Dimension(300, 50);
        Color btnColor = Color.WHITE;

        // Título principal
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
        contentPane.add(lblTitulo, gbcTitulo);

        // Botón Trabajador
        JButton btnTrabajador = new JButton("Trabajador");
        btnTrabajador.setFont(btnFont);
        btnTrabajador.setPreferredSize(btnSize);
        btnTrabajador.setBackground(btnColor);

        GridBagConstraints gbc_btnTrabajador = new GridBagConstraints();
        gbc_btnTrabajador.gridx = 0;
        gbc_btnTrabajador.gridy = 1;
        gbc_btnTrabajador.insets = new Insets(20, 20, 20, 20);
        contentPane.add(btnTrabajador, gbc_btnTrabajador);

        btnTrabajador.addActionListener(e -> {
            if (ventanaLogin != null && ventanaLogin.isDisplayable()) {
                ventanaLogin.dispose();
            }
            ventanaLogin = new LoginGUI("trabajador", this);
            ventanaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaLogin.setVisible(true);
        });

        // Botón Administrador
        JButton btnAdministrador = new JButton("Administrador");
        btnAdministrador.setFont(btnFont);
        btnAdministrador.setPreferredSize(btnSize);
        btnAdministrador.setBackground(btnColor);

        GridBagConstraints gbcAdmin = new GridBagConstraints();
        gbcAdmin.gridx = 0;
        gbcAdmin.gridy = 2;
        gbcAdmin.insets = new Insets(20, 20, 20, 20);
        contentPane.add(btnAdministrador, gbcAdmin);

        btnAdministrador.addActionListener(e -> {
            if (ventanaLogin != null && ventanaLogin.isDisplayable()) {
                ventanaLogin.dispose();
            }
            ventanaLogin = new LoginGUI("administrador", this);
            ventanaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaLogin.setVisible(true);
        });

        // Botón PROGRAMADORES
        btnNewButton = new JButton("PROGRAMADORES");
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        btnNewButton.setPreferredSize(btnSize);
        btnNewButton.setBackground(btnColor);
        btnNewButton.addActionListener(this);

        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(20, 20, 20, 20);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 3;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InicioGUI frame = new InicioGUI();
            frame.setVisible(true);
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewButton) {
            do_btnNewButton_actionPerformed(e);
        }
    }

    protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        ProgramadoresGUI creditosGui = new ProgramadoresGUI();
        creditosGui.setVisible(true);
    }
}
