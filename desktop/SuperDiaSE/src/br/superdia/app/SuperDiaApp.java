package br.superdia.app;

import br.superdia.gui.IgCaixa;
import br.superdia.gui.IgLogin;
import br.superdia.webservice.ClientService;
import br.superdia.webservice.ClientServiceService;
import br.superdia.webservice.Produto;
import br.superdia.webservice.UserServiceService;
import br.superdia.webservice.Usuario;

public class SuperDiaApp {
	private ClientService client;
	private Produto produto;
	private Usuario usuario, usuarioLogado;
	private Produto permitido;
	private Integer codigo;
	private UserServiceService userServiceService;
	private IgCaixa igCaixa;
	
	public SuperDiaApp() {
		criaConexao();
		userServiceService = new UserServiceService();
		usuarioLogado = new Usuario();
		new IgLogin(this);
		
		//new IgCaixa(null, this);
	}

	public static void main(String[] args) {
		new SuperDiaApp();
	}

	public void criaConexao(){
		ClientServiceService service = new ClientServiceService();
		client = service.getClientServicePort();		
	}
	
	public UserServiceService getUserServiceService() {
		return userServiceService;
	}

	public void setUserServiceService(UserServiceService userServiceService) {
		this.userServiceService = userServiceService;
	}

	public ClientService getClient() {
		return client;
	}

	public void setClient(ClientService client) {
		this.client = client;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Produto getPermitido() {
		return permitido;
	}

	public void setPermitido(Produto permitido) {
		this.permitido = permitido;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public IgCaixa getIgCaixa() {
		return igCaixa;
	}

	public void setIgCaixa(IgCaixa igCaixa) {
		this.igCaixa = igCaixa;
	}	
}
