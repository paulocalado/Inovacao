package com.example.paulo.inovacao;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.database.sqlite.*;
import android.database.*;

import com.example.paulo.inovacao.database.DataManager;

public class Cadastro extends AppCompatActivity {

    Button btEntrarCadastro, btCriarConta;
    EditText editLoginCadastro, editSenhaCadastro;
    RadioGroup radioGroupCadastro;
    Bundle params;
    private DataManager dataBase;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        params = new Bundle();
        editLoginCadastro = (EditText)findViewById(R.id.editLoginCadastro);
        editSenhaCadastro = (EditText)findViewById(R.id.editSenhaCadastro);
        btEntrarCadastro = (Button)findViewById(R.id.btEntrarCadastro);
        radioGroupCadastro = (RadioGroup)findViewById(R.id.radioGroupCadastro);
        btCriarConta = (Button)findViewById(R.id.btCriarConta);

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

        btEntrarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aux = radioGroupCadastro.getCheckedRadioButtonId();

                if(aux==R.id.radioButtonContratanteCadastro){
                    Intent intentContratante = new Intent(Cadastro.this, MainContratante.class);
                    params.putString("editLoginCadastro", editLoginCadastro.getText().toString());

                    intentContratante.putExtras(params);

                    startActivity(intentContratante);
                }
                if(aux==R.id.radioButtonDiaristaCadastro){
                    Intent intentDiarista = new Intent(Cadastro.this, MainDiarista.class);
                    params.putString("editLoginCadastro", editLoginCadastro.getText().toString());

                    intentDiarista.putExtras(params);

                    startActivity(intentDiarista);
                }
            }
        });

        btCriarConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int aux2 = radioGroupCadastro.getCheckedRadioButtonId();

                if(aux2==R.id.radioButtonDiaristaCadastro){
                    Intent intentCadastroDiarista = new Intent(Cadastro.this, CriarConta.class);
                    startActivity(intentCadastroDiarista);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
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
}
