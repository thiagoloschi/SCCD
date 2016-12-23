package trabalho.sccd.model;

/**
 * Created by mjunior on 23/12/16.
 */

public class Usuario {
    //{"id":1,"usuario":"mauricio","senha":"1234","perfil":"cliente","token":""}
    private Long id;
    private String usuario;
    private String senha;
    private String perfil;
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
