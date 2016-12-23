package trabalho.sccd.controller;

import android.content.Context;
import android.util.Log;
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

import trabalho.sccd.model.Usuario;
import trabalho.sccd.utils.Constantes;

public class RequestURL {
    private final Context context;

    public RequestURL(Context context) {
        this.context = context;
    }

    //Efetua a requisição dos dados através da url recebida pelo usuário.
    public void requestURL(String url, final VolleyCallback callback) {

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    Log.i("Error Request: ", error.getMessage());
                }catch (NullPointerException e){
                    Log.i("Erro ao Conectar... \n",e.getMessage());
                }
            }
        });
        queue.add(stringRequest);
    }

    //Efetua a requisição POST dos dados através da url recebida pelo usuário.
    public void request_POST_URL(String URL, final String formInJson, final VolleyCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JSONObject jsonBody = new JSONObject();
        //jsonBody.put("usuario", loginField.getText().toString());
        //jsonBody.put("senha", passwordField.getText().toString());
        final String requestBody = formInJson;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    callback.onSuccess(response);
                }
            },
            new Response.ErrorListener() {
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
                    Log.i("POST FORM: ",requestBody);
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
    }

    public interface VolleyCallback {
        void onSuccess(String response);
    }
}//class RequestURL


