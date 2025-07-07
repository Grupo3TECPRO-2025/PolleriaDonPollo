package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arraylist.ArregloMateriaPrima;
import Arraylist.ArregloMenuProducto;
import CartaPolleria.MenuProducto;
import Inventario.MateriaPrima;
import Inventario.PlatoConsumo;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class ListarPlatosGUI extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTable table;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarPlatosGUI dialog = new ListarPlatosGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarPlatosGUI() {
		setBounds(100, 100, 451, 535);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 64, 64));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNombre = new JTextField();
			txtNombre.addKeyListener(this);
			txtNombre.setBounds(38, 103, 345, 25);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Ingresa el Nombre del Plato");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(38, 73, 242, 19);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblListarInventario = new JLabel("LISTAR PLATO");
			lblListarInventario.setForeground(new Color(255, 255, 255));
			lblListarInventario.setBackground(new Color(255, 255, 255));
			lblListarInventario.setHorizontalAlignment(SwingConstants.CENTER);
			lblListarInventario.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblListarInventario.setBounds(100, 28, 242, 30);
			contentPanel.add(lblListarInventario);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 143, 345, 291);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"N\u00B0", "Descripci\u00F3n", "Insumo", "Cant."
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(31);
				table.getColumnModel().getColumn(1).setPreferredWidth(122);
				table.getColumnModel().getColumn(2).setPreferredWidth(105);
				table.getColumnModel().getColumn(3).setPreferredWidth(52);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(197, 139, 139));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Volver");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		BuscarNombreMateria();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	void BuscarNombreMateria() {
		String nombreBuscar = txtNombre.getText().trim();
	    ArrayList<MenuProducto> lista = ArregloMenuProducto.buscarPlatoPorDescripcion(nombreBuscar);

	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0); 

	    int nro = 1;
	    for (MenuProducto mp : lista) {
	        ArrayList<PlatoConsumo> listaConsumos = ArregloMenuProducto.obtenerInsumosPorProductoID(mp.getIdProducto());
	    	
	        boolean primeraFila = true;
	        for (PlatoConsumo consumo : listaConsumos) {
	            if (primeraFila) {
	                modelo.addRow(new Object[] {
	                    nro, mp.getDescripcion(),
	                    consumo.getInsumo().getNombre(), consumo.getCantidad()
	                });
	                nro++;
	                primeraFila = false;
	            } else {
	                modelo.addRow(new Object[] {
	                    "", "",
	                    consumo.getInsumo().getNombre(), consumo.getCantidad()
	                });
	            }
	        }

	        // Si el plato no tiene insumos (caso raro pero posible), mostrar igual
	        if (listaConsumos.isEmpty()) {
	            modelo.addRow(new Object[] {
	                nro, mp.getDescripcion(),
	                "Sin insumos", "-"
	            });
	            nro++;
	        }
	    }

	    if (lista.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No se encontraron insumos con ese nombre.");
	    }
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNombre) {
			do_txtNombre_keyTyped(e);
		}
	}
	protected void do_txtNombre_keyTyped(KeyEvent e) {
		BuscarNombreMateria();
	}
}
