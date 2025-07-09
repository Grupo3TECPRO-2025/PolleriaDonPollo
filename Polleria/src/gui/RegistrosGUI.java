package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloAdministrador;
import Arraylist.ArregloCliente;
import Arraylist.ArregloPedido;
import Arraylist.ArregloPersona;
import Arraylist.ArregloTrabajador;
import Arraylist.ArregloUsuario;
import CartaPolleria.MenuProducto;
import DatosPersonales.Administrador;
import DatosPersonales.Cliente;
import DatosPersonales.Trabajador;
import Gestiones.DetallePedido;
import Gestiones.Pedido;
import Gestiones.Usuario;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class RegistrosGUI extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblReportes;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtNumPedidos;
	private JButton btnActualizar;
	private JScrollPane scrollPane;
	private JTable tbPedidoHistorial;
	private JButton btnListar;
	private JLabel lblAdministradorPolleria;
	private JPanel panel_2;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2_1;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JPanel panel_3;
	private JTextField txtGanancias;
	private JLabel lblNewLabel_8;
	private JScrollPane scrollPane_1;
	private JTextArea txtProductoModa;
	private JButton btnVerCarta;
	private JButton btnVerDetallePedido;
	private JTextField txtBuscar;
	private JComboBox cbxPedidoH;
	private JLabel lblNewLabel_4;
	private JButton btnAgregarPlato;
	private JButton btnActualizarPedido;
	private JButton btnAgregarMateriaPrima;
	private JButton btnVolver;
	private Usuario user;
	private ListarInventarioGUI listar;
	private AgregarPlatoGUI platos;
	private ListarPlatosGUI listarPlatos;
	private AgregarMateriaPrima agregearMateriaPrima;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrosGUI frame = new RegistrosGUI(null);
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
	public RegistrosGUI(Usuario user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 785, 574);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(new Color(211, 185, 175));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(233, 209, 209));
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel.setBounds(22, 220, 710, 86);
			panel.setBackground(new Color(255, 250, 250));
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Gestion de Inventario / Stock");
				lblNewLabel.setBounds(202, 11, 255, 24);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
			}
			{
				btnListar = new JButton("Listar Inventario");
				btnListar.addActionListener(this);
				btnListar.setBounds(10, 40, 129, 35);
				panel.add(btnListar);
			}
			{
				btnAgregarPlato = new JButton("Agregar/Modificar Plato");
				btnAgregarPlato.addActionListener(this);
				btnAgregarPlato.setBounds(313, 40, 174, 35);
				panel.add(btnAgregarPlato);
			}
			{
				btnAgregarMateriaPrima = new JButton("Agregar Materia Prima");
				btnAgregarMateriaPrima.addActionListener(this);
				btnAgregarMateriaPrima.setBounds(511, 40, 174, 35);
				panel.add(btnAgregarMateriaPrima);
			}
			{
				btnListarPlatos = new JButton("Listar Platos");
				btnListarPlatos.addActionListener(this);
				btnListarPlatos.setBounds(160, 40, 129, 35);
				panel.add(btnListarPlatos);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 250, 250));
			panel_1.setLayout(null);
			panel_1.setBounds(22, 318, 710, 198);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			contentPane.add(panel_1);
			{
				lblReportes = new JLabel("PEDIDOS HISTORIAL");
				lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
				lblReportes.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
				lblReportes.setBounds(178, 17, 197, 24);
				panel_1.add(lblReportes);
			}
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(17, 44, 539, 135);
				panel_1.add(scrollPane);
				{
					tbPedidoHistorial = new JTable();
					tbPedidoHistorial.setFillsViewportHeight(true);
					tbPedidoHistorial.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Venta ID", "cliente", "DNI", "Trabajador", "fecha"
						}
					));
					tbPedidoHistorial.getColumnModel().getColumn(0).setPreferredWidth(50);
					tbPedidoHistorial.getColumnModel().getColumn(1).setPreferredWidth(100);
					tbPedidoHistorial.getColumnModel().getColumn(2).setPreferredWidth(120);
					tbPedidoHistorial.getColumnModel().getColumn(3).setPreferredWidth(120);
					tbPedidoHistorial.getColumnModel().getColumn(4).setPreferredWidth(120);
					scrollPane.setViewportView(tbPedidoHistorial);
				}
			}
			{
				btnVerDetallePedido = new JButton("Ver Detalle");
				btnVerDetallePedido.addActionListener(this);
				btnVerDetallePedido.setBounds(567, 152, 125, 27);
				panel_1.add(btnVerDetallePedido);
			}
			{
				txtBuscar = new JTextField();
				txtBuscar.addKeyListener(this);
				txtBuscar.setColumns(10);
				txtBuscar.setBounds(567, 95, 125, 20);
				panel_1.add(txtBuscar);
			}
			{
				cbxPedidoH = new JComboBox();
				cbxPedidoH.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "DNI", "Fecha (dd-mm-yy)", "Trabajador nombre"}));
				cbxPedidoH.setBounds(566, 68, 125, 22);
				panel_1.add(cbxPedidoH);
			}
			{
				lblNewLabel_4 = new JLabel("Elige una opcion ");
				lblNewLabel_4.setBounds(566, 44, 164, 15);
				panel_1.add(lblNewLabel_4);
			}
			{
				btnActualizarPedido = new JButton("Actualizar");
				btnActualizarPedido.addActionListener(this);
				btnActualizarPedido.setBounds(567, 120, 125, 27);
				panel_1.add(btnActualizarPedido);
			}
		}
		{
			lblAdministradorPolleria = new JLabel("REGISTROS - POLLERIA DON POLLO");
			lblAdministradorPolleria.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdministradorPolleria.setBounds(122, 16, 612, 50);
			contentPane.add(lblAdministradorPolleria);
			lblAdministradorPolleria.setForeground(new Color(0, 0, 0));
			lblAdministradorPolleria.setFont(new Font("Segoe UI Black", Font.PLAIN, 34));
			lblAdministradorPolleria.setBackground(new Color(233, 209, 209));
		}
		{
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_2.setBackground(new Color(255, 250, 250));
			panel_2.setBounds(22, 77, 211, 135);
			contentPane.add(panel_2);
			{
				lblNewLabel_1_1 = new JLabel("Usuario");
				lblNewLabel_1_1.setBounds(15, 28, 108, 22);
				panel_2.add(lblNewLabel_1_1);
			}
			{
				lblNewLabel_2_1 = new JLabel("Nombre");
				lblNewLabel_2_1.setBounds(15, 72, 138, 20);
				panel_2.add(lblNewLabel_2_1);
			}
			{
				txtUsuario = new JTextField();
				txtUsuario.setEditable(false);
				txtUsuario.setColumns(10);
				txtUsuario.setBounds(15, 52, 152, 20);
				panel_2.add(txtUsuario);
				txtUsuario.setText(user.getUser());
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setColumns(10);
				txtNombre.setBounds(15, 95, 152, 20);
				panel_2.add(txtNombre);
				txtNombre.setText(ArregloPersona.obtenerPersonaPorUsuario(user.getUser()).getNombreCompleto());
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Reportes / Consultas de Ventas", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
			panel_3.setBackground(new Color(255, 250, 250));
			panel_3.setBounds(268, 79, 466, 134);
			contentPane.add(panel_3);
			{
				lblNewLabel_5 = new JLabel("Total de Pedidos");
				lblNewLabel_5.setBounds(17, 28, 100, 14);
				panel_3.add(lblNewLabel_5);
			}
			{
				txtNumPedidos = new JTextField();
				txtNumPedidos.setEditable(false);
				txtNumPedidos.setBounds(17, 46, 86, 20);
				panel_3.add(txtNumPedidos);
				txtNumPedidos.setText(""+ArregloPedido.obtenerTotalPedidos());
				txtNumPedidos.setColumns(10);
			}
			{
				lblNewLabel_6 = new JLabel("Producto mas Vendido:");
				lblNewLabel_6.setBounds(165, 24, 142, 17);
				panel_3.add(lblNewLabel_6);
			}
			{
				txtGanancias = new JTextField();
				txtGanancias.setEditable(false);
				txtGanancias.setColumns(10);
				txtGanancias.setBounds(17, 91, 86, 20);
				txtGanancias.setText("S/"+ArregloPedido.obtenerGananciasTotalesConCupones());
			
				panel_3.add(txtGanancias);
			}
			{
				lblNewLabel_8 = new JLabel("Ganancias");
				lblNewLabel_8.setBounds(18, 72, 100, 14);
				panel_3.add(lblNewLabel_8);
			}
			{
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(128, 48, 205, 63);
				panel_3.add(scrollPane_1);
				{
					txtProductoModa = new JTextArea();
					scrollPane_1.setViewportView(txtProductoModa);
				}
			}
			{
				btnActualizar = new JButton("Actualizar");
				btnActualizar.addActionListener(this);
				btnActualizar.setBounds(350, 29, 100, 33);
				panel_3.add(btnActualizar);
			}
			{
				btnVerCarta = new JButton("Ver Carta");
				btnVerCarta.addActionListener(this);
				btnVerCarta.setBounds(350, 79, 100, 33);
				panel_3.add(btnVerCarta);
			}
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			btnVolver.setBounds(24, 21, 101, 38);
			contentPane.add(btnVolver);
		}

		listarHistorialPedidos(ArregloPedido.listarPedidosBasico());
		actualizarProductosMasVendidosEnLista();
		ActualizarGananciasTotales();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListarPlatos) {
			do_btnListarPlatos_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarMateriaPrima) {
			do_btnAgregarMateriaPrima_actionPerformed(e);
		}
		if (e.getSource() == btnVerCarta) {
			do_btnVerCarta_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarPlato) {
			do_btnAgregarPlato_actionPerformed(e);
		}
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnVerDetallePedido) {
			do_btnVerDetallePedido_actionPerformed(e);
		}
		if (e.getSource() == btnActualizarPedido) {
			do_btnActualizarPedido_actionPerformed(e);
		}
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		this.dispose();
		AdministradorGUI volver = new AdministradorGUI(user);
		volver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		volver.setVisible(true);
	}
	
	void listarHistorialPedidos(List<Pedido> listaPedidos) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbPedidoHistorial.getModel();
	    modelo.setRowCount(0);

	    int nro = 1;
	    for (Pedido p : listaPedidos) {
	        Usuario traba = ArregloUsuario.obtenerUsuarioTrabajadorPorPedido(p.getPedidoId());
	        Usuario admin = ArregloUsuario.obtenerUsuarioAdministradorPorPedido(p.getPedidoId());
	        
	        if(admin!=null) {
	        	Administrador administrador = ArregloAdministrador.obtenerAdministrador(admin.getUser());
	        	if(p.getCli().getDNI()==null) {
		        	modelo.addRow(new Object[]{
		    	            p.getPedidoId(),
		    	            p.getCli().getNombreCompleto(),
		    	            "Sin DNI",
		    	            administrador.getNombreCompleto(),
		    	            p.getFecha() // Este debe ser java.sql.Date
		    	        });
		        }else {
		        	modelo.addRow(new Object[]{
		    	            p.getPedidoId(),
		    	            p.getCli().getNombreCompleto(),
		    	            p.getCli().getDNI(),
		    	            administrador.getNombreCompleto(),
		    	            p.getFecha() // Este debe ser java.sql.Date
		    	        });
		        }
	        }else if(traba != null){
	        	Trabajador trabajador = ArregloTrabajador.obtenerTrabajador(traba.getUser());
	        	if(p.getCli().getDNI()==null) {
		        	modelo.addRow(new Object[]{
		    	            p.getPedidoId(),
		    	            p.getCli().getNombreCompleto(),
		    	            "Sin DNI",
		    	            trabajador.getNombreCompleto(),
		    	            p.getFecha() // Este debe ser java.sql.Date
		    	        });
		        }else {
		        	modelo.addRow(new Object[]{
		    	            p.getPedidoId(),
		    	            p.getCli().getNombreCompleto(),
		    	            p.getCli().getDNI(),
		    	            trabajador.getNombreCompleto(),
		    	            p.getFecha() 
		    	        });
		        }
	        }
	    	
	        
	    }
	}
	protected void do_btnActualizarPedido_actionPerformed(ActionEvent e) {
		try {
			List<Pedido> listaPedidos = ArregloPedido.listarPedidosBasico();
			listarHistorialPedidos(ArregloPedido.listarPedidosBasico());
			txtGanancias.setText("S/"+ArregloPedido.obtenerGananciasTotalesConCupones());
			txtNumPedidos.setText(""+ArregloPedido.obtenerTotalPedidos());
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Se actualizó el contenido");
		}
	}
	protected void do_btnVerDetallePedido_actionPerformed(ActionEvent e) {
		int filaSeleccionada = tbPedidoHistorial.getSelectedRow();
	    
		if (filaSeleccionada != -1) {
	        int pedidoID = (int) tbPedidoHistorial.getValueAt(filaSeleccionada, 0);

	        // Abrir la ventana con solo el ID
	        PedidoDetalleGUI ventana = new PedidoDetalleGUI(pedidoID);
	        ventana.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona un pedido de la tabla.");
	    }
	}
	
	private void actualizarProductosMasVendidosEnLista() {
		List<MenuProducto> productosMasVendidos = ArregloPedido.obtenerProductosMasVendidos(); 

	    StringBuilder sb = new StringBuilder();
	    int index = 1;
	    for (MenuProducto producto : productosMasVendidos) {
	        sb.append(index++)
	          .append(". ")
	          .append(producto.getNombre()) 
	          .append("\n");
	    }
	    
	    txtProductoModa.setText(sb.toString());
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		try {
			actualizarProductosMasVendidosEnLista();
			ActualizarGananciasTotales();
			listarHistorialPedidos(ArregloPedido.listarPedidosBasico());
			JOptionPane.showMessageDialog(this, "Se actualizó correctamente");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Hubo un error al momento de actualizar");
		}
		
	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		if (listar != null && listar.isDisplayable()) {
            listar.dispose();
    
        }
		listar = null;
		listar = new ListarInventarioGUI();
		listar.setVisible(true);
	}
	protected void do_btnAgregarPlato_actionPerformed(ActionEvent e) {
		if (platos != null && platos.isDisplayable()) {
            platos.dispose();
    
        }
		platos = null;
		platos = new AgregarPlatoGUI();
		platos.setVisible(true);
	}
	
	void ActualizarGananciasTotales() {
		txtGanancias.setText("S/."+ArregloPedido.obtenerGananciasTotalesConCupones());
	}
	

	private CartaGUI ventanaCarta;
	private JButton btnListarPlatos;
	protected void do_btnVerCarta_actionPerformed(ActionEvent e) {
		if (ventanaCarta == null || !ventanaCarta.isShowing()) {
	        ventanaCarta = new CartaGUI(this);
	        ventanaCarta.setVisible(true);
	    } else {
	        ventanaCarta.toFront(); // Traer al frente si ya existe
	    }
		
		
	}
	protected void do_btnAgregarMateriaPrima_actionPerformed(ActionEvent e) {

		
		if (agregearMateriaPrima != null && agregearMateriaPrima.isDisplayable()) {
			agregearMateriaPrima.dispose();
    
        }
    	
		agregearMateriaPrima  = new AgregarMateriaPrima();
		agregearMateriaPrima.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		agregearMateriaPrima.setVisible(true);
	}
	protected void do_btnListarPlatos_actionPerformed(ActionEvent e) {
		if (listarPlatos != null && listarPlatos.isDisplayable()) {
            listarPlatos.dispose();
    
        }
		listarPlatos = null;
		listarPlatos = new ListarPlatosGUI();
		listarPlatos.setVisible(true);
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			do_txtBuscar_keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		try {
			int fila = cbxPedidoH.getSelectedIndex();
			List<Pedido> listaClientes = new ArrayList<Pedido>();
			switch (fila) {
			case 0: {
				listaClientes = ArregloPedido.buscarPedidosPorNombreCliente(txtBuscar.getText());
				break;
			}case 1:{
				listaClientes = ArregloPedido.buscarPedidosPorDNICliente(txtBuscar.getText());
				break;
			}case 2:{
				listaClientes = ArregloPedido.buscarPedidosPorFecha(txtBuscar.getText());
				break;
			}
			case 3:{
				listaClientes = ArregloPedido.buscarPedidosPorNombreTrabajador(txtBuscar.getText());
			}
			default:
				break;
			}
			
			listarHistorialPedidos(listaClientes);
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	protected void do_txtBuscar_keyPressed(KeyEvent e) {
		
		
	   

	}
}


