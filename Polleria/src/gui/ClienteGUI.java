package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloAdministrador;
import Arraylist.ArregloCliente;
import Arraylist.ArregloPedido;
import Arraylist.ArregloPersona;
import Arraylist.ArregloTrabajador;
import Arraylist.Carta;
import CartaPolleria.CuponeraLista;
import CartaPolleria.Cupon;
import CartaPolleria.MenuProducto;
import DatosPersonales.Administrador;
import DatosPersonales.Cliente;
import DatosPersonales.Persona;
import DatosPersonales.Trabajador;
import Gestiones.DetallePedido;
import Gestiones.Pedido;
import Gestiones.Usuario;
import Reporte.FacturaGenerador;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.desktop.AboutHandler;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.print.attribute.standard.PDLOverrideSupported;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.nio.file.spi.FileTypeDetector;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;

public class ClienteGUI extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPedidoID;
	private JTextField txtCant;
	private JTextField txtNumPedido;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JScrollPane scrollPane;
	private JTable tbPedido;
	private JTextField txtCosto;
	private JTextField txtDni;
	private JTextField txtPromocion;
	private JButton btnAgregar;
	private JButton btnVerCarta;
	private JButton btnEliminar;
	private JButton btnCanjear;
	private Usuario user;
	private Trabajador trabajador;
	private Administrador administrador;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI frame = new ClienteGUI(null);
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
	public ClienteGUI(Usuario user) {
		this.user = user;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteGUI.class.getResource("/img/DonPollo.jpg")));
		setTitle("Polleria Don Pollo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 717);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 185, 175));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POLLERIA DON POLLO");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
		lblNewLabel.setBounds(137, 18, 408, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		panel_1.setBounds(10, 79, 398, 153);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre Completo:");
		lblNewLabel_1_1.setBounds(23, 32, 152, 20);
		panel_1.add(lblNewLabel_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(23, 56, 183, 25);
		panel_1.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(249, 56, 116, 25);
		panel_1.add(txtTelefono);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Teléfono:");
		lblNewLabel_2_1_1.setBounds(249, 30, 138, 25);
		panel_1.add(lblNewLabel_2_1_1);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(23, 114, 116, 25);
		panel_1.add(txtDni);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("DNI (Opcional):");
		lblNewLabel_2_1_1_1.setBounds(23, 92, 138, 25);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		lblNewLabel_1_2 = new JLabel("¿Desea Registrar?");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(149, 87, 108, 20);
		panel_1.add(lblNewLabel_1_2);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(161, 109, 91, 30);
		panel_1.add(btnRegistrar);
		
		lblNewLabel_1_3 = new JLabel("Buscar Cliente");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(259, 87, 108, 20);
		panel_1.add(lblNewLabel_1_3);
		
		btnBucar = new JButton("Buscar");
		btnBucar.setBounds(274, 109, 91, 30);
		panel_1.add(btnBucar);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(9, 405, 653, 176);
			contentPane.add(scrollPane);
			{
				tbPedido = new JTable();
				tbPedido.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"N\u00B0", "Detalle", "Cant.", "Precio U.", "Costo"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, Integer.class, Double.class, Double.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tbPedido.getColumnModel().getColumn(0).setPreferredWidth(5);
				tbPedido.getColumnModel().getColumn(1).setPreferredWidth(270);
				tbPedido.getColumnModel().getColumn(2).setPreferredWidth(30);
				tbPedido.getColumnModel().getColumn(3).setPreferredWidth(30);
				tbPedido.getColumnModel().getColumn(4).setPreferredWidth(40);

				scrollPane.setViewportView(tbPedido);
			}
		}
		
		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setBounds(532, 592, 129, 29);
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Costo Total");
		lblNewLabel_3.setBounds(454, 596, 68, 21);
		contentPane.add(lblNewLabel_3);
		
		btnCancelarPedido = new JButton("Eliminar Pedido");
		btnCancelarPedido.addActionListener(this);
		btnCancelarPedido.setBounds(21, 591, 144, 33);
		contentPane.add(btnCancelarPedido);
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(577, 11, 67, 62);
			contentPane.add(lblNewLabel_4);
			lblNewLabel_4.setIcon(new ImageIcon(new ImageIcon(ClienteGUI.class.getResource
					("/img/DonPollo.jpg")).getImage().getScaledInstance(70, 62, Image.SCALE_FAST)));
			
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 242, 651, 153);
		contentPane.add(panel);
		panel.setBackground(new Color(255, 250, 250));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Pedido", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION) );
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Elige el combo/pedido (ID)");
		lblNewLabel_1.setBounds(21, 22, 152, 20);
		panel.add(lblNewLabel_1);
		
		txtPedidoID = new JTextField();
		txtPedidoID.setEditable(false);
		txtPedidoID.setBounds(21, 46, 167, 25);
		panel.add(txtPedidoID);
		txtPedidoID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Elige la cantidad");
		lblNewLabel_2.setBounds(21, 71, 138, 25);
		panel.add(lblNewLabel_2);
		
		txtCant = new JTextField();
		txtCant.setColumns(10);
		txtCant.setBounds(21, 97, 167, 25);
		panel.add(txtCant);
		
		txtNumPedido = new JTextField();
		txtNumPedido.setColumns(10);
		txtNumPedido.setBounds(342, 46, 167, 25);
		panel.add(txtNumPedido);
		
		JLabel lblNewLabel_2_1 = new JLabel("Elimina N° pedido");
		lblNewLabel_2_1.setBounds(342, 22, 138, 25);
		panel.add(lblNewLabel_2_1);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		
				btnAgregar.setBounds(216, 91, 95, 36);
				panel.add(btnAgregar);
				
				btnVerCarta = new JButton("Ver Carta");
				btnVerCarta.addActionListener(this);
				btnVerCarta.setBounds(216, 40, 95, 36);
				panel.add(btnVerCarta);
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(519, 40, 95, 36);
				panel.add(btnEliminar);
				
				txtPromocion = new JTextField();
				txtPromocion.setColumns(10);
				txtPromocion.setBounds(342, 97, 167, 25);
				panel.add(txtPromocion);
				
				JLabel lblNewLabel_2_1_2 = new JLabel("Código de Promociones");
				lblNewLabel_2_1_2.setBounds(342, 74, 138, 25);
				panel.add(lblNewLabel_2_1_2);
				
				btnCanjear = new JButton("Canjear");
				btnCanjear.addActionListener(this);
				btnCanjear.setBounds(519, 91, 95, 36);
				panel.add(btnCanjear);
				
				btnEnviar = new JButton("Enviar");
				btnEnviar.setBounds(198, 588, 144, 36);
				contentPane.add(btnEnviar);
				btnEnviar.addActionListener(this);
				DesactivarCliente();
				
				panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Pedido", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
				panel_2.setBackground(new Color(255, 250, 250));
				panel_2.setBounds(418, 82, 239, 153);
				contentPane.add(panel_2);
				
				lblNewLabel_2_1_4 = new JLabel("Pedido:");
				lblNewLabel_2_1_4.setBounds(17, 24, 138, 25);
				panel_2.add(lblNewLabel_2_1_4);
				
				cbxPedido = new JComboBox();
				cbxPedido.addActionListener(this);
				cbxPedido.setModel(new DefaultComboBoxModel(new String[] {"Delivery", "Presencial"}));
				cbxPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cbxPedido.setBounds(17, 52, 86, 21);
				panel_2.add(cbxPedido);
				
				lblNewLabel_1_5 = new JLabel("Método de Pago:");
				lblNewLabel_1_5.setBounds(121, 26, 108, 20);
				panel_2.add(lblNewLabel_1_5);
				
				cbxMetodoPago = new JComboBox();
				cbxMetodoPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta", "Efectivo"}));
				cbxMetodoPago.setBounds(120, 51, 86, 25);
				panel_2.add(cbxMetodoPago);
				
				txtDireccion = new JTextField();
				txtDireccion.setBounds(17, 106, 158, 25);
				panel_2.add(txtDireccion);
				txtDireccion.setColumns(10);
				
				
				
				JLabel lblNewLabel_2_2 = new JLabel("Dirección:");
				lblNewLabel_2_2.setBounds(18, 84, 138, 25);
				panel_2.add(lblNewLabel_2_2);
				{
					btnVolver = new JButton("Volver");
					btnVolver.addActionListener(this);
					btnVolver.setBounds(22, 23, 91, 36);
					contentPane.add(btnVolver);
				}
				{
					lblNewLabel_5 = new JLabel("Trabajador: "+ArregloPersona.obtenerPersonaPorUsuario(user.getUser()).getNombreCompleto());
					lblNewLabel_5.setBounds(21, 653, 202, 14);
					contentPane.add(lblNewLabel_5);
				}
				
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
		if (e.getSource() == cbxPedido) {
			do_cbxPedido_actionPerformed(e);
		}
		if (e.getSource() == btnEnviar) {
			do_btnEnviar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelarPedido) {
			do_btnCancelarPedido_actionPerformed(e);
		}
		if (e.getSource() == btnCanjear) {
			do_btnCanjear_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnVerCarta) {
			do_btnVerCarta_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}
	Cliente cli;
	Pedido ped;
	Carta cart = new Carta();

	//VARIABLE TEMPORAL DE PEDIDOS

	
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			MenuProducto pro;
			
	        String idProducto = txtPedidoID.getText().trim();
	        int cantidad = Integer.parseInt(txtCant.getText()); 
	        MenuProducto encontrado = cart.Buscar(idProducto);
	        String metodoPago = cbxMetodoPago.getSelectedItem().toString();
	        String direccion = txtDireccion.getText();
	      
	        if(encontrado!=null) {

		        double precioU = encontrado.getPrecioUnitario();
		    	if(AgregarClienteNuevo()) {
		    		if(cbxPedido.getSelectedItem().equals("Delivery") && txtDireccion.getText().isBlank()) {
		    			JOptionPane.showMessageDialog(this, "Si es delivery escribe una direccion");
		    			return;
		    		}
		    		
		    		
		    		
		    		if(ped == null) {
			        	ped=new Pedido(0,metodoPago,direccion,cbxPedido.getSelectedItem().toString().toLowerCase(),cli);
				   
			        }
			        
		        	if(ped.Buscar(idProducto)!=null) {
		        		ped.Buscar(idProducto).setCantidad(cantidad + ped.Buscar(idProducto).getCantidad());
		        	}else {
		        		DetallePedido nuevoDetalle = new DetallePedido(encontrado, cantidad);
					    ped.Adicionar(nuevoDetalle);
		        	}
		        	
		        	
		        	txtPromocion.setText("");
		    		txtPedidoID.setText("");
		    		txtNumPedido.setText("");
		    		txtCant.setText("");
				    
		    		
		    		txtPromocion.setEditable(true);
		    		
		    		Activar();
		    		
		    		JOptionPane.showMessageDialog(this, "Pedido agregado correctamente.");	
			        
		    		
			        //MOSTRAR TOTAL AL MOMENTO
			        if(ped.getProm()!=null) txtCosto.setText("$"+ped.CostoTotal(true));
			        else txtCosto.setText("$"+ped.CostoTotal());
			        Listar();
		    	}
		        
		        
		        
		        
		        

	        }else JOptionPane.showMessageDialog(this, "No existe el Producto en la Carta.");

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar el pedido, ingrese los datos correctamente.");
	    }
	}
	
	private CartaGUI ventanaCarta;
	protected void do_btnVerCarta_actionPerformed(ActionEvent e) {
		if (ventanaCarta == null || !ventanaCarta.isShowing()) {
	        ventanaCarta = new CartaGUI(this);
	        ventanaCarta.setVisible(true);
	    } else {
	        ventanaCarta.toFront(); // Traer al frente si ya existe
	    }
		
		
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try {
	        int filaSeleccionada = Integer.parseInt(txtNumPedido.getText());
	        
	        ped.Eliminar(filaSeleccionada-1);
	        Listar();

	        JOptionPane.showMessageDialog(this, "Pedido eliminado correctamente.");
	    } catch (NumberFormatException ex)  {
	    	JOptionPane.showMessageDialog(this, "Se debe ingresar el número del pedido. ");
	    } catch (Exception ex) {
	    	JOptionPane.showMessageDialog(this, "Se debe ingresar un número de fila del pedido existente");
	    	
		}
	  

	}
	
	
	CuponeraLista lis = new CuponeraLista();
	private JButton btnCancelarPedido;
	private JLabel lblNewLabel_4;
	private JButton btnEnviar;
	private JPanel panel_2;
	private JLabel lblNewLabel_2_1_4;
	private JComboBox cbxPedido;
	private JLabel lblNewLabel_1_5;
	private JComboBox cbxMetodoPago;
	private JLabel lblNewLabel_1_2;
	private JButton btnRegistrar;
	private JLabel lblNewLabel_1_3;
	private JButton btnBucar;
	private JButton btnVolver;
	private JLabel lblNewLabel_5;
	
	protected void do_btnCanjear_actionPerformed(ActionEvent e) {
		
		
	    
		try {	        

			if(ped!=null) {
				int codigoIngresado = Integer.parseInt(txtPromocion.getText());
				Cupon prom = lis.Buscar(codigoIngresado);
				
				if(prom!= null) {
					ped.setProm(prom);
					txtCosto.setText("$"+ped.CostoTotal(true));
					JOptionPane.showMessageDialog(this, "El cupon ha sido canjeado!");
					txtPromocion.setEditable(false);
				}
			}else JOptionPane.showMessageDialog(this, "Primero haz una orden");
			
			
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Se debe digitar números. " +ex);
	    }
	
	}
	

	void Listar() {
		DefaultTableModel model = (DefaultTableModel) tbPedido.getModel();
	    model.setRowCount(0); 

	    for (int i = 0; i < ped.tamaño(); i++) {
	        DetallePedido detalle = ped.Obtener(i); 
	        model.addRow(new Object[]{
	            (i + 1), 
	            detalle.getProducto().getDescripcion(),
	            detalle.getCantidad(),
	            detalle.getProducto().getPrecioUnitario(),
	            detalle.getCantidad() * detalle.getProducto().getPrecioUnitario(), 
	        });
	    }
	}
	
	void Desactivar() {
		txtPromocion.setEditable(false);
		txtPedidoID.setEditable(false);
		txtNumPedido.setEditable(false);
		txtNombre.setEditable(true);
      	txtDni.setEditable(true);
      	txtTelefono.setEditable(true);
      	txtDireccion.setEditable(true);
		
		txtPromocion.setText("");
		txtPedidoID.setText("");
		txtNumPedido.setText("");
		txtCant.setText("");
		
	}

	
	void Activar() {
		txtPromocion.setEditable(true);
		txtPedidoID.setEditable(true);
		txtNumPedido.setEditable(true);
		txtCant.setEditable(true);
		txtNombre.setEditable(false);
      	txtDni.setEditable(false);
      	txtTelefono.setEditable(false);
      	txtDireccion.setEditable(false);
		
	}
	void DesactivarCliente() {
	}
	void LimpiarCliente() {
		txtNombre.setText("");
		txtDni.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
	protected void do_btnCancelarPedido_actionPerformed(ActionEvent e) {
		if(ped != null) {
			Desactivar();
			cli = null;
			ped.Limpiar();
			Listar();	
			ped = null;
			JOptionPane.showMessageDialog(this, "La cuenta ha eliminado");
			
		}
		DesactivarCliente();
      	
	}
	protected void do_btnEnviar_actionPerformed(ActionEvent e) {
		try {
		
	      	if(ped.tamaño()>0) {
	      		if(user.getRol().equals("trabajador")) {
	      			trabajador= ArregloTrabajador.obtenerTrabajador(user.getUser());
	      		}
	      		else if(user.getRol().equals("administrador")) {
	      			administrador =ArregloAdministrador.obtenerAdministrador(user.getUser());
	      		}
	      		
	      	
	      		if(cbxPedido.getSelectedItem().equals("Delivery") && txtDireccion.getText().isBlank()) {
	    			JOptionPane.showMessageDialog(this, "Si es delivery escribe una direccion");
	    			return;
	    		}
	      		
	      		
	      		ped.setDireccion(txtDireccion.getText());
	      		//SACAR CUENTA
		      	if(ped.getProm()!=null) ped.setMonto(ped.CostoTotal(true));
		        else ped.setMonto(ped.CostoTotal());
		      	
		      	//PEDIR FACTURA
	      		
	      		ArregloPedido.RegistrarPedido(ped, trabajador, administrador);
	      		JOptionPane.showMessageDialog(this, "El pedido fue registrado correctamente!");
		    
	
	      		//REINICIAR PEDIDO
		      	cli = null;
				ped.Limpiar();
				Listar();
				ped = null;
		      	LimpiarCliente();
	      	}else {
				JOptionPane.showMessageDialog(this, "Debe haber un producto para hacer un pedido");
	      		
	      	}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Hubo un error al momento de realizar el pedido, verifica que \nlos datos esten escritos correctamente");
		}

	}
	public void setPedidoId(String id) {
	    txtPedidoID.setText(id);
	}
	public void itemStateChanged(ItemEvent e) {
	}
	protected void do_cbxPedido_actionPerformed(ActionEvent e) {
		
		if(cbxPedido.getSelectedItem().equals("Presencial")) {

			txtDireccion.setEditable(false);
			txtDireccion.setText("");

		}
		else if(cbxPedido.getSelectedItem().equals("Delivery")){
			txtDireccion.setEditable(true);

		}
		
		if(ped!=null){
			if(cbxPedido.getSelectedItem().equals("Presencial")) ped.setDireccion("");
			
			ped.setTipo(cbxPedido.getSelectedItem().toString().toLowerCase());
			System.out.println(ped.getTipo() + " " +ped.getDireccion());
		}
		

		
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		AgregarClienteNuevo();
		ArregloCliente.RegistrarCliente(cli);
		if(!txtDni.getText().isBlank()) {
			
		}
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		if(user.getRol().equals("trabajador")) {
			this.dispose();
			InicioGUI volverInicioGUI = new InicioGUI();
			volverInicioGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			volverInicioGUI.setVisible(true);
				
		}else {
			this.dispose();
			AdministradorGUI volver = new AdministradorGUI(user);
			volver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			volver.setVisible(true);
		}

	}
	
	boolean AgregarClienteNuevo() {
		try {
			String nombre =txtNombre.getText();
			int telefono = Integer.parseInt(txtTelefono.getText());
			String dni = txtDni.getText();
			
			if (txtTelefono.getText().length() != 9 || !txtTelefono.getText().chars().allMatch(Character::isDigit)) {
	            JOptionPane.showMessageDialog(null, "El teléfono debe tener exactamente 9 números.");
	            return false;
	        }
			
			if (!nombre.replace(" ", "").chars().allMatch(Character::isLetter)) {
	            JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras y espacios.");
	            return false;
	        }
			
			if(!txtDni.getText().isBlank()) {
				if (dni.length() != 8 || !dni.chars().allMatch(Character::isDigit)) {
		            JOptionPane.showMessageDialog(null, "El DNI debe tener exactamente 8 números.");
		            return false;
		        }else cli = new Cliente(null,telefono, nombre, dni);
				
			}
			else cli = new Cliente(null,telefono, nombre);
			return true;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ingresa bien los datos del cliente");
		}
		return true;
	}
	
	void GuardarDatos() {
		txtNombre.setText(cli.getNombreCompleto());
		txtDireccion.setText(ped.getDireccion());
		txtTelefono.setText(""+cli.getTelefono());
		txtDni.setText(cli.getDNI());
		
	}
	

}
