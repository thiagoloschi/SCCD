package trabalho.sccd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Define o modelo com a estrutura obtida através da requisição http. Isso é necessário para que a API
 * do Gson possa fazer o parser do objeto de forma correta.
 */

public class ProdutosJSON {
    private int error;
    private List<Produto> produtos = new ArrayList<>();

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
