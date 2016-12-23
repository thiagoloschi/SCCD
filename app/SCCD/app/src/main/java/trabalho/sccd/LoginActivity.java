package trabalho.sccd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import trabalho.sccd.model.Login;
import trabalho.sccd.model.Produto;
import trabalho.sccd.model.Usuario;
import trabalho.sccd.utils.Constantes;
import trabalho.sccd.utils.Preferencias;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.password) EditText passwordField;
    @BindView(R.id.login) EditText loginField;
    @BindView(R.id.logar) Button loginButtonTo;
    SharedPreferences pref;
    SharedPreferences.Editor editor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @OnClick(R.id.logar)
    public void efeturLogin(Button button) {

        pref = getApplicationContext().getSharedPreferences("sccd.app", 0); // 0 - for private mode
        editor = pref.edit();

        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = Constantes.URL_API_AUTENTICAR;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("usuario", loginField.getText().toString());
            jsonBody.put("senha", passwordField.getText().toString());
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        Log.i("Login Response",response);
                        Usuario usuario = new Gson().fromJson(response, Usuario.class);
                        finalizarLogin(usuario);

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Login não efetuado!", Toast.LENGTH_SHORT).show();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        Log.i("LOGIN",requestBody);
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    String jsonString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.headers);
                        // can get more details such as response.headers

                        try {
                            jsonString = new String(response.data, "UTF-8");
                        }catch (UnsupportedEncodingException e){
                            e.printStackTrace();
                        }
                    }
                    return Response.success(jsonString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void finalizarLogin(Usuario usuario){

        Preferencias preferencias = new Preferencias(this);
        preferencias.setUsuario(usuario.getUsuario());
        preferencias.setSenha(usuario.getSenha());
        preferencias.setToken(usuario.getToken());

        editor.putString("token", usuario.getToken()); // Storing string
        editor.putString("usuario", usuario.getUsuario()); // Storing string
        editor.putString("perfil", usuario.getPerfil()); // Storing string
        editor.putString("id", usuario.getId().toString()); // Storing string
        editor.commit();

        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}
