package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloMateriaPrima;
import Arraylist.ArregloMenuProducto;
import Arraylist.Carta;
import CartaPolleria.MenuProducto;
import Inventario.MateriaPrima;
import Inventario.PlatoConsumo;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AgregarPlatoGUI extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JTextField txtDescripcion;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblInsumoQueUtiliza;
	private JComboBox cbxMateriaPrima;
	private JLabel lblCantidad;
	private JTextField txtCant;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_1;
	private JLabel cbxNombre;
	private JLabel lblPrecio_1;
	private JTextField txtNombreM;
	private JLabel lblInsumoQueUtiliza_1;
	private JTextField txtPlatoID;
	private JButton btnModificar;
	private JButton btnEliminarM;
	private JComboBox cbxPlato;
	private JTextField txtPrecioM;
	private JLabel lblPrecio_2;
	private JButton btnVolver;
	private JButton btnEnviarPlato;
	private ArrayList<MateriaPrima> listamaterias;
	private ArrayList<PlatoConsumo> listaPlatoConsumos;
	private JLabel lblNombre;
	private JTextField txtNombre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarPlatoGUI dialog = new AgregarPlatoGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarPlatoGUI() {
		listaPlatoConsumos = new ArrayList<PlatoConsumo>();

		setBounds(100, 100, 470, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(new Color(128, 64, 64));
		contentPanel.setLayout(null);
		
		{
			JLabel lblPlatosPolleria = new JLabel("PLATOS POLLERIA");
			lblPlatosPolleria.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlatosPolleria.setForeground(Color.WHITE);
			lblPlatosPolleria.setFont(new Font("Segoe UI Black", Font.PLAIN, 27));
			lblPlatosPolleria.setBackground(Color.BLACK);
			lblPlatosPolleria.setBounds(66, 11, 313, 50);
			contentPanel.add(lblPlatosPolleria);
		}
		{
			panel = new JPanel();
			panel.setBackground(new Color(255, 237, 232));
			panel.setBounds(10, 72, 230, 236);
			contentPanel.add(panel);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Agregar Plato", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION) );
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Descripción del plato");
				lblNewLabel.setBounds(10, 58, 205, 14);
				panel.add(lblNewLabel);
			}
			{
				txtDescripcion = new JTextField();
				txtDescripcion.setBounds(10, 73, 169, 20);
				panel.add(txtDescripcion);
				txtDescripcion.setColumns(10);
			}
			{
				lblPrecio = new JLabel("Precio");
				lblPrecio.setBounds(10, 95, 122, 14);
				panel.add(lblPrecio);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setBounds(10, 108, 86, 20);
				panel.add(txtPrecio);
				txtPrecio.setColumns(10);
			}
			{
				lblInsumoQueUtiliza = new JLabel("Insumo que utiliza:");
				lblInsumoQueUtiliza.setBounds(9, 130, 122, 14);
				panel.add(lblInsumoQueUtiliza);
			}
			{
				cbxMateriaPrima = new JComboBox();
				cbxMateriaPrima.setBounds(10, 148, 122, 22);
				panel.add(cbxMateriaPrima);
			}
			{
				lblCantidad = new JLabel("Cantidad");
				lblCantidad.setBounds(156, 123, 122, 14);
				panel.add(lblCantidad);
			}
			{
				txtCant = new JTextField();
				txtCant.setColumns(10);
				txtCant.setBounds(154, 149, 61, 20);
				panel.add(txtCant);
			}
			{
				btnAgregar = new JButton("Agregar");
				btnAgregar.addActionListener(this);
				btnAgregar.setBounds(20, 189, 81, 23);
				panel.add(btnAgregar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(121, 190, 83, 23);
				panel.add(btnEliminar);
			}
			{
				lblNombre = new JLabel("Nombre del plato");
				lblNombre.setBounds(11, 17, 205, 14);
				panel.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(11, 31, 169, 20);
				panel.add(txtNombre);
			}

		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(249, 72, 195, 197);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nombre Insumo", "Cantidad"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(104);
				table.getColumnModel().getColumn(1).setPreferredWidth(66);
				scrollPane.setViewportView(table);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 237, 232));
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Modificar Plato", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel_1.setBounds(47, 319, 350, 168);
			contentPanel.add(panel_1);
			{
				cbxNombre = new JLabel("Nombre plato");
				cbxNombre.setBounds(21, 27, 122, 14);
				panel_1.add(cbxNombre);
			}
			{
				lblPrecio_1 = new JLabel("Nuevo Nombre");
				lblPrecio_1.setBounds(20, 58, 122, 14);
				panel_1.add(lblPrecio_1);
			}
			{
				txtNombreM = new JTextField();
				txtNombreM.setColumns(10);
				txtNombreM.setBounds(19, 77, 169, 20);
				panel_1.add(txtNombreM);
			}
			{
				lblInsumoQueUtiliza_1 = new JLabel("Precio Unitario");
				lblInsumoQueUtiliza_1.setBounds(18, 103, 122, 14);
				panel_1.add(lblInsumoQueUtiliza_1);
			}
			{
				txtPlatoID = new JTextField();
				txtPlatoID.setEditable(false);
				txtPlatoID.setColumns(10);
				txtPlatoID.setBounds(215, 77, 112, 20);
				panel_1.add(txtPlatoID);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setBounds(126, 111, 90, 35);
				panel_1.add(btnModificar);
			}
			{
				btnEliminarM = new JButton("Eliminar");
				btnEliminarM.setBounds(234, 111, 90, 34);
				panel_1.add(btnEliminarM);
			}
			{
				cbxPlato = new JComboBox();
				cbxPlato.setBounds(106, 24, 207, 22);
				panel_1.add(cbxPlato);
			}
			{
				txtPrecioM = new JTextField();
				txtPrecioM.setColumns(10);
				txtPrecioM.setBounds(18, 122, 61, 20);
				panel_1.add(txtPrecioM);
			}
			{
				lblPrecio_2 = new JLabel("IdPlato");
				lblPrecio_2.setBounds(215, 58, 122, 14);
				panel_1.add(lblPrecio_2);
			}
		}
		{
			btnEnviarPlato = new JButton("Enviar Plato");
			btnEnviarPlato.addActionListener(this);
			btnEnviarPlato.setBounds(296, 280, 104, 28);
			contentPanel.add(btnEnviarPlato);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setBackground(new Color(197, 139, 139));
			{
				btnVolver = new JButton("Volver");
				btnVolver.addActionListener(this);
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
		ListarMateriaPrima();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarPlato) {
			do_btnEnviarPlato_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	void ListarMateriaPrima() {
		cbxMateriaPrima.removeAllItems();
		for (MateriaPrima m : ArregloMateriaPrima.listarMateriaPrima()) {
			
			cbxMateriaPrima.addItem(m.getNombre());
		}
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {

		
		
		try {
		
			int cantidad = Integer.parseInt(txtCant.getText());
			int materiaID = ArregloMateriaPrima.consultarMateriaPrima(cbxMateriaPrima.getSelectedItem().toString()).getFirst().getMateriaid();
			String nombreMateria = cbxMateriaPrima.getSelectedItem().toString();
			
			MateriaPrima insumo = new MateriaPrima(materiaID,nombreMateria, 0);
			PlatoConsumo consumo = new PlatoConsumo(insumo, cantidad);
		

			  // Evitar duplicados
	        for (PlatoConsumo p : listaPlatoConsumos) {
	            if (p.getInsumo().getMateriaid() == consumo.getInsumo().getMateriaid()) {
	                JOptionPane.showMessageDialog(null, "La insumo ya ha sido agregada.");
	                return;
	            }
	        }

			
			listaPlatoConsumos.add(consumo);			
			JOptionPane.showMessageDialog(this, "Se agregó el insumo");
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		        modelo.setRowCount(0); // limpiar la tabla

		        for (PlatoConsumo p : listaPlatoConsumos) {
		            modelo.addRow(new Object[] { p.getInsumo().getNombre() , p.getCantidad()  });
		     }

			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Escribe una cantidad valida");
		}
		
		
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		
		int filaSeleccionada = table.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) table.getModel();
            modelo.removeRow(filaSeleccionada);
            listaPlatoConsumos.remove(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.");
        }
		
	}
	protected void do_btnEnviarPlato_actionPerformed(ActionEvent e) {
		
		try {
			if(listaPlatoConsumos.size()>0) {
				String descripcion = txtDescripcion.getText();
				double precio = Double.parseDouble(txtPrecio.getText());
				String nom = txtNombre.getText();
				
				

				if (descripcion.isEmpty() || nom.isEmpty() || txtPrecio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Completa todos los campos antes de guardar.");
					return;
				}
				
				if (ArregloMenuProducto.existePlatoPorNombre(nom)) {
	                JOptionPane.showMessageDialog(this, "Ya existe un plato con ese nombre.");
	                return;
	            }
				
				String idPlato = ArregloMenuProducto.generarNuevoIDDesdeNombre(nom);
				MenuProducto nuevoPlato = new MenuProducto(idPlato, nom, descripcion, precio);
				nuevoPlato.setListaDeConsumos(listaPlatoConsumos);
				ArregloMenuProducto.registrarPlato(nuevoPlato);
				
			}else {
				JOptionPane.showMessageDialog(this, "Debe haber minimo 1 insumo registrado");
			}
			
			
			
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Rellena todos los campos correctamente");
		}
		
		
	}
}
