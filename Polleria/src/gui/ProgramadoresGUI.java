package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ProgramadoresGUI extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProgramadoresGUI dialog = new ProgramadoresGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProgramadoresGUI() {
		setBounds(100, 100, 818, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 64, 64));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProgramadoresGrupo = new JLabel("PROGRAMADORES - GRUPO 3");
			lblProgramadoresGrupo.setHorizontalAlignment(SwingConstants.CENTER);
			lblProgramadoresGrupo.setForeground(new Color(255, 255, 255));
			lblProgramadoresGrupo.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
			lblProgramadoresGrupo.setBounds(79, 21, 586, 36);
			contentPanel.add(lblProgramadoresGrupo);
		}
		{
		

	

			ImageIcon josueIcon = new ImageIcon(ProgramadoresGUI.class.getResource("/img/JOSUE.jpg"));
			Image josueImg = josueIcon.getImage().getScaledInstance(122, 159, Image.SCALE_SMOOTH);
			JLabel lblJosue = new JLabel(new ImageIcon(josueImg));
			lblJosue.setBounds(43, 84, 122, 159);
			contentPanel.add(lblJosue);
		}
		{
			ImageIcon pieroCIcon = new ImageIcon(ProgramadoresGUI.class.getResource("/img/PIEROC.jpg"));
			Image pieroCImg = pieroCIcon.getImage().getScaledInstance(122, 159, Image.SCALE_SMOOTH);
			JLabel lblPieroC = new JLabel(new ImageIcon(pieroCImg));
			lblPieroC.setBounds(194, 84, 122, 159);
			contentPanel.add(lblPieroC);
		}
		{
			ImageIcon alexIcon = new ImageIcon(ProgramadoresGUI.class.getResource("/img/ALEX.jpg"));
			Image alexImg = alexIcon.getImage().getScaledInstance(122, 159, Image.SCALE_SMOOTH);
			JLabel lblAlex = new JLabel(new ImageIcon(alexImg));
			lblAlex.setBounds(350, 84, 122, 159);
			contentPanel.add(lblAlex);
		}
		{
			ImageIcon pieroDIcon = new ImageIcon(ProgramadoresGUI.class.getResource("/img/PIEROD.jpg"));
			Image pieroDImg = pieroDIcon.getImage().getScaledInstance(122, 200, Image.SCALE_SMOOTH);
			JLabel lblPieroD = new JLabel(new ImageIcon(pieroDImg));
			lblPieroD.setBounds(501, 84, 122, 159);
			contentPanel.add(lblPieroD);
		}
		{
			ImageIcon rodrigoIcon = new ImageIcon(ProgramadoresGUI.class.getResource("/img/RODRIGO.jpg"));
			Image rodrigoImg = rodrigoIcon.getImage().getScaledInstance(122, 159, Image.SCALE_SMOOTH);
			JLabel lblRodrigo = new JLabel(new ImageIcon(rodrigoImg));
			lblRodrigo.setBounds(651, 84, 122, 159);
			contentPanel.add(lblRodrigo);

		}
		{
			JLabel lblD = new JLabel();
			lblD.setIcon(new ImageIcon(ProgramadoresGUI.class.getResource("/img/PIEROC.jpg")));
			lblD.setText("d");
			lblD.setBounds(198, 84, 122, 159);
			contentPanel.add(lblD);
		}
		{
			JLabel lblNewLabel = new JLabel("Rodrigo");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(651, 254, 122, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCorilla = new JLabel("Corilla");
			lblCorilla.setHorizontalAlignment(SwingConstants.CENTER);
			lblCorilla.setForeground(Color.WHITE);
			lblCorilla.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCorilla.setBounds(651, 271, 122, 14);
			contentPanel.add(lblCorilla);
		}
		{
			JLabel lblRodrigo_1 = new JLabel("Piero");
			lblRodrigo_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodrigo_1.setForeground(Color.WHITE);
			lblRodrigo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRodrigo_1.setBounds(501, 254, 122, 14);
			contentPanel.add(lblRodrigo_1);
		}
		{
			JLabel lblDelgado = new JLabel("Delgado");
			lblDelgado.setHorizontalAlignment(SwingConstants.CENTER);
			lblDelgado.setForeground(Color.WHITE);
			lblDelgado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDelgado.setBounds(501, 271, 122, 14);
			contentPanel.add(lblDelgado);
		}
		{
			JLabel lblRodrigo_1 = new JLabel("Alex");
			lblRodrigo_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodrigo_1.setForeground(Color.WHITE);
			lblRodrigo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRodrigo_1.setBounds(350, 254, 122, 14);
			contentPanel.add(lblRodrigo_1);
		}
		{
			JLabel lblRodrigo_1 = new JLabel("Diaz");
			lblRodrigo_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodrigo_1.setForeground(Color.WHITE);
			lblRodrigo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRodrigo_1.setBounds(350, 273, 122, 14);
			contentPanel.add(lblRodrigo_1);
		}
		{
			JLabel lblRodrigo_1 = new JLabel("Piero");
			lblRodrigo_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodrigo_1.setForeground(Color.WHITE);
			lblRodrigo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRodrigo_1.setBounds(194, 254, 122, 14);
			contentPanel.add(lblRodrigo_1);
		}
		{
			JLabel lblRodrigo_1 = new JLabel("Chipana");
			lblRodrigo_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodrigo_1.setForeground(Color.WHITE);
			lblRodrigo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRodrigo_1.setBounds(194, 273, 122, 14);
			contentPanel.add(lblRodrigo_1);
		}
		{
			JLabel lblRodrigo_1 = new JLabel("Josue");
			lblRodrigo_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodrigo_1.setForeground(Color.WHITE);
			lblRodrigo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRodrigo_1.setBounds(43, 254, 122, 14);
			contentPanel.add(lblRodrigo_1);
		}
		{
			JLabel lblRodrigo_1 = new JLabel("Elias");
			lblRodrigo_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodrigo_1.setForeground(Color.WHITE);
			lblRodrigo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblRodrigo_1.setBounds(43, 273, 122, 14);
			contentPanel.add(lblRodrigo_1);
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
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
	    Image img = new ImageIcon(ProgramadoresGUI.class.getResource(ruta)).getImage();
	    Image esc = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
	    return new ImageIcon(esc);
	}

}
