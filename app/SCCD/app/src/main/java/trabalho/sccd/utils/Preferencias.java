package trabalho.sccd.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import java.util.Map;

import trabalho.sccd.R;

public class Preferencias {
    public static final String NOME_PREFERENCIAS = "sccd.app";
    private SharedPreferences settings;
    private Context contexto;
    private static final String VERSION_CODE = "version_code";
    private static final String USUARIO = "usuario";
    private static final String SENHA = "senha";
    private static final String TOKEN = "token";


    public Preferencias(Context contexto) {
        //Restaura as preferencias gravadas
        this.contexto = contexto;
        settings = this.contexto.getSharedPreferences(NOME_PREFERENCIAS, 0);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> getPreferencias(){
        if(settings != null){
            return (Map<String, String>)settings.getAll();
        }
        return null;
    }

    private void addPreferencia(String nome, String valor){
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(nome, valor);

        //Confirma a gravação dos dados
        editor.commit();
    }

    //Clear elements if versionCode is different
    public void clearElementsIfNecessary(){
        int versionCode = 0;
        try {
            versionCode = contexto.getPackageManager().getPackageInfo(contexto.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        SharedPreferences.Editor editor = settings.edit();
        if (settings.getInt(VERSION_CODE, 0) != versionCode) {
            try {
                editor.putInt(VERSION_CODE, versionCode);
                editor.commit();
            } catch(Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public void setUsuario(String usuario){
        this.addPreferencia(USUARIO, usuario);
    }

    public String getUsuario(){
        return settings.getString(USUARIO, null);
    }

    public void setSenha(String senha){
        this.addPreferencia(SENHA, senha);
    }

    public String getSenha(){
        return settings.getString(SENHA, null);
    }

    public void setToken(String token){
        this.addPreferencia(TOKEN, token);
    }

    public String getToken(){
        return settings.getString(TOKEN, null);
    }
}