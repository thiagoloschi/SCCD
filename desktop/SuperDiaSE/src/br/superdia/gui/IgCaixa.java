package br.superdia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.superdia.app.SuperDiaApp;
import br.superdia.webservice.Produto;

public class IgCaixa extends JDialog {
			
	private JList<String> produtosJList;
	private DefaultListModel<String> produtosListModel = new DefaultListModel<>(), 
									 caixaListModel = new DefaultListModel<>();  
	private JList<String> caixaJList;
	private JButton addicionarButton;
	private JButton removerButton;
	private JButton finalizarCompraButton;
	private JLabel usuarioLogadoLabel;
	private IgLogin igLogin;
	private IgFinalizarCompra igFinalizarCompra;
		
	SuperDiaApp superDiaApp;
	
	/**
	 * Cria e exibe a GUI.
	 */
	
	public IgCaixa(IgLogin igLogin) {
		this.igLogin = igLogin;
		this.superDiaApp = igLogin.getSuperDiaApp();
			
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("clicou em fechar igCaixa");
				listaProdutosComprados();				
				fechar();
				igLogin.setVisible(true);
			}
		});

		//usuarioLogadoLabel.setText(igLogin.getSuperDiaApp().getUsuarioLogado().getUsuario());
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Cria a caixa de listagem.
		produtosJList = new JList<>();
		
		obterProdutos();
		
		produtosJList.setBackground(new Color(255, 255, 224));
		
		JLabel produtosLabel = new JLabel("Produtos - Carrinho");
		produtosLabel.setDisplayedMnemonic(KeyEvent.VK_I);
		produtosLabel.setBounds(12, 80, 132, 16);
		contentPanel.add(produtosLabel);
		
		JScrollPane produtosScrollPane = new JScrollPane();
		produtosScrollPane.setBounds(12, 97, 205, 294);
		contentPanel.add(produtosScrollPane);
		
		// Define a caixa de listagem como o objeto a ser exibido na �rea de visualiza��o do painel rol�vel.
		produtosScrollPane.setViewportView(produtosJList);
		
		// Define o modelo usado pela  caixa de listagem.
		produtosJList.setModel(produtosListModel);
		
		// Define qual o item ser� exibido selecionado na caixa de listagem.  
		produtosJList.setSelectedIndex(0);
		
		produtosJList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		produtosLabel.setLabelFor(produtosJList);
		
		JPanel carrinhoPanel = new JPanel();
		carrinhoPanel.setBackground(new Color(255, 255, 255));
		carrinhoPanel.setBounds(227, 80, 318, 314);
		contentPanel.add(carrinhoPanel);
		carrinhoPanel.setLayout(null);
						
		addicionarButton = new JButton("Adicionar >>");
		addicionarButton.setBounds(0, 139, 105, 26);
		carrinhoPanel.add(addicionarButton);
		
		removerButton = new JButton("<< Remover");
		removerButton.setEnabled(false);
		removerButton.setBounds(0, 191, 105, 26);
		carrinhoPanel.add(removerButton);
		
		JLabel carrinhoLabel = new JLabel("Caixa");
		carrinhoLabel.setBounds(115, 0, 114, 16);
		carrinhoPanel.add(carrinhoLabel);
		carrinhoLabel.setDisplayedMnemonic(KeyEvent.VK_E);
						
		JScrollPane carrinhoScrollPane = new JScrollPane();
		carrinhoScrollPane.setBounds(116, 18, 202, 296);
		carrinhoPanel.add(carrinhoScrollPane);
				
		caixaJList = new JList<String>();
		caixaJList.setBackground(new Color(255, 255, 224));
		carrinhoScrollPane.setViewportView(caixaJList);
		caixaJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		caixaJList.setSelectedIndex(0);
		caixaJList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		caixaJList.setModel(caixaListModel);
								
		JPanel logoPanel = new JPanel();
		logoPanel.setLayout(null);
		logoPanel.setBackground(new Color(60, 179, 113));
		logoPanel.setBounds(0, 0, 562, 57);
		contentPanel.add(logoPanel);
		
		JLabel msgLogLabel = new JLabel("Centro Distribuição - SuperDia");
		msgLogLabel.setForeground(Color.WHITE);
		msgLogLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		msgLogLabel.setBounds(10, 11, 253, 35);
		logoPanel.add(msgLogLabel);
		
		finalizarCompraButton = new JButton("Finalizar Compra");
		finalizarCompraButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		finalizarCompraButton.setBounds(371, 405, 174, 36);
		contentPanel.add(finalizarCompraButton);
		
		usuarioLogadoLabel = new JLabel("");
		usuarioLogadoLabel.setBounds(81, 411, 149, 29);
		contentPanel.add(usuarioLogadoLabel);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setBounds(12, 413, 59, 23);
		contentPanel.add(lblUsurio);
		lblUsurio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		removerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerProduto();
			}
		});
		
		finalizarCompraButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aqui o que fazer ao finalizar a compra
				
			}
		});
		
		addicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarProduto();
			}
		});
				
		setTitle("Caixa - Centro Distribuição - SuperDia");
		setBounds(100, 100, 568, 481);
		setResizable(false);
		setVisible(true);
	} // construtor
	
	private void obterProdutos() {	
		/* Utiliza o modelo de dados da caixa de listagem para exibir os produtos na caixa de listagem. */
		produtosListModel.clear();
		for (String produto : listaNomeProdutos())
			produtosListModel.addElement(produto);
	}
	
	/**
	 * Remove o produto selecionado da caixa de listagem <strong>caixa</strong> e adiciona na caixa de 
	 * listagem <strong>Produtos - Carrinho</strong>. Mantem a lista de produtos na caixa de listagem 
	 * <strong>Produtos - Carrinho</strong> sempre ordenada.
	 */
	private void removerProduto() {
		atualizaLista(produtosListModel, caixaJList.getSelectedValue());
		caixaListModel.removeElement(caixaJList.getSelectedValue());
		
		ativarOuDesativarBotoes();		
	}
	
	/**
	 * Adiciona os produtos selecionados na caixa de listagem <strong>caixa</strong> e remove da caixa de listagem produtos.
	 * Mantem a lista de produtos na caixa de listagem <strong>caixa</strong> sempre ordenada. 
	 */
	private void adicionarProduto() {
		for (String produto : produtosJList.getSelectedValuesList().toArray(new String[0])) {
			atualizaLista(caixaListModel, produto);
			produtosListModel.removeElement(produto);
		}
		ativarOuDesativarBotoes();
	}
	
	/**
	 * Verifica se os botoes Adicionar e Remover devem ser ativados ou desativados.
	 */
	private void ativarOuDesativarBotoes() {
		if (produtosListModel.isEmpty()) addicionarButton.setEnabled(false); 
		else addicionarButton.setEnabled(true);
		
		if (caixaListModel.isEmpty()) removerButton.setEnabled(false);
		else removerButton.setEnabled(true);
	}
	
	/**
	 * Adiciona um item na lista mantendo-a ordenanda.
	 */
	private void atualizaLista(DefaultListModel<String> listModel, String item) {
		listModel.addElement(item);
		Object[] itens = listModel.toArray();
		listModel.clear();
		
		Arrays.sort(itens);
		for (Object i : itens) 
			listModel.addElement((String) i);
	}
	
	/**Obtem uma lista somente com os nomes de todos os produtos cadastrados*/
	private List<String> listaNomeProdutos() {		
		List<Produto> produtos = superDiaApp.getClient().getProdutos();
		
		List<String> nomeProdutos = new ArrayList<>();
		
		for (Produto produto : produtos)
			nomeProdutos.add(produto.getNome());
		
		return nomeProdutos;
	}
	
	/**Fecha a janela do caixa*/
	private void fechar(){
		this.dispose();
	}
	
	/**Obtem uma lista com os nomes dos produtos adicionado ao caixa.*/
	private List<String> listaProdutosNoCaixa(){
		ArrayList<String> produtosNoCaixa = Collections.list(caixaListModel.elements());		
		return produtosNoCaixa;
	}
	
	/**Obtem uma lista com todos os produtos que foram adicionados no caixa*/
	private List<Produto> listaProdutosComprados(){
		List<Produto> todosProdutos = superDiaApp.getClient().getProdutos();
		List<String> nomesProdutosComprados = listaProdutosNoCaixa();
		List<Produto> produtosComprados = new ArrayList<>();
		
		for (String nomeProduto : nomesProdutosComprados) {
			for (Produto produto : todosProdutos) {
				if(nomeProduto.equalsIgnoreCase(produto.getNome())){
					produtosComprados.add(produto);
				}
			}			
		}		
		return produtosComprados;		
	}

	public JList<String> getProdutosJList() {
		return produtosJList;
	}

	public void setProdutosJList(JList<String> produtosJList) {
		this.produtosJList = produtosJList;
	}

	public DefaultListModel<String> getProdutosListModel() {
		return produtosListModel;
	}

	public void setProdutosListModel(DefaultListModel<String> produtosListModel) {
		this.produtosListModel = produtosListModel;
	}

	public DefaultListModel<String> getCaixaListModel() {
		return caixaListModel;
	}

	public void setCaixaListModel(DefaultListModel<String> caixaListModel) {
		this.caixaListModel = caixaListModel;
	}

	public JList<String> getCaixaJList() {
		return caixaJList;
	}

	public void setCaixaJList(JList<String> caixaJList) {
		this.caixaJList = caixaJList;
	}

	public JButton getAddicionarButton() {
		return addicionarButton;
	}

	public void setAddicionarButton(JButton addicionarButton) {
		this.addicionarButton = addicionarButton;
	}

	public JButton getRemoverButton() {
		return removerButton;
	}

	public void setRemoverButton(JButton removerButton) {
		this.removerButton = removerButton;
	}

	public JButton getFinalizarCompraButton() {
		return finalizarCompraButton;
	}

	public void setFinalizarCompraButton(JButton finalizarCompraButton) {
		this.finalizarCompraButton = finalizarCompraButton;
	}

	public JLabel getUsuarioLogadoLabel() {
		return usuarioLogadoLabel;
	}

	public void setUsuarioLogadoLabel(JLabel usuarioLogadoLabel) {
		this.usuarioLogadoLabel = usuarioLogadoLabel;
	}

	public IgLogin getIgLogin() {
		return igLogin;
	}

	public void setIgLogin(IgLogin igLogin) {
		this.igLogin = igLogin;
	}

	public SuperDiaApp getSuperDiaApp() {
		return superDiaApp;
	}

	public void setSuperDiaApp(SuperDiaApp superDiaApp) {
		this.superDiaApp = superDiaApp;
	}

	public IgFinalizarCompra getIgFinalizarCompra() {
		return igFinalizarCompra;
	}

	public void setIgFinalizarCompra(IgFinalizarCompra igFinalizarCompra) {
		this.igFinalizarCompra = igFinalizarCompra;
	}
} // class IgComboBoxList
