package br.superdia.se.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.superdia.modelo.Produto;
import br.superdia.sessionbean.IDAO;
import jdk.nashorn.internal.runtime.ListAdapter;

public class SuperDiaSFSB {
	private static IDAO<Produto> iproduto;
	private static Produto produto;

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); 

		InitialContext ic;
		try {
			ic = new InitialContext(props);
			iproduto = (IDAO<Produto>) ic.lookup("br.superdia.sessionbean.IDAO");

			String op = "";
			Scanner scanner = new Scanner(System.in);

			do{

				op = menu();

				switch (op) {

				case "1":
					iproduto.add(adiciona());
					System.out.println("\nProduto Gravado\n");
					break;

				case "2":
					lista();
					break;

				case "3":
					System.exit(0);
					break;
				default:
					break;
				}

			}while(op != "3");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String menu(){

		String op;

		System.out.println("\n1.Adicionar\n2.Listar\n3.Sair\nOp: ");
		Scanner scanner = new Scanner(System.in);
		op = scanner.next();
		return op;
	}

	public static Produto adiciona() {
		produto = new Produto();
		System.out.println("Nome: ");
		Scanner scanner = new Scanner(System.in);
		produto.setNome(scanner.nextLine());

		System.out.println("Descrição: ");
		produto.setDescricao(scanner.nextLine());

		System.out.println("Preço: ");
		produto.setPreco(scanner.nextDouble());
		
		System.out.println("Quantidade em Estoque: ");
		produto.setQuantidadeEstoque(scanner.nextInt());
		
		System.out.println("Estoque Mínimo: ");
		produto.setEstoqueMinimo(scanner.nextInt());

		System.out.println("Vendido por: ");
		produto.setVendidoPor(scanner.next());
		
		return produto;
	}
	
	public static void lista() {
		List<Produto> produtos = iproduto.getAll(Produto.class);
		
		System.out.println(produtos.size());
		
		for (int i = 0; i < produtos.size(); i++) {
			printProduto(produtos.get(i));
			//produtos.get(i).getNome();
		}
		
	}
	
	public static void printProduto(Produto produto) {
		String.format("Nome: %s\nDescrição: %s\nPreço: %1.2f\nVendido Por: %s\nEstoque Mínimo: %d\n"
				+ "Quantidade em Estoque: %d", 
				produto.getNome(), produto.getDescricao(), produto.getPreco(), 
				produto.getVendidoPor(), produto.getEstoqueMinimo(), produto.getQuantidadeEstoque());
		
	}

}
