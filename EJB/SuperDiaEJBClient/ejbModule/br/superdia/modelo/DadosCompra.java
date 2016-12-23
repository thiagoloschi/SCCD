package br.superdia.modelo;

import java.util.ArrayList;
import java.util.List;

public class DadosCompra {
	private String tipo;
	private String numero;
	private List<ItemVenda> itensVenda = new ArrayList<>();
	
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
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
