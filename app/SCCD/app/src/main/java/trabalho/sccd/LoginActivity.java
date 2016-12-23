package trabalho.sccd;


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
import trabalho.sccd.activity.FragmentDrawer;
import trabalho.sccd.model.Produto;

public class LoginActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    @BindView(R.id.toolbar_login) Toolbar mToolbar;

    private FragmentDrawer mDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

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