package br.com.a2luglios.listasharedroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import br.com.a2luglios.listasharedroid.R;
import br.com.a2luglios.listasharedroid.modelo.Produto;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class ListaProdutosAdapter extends BaseAdapter {

    private Context ctx;
    private List<Produto> produtos;

    public ListaProdutosAdapter (Context ctx, List<Produto> produtos) {
        this.ctx = ctx;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_lista_produtos_layout, null);
        TextView nome = (TextView) v.findViewById(R.id.nome);
        CheckBox checado = (CheckBox) v.findViewById(R.id.checado);

        nome.setText(produtos.get(position).getNome());
        checado.setEnabled(produtos.get(position).isChecado());


        return v;
    }
}
