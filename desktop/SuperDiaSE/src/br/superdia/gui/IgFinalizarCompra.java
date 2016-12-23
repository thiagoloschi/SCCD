package br.superdia.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class IgFinalizarCompra extends JDialog {
	private JButton cartaoButton;
	private JFormattedTextField cartaoFormattedTextField;
	private JLabel mensagemPagamentoLabel;
	private IgCaixa igCaixa;
	
	/**
	 * Create the dialog.
	 */
	public IgFinalizarCompra(IgCaixa igCaixa) {
		this.igCaixa = igCaixa;
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("clicou em fechar igFinalizarCompra");
				fechar();
				
			}
		});
		
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
		
		setTitle("Pagamento");
		setBounds(100, 100, 330, 285);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	
	/**Fecha a janela do caixa*/
	private void fechar(){
		this.dispose();
	}

	public JButton getCartaoButton() {
		return cartaoButton;
	}

	public void setCartaoButton(JButton cartaoButton) {
		this.cartaoButton = cartaoButton;
	}

	public JFormattedTextField getCartaoFormattedTextField() {
		return cartaoFormattedTextField;
	}

	public void setCartaoFormattedTextField(JFormattedTextField cartaoFormattedTextField) {
		this.cartaoFormattedTextField = cartaoFormattedTextField;
	}

	public JLabel getMensagemPagamentoLabel() {
		return mensagemPagamentoLabel;
	}

	public void setMensagemPagamentoLabel(JLabel mensagemPagamentoLabel) {
		this.mensagemPagamentoLabel = mensagemPagamentoLabel;
	}
	
	
}
