package br.com.a2luglios.listasharedroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.a2luglios.listasharedroid.R;
import br.com.a2luglios.listasharedroid.modelo.Lista;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class ListaListasAdapter extends BaseAdapter {

    private Context ctx;
    private List<Lista> listas;

    public ListaListasAdapter(Context ctx, List<Lista> listas) {
        this.ctx = ctx;
        this.listas = listas;
    }

    @Override
    public int getCount() {
        return listas.size();
    }

    @Override
    public Object getItem(int position) {
        return listas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_lista_layout, null);
        ImageView imagem = (ImageView) v.findViewById(R.id.imagem);
        TextView nome = (TextView) v.findViewById(R.id.nome);
        ImageView btnShare = (ImageView) v.findViewById(R.id.btnShare);

        nome.setText(listas.get(position).getNome());

        return v;
    }
}
