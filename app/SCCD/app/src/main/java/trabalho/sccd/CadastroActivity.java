package trabalho.sccd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import trabalho.sccd.model.Usuario;
import trabalho.sccd.utils.Constantes;

public class CadastroActivity extends AppCompatActivity {
    @BindView(R.id.passwordCadastro) EditText passwordField;
    @BindView(R.id.emailCadastro) EditText loginField;
    @BindView(R.id.cadastrar) Button buttonCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

    }

    @OnClick(R.id.cadastrar)
    public void realizarCadastro(Button button) {
        Usuario usuario = new Usuario();
        usuario.setSenha(passwordField.getText().toString());
        usuario.setUsuario(loginField.getText().toString());
        usuario.setPerfil("cliente");
        if(!usuario.isValid()) {
            Toast.makeText(getApplicationContext(),"Usuário invalido", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = Constantes.URL_API_CADASTRAR;
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("usuario", loginField.getText().toString());
            jsonBody.put("senha", passwordField.getText().toString());
            jsonBody.put("perfil", "cliente");
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        Log.i("Login Response",response);
                        Toast.makeText(getApplicationContext(),"Cadastro efetuado!", Toast.LENGTH_SHORT).show();

                        finalizarCadasto();

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Cadastro não efetuado!", Toast.LENGTH_SHORT).show();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY onErrorResponse", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        Log.i("Cadastro: ",requestBody);
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

    public void finalizarCadasto(){
        loginField.setText("");
        passwordField.setText("");

        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
