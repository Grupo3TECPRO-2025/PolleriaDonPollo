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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PolleriaMenu extends JFrame implements ActionListener {

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
					PolleriaMenu frame = new PolleriaMenu();
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
	public PolleriaMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PolleriaMenu.class.getResource("/img/DonPollo.jpg")));
		setTitle("Polleria Don Pollo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 682);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setForeground(new Color(240, 255, 255));
		menuBar.setBackground(new Color(155, 94, 79));
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Menu");
		mnNewMenu.setBackground(new Color(155, 94, 79));
		mnNewMenu.setForeground(UIManager.getColor("text"));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Realiza Pedido");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Registros");
		mnNewMenu.add(mntmNewMenuItem_1);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(24, 86, 318, 296);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Pedido", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION) );
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Elige el combo/pedido (ID)");
		lblNewLabel_1.setBounds(15, 27, 152, 20);
		panel.add(lblNewLabel_1);
		
		txtPedidoID = new JTextField();
		txtPedidoID.setEditable(false);
		txtPedidoID.setBounds(15, 51, 167, 25);
		panel.add(txtPedidoID);
		txtPedidoID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Elige la cantidad");
		lblNewLabel_2.setBounds(15, 76, 138, 25);
		panel.add(lblNewLabel_2);
		
		txtCant = new JTextField();
		txtCant.setEditable(false);
		txtCant.setColumns(10);
		txtCant.setBounds(15, 102, 167, 25);
		panel.add(txtCant);
		
		txtNumPedido = new JTextField();
		txtNumPedido.setEditable(false);
		txtNumPedido.setColumns(10);
		txtNumPedido.setBounds(15, 151, 167, 25);
		panel.add(txtNumPedido);
		
		JLabel lblNewLabel_2_1 = new JLabel("Elimina N° pedido");
		lblNewLabel_2_1.setBounds(15, 127, 138, 25);
		panel.add(lblNewLabel_2_1);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);

		btnAgregar.setBounds(199, 47, 95, 29);
		panel.add(btnAgregar);
		
		btnVerCarta = new JButton("Ver Carta");
		btnVerCarta.addActionListener(this);
		btnVerCarta.setBounds(199, 99, 95, 31);
		panel.add(btnVerCarta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(199, 149, 95, 29);
		panel.add(btnEliminar);
		
		txtPromocion = new JTextField();
		txtPromocion.setEditable(false);
		txtPromocion.setColumns(10);
		txtPromocion.setBounds(15, 202, 167, 25);
		panel.add(txtPromocion);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Codigo de Promociones");
		lblNewLabel_2_1_2.setBounds(15, 179, 138, 25);
		panel.add(lblNewLabel_2_1_2);
		
		btnCanjear = new JButton("Canjear");
		btnCanjear.addActionListener(this);
		btnCanjear.setBounds(199, 199, 95, 30);
		panel.add(btnCanjear);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(46, 245, 108, 33);
		panel.add(btnEnviar);
		{
			cboTipo = new JComboBox();
			cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Delivery", "Presencial"}));
			cboTipo.setBounds(196, 249, 98, 29);
			panel.add(cboTipo);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		panel_1.setBounds(350, 86, 200, 297);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres y Apellidos");
		lblNewLabel_1_1.setBounds(15, 27, 152, 20);
		panel_1.add(lblNewLabel_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(15, 51, 167, 25);
		panel_1.add(txtNombre);
		
		
		
		JLabel lblNewLabel_2_2 = new JLabel("Direccion");
		lblNewLabel_2_2.setBounds(16, 80, 138, 25);
		panel_1.add(lblNewLabel_2_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(15, 102, 167, 25);
		panel_1.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(15, 153, 167, 25);
		panel_1.add(txtTelefono);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Telefono");
		lblNewLabel_2_1_1.setBounds(15, 132, 138, 25);
		panel_1.add(lblNewLabel_2_1_1);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(15, 209, 167, 25);
		panel_1.add(txtDni);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("DNI (opcional):");
		lblNewLabel_2_1_1_1.setBounds(15, 186, 138, 25);
		panel_1.add(lblNewLabel_2_1_1_1);
		{
			btnEnviarDatos = new JButton("Enviar Datos");
			btnEnviarDatos.addActionListener(this);
			btnEnviarDatos.setBounds(47, 245, 105, 36);
			panel_1.add(btnEnviarDatos);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 393, 523, 176);
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
		txtCosto.setBounds(417, 570, 129, 29);
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Costo Total");
		lblNewLabel_3.setBounds(341, 574, 68, 21);
		contentPane.add(lblNewLabel_3);
		
		btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.addActionListener(this);
		btnCancelarPedido.setBounds(22, 569, 144, 33);
		contentPane.add(btnCancelarPedido);
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(455, 11, 67, 62);
			contentPane.add(lblNewLabel_4);
			lblNewLabel_4.setIcon(new ImageIcon(new ImageIcon(PolleriaMenu.class.getResource
					("/img/DonPollo.jpg")).getImage().getScaledInstance(70, 62, Image.SCALE_FAST)));
			
		}
	}
	public void actionPerformed(ActionEvent e) {
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
	CartaGUI ventanaCarta;
	protected void do_btnVerCarta_actionPerformed(ActionEvent e) {
			
			if(ventanaCarta == null || !ventanaCarta.isDisplayable()) {
				 ventanaCarta= new CartaGUI(this);

				ventanaCarta.setVisible(true);
				
			}
	    }

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try {
	        int filaSeleccionada = Integer.parseInt(txtNumPedido.getText());
	        
	        
	        ped.Eliminar(filaSeleccionada-1);
	        if(ped.getProm()!=null) txtCosto.setText("$"+ped.CostoTotal(true));
	        else txtCosto.setText("$"+ped.CostoTotal());
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
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblNewLabel_4;
	private JButton btnEnviar;
	private JComboBox cboTipo;
	
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
	        JOptionPane.showMessageDialog(this, "Se debe digitar números. ");
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
	protected void do_btnEnviarDatos_actionPerformed(ActionEvent e) {
		try {
			String NombreCompleto= txtNombre.getText();
	        String DNI = txtDni.getText();
	        int telefono = Integer.parseInt(txtTelefono.getText());
	        String Direccion = txtDireccion.getText();  
	        
	      	if(DNI.isBlank()) cli=new Cliente(telefono, NombreCompleto, Direccion);
	    	else cli=new Cliente(telefono, NombreCompleto, Direccion,DNI);
	      	
	      	
	      	
	      	
	      	Activar();	
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Ingresa los datos correctamente!");
		}
		
      	
       
	}
	protected void do_btnCancelarPedido_actionPerformed(ActionEvent e) {
		if(ped != null) {
			Desactivar();
			cli = null;
			ped.Limpiar();
			Listar();	
			ped = null;
			JOptionPane.showMessageDialog(this, "El pedido ha sido cancelado");
		}
      	
	}
	protected void do_btnEnviar_actionPerformed(ActionEvent e) {
		try {
	      	if(ped.tamaño()>0) {
	      		
	      		ped.setTipo(cboTipo.getSelectedItem().toString());
	      		
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
}
