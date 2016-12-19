package br.superdia.app;

import static javax.swing.JOptionPane.CLOSED_OPTION;
import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showOptionDialog;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.superdia.webservice.ClientService;
import br.superdia.webservice.ClientServiceService;
import br.superdia.webservice.Produto;

public class SuperdiaSFSB {

	private static final String NOME_PROGRAMA = "Caixa Super Dia";
	private static final String ADICONA_PRODUTO = "Adicionar Produto";
	private static final String LISTA_PRODUTO = "Lista Produto";
	private static final String ALTERA_PRODUTO = "Altera Produto";
	private static final String REMOVE_PRODUTO = "Remove Produto";
	private static final String FINALIZA_COMPRA = "Finaliza Produto";

	private static ClientService client;
	private static Produto produto;
	
	public SuperdiaSFSB() {
		produto = new Produto();
		try {
			criaConexao();
			menu();
			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SuperdiaSFSB();
	}

	/**
	 * Obtem conexão com webService disponibilizado pelo SuperDiaEAR
	 * Com todas as funções do Carrinho.
	 * 
	  	client.addProdutoCarrinho(Long id);
		client.cleanCarrinho();

		client.getCarrinho();
		client.getProdutos();
		client.removeProdutoCarrinho(Long id);

		Ainda não esta funcionando... Irei Criar o WebService para 
		utilizar a questões do usuario.
		client.endsBuy(Usuario usuario);
	 */
	private static void criaConexao(){
		ClientServiceService service = new ClientServiceService();
		client = service.getClientServicePort();

	}

	private static void menu(){

		int opcao;
		String opcoes[] = {"Adicionar", "Listar", "Remover", "Alterar", "Finalizar Compra", "Sair"};

		do {
			opcao = showOptionDialog(null, "Escolha um comando abaixo.", NOME_PROGRAMA, DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcoes[0]);

			if (opcao != CLOSED_OPTION && opcao != 5) {
				switch(opcao) {
				case 0: adiciona(); break;
				case 1: lista(); break;
				case 2: remove(produto); break;
				case 3: altera(produto);break;
				case 4: finalizaCompra(produto); break;
				}
			}
		}while(opcao != CLOSED_OPTION && opcao != 5);
	}

	public static Produto adiciona() {
		lista();
		
		List<Produto> produtos = client.getProdutos();
		
		String nome = lerString("Informe o Produto que deseja adicionar ao carrinho: ", 
				"Você deve fornecer o produto a ser adicionado", NOME_PROGRAMA + "-" + 
		ADICONA_PRODUTO, false);
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
				client.addProdutoCarrinho(produtos.get(i).getId());
			}
		}
		return produto;
	}

	public static void lista() {
		List<Produto> produtos = client.getProdutos();
		String lista = "";
		JTextArea listaJT = new JTextArea(10, 50);
		
		for (int i = 0; i < produtos.size(); i++) {
			lista += "Nome: " + produtos.get(i).getNome() + "\n";
			lista += "Descrição: " + produtos.get(i).getDescricao() + "\n";
			lista += "Preço: R$" + produtos.get(i).getPreco() + "\n";
			lista += "Vendido por: " + produtos.get(i).getVendidoPor() + "\n";
			lista += "Estoque Mínimo: " + produtos.get(i).getEstoqueMinimo() + "\n";
			lista += "Quantidade em Estoque: " + produtos.get(i).getQuantidadeEstoque() + "\n\n\n";
		}
		listaJT.setText(lista);
		msgInfo(new JScrollPane(listaJT), NOME_PROGRAMA + "-" + LISTA_PRODUTO);
	}
	
	public static void remove(Produto produto){
		/*int op = showConfirmDialog(null, String.format("Nome: %s\nDescrição: %s\nPreço: %1.2f\nVendido Por: %s\nEstoque Mínimo: %d\n"
				+ "Quantidade em Estoque: %d\n\nDeseja remover este produto?", 
				produto.getNome(), produto.getDescricao(), produto.getPreco(), 
				produto.getVendidoPor(), produto.getEstoqueMinimo(), produto.getQuantidadeEstoque()),
				"Remover Produto", YES_NO_OPTION, QUESTION_MESSAGE);*/
		/*if(op == YES_OPTION)
			iproduto.remove(produto);*/
		/*else
			msgInfo("Operação Cancelada", "Remover Produto");*/
	}

	public static void altera(Produto produto){
		//int pesquisar = iproduto.s
				//produto = iproduto.getForId(produto.getId(), Produto.class);

			/*	boolean alterou = false;
		String nome = lerString("Nome: ", "Você deve fornecer o nome!", "Alterar Produto", true);
		if(nome != null){
			produto.setNome(nome);
			alterou = true;
		}
		String descricao = lerString("Descrição: ", "Vocẽ deve fornecer uma descrição", "Alterar Produto", true);
		if(descricao != null){
			produto.setDescricao(descricao);
			alterou = true;
		}
		Double preco = lerNumeroReal("Preço: ", "Você deve fornecer o preço", "Adiciona Produto", true);
		if(preco != null){
			produto.setPreco(preco);	
			alterou = true;
		}
		String vendidoPor = lerString("Vendido Por: ", "Vocẽ deve fornecer quem vendeu o produto", "Adiconar Produto", true);
		if(vendidoPor != null){
			produto.setVendidoPor(vendidoPor);
			alterou = true;
		}
		Integer estoqueMinimo = lerNumeroInteiro("Estoque Mínimo: ", "Você deve fornecer o estoque mínimo!", "Alterar Produto", true);
		if(estoqueMinimo != null){
			produto.setEstoqueMinimo(estoqueMinimo);
			alterou = true;
		}
		Integer quantidadeEstoque = lerNumeroInteiro("Quantidade de Estoque: ", "Você deve fornecer a quantidade de estoque!",
				"Alterar Produto", true);
		if(quantidadeEstoque != null){
			produto.setQuantidadeEstoque(quantidadeEstoque);
			alterou = true;
		}*/

		/*if(alterou)
			iproduto.update(produto);*/
	}
	
	public static void finalizaCompra(Produto produto) {
		
	}

	public static String lerString(String prompt, String msgErro, String modulo, boolean vazia) {
		String string;

		do {
			string = showInputDialog(null, prompt, modulo, QUESTION_MESSAGE);

			if (string == null) break;

			if (string.equals("") && !vazia)
				showMessageDialog(null, msgErro, modulo, ERROR_MESSAGE);
		} while(string.equals("") && !vazia);
		return string;
	}

	public static Double lerNumeroReal(String prompt, String msgErro, String modulo, boolean vazio) {
		String valor;

		do {
			valor = showInputDialog(null, prompt, modulo, QUESTION_MESSAGE);

			if (valor == null) return null;

			if (valor.equals("") && !vazio)
				showMessageDialog(null, msgErro, modulo, ERROR_MESSAGE);
		} while (valor.equals("") && !vazio);

		// COnverte a string lida pra double.
		return Double.parseDouble(valor);
	}

	public static Integer lerNumeroInteiro(String prompt, String msgErro, String modulo, boolean vazio) {
		String valor;

		do {
			valor = showInputDialog(null, prompt, modulo, QUESTION_MESSAGE);

			if (valor == null) return null;

			if (valor.equals("") && !vazio)
				showMessageDialog(null, msgErro, modulo, ERROR_MESSAGE);
		} while (valor.equals("") && !vazio);

		// COnverte a string lida pra inteiro.
		return Integer.parseInt(valor);
	}

	private static void msgInfo(Object mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, INFORMATION_MESSAGE);
	}

	private static void msgErro(Object mensagem, String titulo) {
		showMessageDialog(null, mensagem, titulo, ERROR_MESSAGE);
	}
}
