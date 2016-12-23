package trabalho.sccd.utils;

public final class Constantes {

    private Constantes(){}

    public static final String URL_API = "http://192.168.0.101:8080";
    public static final String URL_API_LISTAR_PRODUTOS = URL_API + "/SuperDiaRestFul/rest/produtos/listar?token=#{token}";
    public static final String URL_API_AUTENTICAR = URL_API + "/SuperDiaRestFul/rest/usuarios/autenticar";

    public static final String URL_API_ADD_PRODUTO_CARRINHO = URL_API + "/SuperDiaRestFul/rest/carrinho/inserir?token=#{token}";

}
