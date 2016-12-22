package br.superdia.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemVenda {
	
	@Id
	@SequenceGenerator(name = "item_venda_id", sequenceName = "item_venda_seq", allocationSize = 1)
	@GeneratedValue(generator = "item_venda_id", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne
	private Venda venda;
	
	@OneToOne
	private Produto produto;
	
	@Column(nullable=false)
	private Long quantidade;

	public ItemVenda() {}

	public ItemVenda(Venda venda, Produto produto, Long quantidade) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
}
