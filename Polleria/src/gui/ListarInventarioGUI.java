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
import Inventario.MateriaPrima;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ListarInventarioGUI extends JDialog implements ActionListener, KeyListener {

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
			ListarInventarioGUI dialog = new ListarInventarioGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarInventarioGUI() {
		setBounds(100, 100, 380, 535);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNombre = new JTextField();
			txtNombre.addKeyListener(this);
			txtNombre.setBounds(38, 103, 288, 25);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Ingresa el Nombre del Producto");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(38, 73, 242, 19);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblListarInventario = new JLabel("LISTAR INVENTARIO");
			lblListarInventario.setHorizontalAlignment(SwingConstants.CENTER);
			lblListarInventario.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblListarInventario.setBounds(58, 32, 242, 14);
			contentPanel.add(lblListarInventario);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 143, 288, 291);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Nombre", "Stock", "Estado"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(34);
				table.getColumnModel().getColumn(1).setPreferredWidth(101);
				table.getColumnModel().getColumn(2).setPreferredWidth(50);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
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
	    ArrayList<MateriaPrima> lista = ArregloMateriaPrima.consultarMateriaPrima(nombreBuscar);

	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0); 

	    int nro = 1;
	    for (MateriaPrima mp : lista) {
	        int stock = mp.getStock();
	        String estado;

	        if (stock == 0) {
	            estado = "Vacío";
	        } else if (stock < 10) {
	            estado = "Bajo";
	        } else if (stock <= 20) {
	            estado = "En Atención";
	        } else {
	            estado = "Normal";
	        }

	        modelo.addRow(new Object[] {
	            mp.getMateriaid(), mp.getNombre(), stock, estado
	        });
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
