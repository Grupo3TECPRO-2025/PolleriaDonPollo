package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloMateriaPrima;
import Arraylist.ArregloProveedor;
import DatosPersonales.Proveedor;
import Gestiones.Usuario;
import Inventario.MateriaPrima;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegistroProveedoresGUI extends JFrame implements ActionListener, ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblRuc;
	private JLabel lblTelfono;
	private JLabel lblDireccin;
	private JTextField txtNombreEmpresa;
	private JTextField txtRUC;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_1;
	private JLabel lblTipoDeProvicin;
	private JComboBox cbxTipoProvicion;
	private JButton btnAregar;
	private JPanel panel_1;
	private JLabel lblIngreseElRuc;
	private JLabel lblTelfono_1;
	private JLabel lblDireccin_1;
	private JTextField txtTelefonoM;
	private JTextField txtNombreM;
	private JButton btnModificar;
	private JComboBox cbxNombreEmpresa;
	private JLabel lblNewLabel_3;
	private JTextField txtDireccionM;
	private JButton btnEliminarf;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblCargarALa;
	DefaultTableModel modelo;
	private ArrayList<MateriaPrima> mPrimas;
	private ArrayList<MateriaPrima> proveedorPrimas;
	Usuario user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroProveedoresGUI frame = new RegistroProveedoresGUI(null);
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
	public RegistroProveedoresGUI(Usuario user) {
		this.user = user;
		proveedorPrimas = new ArrayList<MateriaPrima>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(10, 64, 657, 215);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setBounds(10, 26, 83, 13);
				panel.add(lblNewLabel);
			}
			{
				lblRuc = new JLabel("RUC:");
				lblRuc.setBounds(10, 60, 83, 13);
				panel.add(lblRuc);
			}
			{
				lblTelfono = new JLabel("Teléfono:");
				lblTelfono.setBounds(264, 26, 83, 13);
				panel.add(lblTelfono);
			}
			{
				lblDireccin = new JLabel("Dirección:");
				lblDireccin.setBounds(264, 60, 83, 13);
				panel.add(lblDireccin);
			}
			{
				txtNombreEmpresa = new JTextField();
				txtNombreEmpresa.setBounds(103, 23, 96, 19);
				panel.add(txtNombreEmpresa);
				txtNombreEmpresa.setColumns(10);
			}
			{
				txtRUC = new JTextField();
				txtRUC.setColumns(10);
				txtRUC.setBounds(103, 57, 96, 19);
				panel.add(txtRUC);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(320, 23, 96, 19);
				panel.add(txtTelefono);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(320, 57, 96, 19);
				panel.add(txtDireccion);
			}
			{
				lblNewLabel_1 = new JLabel("................................................................................................................................................................................................................................................................................................................................................");
				lblNewLabel_1.setBounds(0, 86, 696, 13);
				panel.add(lblNewLabel_1);
			}
			{
				lblTipoDeProvicin = new JLabel("Tipo de provición:");
				lblTipoDeProvicin.setBounds(10, 111, 140, 13);
				panel.add(lblTipoDeProvicin);
			}
			{
				cbxTipoProvicion = new JComboBox();
				cbxTipoProvicion.addItemListener(this);
				cbxTipoProvicion.setBounds(10, 134, 173, 21);
				panel.add(cbxTipoProvicion);
			}
			{
				btnAregar = new JButton("AGREGAR");
				btnAregar.addActionListener(this);
				btnAregar.setBounds(10, 176, 113, 29);
				panel.add(btnAregar);
			}
			{
				btnEliminarf = new JButton("ELIMINAR");
				btnEliminarf.addActionListener(this);
				btnEliminarf.setBounds(130, 176, 113, 29);
				panel.add(btnEliminarf);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(253, 109, 246, 96);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Nombre"
						}
					));
					table.addMouseListener(this);
					scrollPane.setViewportView(table);
				}
			}
			{
				btnEnviar = new JButton("ENVIAR");
				btnEnviar.addActionListener(this);
				btnEnviar.setBounds(516, 166, 113, 29);
				panel.add(btnEnviar);
			}
			{
				lblCargarALa = new JLabel("Registrar:");
				lblCargarALa.setBounds(537, 134, 63, 21);
				panel.add(lblCargarALa);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(10, 289, 657, 133);
			contentPane.add(panel_1);
			{
				lblIngreseElRuc = new JLabel("Nombre de la empresa:");
				lblIngreseElRuc.setBounds(10, 26, 171, 13);
				panel_1.add(lblIngreseElRuc);
			}
			{
				lblTelfono_1 = new JLabel("Teléfono:");
				lblTelfono_1.setBounds(20, 88, 83, 13);
				panel_1.add(lblTelfono_1);
			}
			{
				lblDireccin_1 = new JLabel("Dirección:");
				lblDireccin_1.setBounds(291, 59, 83, 13);
				panel_1.add(lblDireccin_1);
			}
			{
				txtTelefonoM = new JTextField();
				txtTelefonoM.setColumns(10);
				txtTelefonoM.setBounds(93, 85, 150, 19);
				panel_1.add(txtTelefonoM);
			}
			{
				txtNombreM = new JTextField();
				txtNombreM.setColumns(10);
				txtNombreM.setBounds(93, 56, 150, 19);
				panel_1.add(txtNombreM);
			}
			{
				btnModificar = new JButton("MODIFICAR");
				btnModificar.addActionListener(this);
				btnModificar.setBounds(336, 91, 113, 29);
				panel_1.add(btnModificar);
			}
			{
				cbxNombreEmpresa = new JComboBox();
				cbxNombreEmpresa.addItemListener(this);
				cbxNombreEmpresa.setBounds(160, 22, 150, 21);
				panel_1.add(cbxNombreEmpresa);
			}
			{
				lblNewLabel_3 = new JLabel("Nombre:");
				lblNewLabel_3.setBounds(20, 59, 72, 13);
				panel_1.add(lblNewLabel_3);
			}
			{
				txtDireccionM = new JTextField();
				txtDireccionM.setColumns(10);
				txtDireccionM.setBounds(368, 56, 150, 19);
				panel_1.add(txtDireccionM);
			}
			{
				btnEliminar_1 = new JButton("ELIMINAR");
				btnEliminar_1.addActionListener(this);
				btnEliminar_1.setBounds(484, 91, 113, 29);
				panel_1.add(btnEliminar_1);
			}
			{
				txtRUCM = new JTextField();
				txtRUCM.setEditable(false);
				txtRUCM.setColumns(10);
				txtRUCM.setBounds(393, 23, 223, 19);
				panel_1.add(txtRUCM);
			}
			{
				lblNewLabel_4 = new JLabel("RUC");
				lblNewLabel_4.setBounds(352, 25, 46, 14);
				panel_1.add(lblNewLabel_4);
			}
		}
		{
			lblNewLabel_2 = new JLabel("REGISTRAR PROVEEDORES");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_2.setBounds(178, 17, 329, 30);
			contentPane.add(lblNewLabel_2);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(13, 16, 91, 36);
			contentPane.add(btnVolver);
		}
		
		mPrimas = ArregloMateriaPrima.listarMateriaPrima();
		
		for (MateriaPrima mPrima : mPrimas) {
			cbxTipoProvicion.addItem(mPrima.getNombre());
		}
		
		proveedores = ArregloProveedor.listarProveedores();
		for (Proveedor pro : proveedores) {
			cbxNombreEmpresa.addItem(pro.getNombreEmpresa());
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar_1) {
			do_btnEliminar_1_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEnviar) {
			do_btnEnviar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarf) {
			do_btnEliminarf_actionPerformed(e);
		}
		if (e.getSource() == btnAregar) {
			do_btnAregar_actionPerformed(e);
		}
	}
	ArrayList<Proveedor> proveedores=new ArrayList<>();
	private JButton btnEliminar_1;
	private JTextField txtRUCM;
	private JLabel lblNewLabel_2;
	private JButton btnVolver;
	private JLabel lblNewLabel_4;
	protected void do_btnAregar_actionPerformed(ActionEvent e) {
		try {
		    String nombre = txtNombreEmpresa.getText().trim();
		    String ruc = txtRUC.getText().trim();
		    String telefono = txtTelefono.getText().trim();
		    String direccion = txtDireccion.getText().trim();
		    String tipoProvidencia = (String) cbxTipoProvicion.getSelectedItem();

		    if (nombre.isEmpty() || ruc.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Completa todos los campos del proveedor antes de agregar una provisión.");
		        return;
		    }

		    if (tipoProvidencia == null || tipoProvidencia.trim().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Selecciona un tipo de provisión válida.");
		        return;
		    }
		    
		    MateriaPrima nueva = ArregloMateriaPrima.consultarMateriaPrima(tipoProvidencia).getFirst();

	        // Evitar duplicados
	        for (MateriaPrima mp : proveedorPrimas) {
	            if (mp.getMateriaid() == nueva.getMateriaid()) {
	                JOptionPane.showMessageDialog(null, "La materia prima ya ha sido agregada.");
	                return;
	            }
	        }

	        proveedorPrimas.add(nueva);
	        

	        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	        modelo.setRowCount(0); // limpiar la tabla

	        for (MateriaPrima mp : proveedorPrimas) {
	            modelo.addRow(new Object[] { mp.getNombre() });
	        }



		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar la categoría: " + ex.getMessage());
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbxNombreEmpresa) {
			do_cbxNombreEmpresa_itemStateChanged(e);
		}
		if (e.getSource() == cbxTipoProvicion) {
			do_cbxTipoProvicion_itemStateChanged(e);
		}
	}
	protected void do_cbxTipoProvicion_itemStateChanged(ItemEvent e) {
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
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
		
	}
	protected void do_btnEliminarf_actionPerformed(ActionEvent e) {
		int filaSeleccionada = table.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) table.getModel();
            modelo.removeRow(filaSeleccionada);
            proveedorPrimas.remove(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.");
        }
	}
	protected void do_btnEnviar_actionPerformed(ActionEvent e) {
		try {
		    String nombre = txtNombreEmpresa.getText().trim();
		    String ruc = txtRUC.getText().trim();
		    int telefono = Integer.parseInt(txtTelefono.getText().trim());
		    String direccion = txtDireccion.getText().trim();

		    proveedores = ArregloProveedor.listarProveedores();
		    
		    if (nombre.isEmpty() || ruc.isEmpty() || txtTelefono.getText().isEmpty() || direccion.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Completa todos los campos del proveedor.");
		        return;
		    }

		    ArrayList<String> tipos = new ArrayList<>();
		    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		    for (int i = 0; i < modelo.getRowCount(); i++) {
		        String tipo = modelo.getValueAt(i, 0).toString().trim();
		        tipos.add(tipo);
		    }

		    if (tipos.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Debe agregar al menos una categoría de provisión.");
		        return;
		    }

		    for (Proveedor p : proveedores) {
		        if (p.getNombreEmpresa().equalsIgnoreCase(nombre)) {
		            JOptionPane.showMessageDialog(null, "El proveedor '" + nombre + "' ya fue registrado.");
		            return;
		        }
		    }

		    Proveedor proveedor = new Proveedor(ruc, nombre, direccion, telefono);
		    proveedor.setTipoProvicion(proveedorPrimas);
		    
		    ArregloProveedor.RegistrarProveedor(proveedor);
		    
		    cbxNombreEmpresa.removeAllItems();
		    
		    //LIMPIANDO VALORES
		    proveedorPrimas.clear();
		    
		    
		    proveedores = ArregloProveedor.listarProveedores();
		    for (Proveedor pro : proveedores) {
				cbxNombreEmpresa.addItem(pro.getNombreEmpresa());
			}
		    
		   

		    JOptionPane.showMessageDialog(null, "Proveedor almacenado correctamente.");

		    txtNombreEmpresa.setText("");
		    txtRUC.setText("");
		    txtTelefono.setText("");
		    txtDireccion.setText("");
		    modelo.setRowCount(0); 

		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "Error al guardar el proveedor: " + ex.getMessage());
		}
	}
	protected void do_cbxNombreEmpresa_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
	        String nombreSeleccionado = (String) cbxNombreEmpresa.getSelectedItem();

	        for (Proveedor p : proveedores) {
	            if (p.getNombreEmpresa().equals(nombreSeleccionado)) {
	                txtNombreM.setText(p.getNombreEmpresa());
	                txtRUCM.setText(p.getRUC());
	                txtTelefonoM.setText(""+p.getTelefono());
	                txtDireccionM.setText(p.getDireccion());
	                break;
	            }
	        }
	    }
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
	        String nombre = txtNombreM.getText().trim();
	        String ruc = txtRUCM.getText().trim();
	        int telefono =Integer.parseInt( txtTelefonoM.getText().trim());
	        String direccion = txtDireccionM.getText().trim();
	        String nombreSeleccionado = (String) cbxNombreEmpresa.getSelectedItem();

	        if (nombreSeleccionado == null) {
	            JOptionPane.showMessageDialog(null, "Selecciona un proveedor en el combo para modificar.");
	            return;
	        }

	        if (nombre.isEmpty() || ruc.isEmpty() || txtTelefono.getText().isEmpty() || direccion.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Completa todos los campos para modificar el proveedor.");
	            return;
	        }

	        boolean modificado = false;
	        Proveedor promodificado = new Proveedor(ruc, nombre, direccion, telefono);
	        if(ArregloProveedor.modificarProveedorPorNombre(nombreSeleccionado, promodificado)){
	        	cbxNombreEmpresa.removeItem(nombreSeleccionado);
		        JOptionPane.showMessageDialog(null, "Proveedor modificado correctamente.");
		         
		        
		         
	        }else {
	            JOptionPane.showMessageDialog(null, "Proveedor no encontrado en la lista.");
	        }
	        
	       
	    

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar: ");
	    }
	}
	
	protected void do_btnEliminar_1_actionPerformed(ActionEvent e) {
		try {
	        String nombreSeleccionado = (String) cbxNombreEmpresa.getSelectedItem();

	        if (nombreSeleccionado == null) {
	            JOptionPane.showMessageDialog(null, "Selecciona un proveedor para eliminar.");
	            return;
	        }

	        int opcion = JOptionPane.showConfirmDialog(null, 
	                        "¿Estás seguro de eliminar al proveedor: " + nombreSeleccionado + "?", 
	                        "Confirmar eliminación", 
	                        JOptionPane.YES_NO_OPTION);

	        if (opcion != JOptionPane.YES_OPTION) {
	            return; 
	        }


	        if(ArregloProveedor.EliminarProveedor(nombreSeleccionado)) {
	        	txtNombreM.setText("");
	            txtRUCM.setText("");
	            txtTelefonoM.setText("");
	            txtDireccionM.setText("");
	            
	            JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.");
	            cbxNombreEmpresa.removeAllItems();
	            
	            proveedores = ArregloProveedor.listarProveedores();
	            for (Proveedor pro : proveedores) {
	    			cbxNombreEmpresa.addItem(pro.getNombreEmpresa());
	    		}
	            

	        }else {
	            JOptionPane.showMessageDialog(null, "No se encontró el proveedor en la lista.");

	        }


	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar: " + ex.getMessage());
	    }
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		this.dispose();
		AdministradorGUI volver = new AdministradorGUI(user);
		volver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volver.setVisible(true);
	}
	
	void ActualizarNombreEmpresas() {
		cbxNombreEmpresa.removeAllItems();
        proveedores = ArregloProveedor.listarProveedores();
 		for (Proveedor pro : proveedores) {
 			cbxNombreEmpresa.addItem(pro.getNombreEmpresa());
 		}
         	
	}
}
