package br.com.a2luglios.listasharedroid.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
