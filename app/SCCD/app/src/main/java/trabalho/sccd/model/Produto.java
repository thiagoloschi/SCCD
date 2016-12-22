package trabalho.sccd.model;

public class Produto{
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String vendidoPor;
    private String estoqueMinimo;
    private int quantidadeEstoque;

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(String estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getVendidoPor() {
        return vendidoPor;
    }

    public void setVendidoPor(String vendidoPor) {
        this.vendidoPor = vendidoPor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
