package trabalho.sccd;

<<<<<<< HEAD
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
=======

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
>>>>>>> 84cc2ea9b9e1716ab2bf2b7cc8e040ec10642684

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
<<<<<<< HEAD
import trabalho.sccd.model.Login;
import trabalho.sccd.model.Produto;
import trabalho.sccd.model.Usuario;
import trabalho.sccd.utils.Constantes;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.password) EditText passwordField;
    @BindView(R.id.login) EditText loginField;
    @BindView(R.id.logar) Button loginButtonTo;
    SharedPreferences pref;
    SharedPreferences.Editor editor ;
=======
import trabalho.sccd.activity.FragmentDrawer;
import trabalho.sccd.model.Produto;

public class LoginActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    @BindView(R.id.toolbar_login) Toolbar mToolbar;

    private FragmentDrawer mDrawerFragment;
>>>>>>> 84cc2ea9b9e1716ab2bf2b7cc8e040ec10642684

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

<<<<<<< HEAD
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

        editor.putString("token", usuario.getToken()); // Storing string
        editor.putString("usuario", usuario.getUsuario()); // Storing string
        editor.putString("perfil", usuario.getPerfil()); // Storing string
        editor.putString("id", usuario.getId().toString()); // Storing string
        editor.commit();

        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

}
=======
        createToolbar();
    }

    private void createToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout_login), mToolbar);
        mDrawerFragment.setDrawerListener(this);
    }

    public void mainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void carrinhoActivity(View view) {
        //startActivity(new Intent(this, CarrinhoActivity.class));
    }

    public void loginActivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void registrarActivity(View view) {
        //startActivity(new Intent(this, RegistrarActivity.class));
    }

    public void infoActivity(View view) {
        startActivity(new Intent(this, InfoActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        switch (position){
            case 0: mainActivity(view); break;
            case 1: carrinhoActivity(view); break;
            //case 2: loginActivity(view); break;
            case 3: registrarActivity(view); break;
            case 4: infoActivity(view); break;
            default: Log.i("ERRO","POSITION ERROR"); break;
        }
    }

    @OnClick(R.id.activity_login_btn_logar)
    void logar(View view) {
    }
}
>>>>>>> 84cc2ea9b9e1716ab2bf2b7cc8e040ec10642684
