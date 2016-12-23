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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import trabalho.sccd.activity.FragmentDrawer;
import trabalho.sccd.adapter.AdapterListViewMain;
import trabalho.sccd.controller.RequestURL;
import trabalho.sccd.model.Produto;
import trabalho.sccd.utils.Constantes;

public class ProdutoActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    @BindView(R.id.toolbar_produto) Toolbar mToolbar;

    @BindView(R.id.activity_produto_nome) TextView nomeProduto;
    @BindView(R.id.activity_produto_preco) TextView precoProduto;
    @BindView(R.id.activity_produto_descricao) TextView descricaoProduto;
    @BindView(R.id.activity_produto_vendidopor) TextView vendidoPorProduto;
    @BindView(R.id.activity_produto_quantidade_estoque) TextView quantidadeProduto;
    @BindView(R.id.activity_produto_btn_carrinho) TextView btnCarrinho;

    private FragmentDrawer mDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        Bundle extras = getIntent().getExtras();

        System.out.println(extras.getString("produto"));
        carregaInforActivity(extras);

        createToolbar();
    }

    private void carregaInforActivity(Bundle bundle) {
        String produtoJson = bundle.getString("produto");
        Produto produto = new Gson().fromJson(produtoJson, Produto.class);

        nomeProduto.setText(produto.getNome());
        descricaoProduto.setText(produto.getDescricao());
        precoProduto.setText("R$ " + produto.getPreco().toString());
        vendidoPorProduto.setText(produto.getVendidoPor());
        quantidadeProduto.setText(produto.getQuantidadeEstoque().toString());
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


    public void infoActivity(View view) {
        Intent infoActivity = new Intent(this, InfoActivity.class);
        startActivity(infoActivity);
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
            case 0: break;
            //case 1: searchActivity(view); break;
            //case 2: favoriteActivity(view); break;
            case 4: infoActivity(view); break;
            default: Log.i("ERRO","POSITION ERROR"); break;
        }
    }
}