package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloPersona;
import Arraylist.ArregloTrabajador;
import DatosPersonales.Persona;
import DatosPersonales.Trabajador;
import Gestiones.Usuario;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegistrarTrabajadorGUI extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNombreCompleto;
	private JLabel lblTelfono;
	private JLabel lblDireccin;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtDNI;
	private JButton btnRegistrar;
	Usuario user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarTrabajadorGUI frame = new RegistrarTrabajadorGUI(null);
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
	public RegistrarTrabajadorGUI(Usuario user) {
		this.user = user;
		setFont(new Font("Dialog", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(19, 78, 262, 218);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("DNI:");
				lblNewLabel.setBounds(22, 30, 60, 20);
				panel.add(lblNewLabel);
			}
			{
				lblNombreCompleto = new JLabel("Nombre Completo:");
				lblNombreCompleto.setBounds(22, 60, 115, 20);
				panel.add(lblNombreCompleto);
			}
			{
				lblTelfono = new JLabel("Teléfono:");
				lblTelfono.setBounds(22, 90, 86, 20);
				panel.add(lblTelfono);
			}
			{
				lblDireccin = new JLabel("Dirección:");
				lblDireccin.setBounds(22, 120, 86, 20);
				panel.add(lblDireccin);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(140, 61, 96, 19);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(140, 91, 96, 19);
				panel.add(txtTelefono);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(140, 121, 96, 19);
				panel.add(txtDireccion);
			}
			{
				txtDNI = new JTextField();
				txtDNI.setColumns(10);
				txtDNI.setBounds(140, 31, 96, 19);
				panel.add(txtDNI);
			}
			{
				btnRegistrar = new JButton("REGISTRAR");
				btnRegistrar.addActionListener(this);
				btnRegistrar.setBounds(76, 161, 103, 37);
				panel.add(btnRegistrar);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(305, 78, 434, 413);
			contentPane.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(this);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"DNI", "Nombre", "Tel\u00E9fono", "Direcci\u00F3n", "Usuario", "Contrase\u00F1a"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(19, 307, 261, 184);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblOpciones = new JLabel("OPCIONES DATOS:");
				lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblOpciones.setBounds(10, 10, 115, 20);
				panel_1.add(lblOpciones);
			}
			{
				btnModificar = new JButton("MODIFICAR");
				btnModificar.setBounds(126, 51, 96, 33);
				panel_1.add(btnModificar);
				{
					btnEliminar = new JButton("ELIMINAR");
					btnEliminar.setBounds(20, 51, 96, 33);
					panel_1.add(btnEliminar);
					{
						btnBuscar = new JButton("BUSCAR");
						btnBuscar.setBounds(71, 137, 103, 32);
						panel_1.add(btnBuscar);
						{
							txtBusqueda = new JTextField();
							txtBusqueda.setBounds(126, 107, 96, 19);
							panel_1.add(txtBusqueda);
							txtBusqueda.setColumns(10);
						}
						{
							lblBusquedaPorDni = new JLabel("Busqueda por DNI:");
							lblBusquedaPorDni.setBounds(20, 108, 115, 20);
							panel_1.add(lblBusquedaPorDni);
						}
						{
							lblRegistrarEmpleados = new JLabel("REGISTRAR EMPLEADOS");
							lblRegistrarEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
							lblRegistrarEmpleados.setForeground(Color.BLACK);
							lblRegistrarEmpleados.setFont(new Font("Segoe UI Black", Font.PLAIN, 34));
							lblRegistrarEmpleados.setBackground(Color.BLACK);
							lblRegistrarEmpleados.setBounds(69, 11, 670, 50);
							contentPane.add(lblRegistrarEmpleados);
						}
						{
							btnVolver = new JButton("Volver");
							btnVolver.addActionListener(this);
							btnVolver.setBounds(21, 20, 116, 38);
							contentPane.add(btnVolver);
						}
						btnBuscar.addActionListener(this);
					}
					btnEliminar.addActionListener(this);
				}
				btnModificar.addActionListener(this);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBuscar;
	private JTextField txtBusqueda;
	private JLabel lblOpciones;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel_1;
	private JLabel lblBusquedaPorDni;
	private JLabel lblRegistrarEmpleados;
	private JButton btnVolver;
	
	
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		try {
	        String dni = txtDNI.getText().trim();
	        String nombre = txtNombre.getText().trim();
	        int telefono = Integer.parseInt(txtTelefono.getText().trim());
	        String direccion = txtDireccion.getText().trim();

	        if (!camposCompletos(dni, nombre, txtTelefono.getText(), direccion)) {
	            JOptionPane.showMessageDialog(null, "¡Complete todos los campos!");
	            return;
	        }
	        if (dni.length() != 8 || !dni.chars().allMatch(Character::isDigit)) {
	            JOptionPane.showMessageDialog(null, "El DNI debe tener exactamente 8 números.");
	            return;
	        }

	        if (txtTelefono.getText().length() != 9 || !txtTelefono.getText().chars().allMatch(Character::isDigit)) {
	            JOptionPane.showMessageDialog(null, "El teléfono debe tener exactamente 9 números.");
	            return;
	        }

	        if (!nombre.replace(" ", "").chars().allMatch(Character::isLetter)) {
	            JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.");
	            return;
	        }
	        if (ArregloPersona.VerificarDNI(dni) != null) {
	            JOptionPane.showMessageDialog(null, "¡Ya existe un empleado con ese DNI!");
	            return;
	        }

	        String usuario = generarUsuario(nombre, dni);
	        String contrasena = generarContrasena();
	        
	        Usuario userEmpleado = new Usuario(usuario, contrasena, "trabajador");

	        Trabajador emp = new Trabajador(null,telefono, nombre, dni, direccion, userEmpleado);

	        JOptionPane.showMessageDialog(this, "REGISTRADO EXITOSAMENTE\n"
	            + "Usuario: " + usuario + "\nContraseña: " + contrasena);

	        mostrarEnTabla();
	        limpiarCampos();
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "¡Error al registrar empleado!");
	    }		
	}
	public String generarUsuario(String nombre, String dni) {
	    String parteNombre = nombre.toLowerCase().replace(" ", "");
	    String ultimosDni = dni.substring(Math.max(0, dni.length() - 3));
	    return parteNombre + ultimosDni;
	}

	public String generarContrasena() {
	    String caracteres = "abc123";
	    StringBuilder contrasena = new StringBuilder();
	    for (int i = 0; i < 6; i++) {
	        int aleatorio = (int) (Math.random() * caracteres.length());
	        contrasena.append(caracteres.charAt(aleatorio));
	    }
	    return contrasena.toString();
	}

	
	public void mostrarEnTabla() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0);
	    
	    ArrayList<Trabajador> arregloEmpleado = ArregloTrabajador.listarTrabajadores();

	    for (Trabajador emp : arregloEmpleado) {
	        Object[] fila = {
	            emp.getDNI(),
	            emp.getNombreCompleto(),
	            emp.getTelefono(),
	            emp.getDireccion(),
	            emp.getUser().getUser(),
	            emp.getUser().getContraseña()
	        };
	        modelo.addRow(fila);
	    }
	}
	
	public void limpiarCampos() {
	    txtNombre.setText("");
	    txtDNI.setText("");
	    txtTelefono.setText("");
	    txtDireccion.setText("");
	    txtDNI.setEditable(true);
	}
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		String dni = txtBusqueda.getText().trim();
	    txtBusqueda.setText("");

	    Trabajador emp = ArregloTrabajador.VerificarDNITrabajador(dni);

	    if (emp != null) {
	        JOptionPane.showMessageDialog(null,
	            "Empleado encontrado:\n" +
	            "Nombre: " + emp.getNombreCompleto() + "\n" +
	            "Teléfono: " + emp.getTelefono() + "\n" +
	            "Dirección: " + emp.getDireccion()
	        );
	    } else {
	        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
	    }
	}
	
	

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
	}
	
	public boolean camposCompletos(String dni, String nombre, String telefono, String direccion) {
	    return !(dni.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty());
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		int fila = table.getSelectedRow();
        if (fila >= 0) {
            txtDNI.setText(table.getValueAt(fila, 0).toString());
            txtNombre.setText(table.getValueAt(fila, 1).toString());
            txtTelefono.setText(table.getValueAt(fila, 2).toString());
            txtDireccion.setText(table.getValueAt(fila, 3).toString());
        }
	}
	

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		String dniActual = txtDNI.getText().trim();

	    Trabajador emp = ArregloTrabajador.VerificarDNITrabajador(dniActual);

	    if (emp != null) {
	        emp.setNombreCompleto((txtNombre.getText().trim()));
	        emp.setTelefono(Integer.parseInt(txtTelefono.getText().trim()));
	        emp.setDireccion(txtDireccion.getText().trim());

	        JOptionPane.showMessageDialog(null, "Empleado modificado correctamente.");
	        mostrarEnTabla();
	        limpiarCampos();
	    } else {
	        JOptionPane.showMessageDialog(null, "NO SE PUEDE MODIFICAR EL DNI");
	    }
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		String dni = txtDNI.getText().trim();

	    if (dni.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Seleccione un empleado primero.");
	        return;
	    }

	    Trabajador emp = ArregloTrabajador.VerificarDNITrabajador(dni);

	    if (emp != null) {
	        if(ArregloTrabajador.EliminarTrabajador(dni)) {
	        	
	        	mostrarEnTabla();
		        limpiarCampos();
		        JOptionPane.showMessageDialog(null, "Empleado eliminado.");	
	        }else {
	        	JOptionPane.showMessageDialog(null, "No se pudo eliminar al empleado");		
	        }
	        
	    } else {
	        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
	    }
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		this.dispose();
		AdministradorGUI volver = new AdministradorGUI(user);
		volver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volver.setVisible(true);
	}
}
