package br.com.a2luglios.listasharedroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.a2luglios.listasharedroid.modelo.Produto;
import br.com.a2luglios.listasharedroid.modelo.Shared;
import br.com.a2luglios.listasharedroid.util.BancoUtil;

/**
 * Created by ettoreluglio on 25/04/17.
 */

public class SharedDao extends BancoUtil {

    public static final String TABELA = "SHARED";

    public static final String CREATEQUERY = "CREATE TABLE " + TABELA
            + "(" +
            "id INTEGER PRIMARY KEY," +
            "nome TEXT, " +
            "email TEXT, " +
            "idLista INTEGER);";

    public static final String UPDATEQUERY = "";

    public SharedDao(Context context) {
        super(context);
    }

    public void insertOrUpdate(Shared shared) {
        getWritableDatabase().insert(TABELA, null, produtoToContentValues(shared));
    }

    public void delete (Shared shared) {
        getWritableDatabase().delete(TABELA, "id=?", new String[]{shared.getId().toString()});
    }

    private ContentValues produtoToContentValues(Shared shared) {
        ContentValues values = new ContentValues();
        values.put("id", shared.getId());
        values.put("nome", shared.getNome());
        values.put("email", shared.getEmail());
        values.put("idLista", shared.getIdLista());

        return values;
    }

    public List<Shared> listaSharedsPorIdLista(Long id) {
        Cursor cursorDeShareds = getWritableDatabase().query(SharedDao.TABELA,
                null, "idLista=?", new String[]{id.toString()}, null, null, null);

        List<Shared> shareds = new ArrayList<>();
        while(cursorDeShareds.moveToNext()) {
            Shared shared = new Shared();
            shared.setId(cursorDeShareds.getLong(cursorDeShareds.getColumnIndex("id")));
            shared.setNome(cursorDeShareds.getString(cursorDeShareds.getColumnIndex("nome")));
            shared.setEmail(cursorDeShareds.getString(cursorDeShareds.getColumnIndex("email")));
            shared.setIdLista(cursorDeShareds.getLong(cursorDeShareds.getColumnIndex("idLista")));
            shareds.add(shared);
        }
        return shareds;
    }
}
