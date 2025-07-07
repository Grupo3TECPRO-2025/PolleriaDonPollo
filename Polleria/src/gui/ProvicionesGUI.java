package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloAdministrador;
import Arraylist.ArregloMateriaPrima;
import Arraylist.ArregloOrden;
import Arraylist.ArregloPedido;
import Arraylist.ArregloProveedor;
import Arraylist.ArregloTrabajador;
import Arraylist.ArregloUsuario;
import DatosPersonales.Administrador;
import DatosPersonales.Proveedor;
import DatosPersonales.Trabajador;
import Gestiones.DetalleOrdenCompra;
import Gestiones.OrdenCompra;
import Gestiones.Pedido;
import Gestiones.Usuario;
import Inventario.MateriaPrima;
import Inventario.PlatoConsumo;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ProvicionesGUI extends JFrame implements ActionListener, KeyListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JButton btnEnviar;
	private JPanel panel_1;
	private JLabel lblNewLabel_2_1_3;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2_1_2;
	private JTextField txtCant;
	private JComboBox cbxMateriaPrima;
	private JTable tbOrden;
	private JLabel lblNewLabel_5;
	private JButton btnAgregar;
	private JPanel panel_3;
	private JScrollPane scrollPane_2;
	private JTable tbOrdenHistorial;
	private JComboBox cbxOrdenH;
	private JTextField txtFiltrar;
	private JButton btnActualizarOrden;
	private JButton btnVerDetalleOrden;
	private JLabel lblNewLabel_1;
	private JTextField txtBuscar;
	private JComboBox cbxBuscar;
	private JPanel panel;
	private JLabel lblNewLabel_2_1;
	private JTextField txtRUC;
	private JTextField txtEmpresa;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_6;
	private JTextField txtDireccion;
	private JButton btnVolver;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	Usuario user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProvicionesGUI frame = new ProvicionesGUI(null);
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
	public ProvicionesGUI(Usuario user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 769);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteGUI.class.getResource("/img/DonPollo.jpg")));
		setTitle("Polleria Don Pollo");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("RELLENAR INVENTARIO");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 31));
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setBounds(117, 20, 398, 50);
			contentPane.add(lblNewLabel);
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Buscar Empresa", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_1.setBackground(new Color(250, 245, 245));
			panel_1.setBounds(22, 86, 242, 112);
			contentPane.add(panel_1);
			{
				lblNewLabel_2_1_3 = new JLabel("Ingresar empresa nombre:");
				lblNewLabel_2_1_3.setBounds(24, 21, 187, 14);
				panel_1.add(lblNewLabel_2_1_3);
			}
			{
				txtBuscar = new JTextField();
				txtBuscar.addKeyListener(this);
				txtBuscar.setBounds(24, 46, 187, 20);
				panel_1.add(txtBuscar);
				txtBuscar.setColumns(10);
			}
			{
				cbxBuscar = new JComboBox();
				cbxBuscar.addItemListener(this);
				cbxBuscar.setBounds(24, 77, 187, 22);
				panel_1.add(cbxBuscar);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_2.setBackground(new Color(250, 245, 245));
			panel_2.setBounds(22, 209, 587, 259);
			contentPane.add(panel_2);
			{
				lblNewLabel_3 = new JLabel("Cantidad");
				lblNewLabel_3.setBounds(22, 93, 108, 20);
				panel_2.add(lblNewLabel_3);
			}
			{
				lblNewLabel_2_1_2 = new JLabel("Provición");
				lblNewLabel_2_1_2.setBounds(22, 26, 138, 14);
				panel_2.add(lblNewLabel_2_1_2);
			}
			{
				txtCant = new JTextField();
				txtCant.setColumns(10);
				txtCant.setBounds(22, 112, 75, 20);
				panel_2.add(txtCant);
			}
			{
				cbxMateriaPrima = new JComboBox();
				cbxMateriaPrima.setBounds(21, 50, 103, 20);
				panel_2.add(cbxMateriaPrima);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(156, 51, 271, 192);
				panel_2.add(scrollPane);
				{
					tbOrden = new JTable();
					tbOrden.setFillsViewportHeight(true);
					tbOrden.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"N\u00B0", "Producto", "Cantidad"
						}
					));
					tbOrden.getColumnModel().getColumn(0).setPreferredWidth(10);
					tbOrden.getColumnModel().getColumn(1).setPreferredWidth(100);
					tbOrden.getColumnModel().getColumn(2).setPreferredWidth(100);
					scrollPane.setViewportView(tbOrden);
				}
			}
			{
				lblNewLabel_5 = new JLabel("DETALLES DE PROVICIÓN");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
				lblNewLabel_5.setBounds(170, 20, 255, 24);
				panel_2.add(lblNewLabel_5);
			}
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(this);
				btnAgregar.setBounds(22, 157, 89, 30);
				panel_2.add(btnAgregar);
			}
			{
				btnEnviar = new JButton("Enviar");
				btnEnviar.addActionListener(this);
				btnEnviar.setBounds(450, 119, 108, 35);
				panel_2.add(btnEnviar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(22, 198, 89, 30);
				panel_2.add(btnEliminar);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"HISTORIAL DE ORDENES", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_3.setBackground(new Color(250, 245, 245));
			panel_3.setBounds(22, 479, 587, 240);
			contentPane.add(panel_3);
			{
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(21, 36, 392, 176);
				panel_3.add(scrollPane_2);
				{
					tbOrdenHistorial = new JTable();
					tbOrdenHistorial.setFillsViewportHeight(true);
					scrollPane_2.setViewportView(tbOrdenHistorial);
					tbOrdenHistorial.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"N\u00B0", "Empresa Nombre", "RUC", "Fecha"
							}
						));
					tbOrdenHistorial.getColumnModel().getColumn(0).setMaxWidth(40);
					tbOrdenHistorial.getColumnModel().getColumn(1).setPreferredWidth(120);
					tbOrdenHistorial.getColumnModel().getColumn(2).setPreferredWidth(120);
					tbOrdenHistorial.getColumnModel().getColumn(3).setPreferredWidth(120);
				}
			}
			{
				cbxOrdenH = new JComboBox();
				cbxOrdenH.setModel(new DefaultComboBoxModel(new String[] {"RUC", "Nombre Empresa", "fecha (dd-mm-yy)"}));
				cbxOrdenH.setBounds(437, 62, 125, 22);
				panel_3.add(cbxOrdenH);
			}
			{
				txtFiltrar = new JTextField();
				txtFiltrar.addKeyListener(this);
				txtFiltrar.setColumns(10);
				txtFiltrar.setBounds(437, 96, 125, 20);
				panel_3.add(txtFiltrar);
			}
			{
				btnActualizarOrden = new JButton("Actualizar Datos");
				btnActualizarOrden.setBounds(437, 127, 125, 27);
				panel_3.add(btnActualizarOrden);
			}
			{
				btnVerDetalleOrden = new JButton("Ver Detalle");
				btnVerDetalleOrden.setBounds(438, 167, 124, 27);
				panel_3.add(btnVerDetalleOrden);
			}
			{
				lblNewLabel_1 = new JLabel("Elige una opción");
				lblNewLabel_1.setBounds(436, 36, 164, 15);
				panel_3.add(lblNewLabel_1);
			}
		}
		{
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Empresa", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel.setBackground(new Color(250, 245, 245));
			panel.setBounds(286, 86, 324, 113);
			contentPane.add(panel);
			{
				lblNewLabel_2_1 = new JLabel("RUC:");
				lblNewLabel_2_1.setBounds(24, 21, 114, 14);
				panel.add(lblNewLabel_2_1);
			}
			{
				txtRUC = new JTextField();
				txtRUC.setEditable(false);
				txtRUC.setColumns(10);
				txtRUC.setBounds(23, 40, 128, 20);
				panel.add(txtRUC);
			}
			{
				txtEmpresa = new JTextField();
				txtEmpresa.setEditable(false);
				txtEmpresa.setColumns(10);
				txtEmpresa.setBounds(23, 78, 128, 20);
				panel.add(txtEmpresa);
			}
			{
				lblNewLabel_2 = new JLabel("Nombre Empresa");
				lblNewLabel_2.setBounds(23, 61, 115, 14);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_4 = new JLabel("Teléfono");
				lblNewLabel_4.setBounds(176, 21, 115, 14);
				panel.add(lblNewLabel_4);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(176, 40, 128, 20);
				panel.add(txtTelefono);
			}
			{
				lblNewLabel_6 = new JLabel("Dirección");
				lblNewLabel_6.setBounds(177, 61, 115, 14);
				panel.add(lblNewLabel_6);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(176, 77, 128, 20);
				panel.add(txtDireccion);
			}
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(25, 27, 103, 38);
			contentPane.add(btnVolver);
		}
		{
			lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setBounds(153, 6, 67, 62);
			contentPane.add(lblNewLabel_8);
		}
		{
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon(new ImageIcon(ClienteGUI.class.getResource
					("/img/DonPollo.jpg")).getImage().getScaledInstance(70, 62, Image.SCALE_FAST)));
			lblNewLabel_9.setBounds(544, 13, 67, 62);
			contentPane.add(lblNewLabel_9);
		}
		buscar("");
		ListarMateriales();
		RellenarDatos();
		listarHistorialOrdenes(ArregloOrden.buscarOrdenesPorNombreEmpresa(""));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			do_btnEnviar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}
	private ArrayList<DetalleOrdenCompra> detalleOrdenCompras = new ArrayList<DetalleOrdenCompra>();
	private JButton btnEliminar;
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		
		try {
			
			int cantidad = Integer.parseInt(txtCant.getText());
			int materiaID = ArregloMateriaPrima.consultarMateriaPrima(cbxMateriaPrima.getSelectedItem().toString()).getFirst().getMateriaid();
			String nombreMateria = cbxMateriaPrima.getSelectedItem().toString();
			
			MateriaPrima insumo = new MateriaPrima(materiaID,nombreMateria, 0);
			DetalleOrdenCompra consumo = new DetalleOrdenCompra(null,insumo, cantidad);

	        for (DetalleOrdenCompra p : detalleOrdenCompras) {
	            if (p.getMateriaPrima().getMateriaid() == consumo.getMateriaPrima().getMateriaid()) {
	                JOptionPane.showMessageDialog(null, "La insumo ya ha sido agregada.");
	                return;
	            }
	        }

			
			detalleOrdenCompras.add(consumo);			
			JOptionPane.showMessageDialog(this, "Se agregó el insumo");
			
			int n= 1;
			DefaultTableModel modelo = (DefaultTableModel) tbOrden.getModel();
		        modelo.setRowCount(0); // limpiar la tabla

		        for (DetalleOrdenCompra p : detalleOrdenCompras) {
		            modelo.addRow(new Object[] {  n, p.getMateriaPrima().getNombre() , p.getCantidad()  });
		            n++;
		     }

			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Escribe una cantidad valida");
		}
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		this.dispose();
		AdministradorGUI volver = new AdministradorGUI(user);
		volver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volver.setVisible(true);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltrar) {
			do_txtFiltrar_keyReleased(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			do_txtBuscar_keyTyped(e);
		}
	}
	protected void do_txtBuscar_keyTyped(KeyEvent e) {
		buscar(txtBuscar.getText());
	}
	
	void buscar(String nom) {
		ArrayList<Proveedor> lista = ArregloProveedor.buscarProveedorPorNombre(nom);
		cbxBuscar.removeAllItems();
		
		for (Proveedor proveedor : lista) {
			cbxBuscar.addItem(proveedor.getNombreEmpresa());
		}
	}
	void RellenarDatos() {
		txtRUC.setText(ArregloProveedor.buscarProveedorPorNombre(cbxBuscar.getSelectedItem().toString()).getFirst().getRUC());
		txtDireccion.setText(ArregloProveedor.buscarProveedorPorNombre(cbxBuscar.getSelectedItem().toString()).getFirst().getDireccion());
		txtEmpresa.setText(ArregloProveedor.buscarProveedorPorNombre(cbxBuscar.getSelectedItem().toString()).getFirst().getNombreEmpresa());
		txtTelefono.setText(""+ArregloProveedor.buscarProveedorPorNombre(cbxBuscar.getSelectedItem().toString()).getFirst().getTelefono());
	}
	
	void ListarMateriales() {
		cbxMateriaPrima.removeAllItems();
		for (MateriaPrima m : ArregloProveedor.listarProvisionesPorProveedor(ArregloProveedor.buscarProveedorPorNombre(cbxBuscar.getSelectedItem().toString()).getFirst().getRUC())) {
			cbxMateriaPrima.addItem(m.getNombre());	
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbxBuscar) {
			do_cbxBuscar_itemStateChanged(e);
		}
	}
	protected void do_cbxBuscar_itemStateChanged(ItemEvent e) {
		RellenarDatos();
		ListarMateriales();
		detalleOrdenCompras.clear();
		((DefaultTableModel) tbOrden.getModel()).setRowCount(0); 
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		int filaSeleccionada = tbOrden.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) tbOrden.getModel();
            modelo.removeRow(filaSeleccionada);
            detalleOrdenCompras.remove(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.");
        }
		
	}
	protected void do_btnEnviar_actionPerformed(ActionEvent e) {
		try {
	        if (detalleOrdenCompras.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Debe agregar al menos un insumo para registrar la orden.");
	            return;
	        }

	        Proveedor proveedor = ArregloProveedor.buscarProveedorPorNombre(cbxBuscar.getSelectedItem().toString()).getFirst();
	        Administrador administrador = ArregloAdministrador.obtenerAdministrador(user.getUser());
	        OrdenCompra orden = new OrdenCompra(0, proveedor, administrador);
	        

	        orden.setListaDetalleOrdenCompras(detalleOrdenCompras);
	    
	        
	        ArregloOrden.registrarOrdenCompra(orden);

	        JOptionPane.showMessageDialog(this, "Orden registrada correctamente.");
	        detalleOrdenCompras.clear();
	        ((DefaultTableModel) tbOrden.getModel()).setRowCount(0); 

	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la orden."+ex);
	    }
		
	}
	protected void do_txtFiltrar_keyReleased(KeyEvent e) {
		try {
			int fila = cbxOrdenH.getSelectedIndex();
			ArrayList<OrdenCompra> listaOrdenes = new ArrayList<OrdenCompra>();
			switch (fila) {
			case 0: {
				listaOrdenes = ArregloOrden.buscarOrdenesPorRUCProveedor(txtFiltrar.getText());
				break;
			}case 1:{
				listaOrdenes = ArregloOrden.buscarOrdenesPorNombreEmpresa(txtBuscar.getText());
				break;
			}case 2:{
				listaOrdenes = ArregloOrden.buscarOrdenesPorFecha(txtBuscar.getText());
				break;
			}
			default:
				break;
			}
			
			listarHistorialOrdenes(listaOrdenes);
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	void listarHistorialOrdenes(ArrayList<OrdenCompra> lista) {

		DefaultTableModel modelo = (DefaultTableModel) tbOrdenHistorial.getModel();
	    modelo.setRowCount(0); // Limpiar la tabla antes de llenar

	    int nro = 1;
	    for (OrdenCompra p : lista) {
	        
	        
	        modelo.addRow(new Object[]{
    	            nro,
    	            p.getProveedor().getNombreEmpresa(),
    	            p.getProveedor().getRUC(),
    	            p.getFechaEmision() // Este debe ser java.sql.Date
    	        });
	        nro++;
	        
	     
	    }
	    	
	}
}
