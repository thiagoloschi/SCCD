package trabalho.sccd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SucessoCompraActivity extends AppCompatActivity {


    @BindView(R.id.valorCompra) TextView valorCompraField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesso_compra);

        //Define o ButterKnife para gerenciar as activities e ativa o modo de debugação.
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        Double valorCompra = getIntent().getDoubleExtra("valorCompra",0);

        valorCompraField.setText("R$ "+String.valueOf(valorCompra).replace(".",","));


    }
}
