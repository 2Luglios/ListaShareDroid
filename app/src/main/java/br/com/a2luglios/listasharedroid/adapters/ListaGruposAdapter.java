package br.com.a2luglios.listasharedroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.a2luglios.listasharedroid.R;
import br.com.a2luglios.listasharedroid.modelo.Compartilhamento;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class ListaGruposAdapter extends BaseAdapter {

    private Context ctx;
    private List<Compartilhamento> compartilhamentos;

    public ListaGruposAdapter (Context ctx, List<Compartilhamento> compartilhamentos) {
        this.ctx = ctx;
        this.compartilhamentos = compartilhamentos;
    }

    @Override
    public int getCount() {
        return compartilhamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return compartilhamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return compartilhamentos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_grupo_layout, null);

        ImageView imagem = (ImageView) v.findViewById(R.id.imagem);
        TextView nome = (TextView) v.findViewById(R.id.nome);

        nome.setText(compartilhamentos.get(position).getNome());

        return v;
    }
}
