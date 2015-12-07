package com.example.paulo.inovacao;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paulo.inovacao.database.DataManager;
import com.example.paulo.inovacao.dominio.RepositorioDiarista;
import com.example.paulo.inovacao.entidades.Diarista;

import java.util.ArrayList;

public class MainContratante extends ListActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView textNomeContratante;
    ArrayList<Diarista> listaDiarista;
    ListaDiaristaAdapter diaristaAdapter;

    private RepositorioDiarista repositorioDiarista;
    public DataManager dataBase;
    public SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contratante);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



      try {
            dataBase = new DataManager(this);
            conn = dataBase.getWritableDatabase();

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso");
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco" + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

        repositorioDiarista = new RepositorioDiarista(conn);
        repositorioDiarista.testeInserirDiarista();
        listaDiarista = gerarDiarista();
        diaristaAdapter =  new ListaDiaristaAdapter(MainContratante.this, listaDiarista);
        setListAdapter(diaristaAdapter);

        textNomeContratante = (TextView)findViewById(R.id.txtViewNomeContratante);
        Intent intent = getIntent();

        if(intent!=null){
            Bundle params = intent.getExtras();
                if(params!=null){
                    textNomeContratante.setText(params.getString("editLoginCadastro"));
                }
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_contratante, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public class ListaDiaristaAdapter extends ArrayAdapter<Diarista> {
        private Context context;
        private ArrayList<Diarista> listaDiaristaAdapter;

        public ListaDiaristaAdapter(Context context, ArrayList<Diarista> listaDiaristaAdapter) {
            super(context, 0, listaDiaristaAdapter);
            this.context = context;
            this.listaDiaristaAdapter = listaDiaristaAdapter;
        }

        //aqui é onde eu inflo o layout e seto os dados de cada item da lista
        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.layout_lista_diarista_disponivel, parent, false);

            Diarista diarista = listaDiaristaAdapter.get(position);

            ImageView imageDiarista = (ImageView)rowView.findViewById(R.id.imageDiarista);
            imageDiarista.setImageResource(diarista.getImagem());

            TextView textNomeDiarista = (TextView)rowView.findViewById(R.id.txtNome);
            textNomeDiarista.setText(diarista.getNome());

            TextView textIdadeDiarista = (TextView)rowView.findViewById(R.id.txtIdade);
            textIdadeDiarista.setText(diarista.getIdade());

            return rowView;
        }
    }

    /*Esse método vai recuperar os dados do banco e colocar na lista*/
    private ArrayList<Diarista> gerarDiarista(){
        ArrayList<Diarista> listaDiarista = new ArrayList<Diarista>();

        Cursor cursor = conn.query("DIARISTA", null, null, null, null, null, null);

        cursor.moveToFirst();



        if(cursor.getCount() > 0){


            do {
                String nome = cursor.getString(1);
                String idade = cursor.getString(4);

                listaDiarista.add(new Diarista(nome, "vic_bot", "R$100", "lava e passa", idade, R.drawable.victor, "piedade"));
            }while(cursor.moveToNext());
        }

       /*listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));
        listaDiarista.add(new Diarista("Victor", "vic_bot", "R$100", "lava e passa", "22", R.drawable.victor));
        listaDiarista.add(new Diarista("Francisco", "scrum_master", "R$300", "lava e passa", "22", R.drawable.chico));*/


        return listaDiarista;
    }
}
