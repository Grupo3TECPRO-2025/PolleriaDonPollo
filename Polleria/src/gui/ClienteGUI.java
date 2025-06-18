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

import CartaPolleria.CuponeraLista;
import CartaPolleria.Carta;
import CartaPolleria.Cupon;
import CartaPolleria.MenuProducto;
import DatosPersonales.Cliente;
import Gestiones.DetallePedido;
import Gestiones.Pedido;
import Reporte.FacturaGenerador;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI frame = new ClienteGUI();
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
	public ClienteGUI() {
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
		lblNewLabel.setBounds(33, 19, 408, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		panel_1.setBounds(10, 79, 652, 153);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre Completo:");
		lblNewLabel_1_1.setBounds(150, 32, 152, 20);
		panel_1.add(lblNewLabel_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(150, 56, 116, 25);
		panel_1.add(txtNombre);
		
		
		
		JLabel lblNewLabel_2_2 = new JLabel("Dirección:");
		lblNewLabel_2_2.setBounds(151, 85, 138, 25);
		panel_1.add(lblNewLabel_2_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(150, 107, 116, 25);
		panel_1.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(274, 56, 116, 25);
		panel_1.add(txtTelefono);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Teléfono:");
		lblNewLabel_2_1_1.setBounds(274, 35, 138, 25);
		panel_1.add(lblNewLabel_2_1_1);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(274, 107, 116, 25);
		panel_1.add(txtDni);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("DNI (Opcional):");
		lblNewLabel_2_1_1_1.setBounds(274, 84, 138, 25);
		panel_1.add(lblNewLabel_2_1_1_1);
		{
			btnEnviarDatos = new JButton("Enviar Datos");
			btnEnviarDatos.addActionListener(this);
			btnEnviarDatos.setBounds(526, 32, 116, 36);
			panel_1.add(btnEnviarDatos);
		}
		{
			lblNewLabel_2_1_5 = new JLabel("Pedido:");
			lblNewLabel_2_1_5.setBounds(10, 67, 138, 25);
			panel_1.add(lblNewLabel_2_1_5);
		}
		{
			cbxPedido = new JComboBox();
			cbxPedido.setFont(new Font("Tahoma", Font.PLAIN, 10));
			cbxPedido.addItemListener(this);
			cbxPedido.setBounds(10, 87, 116, 21);
			panel_1.add(cbxPedido);
			cbxPedido.setModel(new DefaultComboBoxModel(new String[] {"--Selecciona--", "Local/Llevar", "Domicilio"}));
		}
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(536, 112, 94, 20);
		panel_1.add(btnRegistrar);
		{
			lblNewLabel_2_1_1_2 = new JLabel("Deseas?");
			lblNewLabel_2_1_1_2.setBounds(563, 85, 69, 25);
			panel_1.add(lblNewLabel_2_1_1_2);
		}
		{
			lblNewLabel_1_2 = new JLabel("Método de Pago:");
			lblNewLabel_1_2.setBounds(401, 32, 152, 20);
			panel_1.add(lblNewLabel_1_2);
		}
		{
			lblNewLabel_1_3 = new JLabel("Número de Mesa:");
			lblNewLabel_1_3.setBounds(401, 87, 152, 20);
			panel_1.add(lblNewLabel_1_3);
		}
		{
			cbxMetodoPago = new JComboBox();
			cbxMetodoPago.setModel(new DefaultComboBoxModel(new String[] {"--Selecciona--", "Efectivo", "Tarjeta"}));
			cbxMetodoPago.setBounds(400, 56, 116, 25);
			panel_1.add(cbxMetodoPago);
		}
		{
			cbxNumeroMesa = new JComboBox();
			cbxNumeroMesa.setModel(new DefaultComboBoxModel(new String[] {"--Selecciona--", "1", "2", "3", "4", "5", "6", "7", "8"}));
			cbxNumeroMesa.setBounds(400, 107, 116, 25);
			panel_1.add(cbxNumeroMesa);
		}
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
		
		btnCancelarPedido = new JButton("Eliminar Cuenta");
		btnCancelarPedido.addActionListener(this);
		btnCancelarPedido.setBounds(21, 591, 144, 33);
		contentPane.add(btnCancelarPedido);
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(455, 11, 67, 62);
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
		txtCant.setEditable(false);
		txtCant.setColumns(10);
		txtCant.setBounds(21, 97, 167, 25);
		panel.add(txtCant);
		
		txtNumPedido = new JTextField();
		txtNumPedido.setEditable(false);
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
				btnEliminar.setBounds(519, 37, 95, 36);
				panel.add(btnEliminar);
				
				txtPromocion = new JTextField();
				txtPromocion.setEditable(false);
				txtPromocion.setColumns(10);
				txtPromocion.setBounds(342, 97, 167, 25);
				panel.add(txtPromocion);
				
				JLabel lblNewLabel_2_1_2 = new JLabel("Codigo de Promociones");
				lblNewLabel_2_1_2.setBounds(342, 74, 138, 25);
				panel.add(lblNewLabel_2_1_2);
				
				btnCanjear = new JButton("Canjear");
				btnCanjear.addActionListener(this);
				btnCanjear.setBounds(519, 83, 95, 36);
				panel.add(btnCanjear);
				
				btnEnviar = new JButton("Cancelar Cuenta");
				btnEnviar.setBounds(198, 588, 144, 36);
				contentPane.add(btnEnviar);
				btnEnviar.addActionListener(this);
				DesactivarCliente();
				btnVerCarta.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnAgregar.setEnabled(false);
				btnCanjear.setEnabled(false);
				
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
		if (e.getSource() == btnEnviar) {
			do_btnEnviar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelarPedido) {
			do_btnCancelarPedido_actionPerformed(e);
		}
		if (e.getSource() == btnEnviarDatos) {
			do_btnEnviarDatos_actionPerformed(e);
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
	int numped= 0;
	
	
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			MenuProducto pro;
			
	        String idProducto = txtPedidoID.getText().trim();
	        int cantidad = Integer.parseInt(txtCant.getText()); 
	        MenuProducto encontrado = cart.Buscar(idProducto);
	        
	        if(encontrado!=null) {

		        double precioU = encontrado.getPrecioUnitario();
		        
		        if(ped == null) {
			        ped=new Pedido(numped,cli);
			        numped++;
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
		        JOptionPane.showMessageDialog(this, "Pedido agregado correctamente.");
		        
		        
		        
		        //MOSTRAR TOTAL AL MOMENTO
		        if(ped.getProm()!=null) txtCosto.setText("$"+ped.CostoTotal(true));
		        else txtCosto.setText("$"+ped.CostoTotal());
		        Listar();

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
	
	
	private JButton btnEnviarDatos;
	private JButton btnCancelarPedido;
	private JLabel lblNewLabel_4;
	private JButton btnEnviar;
	private JComboBox cbxPedido;
	private JLabel lblNewLabel_2_1_5;
	private JButton btnRegistrar;
	private JLabel lblNewLabel_2_1_1_2;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JComboBox cbxMetodoPago;
	private JComboBox cbxNumeroMesa;
	
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
		txtCant.setEditable(false);
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
		txtNombre.setEditable(false);
		txtDni.setEditable(false);
		txtDireccion.setEditable(false);
		txtTelefono.setEditable(false);
		cbxMetodoPago.setEnabled(false);
		cbxNumeroMesa.setEnabled(false);
	}
	void LimpiarCliente() {
		txtNombre.setText("");
		txtDni.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
	protected void do_btnEnviarDatos_actionPerformed(ActionEvent e) {
		if ((cbxPedido.getSelectedItem().equals("Local/Llevar") && cbxNumeroMesa.getSelectedItem().equals("--Selecciona--")) 
			    || cbxMetodoPago.getSelectedItem().equals("--Selecciona--")) {
			    
			    JOptionPane.showMessageDialog(this, "Complete los campos correctamente!");
			} else {
			    try {
			        String nombreCompleto = txtNombre.getText();
			        String dni = txtDni.getText();
			        int telefono = Integer.parseInt(txtTelefono.getText());
			        String direccion = txtDireccion.getText();
			        String Metodo_Pago=cbxMetodoPago.getSelectedItem().toString();

			        cli = dni.isBlank()
			            ? new Cliente(telefono, nombreCompleto, direccion,Metodo_Pago)
			            : new Cliente(telefono, nombreCompleto, direccion,Metodo_Pago, dni);

			        DesactivarCliente();
					btnVerCarta.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnAgregar.setEnabled(true);
					btnCanjear.setEnabled(true);
			        cbxPedido.setEnabled(true);
			        Activar();
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(this, "Complete los campos correctamente!");
			    }
			}
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
	      		//SACAR CUENTA
		      	if(ped.getProm()!=null) ped.setMonto(ped.CostoTotal(true));
		        else ped.setMonto(ped.CostoTotal());
		      	
		      	//PEDIR FACTURA
	      		FacturaGenerador.generarFactura(ped);
		      	
	      		
	      		//REINICIAR PEDIDO
		      	cli = null;
				ped.Limpiar();
				Listar();
				ped = null;
		      	Desactivar();

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
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		txtNombre.setEditable(true);
      	txtDni.setEditable(true);
      	txtTelefono.setEditable(true);
      	txtDireccion.setEditable(true);
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cbxPedido) {
			do_cbxPedido_itemStateChanged(e);
		}
	}
	protected void do_cbxPedido_itemStateChanged(ItemEvent e) {
		int index = cbxPedido.getSelectedIndex();

		if (index == 0 && cbxPedido.getSelectedItem().equals("--Seleciona--")) {
		    JOptionPane.showMessageDialog(this, "Complete el campo del tipo de pedido");
		}

		boolean editableNombre = false;
		boolean editableDni = false;
		boolean editableTelefono = false;
		boolean editableDireccion = false;
		boolean habilitarMetodoPago = false;
		boolean habilitarNumeroMesa = false;

		switch (index) {
		    case 0:
		        LimpiarCliente();
		        break;
		    case 1:
		        editableNombre = true;
		        editableDni = true;
		        editableTelefono = true;
		        habilitarMetodoPago = true;
		        habilitarNumeroMesa = true;
		        txtDireccion.setText("");
		        break;
		    case 2:
		        editableNombre = true;
		        editableDni = true;
		        editableTelefono = true;
		        editableDireccion = true;
		        habilitarMetodoPago = true;
		        break;
		}

		txtNombre.setEditable(editableNombre);
		txtDni.setEditable(editableDni);
		txtTelefono.setEditable(editableTelefono);
		txtDireccion.setEditable(editableDireccion);
		cbxMetodoPago.setEnabled(habilitarMetodoPago);
		cbxNumeroMesa.setEnabled(habilitarNumeroMesa);

	}
}
