package trabalho.sccd.model;

import java.util.ArrayList;

/**
 * Created by mjunior on 23/12/16.
 */

public class Carrinho {
    private static ArrayList<Produto> carrinho = new ArrayList<Produto>();

    public static ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public static void setCarrinho(Produto produto) {
        Carrinho.carrinho.add(produto);
    }
}
