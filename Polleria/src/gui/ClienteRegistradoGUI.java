package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloCliente;
import DatosPersonales.Cliente;
import DatosPersonales.ClienteCuenta;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClienteRegistradoGUI extends JDialog implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTextField txtBuscar;
	private JLabel lblNewLabel;
	private JLabel lblListarInventario;
	private JTable table;
	private JButton btnEliminar;
	private ClienteGUI clienteGUI;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClienteRegistradoGUI dialog = new ClienteRegistradoGUI(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClienteRegistradoGUI(ClienteGUI clienteGUI) {
	    this.clienteGUI = clienteGUI;

		setBounds(100, 100, 378, 536);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 64, 64));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 138, 288, 291);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nombre", "DNI", "Pedidos Cant"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
		{
			txtBuscar = new JTextField();
			txtBuscar.addKeyListener(this);
			txtBuscar.setColumns(10);
			txtBuscar.setBounds(31, 98, 288, 25);
			contentPanel.add(txtBuscar);
		}
		{
			lblNewLabel = new JLabel("Ingresa el nombre de un cliente:");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(31, 68, 242, 19);
			contentPanel.add(lblNewLabel);
		}
		{
			lblListarInventario = new JLabel("CLIENTES REGISTRADOS");
			lblListarInventario.setHorizontalAlignment(SwingConstants.CENTER);
			lblListarInventario.setForeground(Color.WHITE);
			lblListarInventario.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblListarInventario.setBounds(31, 27, 288, 30);
			contentPanel.add(lblListarInventario);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(197, 139, 139));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setActionCommand("Cancel");
				buttonPane.add(btnEliminar);
			}
			{
				cancelButton = new JButton("Seleccionar");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarClientesRegistrados();
	}
	
	
	private void cargarClientesRegistrados() {
	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0); // limpiar la tabla antes de llenar

	    for (ClienteCuenta cuenta : ArregloCliente.listarClientesRegisHabilitados()) {
	        Cliente c = cuenta.getCli();
	        Object[] fila = {
	            c.getNombreCompleto(),
	            c.getDNI(),
	            cuenta.getPuntosCuenta()
	        };
	        modelo.addRow(fila);
	    }
	}
	
	private void actualizarTablaClientesPorNombre(String nombreParcial) {
	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0);

	    for (ClienteCuenta cuenta : ArregloCliente.buscarClientesRegisPorNombre(nombreParcial)) {
	        Cliente c = cuenta.getCli();
	        Object[] fila = {
	            c.getNombreCompleto(),
	            c.getDNI(),
	            cuenta.getPuntosCuenta()
	        };
	        modelo.addRow(fila);
	    }
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			do_textField_keyTyped(e);
		}
	}
	protected void do_textField_keyTyped(KeyEvent e) {
		actualizarTablaClientesPorNombre(txtBuscar.getText());
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try {
			int fila = table.getSelectedRow();
		    if (fila >= 0) {
		        String dni = table.getValueAt(fila, 1).toString(); // columna DNI
		        String nombreString = table.getValueAt(fila, 0).toString();
		        

		        int opcion = JOptionPane.showConfirmDialog(null, 
		                        "¿Estás seguro de eliminar al proveedor: " + nombreString + "?", 
		                        "Confirmar eliminación", 
		                        JOptionPane.YES_NO_OPTION);

		        if (opcion != JOptionPane.YES_OPTION) {
		            return; 
		        }

		        boolean exito = ArregloCliente.deshabilitarClienteRegisPorDNI(dni);

		        if (exito) {
		        	actualizarTablaClientesPorNombre("");
		            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
		            cargarClientesRegistrados(); // vuelve a cargar la tabla
		        } else {
		            JOptionPane.showMessageDialog(null, "No se pudo deshabilitar. ¿Ya está deshabilitado?");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Seleccione una fila primero.");
		    }
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		 int fila = table.getSelectedRow();
	        if (fila >= 0) {
	            String nombre = table.getValueAt(fila, 0).toString();
	            String dni = table.getValueAt(fila, 1).toString();

	            // Buscar ClienteCuenta completo
	            ClienteCuenta cuenta = ArregloCliente.buscarClienteRegisPorDNI(dni);
	            if (cuenta != null) {
	                clienteGUI.setClienteDesdeSeleccion(cuenta.getCli());
	                dispose(); // cerrar ventana actual
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Selecciona una fila primero.");
	        }
	}
}
