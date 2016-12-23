package br.superdia.trataEvento;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.superdia.app.Perfil;
import br.superdia.gui.IgCaixa;
import br.superdia.gui.IgLogin;
import br.superdia.webservice.UserService;
import br.superdia.webservice.Usuario;

public class TrataEventosIgLogin {
	private IgLogin igLogin;
	private UserService userService;
	private Usuario usuario;
	
	public TrataEventosIgLogin(IgLogin igLogin) {
		this.igLogin = igLogin;				
		this.userService = igLogin.getSuperDiaApp().getUserServiceService().getUserServicePort();
		this.usuario = igLogin.getSuperDiaApp().getUsuario();
	}
	
	public IgLogin getIgLogin() {
		return igLogin;
	}
	
	/**Classe interna anonima respons�vel por tratar os eventos de janela da janela <code>IgLogin</code>*/
	public class TrataEventoWindowIgLogin extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent event) {			
			System.exit(0);
		}
	}
	
	/**Classe interna anonima respons�vel por tratar os eventos de mouse do campo <i>usuarioTextField</i> da janela de <code>IgLogin</code>*/
	public class TrataEventoUsuarioTextField extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			igLogin.getUsuarioTextField().setText("");
		}
	}
	
	/**Classe interna anonima respons�vel por tratar os eventos de foco do mouse no bot�o <code>entrarButton</code> da classe (janela) 
	 * <code>IgLogin</code>*/
	public class TrataEventoFocoMouseEntrarButton extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent e) {
			igLogin.getEntrarButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}
	
	/**Classe interna anonima respons�vel por tratar os eventos de mouse do campo <i>senhaTextField</i> da janela de <code>IgLogin</code>*/
	public class TrataEventoSenhaTextField extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			igLogin.getSenhaPasswordField().setText("");
		}
	}

	/**Classe interna anonima respons�vel por tratar o envento do bot�o <i>Entrar</i> da janela <code>IgLogin</code>*/
	public class TrataEventoBotaoEntrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			trataEventoButtonEntrarLogin();
		}		
	}
	
	/**
	 * M�todo privado respons�vel por tratar o evento de login. 
	 */
	private void trataEventoButtonEntrarLogin(){		
		usuario = new Usuario();
		
		usuario.setUsuario(igLogin.getUsuarioTextField().getText());
		usuario.setSenha(new String(igLogin.getSenhaPasswordField().getPassword()));
		
		usuario = userService.obtemUsuario(usuario);
		
		if (usuario == null){
			igLogin.getMensagemLabel().setText("Usuario e/ou senha invalido(s).");
		}else if(!(usuario.getPerfil().equalsIgnoreCase(Perfil.ADMINISTRADOR.getPerfil()) || 
				   usuario.getPerfil().equalsIgnoreCase(Perfil.CAIXA.getPerfil()))){
			igLogin.getMensagemLabel().setText("Usuario cliente: " + igLogin.getUsuarioTextField().getText() + 
					", nao pode acessar o caixa.");
		}else{			
			igLogin.getSuperDiaApp().setUsuarioLogado(usuario);
			igLogin.getUsuarioTextField().setText("");		
			igLogin.getSenhaPasswordField().setText("");
			igLogin.getMensagemLabel().setText("Informe o usuário e a senha e clique em Entrar.");
			igLogin.dispose();			
			
			new IgCaixa(igLogin);
		}		
	}

}
