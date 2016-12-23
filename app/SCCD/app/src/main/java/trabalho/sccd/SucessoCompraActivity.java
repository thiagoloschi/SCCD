package trabalho.sccd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SucessoCompraActivity extends AppCompatActivity {


    @BindView(R.id.back) Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesso_compra);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);


    }

    @OnClick(R.id.back)
    public void voltar(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
