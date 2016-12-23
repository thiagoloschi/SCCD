package br.superdia.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;

public class IgFinalizarCompra extends JDialog {
	private JButton cartaoButton;
	private JFormattedTextField cartaoFormattedTextField;
	private JLabel mensagemPagamentoLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IgFinalizarCompra dialog = new IgFinalizarCompra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IgFinalizarCompra() {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Pagamento");
		setBounds(100, 100, 330, 285);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 326, 59);
		getContentPane().add(panel);
		
		JLabel lblCentroDistribuioo = new JLabel("Centro Distribui\u00E7\u00E3o - SuperDia");
		lblCentroDistribuioo.setForeground(Color.WHITE);
		lblCentroDistribuioo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCentroDistribuioo.setBounds(10, 11, 305, 35);
		panel.add(lblCentroDistribuioo);
		
		JLabel cartaoLabel = new JLabel("Cart\u00E3o De Cr\u00E9dito:");
		cartaoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cartaoLabel.setToolTipText("Informe o n\u00FAmero do cart\u00E3o de cr\u00E9dito.");
		cartaoLabel.setBounds(10, 83, 110, 22);
		getContentPane().add(cartaoLabel);
		
		cartaoFormattedTextField = new JFormattedTextField();
		cartaoFormattedTextField.setBounds(119, 83, 195, 22);
		getContentPane().add(cartaoFormattedTextField);
		
		cartaoButton = new JButton("Pagar");
		cartaoButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cartaoButton.setBounds(129, 121, 89, 23);
		getContentPane().add(cartaoButton);
		
		mensagemPagamentoLabel = new JLabel("");
		mensagemPagamentoLabel.setForeground(Color.RED);
		mensagemPagamentoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mensagemPagamentoLabel.setBorder(new TitledBorder(null, "Situa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mensagemPagamentoLabel.setBounds(10, 155, 304, 90);
		getContentPane().add(mensagemPagamentoLabel);
	}
}
