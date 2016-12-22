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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import trabalho.sccd.activity.FragmentDrawer;
import trabalho.sccd.adapter.AdapterListView;
import trabalho.sccd.controller.RequestURL;
import trabalho.sccd.function.Conexao;
import trabalho.sccd.model.Produto;
import trabalho.sccd.model.ProdutosJSON;
import trabalho.sccd.utils.Constantes;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    @BindView(R.id.list_produtos) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    private AdapterListView mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FragmentDrawer mDrawerFragment;

    private List<Produto> produtos = new ArrayList<>();

    private Button filtroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        filtroButton = (Button) findViewById(R.id.filterProdutos);

        obtemVagasAPI();

        createToolbar();
        verificaFiltroSelecionado();
    }

    private void createToolbar(){
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        mDrawerFragment.setDrawerListener(this);
    }

    private void verificaFiltroSelecionado() {
        createRecyclerView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        verificaFiltroSelecionado();
        mRecyclerView.scrollToPosition((int)data.getExtras().get("position"));
    }

    private void createRecyclerView(){
        //Remove os itens do Recycler, para add os novos valores.
        mRecyclerView.removeAllViewsInLayout();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterListView(produtos,this);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    // obtem os produtos da api.
    public void obtemVagasAPI(){
        RequestURL req = new RequestURL(this);

        req.requestURL(String.format(Constantes.URL_API_LISTAR_PRODUTOS), new RequestURL.VolleyCallback() {
            @Override
            public void onSuccess(String response) {
                System.out.println("GET PRODUTOS:" + response);
                Gson gson = new Gson();
                List<Produto> produtosJSON = Arrays.asList(gson.fromJson(response, Produto[].class));

                produtos.addAll(produtosJSON);
                carregaRecyclerView();
            }
        });
    }

    private void carregaRecyclerView() {
        createRecyclerView();
    }


/*
    public void infoActivity(View view) {
        Intent infoActivity = new Intent(this, InfoActivity.class);
        startActivity(infoActivity);
    }
*/
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
            case 0: break;
            //case 1: searchActivity(view); break;
            //case 2: favoriteActivity(view); break;
            //case 4: info(); break;
            default: Log.i("ERRO","POSITION ERROR"); break;
        }
    }
}