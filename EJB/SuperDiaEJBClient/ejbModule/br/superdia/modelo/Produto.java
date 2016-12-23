package br.superdia.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "produto_id", sequenceName = "produto_seq", allocationSize = 1)
	@GeneratedValue(generator = "produto_id", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 300)
	private String descricao;
	@Column(nullable = false)
	private Double preco;
	@Column(nullable=false)
	private String vendidoPor;
	private int estoqueMinimo;
	private int quantidadeEstoque;
	
	public Produto() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendidoPor() {
		return vendidoPor;
	}

	public void setVendidoPor(String vendidoPor) {
		this.vendidoPor = vendidoPor;
	}

	@Override
	public String toString() {
		return "produto:[id:" + id + ",nome:" + nome + ",descricao:" + descricao + ",preco:" + preco
				+ ",vendidoPor:" + vendidoPor + ",estoqueMinimo:" + estoqueMinimo + ",quantidadeEstoque:"
				+ quantidadeEstoque + "]";
	}
	
	

}
