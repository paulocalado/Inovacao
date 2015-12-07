package com.example.paulo.inovacao.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.paulo.inovacao.R;
import com.example.paulo.inovacao.database.DataManager;
import com.example.paulo.inovacao.entidades.Diarista;

/**
 * Created by Paulo on 07/12/2015.
 */
public class RepositorioDiarista {



    private SQLiteDatabase conn;

    public RepositorioDiarista(SQLiteDatabase conn){

        this.conn = conn;
    }

    public ArrayAdapter<String> buscaDiarista(Context context){

        ArrayAdapter<String> adpDiarista = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1);

        Cursor cursor = conn.query("DIARISTA", null, null, null, null, null, null);

        if(cursor.getCount() > 0){

            do {
                String nome = cursor.getString(1);

                adpDiarista.add(nome);
            }while(cursor.moveToNext());
        }

        return adpDiarista;
    }

    public void inserirDiarista(Diarista diarista){

        ContentValues values = new ContentValues();
        values.put("NOME", diarista.getNome());
        conn.insertOrThrow("DIARISTA", null, values);
    }

    public void testeInserirDiarista(){


            ContentValues values = new ContentValues();
            values.put("NOME", "Neide");
            values.put("IDADE", "25");
            ContentValues values2 = new ContentValues();
            values2.put("NOME", "Carla");
            ContentValues values3 = new ContentValues();
            values3.put("NOME", "Katia");

            conn.insertOrThrow("DIARISTA", null, values);
            conn.insertOrThrow("DIARISTA", null, values2);
            conn.insertOrThrow("DIARISTA", null, values3);


    }

}
