package com.example.paulo.inovacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CriarConta extends AppCompatActivity {

    EditText editTextNomeCriarConta, editTextIdadeCriarConta,
            editTextLoginCriarConta, editTextSenhaCriarConta;

    Button btNovaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextIdadeCriarConta = (EditText)findViewById(R.id.editTextIdadeCriarConta);
        editTextLoginCriarConta = (EditText)findViewById(R.id.editTextLoginCriarConta);
        editTextNomeCriarConta  = (EditText)findViewById(R.id.editTextNomeCriarConta);
        editTextSenhaCriarConta = (EditText)findViewById(R.id.editTextSenhaCriarConta);
        btNovaConta = (Button)findViewById(R.id.btNovaConta);

        btNovaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((editTextIdadeCriarConta.toString()!= ""))&&(editTextLoginCriarConta.toString()!= "")&&(editTextSenhaCriarConta.toString()!= "")&&(editTextSenhaCriarConta.toString()!= "")){
                    Intent intentMainDiarista = new Intent(CriarConta.this, MainDiarista.class);
                    startActivity(intentMainDiarista);
                }else{
                    Toast.makeText(CriarConta.this,"Por Favor, preencha todos os campos",Toast.LENGTH_LONG).show();
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

}
