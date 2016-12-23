package trabalho.sccd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import trabalho.sccd.controller.RequestURL;
import trabalho.sccd.model.Usuario;
import trabalho.sccd.utils.Constantes;
import trabalho.sccd.utils.Preferencias;


public class PagamentoActivity extends AppCompatActivity {

    @BindView(R.id.cartao_numero) EditText cartaoNumeroField;
    @BindView(R.id.cartao_cvv) EditText cartaoCvvField;
    @BindView(R.id.cartao_data) EditText cartaoDataField;

    SharedPreferences pref;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_pagamento);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.activity_pagamento_finalizar_compra)
    public void finalizarCompra(Button button) {
        Preferencias preferencias = new Preferencias(this);
        String token = preferencias.getToken();

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("cartao", cartaoNumeroField.getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String requestBody = jsonBody.toString();

        RequestURL req = new RequestURL(this);
        req.request_POST_URL(String.format(Constantes.URL_API_FINALIZAR_CARRINHO.replace("#{token}",token)), requestBody, new RequestURL.VolleyCallback() {
            @Override
            public void onSuccess(String response) {
                System.out.println("Finalizar Carrinho:" + response);
                Gson gson = new Gson();
                try{

                }catch (Exception e){

                }
            }
        });
    }
}
