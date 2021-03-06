package trabalho.sccd;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import trabalho.sccd.activity.FragmentDrawer;
import trabalho.sccd.adapter.AdapterListViewMain;
import trabalho.sccd.controller.RequestURL;
import trabalho.sccd.model.Carrinho;
import trabalho.sccd.model.Produto;
import trabalho.sccd.utils.Constantes;
import trabalho.sccd.utils.Preferencias;

public class ProdutoActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    @BindView(R.id.toolbar_produto) Toolbar mToolbar;

    @BindView(R.id.activity_produto_nome) TextView nomeProduto;
    @BindView(R.id.activity_produto_preco) TextView precoProduto;
    @BindView(R.id.activity_produto_descricao) TextView descricaoProduto;
    @BindView(R.id.activity_produto_vendidopor) TextView vendidoPorProduto;
    @BindView(R.id.activity_produto_quantidade_estoque) TextView quantidadeProduto;

    private Produto produto;


    private FragmentDrawer mDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        Bundle extras = getIntent().getExtras();

        carregaInforActivity(extras);

        createToolbar();
    }

    private void carregaInforActivity(Bundle bundle) {
        String produtoJson = bundle.getString("produto");
        produto = new Gson().fromJson(produtoJson, Produto.class);

        nomeProduto.setText(produto.getNome());
        descricaoProduto.setText(produto.getDescricao());
        precoProduto.setText("R$ " + produto.getPreco().toString());
        vendidoPorProduto.setText("Vendido Por: " + produto.getVendidoPor());
        quantidadeProduto.setText("Quantidade em Estoque: " + produto.getQuantidadeEstoque().toString());
    }

    private void createToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout_produto), mToolbar);
        mDrawerFragment.setDrawerListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //mRecyclerView.scrollToPosition((int)data.getExtras().get("position"));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void carrinhoActivity(View view) {
        startActivity(new Intent(this, CarrinhoActivity.class));
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
            case 2: loginActivity(view); break;
            case 3: registrarActivity(view); break;
            case 4: infoActivity(view); break;
            default: Log.i("ERRO","POSITION ERROR"); break;
        }
    }

    @OnClick(R.id.activity_produto_btn_carrinho)
    void adicionarAoCarrinho(View view) {

        Carrinho.setCarrinho(produto);

//        Preferencias preferencias = new Preferencias(this);
//        String token = preferencias.getToken();
//
//        JSONObject jsonBody = new JSONObject();
//        try {
//            jsonBody.put("id", produto.getId());
//            jsonBody.put("nome", produto.getNome());
//            jsonBody.put("descricao", produto.getDescricao());
//            jsonBody.put("preco", produto.getPreco());
//            jsonBody.put("vendidoPor", produto.getVendidoPor());
//            jsonBody.put("estoqueMinimo", produto.getEstoqueMinimo());
//            jsonBody.put("quantidadeEstoque", produto.getQuantidadeEstoque());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        final String requestBody = jsonBody.toString();
//
//        RequestURL req = new RequestURL(this);
//        req.request_POST_URL(String.format(Constantes.URL_API_ADD_PRODUTO_CARRINHO.replace("#{token}",token)), requestBody, new RequestURL.VolleyCallback() {
//            @Override
//            public void onSuccess(String response) {
//                System.out.println("ADD NO CARRINHO:" + response);
//                Gson gson = new Gson();
//                try{
//                    /*List<Produto> produtosJSON = Arrays.asList(gson.fromJson(response, Produto[].class));
//
//                    produtos.addAll(produtosJSON);
//                    carregaRecyclerView();*/
//                }catch (Exception e){
//
//                }
//            }
//        });
        //ir para tela do carrinho
    }
}