package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Arraylist.ArregloMateriaPrima;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarMateriaPrima extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtStock;
	private JButton btnAgregar;
	private JTextField txtInsumoNombre;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarMateriaPrima dialog = new AgregarMateriaPrima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarMateriaPrima() {
		setBounds(800, 100, 249, 355);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 240, 279);
		contentPanel.setBackground(new Color(128, 64, 64));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblPlatosPolleria = new JLabel("INSUMOS");
			lblPlatosPolleria.setBounds(21, 11, 192, 37);
			lblPlatosPolleria.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlatosPolleria.setForeground(Color.WHITE);
			lblPlatosPolleria.setFont(new Font("Segoe UI Black", Font.PLAIN, 27));
			lblPlatosPolleria.setBackground(Color.BLACK);
			contentPanel.add(lblPlatosPolleria);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Agregar Insumo", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			panel.setBackground(new Color(255, 237, 232));
			panel.setBounds(21, 70, 192, 176);
			contentPanel.add(panel);
			{
				txtStock = new JTextField();
				txtStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtStock.setColumns(10);
				txtStock.setBounds(10, 101, 81, 20);
				panel.add(txtStock);
			}
			{
				JLabel lblStockInicial = new JLabel("Stock Inicial");
				lblStockInicial.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblStockInicial.setBounds(10, 79, 122, 14);
				panel.add(lblStockInicial);
			}
			{
				btnAgregar = new JButton("ENVIAR");
				btnAgregar.addActionListener(this);
				btnAgregar.setBounds(54, 142, 81, 23);
				panel.add(btnAgregar);
			}
			{
				JLabel lblNombreDelInsumo = new JLabel("Nombre del insumo");
				lblNombreDelInsumo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNombreDelInsumo.setBounds(10, 23, 127, 14);
				panel.add(lblNombreDelInsumo);
			}
			{
				txtInsumoNombre = new JTextField();
				txtInsumoNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtInsumoNombre.setColumns(10);
				txtInsumoNombre.setBounds(10, 48, 121, 20);
				panel.add(txtInsumoNombre);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(233, 209, 209));
			buttonPane.setBounds(0, 280, 234, 36);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				btnVolver = new JButton("Volver");
				btnVolver.addActionListener(this);
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			String nombre = txtInsumoNombre.getText();
			int stock = Integer.parseInt(txtStock.getText());
			
			if(ArregloMateriaPrima.consultarMateriaPrima(nombre)!=null) {
				ArregloMateriaPrima.registrarMateriaPrima(nombre, stock);
				JOptionPane.showMessageDialog(this, "Se registró el insumo");

				
			}else {
				JOptionPane.showMessageDialog(this, "Ya existe ese insumo");
			}
		}
		catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this, "Ingresa correctamente los datos");
		}
	}
	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		dispose();
	}
}
