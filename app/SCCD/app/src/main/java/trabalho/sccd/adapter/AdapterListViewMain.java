package trabalho.sccd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import trabalho.sccd.R;
import trabalho.sccd.model.Produto;

public class AdapterListViewMain extends RecyclerView.Adapter<AdapterListViewMain.DataObjectHolder> {

    //Cria uma TAG para o logs
    private static String LOG_TAG = "MyRecyclerViewAdapter";

    //Objeto com os Dados as serem exebidos na tela
    private static List<Produto> mDataset;

    private static Context context;

    //Construtor da Class
    public AdapterListViewMain(List<Produto> mDataset, Context context) {
        this.context = context;
        this.mDataset = mDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_adapter, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    //Define O Text do Labels
    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {


        holder.setProduto(mDataset.get(position));
        holder.produtoNome.setText(mDataset.get(position).getNome());
        holder.produtoDescricao.setText(mDataset.get(position).getDescricao());
        holder.produtoPreco.setText((mDataset.get(position).getPreco().toString()));
    }

    public void addItem(Produto dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    public Produto getItemPosition(int position){
        return mDataset.get(position);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    //Class Interna responsavel por criar cada Item do ListView
    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView produtoNome;
        TextView produtoDescricao;
        TextView produtoPreco;
        private Produto produto;
        static final int ACTIVITY_REQUEST = 1;

        //Construtor da Class
        //Obtem as Referencias para Views que será utilizada.
        public DataObjectHolder(View itemView) {
            super(itemView);
            produtoNome = (TextView) itemView.findViewById(R.id.produto_nome);
            produtoDescricao = (TextView) itemView.findViewById(R.id.produto_descricao);
            produtoPreco = (TextView) itemView.findViewById(R.id.produto_preco);
            itemView.setOnClickListener(this);
        }

        //Método responsavel pelo Click.
        @Override
        public void onClick(View v) {
            /*Intent resultadoActivity = new Intent(context, ProdutoActivity.class);
            resultadoActivity.putExtra("produto", transformaProdutoJson(produto));
            resultadoActivity.putExtra("position",mDataset.indexOf(produto));
            ((Activity)context).startActivityForResult(resultadoActivity,ACTIVITY_REQUEST);*/
        }

        private String transformaProdutoJson(Produto produto){
            Gson gson = new Gson();
            return gson.toJson(produto);
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }
    }

}
