package br.com.a2luglios.listasharedroid.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.a2luglios.listasharedroid.dao.CompartilhamentoDao;
import br.com.a2luglios.listasharedroid.dao.ListaDao;
import br.com.a2luglios.listasharedroid.dao.ProdutoDao;
import br.com.a2luglios.listasharedroid.dao.SharedDao;

/**
 * Created by ettoreluglio on 19/04/17.
 */

public class BancoUtil extends SQLiteOpenHelper {

    private static final String DATABASE = "ListaShare";
    private static final int VERSION = 1;

    public BancoUtil(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CompartilhamentoDao.CREATEQUERY);
        db.execSQL(ProdutoDao.CREATEQUERY);
        db.execSQL(ListaDao.CREATEQUERY);
        db.execSQL(SharedDao.CREATEQUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CompartilhamentoDao.UPDATEQUERY);
        db.execSQL(ProdutoDao.UPDATEQUERY);
        db.execSQL(ListaDao.UPDATEQUERY);
        db.execSQL(SharedDao.UPDATEQUERY);
    }

}
