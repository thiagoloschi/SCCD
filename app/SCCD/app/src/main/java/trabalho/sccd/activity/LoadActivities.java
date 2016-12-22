package trabalho.sccd.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import trabalho.sccd.InfoActivity;
import trabalho.sccd.MainActivity;
import trabalho.sccd.R;
import trabalho.sccd.function.Conexao;

public class LoadActivities {

    public static void home(Context context) {
        Intent home = new Intent(context, MainActivity.class);
        context.startActivity(home);
    }

    public static void favoriteActivity(Context context) {
        //Intent carrinhoActivity = new Intent(context, CarrinhoActivity.class);
        //context.startActivity(carrinhoActivity);
    }

    public static void searchActivity(Context context) {
        if(Conexao.isConectado(context)) {
            //Intent loginActivity = new Intent(context, LoginActivity.class);
            //context.startActivity(loginActivity);
        }else
            Toast.makeText(context,R.string.conexao_infor,Toast.LENGTH_LONG).show();
    }

    public static void info(Context context) {
        Intent info = new Intent(context, InfoActivity.class);
        context.startActivity(info);
    }
}
