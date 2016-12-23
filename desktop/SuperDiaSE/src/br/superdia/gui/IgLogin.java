package br.superdia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.superdia.app.SuperDiaApp;
import br.superdia.trataEvento.TrataEventosIgLogin;

public class IgLogin extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JTextField usuarioTextField;
	private JPasswordField senhaPasswordField;
	private JLabel mensagemLabel;
	private JButton entrarButton;	
	private SuperDiaApp superDiaApp;
	private TrataEventosIgLogin trataEventosIgLogin;
	/**
	 * Cria e exibe uma caixa de diálogo para obter o login do usuï¿½rio.
	 */
	public IgLogin(SuperDiaApp superDiaApp) {
		this.superDiaApp = superDiaApp;		
						
		trataEventosIgLogin = new TrataEventosIgLogin(this);
				
		JPanel autenticacaoPanel = new JPanel();
		autenticacaoPanel.setBackground(Color.WHITE);
		getContentPane().add(autenticacaoPanel, BorderLayout.CENTER);
		autenticacaoPanel.setLayout(null);
		
		JPanel tituloPanel = new JPanel();
		tituloPanel.setBackground(new Color(60, 179, 113));
		tituloPanel.setBounds(0, 0, 288, 57);
		autenticacaoPanel.add(tituloPanel);
		tituloPanel.setLayout(null);
		
		JLabel lblCdSuperdia = new JLabel("Centro Distribui\u00E7\u00E3o - SuperDia");
		lblCdSuperdia.setForeground(new Color(255, 255, 255));
		lblCdSuperdia.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCdSuperdia.setBounds(10, 11, 253, 35);
		tituloPanel.add(lblCdSuperdia);
		
		JLabel usuarioLabel = new JLabel("Usu\u00E1rio:");
		usuarioLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		usuarioLabel.setBounds(10, 95, 82, 20);
		autenticacaoPanel.add(usuarioLabel);
		
		JLabel senhaLabel = new JLabel("Senha:");
		senhaLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		senhaLabel.setBounds(22, 137, 62, 20);
		autenticacaoPanel.add(senhaLabel);
		
		usuarioTextField = new JTextField();
		usuarioTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
		usuarioTextField.setBounds(94, 80, 174, 33);
		autenticacaoPanel.add(usuarioTextField);
		usuarioTextField.setColumns(10);
		
		usuarioTextField.addMouseListener(trataEventosIgLogin.new TrataEventoUsuarioTextField());
		
		senhaPasswordField = new JPasswordField();
		senhaPasswordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		senhaPasswordField.setBounds(94, 126, 174, 33);
		autenticacaoPanel.add(senhaPasswordField);
		
		senhaPasswordField.addMouseListener(trataEventosIgLogin.new TrataEventoSenhaTextField());
		
		mensagemLabel = new JLabel("Informe o usu\u00E1rio e a senha e clique em Entrar.");
		mensagemLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mensagemLabel.setBounds(10, 168, 258, 57);
		autenticacaoPanel.add(mensagemLabel);
		
		entrarButton = new JButton("Entrar");
		entrarButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		entrarButton.setBounds(94, 242, 94, 30);
		autenticacaoPanel.add(entrarButton);
		
		//tratando o evento foco entrar cursor mouse colocando o cursor do mouse como uma mï¿½o.
		entrarButton.addMouseListener(trataEventosIgLogin.new TrataEventoFocoMouseEntrarButton());
		
		// tratando o evento do botï¿½o Entrar
		entrarButton.addActionListener(trataEventosIgLogin.new TrataEventoBotaoEntrar());		
		
		// tratando os eventos da janela
		addWindowListener(trataEventosIgLogin.new TrataEventoWindowIgLogin());
		
		setBounds(100, 100, 294, 327);		
		setModal(true);
		setTitle("Autentica\u00E7\u00E3o");
		setVisible(true);
	}

	public JTextField getUsuarioTextField() {
		return usuarioTextField;
	}

	public void setUsuarioTextField(JTextField usuarioTextField) {
		this.usuarioTextField = usuarioTextField;
	}

	public JPasswordField getSenhaPasswordField() {
		return senhaPasswordField;
	}
	
	public void setSenhaPasswordField(JPasswordField senhaPasswordField) {
		this.senhaPasswordField = senhaPasswordField;
	}

	public JLabel getMensagemLabel() {
		return mensagemLabel;
	}

	public void setMensagemLabel(JLabel mensagemLabel) {
		this.mensagemLabel = mensagemLabel;
	}

	public SuperDiaApp getSuperDiaApp() {
		return superDiaApp;
	}

	public void setSuperDiaApp(SuperDiaApp superDiaApp) {
		this.superDiaApp = superDiaApp;
	}

	public JButton getEntrarButton() {
		return entrarButton;
	}

	public void setEntrarButton(JButton entrarButton) {
		this.entrarButton = entrarButton;
	}

	public TrataEventosIgLogin getTrataEventosIgLogin() {
		return trataEventosIgLogin;
	}

	public void setTrataEventosIgLogin(TrataEventosIgLogin trataEventosIgLogin) {
		this.trataEventosIgLogin = trataEventosIgLogin;
	}	
}// class IgLogin
