package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import CartaPolleria.Carta;
import CartaPolleria.MenuProducto;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class CartaGUI extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnEscoger;
	private JTable tableProductos;
    private DefaultTableModel tableModel;
    private PolleriaMenu pedidoGUI;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CartaGUI dialog = new CartaGUI(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CartaGUI(PolleriaMenu ventana) {
		pedidoGUI = ventana;
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 631, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 64, 64));
		contentPanel.setBorder(new EmptyBorder(5, 30, 20, 30));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			 String[] columnas = {"Producto", "Precio","Referencia"};
	            tableModel = new DefaultTableModel(columnas, 0) {
	                @Override
	                public boolean isCellEditable(int row, int column) {
	                    return false;  // No editable las celdas
	                }
	          };
	          tableProductos = new JTable(tableModel);
	          tableProductos.setFont(new Font("Tahoma", Font.PLAIN, 15));
	          tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	          tableProductos.getColumnModel().getColumn(0).setPreferredWidth(300); 
	          tableProductos.getColumnModel().getColumn(1).setPreferredWidth(40); 
	          tableProductos.setRowHeight(40);  // altura filas más grande
	          JTableHeader header = tableProductos.getTableHeader();
	          header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30)); // altura a 40 px
	          header.setFont(new Font("Segoe UI", Font.BOLD, 16));

	          scrollPane.setViewportView(tableProductos);
	       // Renderizador multilinea para la columna de descripción (Producto)
	          tableProductos.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
	              public Component getTableCellRendererComponent(JTable table, Object value,
	                      boolean isSelected, boolean hasFocus, int row, int column) {
	                  
	                  JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
	                  textArea.setLineWrap(true);
	                  textArea.setWrapStyleWord(true);
	                  textArea.setOpaque(true);
	                  textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
	                  
	                  // Colores por defecto o selección
	                  if (isSelected) {
	                      textArea.setBackground(table.getSelectionBackground());
	                      textArea.setForeground(table.getSelectionForeground());
	                  } else {
	                      textArea.setBackground(table.getBackground());
	                      textArea.setForeground(table.getForeground());
	                  }

	                  // Ajustar altura de la fila automáticamente
	                  int preferredHeight = textArea.getPreferredSize().height;
	                  if (table.getRowHeight(row) < preferredHeight) {
	                      table.setRowHeight(row, preferredHeight);
	                  }

	                  return textArea;
	              }
	          });

	          
	          cargarProductos();
			
		}
		{
			JLabel lblNewLabel = new JLabel("ESCOGE UN PRODUCTO DE NUESTRO MENU!");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 26));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBorder(new EmptyBorder(15, 10, 15, 10)); // Padding arriba, izquierda, abajo, derecha
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(197, 139, 139));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setBorder(new EmptyBorder(5,25,7,25));
			{
				btnEscoger = new JButton("Escoger");
				btnEscoger.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnEscoger.addActionListener(this);
				btnEscoger.setActionCommand("OK");
				buttonPane.add(btnEscoger);
				btnEscoger.setPreferredSize(new java.awt.Dimension(90, 40)); // Botón más grande
				getRootPane().setDefaultButton(btnEscoger);
			}
			
			
			
		}
	}

	Carta cartaPolleria = new Carta();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEscoger) {
			do_btnEscoger_actionPerformed(e);
		}
	}
	protected void do_btnEscoger_actionPerformed(ActionEvent e) {
		int fila = tableProductos.getSelectedRow();
	    if (fila != -1) {
	    
	    	pedidoGUI.setPedidoId(""+cartaPolleria.Obtener(fila).getIdProducto());
	        dispose();
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona un producto primero");
	    }
	}
	
	private void cargarProductos() {

		tableModel.setRowCount(0);

        for (MenuProducto producto : cartaPolleria.getMenu()) {
            Object[] fila = {producto.getDescripcion(), String.format("%.2f", producto.getPrecioUnitario())};
            tableModel.addRow(fila);
        }
    }
	
	

}
