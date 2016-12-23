package trabalho.sccd.utils;

public final class Constantes {

    private Constantes(){}

    public static final String URL_API = "http://192.168.0.16:8080";
    public static final String URL_API_LISTAR_PRODUTOS = URL_API + "/SuperDiaRestFul/rest/produtos/listar?token=#{token}";
    public static final String URL_API_AUTENTICAR = URL_API + "/SuperDiaRestFul/rest/usuarios/autenticar";
    public static final String URL_API_CADASTRAR = URL_API + "/SuperDiaRestFul/rest/usuarios/inserir";

}
