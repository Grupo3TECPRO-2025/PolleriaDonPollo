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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Carta;
import Clases.Cliente;
import Clases.MenuProducto;
import Clases.Pedidos;
import Clases.Productos;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 623);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("POLLERIA DON POLLO");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 36));
		lblNewLabel.setBounds(73, 11, 435, 50);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(24, 72, 318, 251);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Pedido", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION) );
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Elige el combo/pedido (ID)");
		lblNewLabel_1.setBounds(15, 27, 152, 20);
		panel.add(lblNewLabel_1);
		
		txtPedidoID = new JTextField();
		txtPedidoID.setBounds(15, 51, 167, 25);
		panel.add(txtPedidoID);
		txtPedidoID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Elige la cantidad");
		lblNewLabel_2.setBounds(15, 76, 138, 25);
		panel.add(lblNewLabel_2);
		
		txtCant = new JTextField();
		txtCant.setColumns(10);
		txtCant.setBounds(15, 101, 167, 25);
		panel.add(txtCant);
		
		txtNumPedido = new JTextField();
		txtNumPedido.setColumns(10);
		txtNumPedido.setBounds(15, 156, 167, 25);
		panel.add(txtNumPedido);
		
		JLabel lblNewLabel_2_1 = new JLabel("Elimina N° pedido");
		lblNewLabel_2_1.setBounds(15, 131, 138, 25);
		panel.add(lblNewLabel_2_1);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);

		btnAgregar.setBounds(199, 40, 95, 36);
		panel.add(btnAgregar);
		
		btnVerCarta = new JButton("Ver Carta");
		btnVerCarta.addActionListener(this);
		btnVerCarta.setBounds(199, 96, 95, 36);
		panel.add(btnVerCarta);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(198, 152, 95, 36);
		panel.add(btnEliminar);
		
		txtPromocion = new JTextField();
		txtPromocion.setColumns(10);
		txtPromocion.setBounds(15, 209, 167, 25);
		panel.add(txtPromocion);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Codigo de Promociones");
		lblNewLabel_2_1_2.setBounds(15, 184, 138, 25);
		panel.add(lblNewLabel_2_1_2);
		
		btnCanjear = new JButton("Canjear");
		btnCanjear.addActionListener(this);
		btnCanjear.setBounds(198, 202, 95, 36);
		panel.add(btnCanjear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Datos Personales", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		panel_1.setBounds(350, 72, 200, 251);
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
			scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 333, 523, 200);
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
		txtCosto.setBounds(417, 533, 129, 29);
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Costo Total");
		lblNewLabel_3.setBounds(341, 537, 68, 21);
		contentPane.add(lblNewLabel_3);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(23, 533, 100, 29);
		contentPane.add(btnEnviar);
	}
	public void actionPerformed(ActionEvent e) {
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
	Pedidos ped = new Pedidos(null);
	Carta cart = new Carta();
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			Productos pro;
			
	        String idProducto = txtPedidoID.getText().trim();
	        int cantidad = Integer.parseInt(txtCant.getText()); 
	        String NombreCompleto= txtNombre.getText();
	        String DNI = txtDni.getText();
	        int telefono = Integer.parseInt(txtTelefono.getText());
	        String Direccion = txtDireccion.getText();  
	        
	        MenuProducto encontrado = cart.Buscar(idProducto);
	        
	        if(encontrado!=null) {

		        double precioU=encontrado.getPrecioUnitario();
	        	if(ped.tamaño()==0) {  
		        	
		        	if(DNI.isBlank()) cli=new Cliente(telefono, NombreCompleto, Direccion);
		        	else cli=new Cliente(telefono, NombreCompleto, Direccion,DNI);

		        	ped=new Pedidos(cli);
		        }
	        	
	        	if(ped.Buscar(idProducto)!=null) {
	        		ped.Buscar(idProducto).setCantidad(cantidad);
	        	}else {
	        		pro=new Productos(precioU, idProducto, cart.Buscar(idProducto).getDescripcion(), cantidad);
				    ped.Adicionar(pro);
	        	}
	        	
	        	
			    
		        JOptionPane.showMessageDialog(this, "Pedido agregado correctamente.");
		        Listar();

	        }else JOptionPane.showMessageDialog(this, "No existe el Producto en la Carta.");

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar el pedido, ingrese los datos correctamente. " + ex.getMessage());
	    }
	}
	
	protected void do_btnVerCarta_actionPerformed(ActionEvent e) {
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
	
	
	//PROGRAMADO
	protected void do_btnCanjear_actionPerformed(ActionEvent e) {
		
		String CodigoProm1 = "123456";
		String CodigoProm2 = "343425";
		String CodigoProm3 = "322423";
	    double descuento = 0.0;
		
		try {	        
			
			String codigoIngresado = txtPromocion.getText();
					
			if (codigoIngresado.equals(CodigoProm1)) {
		        descuento = 10; 
		    } else if (codigoIngresado.equals(CodigoProm2)) {
		        descuento = 15; 
		    } else if (codigoIngresado.equals(CodigoProm3)) {
		        descuento = 20;
		    } else {
		        JOptionPane.showMessageDialog(this, "Debe ingresar un Codigo Existente y Solo numeros.");
		    }
		    
		    if (descuento > 0) {
		        JOptionPane.showMessageDialog(this, "El codigo es Valido, Gananste un " + descuento + "% de descuento");
		    }	 
			
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Se debe digitar números. " );
	    }
	
	}
	
	
	void Listar() {
		DefaultTableModel model = (DefaultTableModel) tbPedido.getModel();
	    model.setRowCount(0); 

	    for (int i = 0; i < ped.tamaño(); i++) {
	        Productos pro = ped.Obtner(i); 
	        model.addRow(new Object[]{
	            (i + 1), 
	            pro.getNombre(),
	            pro.getCantidad(), 
	            pro.getPrecioUnitario(),
	            pro.getCantidad() * pro.getPrecioUnitario() 
	        });
	    }
	}
	
}
