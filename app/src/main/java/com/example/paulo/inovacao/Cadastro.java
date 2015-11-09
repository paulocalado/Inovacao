package com.example.paulo.inovacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Cadastro extends AppCompatActivity {

    Button btEntrarCadastro;
    EditText editLoginCadastro, editSenhaCadastro;
    RadioGroup radioGroupCadastro;
    Bundle params;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
