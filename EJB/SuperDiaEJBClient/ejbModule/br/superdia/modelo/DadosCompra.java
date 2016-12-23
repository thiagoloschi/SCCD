package br.superdia.modelo;

import java.util.ArrayList;
import java.util.List;

public class DadosCompra {
	private String tipo;
	private String numero;
	private List<ItemVenda> itens_venda = new ArrayList<>();
	
	public List<ItemVenda> getItens_venda() {
		return itens_venda;
	}

	public void setItens_venda(List<ItemVenda> itens_venda) {
		this.itens_venda = itens_venda;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
