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
import javax.swing.JTextField;

public class IgFinalizarCompra extends JDialog {
	private JButton pagarButton;
	private JLabel mensagemPagamentoLabel;
	private IgCaixa igCaixa;
	private JTextField nomeTitularTextField;
	private JTextField cartaoTextField;
	
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
		cartaoLabel.setBounds(9, 130, 110, 22);
		getContentPane().add(cartaoLabel);
		
		pagarButton = new JButton("Pagar");
		pagarButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pagarButton.setBounds(126, 200, 89, 23);
		getContentPane().add(pagarButton);
		
		mensagemPagamentoLabel = new JLabel("");
		mensagemPagamentoLabel.setForeground(Color.RED);
		mensagemPagamentoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mensagemPagamentoLabel.setBorder(new TitledBorder(null, "Situa\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mensagemPagamentoLabel.setBounds(9, 230, 304, 90);
		getContentPane().add(mensagemPagamentoLabel);
		
		setTitle("Pagamento");
		setBounds(100, 100, 330, 364);
		getContentPane().setLayout(null);
		
		JLabel nomeTitularLabel = new JLabel("Nome do Titular:");
		nomeTitularLabel.setToolTipText("Informe o nome do titular do cart\u00E3o de cr\u00E9dito.");
		nomeTitularLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomeTitularLabel.setBounds(10, 70, 110, 22);
		getContentPane().add(nomeTitularLabel);
		
		nomeTitularTextField = new JTextField();
		nomeTitularTextField.setBounds(10, 91, 304, 28);
		getContentPane().add(nomeTitularTextField);
		nomeTitularTextField.setColumns(10);
		
		cartaoTextField = new JTextField();
		cartaoTextField.setColumns(10);
		cartaoTextField.setBounds(10, 152, 304, 28);
		getContentPane().add(cartaoTextField);
		setVisible(true);
	}
	
	/**Fecha a janela do caixa*/
	private void fechar(){
		this.dispose();
	}

	public JButton getCartaoButton() {
		return pagarButton;
	}

	public void setCartaoButton(JButton cartaoButton) {
		this.pagarButton = cartaoButton;
	}

	public JLabel getMensagemPagamentoLabel() {
		return mensagemPagamentoLabel;
	}

	public void setMensagemPagamentoLabel(JLabel mensagemPagamentoLabel) {
		this.mensagemPagamentoLabel = mensagemPagamentoLabel;
	}

	public JButton getPagarButton() {
		return pagarButton;
	}

	public void setPagarButton(JButton pagarButton) {
		this.pagarButton = pagarButton;
	}

	public IgCaixa getIgCaixa() {
		return igCaixa;
	}

	public void setIgCaixa(IgCaixa igCaixa) {
		this.igCaixa = igCaixa;
	}

	public JTextField getNomeTitularTextField() {
		return nomeTitularTextField;
	}

	public void setNomeTitularTextField(JTextField nomeTitularTextField) {
		this.nomeTitularTextField = nomeTitularTextField;
	}

	public JTextField getCartaoTextField() {
		return cartaoTextField;
	}

	public void setCartaoTextField(JTextField cartaoTextField) {
		this.cartaoTextField = cartaoTextField;
	}
}
