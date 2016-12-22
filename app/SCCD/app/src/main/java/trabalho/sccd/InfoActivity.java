package trabalho.sccd;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import trabalho.sccd.activity.FragmentDrawer;

public class InfoActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{



    @BindView(R.id.toolbar) Toolbar mToolbar;
    private FragmentDrawer mDrawerFragment;

    @BindView(R.id.titulo) TextView titulo;
    @BindView(R.id.developers)TextView desenvolvedores;
    @BindView(R.id.versao)TextView versao;
    @BindView(R.id.imagemSCCD) ImageView imagemSCCD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        createToolbar();

        imagemSCCD.setBackgroundColor(Color.TRANSPARENT);
    }

    //Responsavel pela criação e definção do toolbar
    private void createToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer_info);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer_info, (DrawerLayout) findViewById(R.id.activity_info), mToolbar);
        mDrawerFragment.setDrawerListener(this);
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
            //case 0: LoadActivities.home(this); break;
            //case 1: LoadActivities.carrinhoActivity(this); break;
            case 2: break;
            default: Log.i("ERRO","POSITION ERROR"); break;
        }
    }
}
