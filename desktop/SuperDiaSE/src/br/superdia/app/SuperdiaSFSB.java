package br.superdia.app;

import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showOptionDialog;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import br.superdia.webservice.ClientService;
import br.superdia.webservice.ClientServiceService;
import br.superdia.webservice.Produto;
import br.superdia.webservice.Usuario;

public class SuperdiaSFSB {

	private static final String NOME_PROGRAMA = "Caixa Super Dia";
	private static final String ADICONA_PRODUTO = "Adicionar Produto";
	private static final String LISTA_PRODUTO = "Lista Produto";
	private static final String LISTA_PRODUTO_CAIXA = "Lista Produto Caixa";
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
		String opcoes[] = {"Adicionar", "Listar Caixa", "Remover", "Finalizar Compra", "Sair"};

		do {
			opcao = showOptionDialog(null, "Escolha um comando abaixo.", NOME_PROGRAMA, DEFAULT_OPTION, QUESTION_MESSAGE, null, opcoes, opcoes[0]);

			if (opcao != CLOSED_OPTION && opcao != 4) {

				if (opcao == 0)
					adiciona();
				else 
					if (client.getCarrinho().isEmpty()) {
						msgInfo("O caixa está vazio", NOME_PROGRAMA + LISTA_PRODUTO_CAIXA);
					}
					else 
						switch(opcao) {
						case 1:
							listaCaixa();
							break;
						case 2: 
							remove(produto);
							break;
						case 3: 
							finalizaCompra(produto); 
							break;
						}
			}
		}while(opcao != CLOSED_OPTION && opcao != 4);
	}

	public static Produto adiciona() {
		listaProduto();

		List<Produto> produtos = client.getProdutos();

		int codigo = lerNumeroInteiro("Informe o Código do Produto que deseja adicionar ao carrinho: ", 
				"Você deve fornecer o produto a ser adicionado", NOME_PROGRAMA + "-" + 
						ADICONA_PRODUTO, false);

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == codigo) {
				int op = showConfirmDialog(null, String.format("Código: %d\nNome: %s\nDescrição: %s\nPreço: %1.2f\nVendido Por: %s\nEstoque Mínimo: %d\n"
						+ "Quantidade em Estoque: %d\n\nDeseja adicionar este produto?", produtos.get(i).getId(), 
						produtos.get(i).getNome(), produtos.get(i).getDescricao(), produtos.get(i).getPreco(), 
						produtos.get(i).getVendidoPor(), produtos.get(i).getEstoqueMinimo(), produtos.get(i).getQuantidadeEstoque()),
						NOME_PROGRAMA + "-" + ADICONA_PRODUTO, YES_NO_OPTION, QUESTION_MESSAGE);
				if(op == YES_OPTION) {
					client.addProdutoCarrinho(produtos.get(i).getId());
					msgInfo("Produto adicionado com sucesso!", NOME_PROGRAMA + "-" + ADICONA_PRODUTO);
				}
				else
					msgInfo("Operação Cancelada", NOME_PROGRAMA + "-" + ADICONA_PRODUTO);
			}
		}
		return produto;
	}

	public static void listaCaixa() {
		List<Produto> produtos = client.getCarrinho();
		String lista = "";
		JTextArea listaJT = new JTextArea(10, 50);

		for (int i = 0; i < produtos.size(); i++) {
			lista += "Código: " + produtos.get(i).getId() + "\n";
			lista += "Nome: " + produtos.get(i).getNome() + "\n";
			lista += "Descrição: " + produtos.get(i).getDescricao() + "\n";
			lista += "Preço: R$" + produtos.get(i).getPreco() + "\n";
			lista += "Vendido por: " + produtos.get(i).getVendidoPor() + "\n";
			lista += "Estoque Mínimo: " + produtos.get(i).getEstoqueMinimo() + "\n";
			lista += "Quantidade em Estoque: " + produtos.get(i).getQuantidadeEstoque() + "\n\n\n";
		}
		listaJT.setText(lista);
		msgInfo(new JScrollPane(listaJT), NOME_PROGRAMA + "-" + LISTA_PRODUTO_CAIXA);
	}

	public static void listaProduto() {
		List<Produto> produtos = client.getProdutos();
		String lista = "";
		JTextArea listaJT = new JTextArea(10, 50);

		for (int i = 0; i < produtos.size(); i++) {
			lista += "Código: " + produtos.get(i).getId() + "\n";
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
		listaCaixa();

		List<Produto> produtos = client.getProdutos();

		int codigo = lerNumeroInteiro("Informe o Código do Produto que deseja remover do carrinho: ", 
				"Você deve fornecer o produto a ser adicionado", NOME_PROGRAMA + "-" + 
						REMOVE_PRODUTO, false);

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == codigo) {
				int op = showConfirmDialog(null, String.format("Código: %d\nNome: %s\nDescrição: %s\nPreço: %1.2f\nVendido Por: %s\nEstoque Mínimo: %d\n"
						+ "Quantidade em Estoque: %d\n\nDeseja remover este produto?", produtos.get(i).getId(), 
						produtos.get(i).getNome(), produtos.get(i).getDescricao(), produtos.get(i).getPreco(), 
						produtos.get(i).getVendidoPor(), produtos.get(i).getEstoqueMinimo(), produtos.get(i).getQuantidadeEstoque()),
						NOME_PROGRAMA + "-" + REMOVE_PRODUTO, YES_NO_OPTION, QUESTION_MESSAGE);
				if(op == YES_OPTION) {
					client.removeProdutoCarrinho(produtos.get(i).getId());
					msgInfo("Produto removido com sucesso!", NOME_PROGRAMA + "-" + REMOVE_PRODUTO);
				}
				else
					msgInfo("Operação Cancelada",  NOME_PROGRAMA + "-" + REMOVE_PRODUTO);
			}
		}
	}

	public static void finalizaCompra(Produto produto) {
		Usuario usuario = new Usuario();


		client.cleanCarrinho();
		client.endsBuy(usuario);
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
