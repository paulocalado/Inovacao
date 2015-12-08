package com.example.paulo.inovacao;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class ActContratarDiarista extends AppCompatActivity {

    TextView txtContratarDiarista;
    CalendarView calendar;
    Bundle params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_contratar_diarista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }


        });*/

        txtContratarDiarista = (TextView)findViewById(R.id.txtContratarDiarista);
        Intent intent = getIntent();

        if(intent!=null){
            params = intent.getExtras();
            if(params!=null){
                txtContratarDiarista.setText(params.getString("nomeDiarista"));
            }
        }

        utilizaCalendario(params.getString("nomeDiarista"));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void utilizaCalendario(final String nomeDiarista){

        int aux;
        calendar = (CalendarView) findViewById(R.id.calendarContratarDiarista);
        calendar.setShowWeekNumber(false);

        calendar.setDate(calendar.getDate());


        calendar.setFirstDayOfWeek(2);




        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                AlertDialog.Builder dlg = new AlertDialog.Builder(ActContratarDiarista.this);
                dlg.setMessage("Deseja contrata-la para a data " + dayOfMonth + "/" + month + "?");
                dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(ActContratarDiarista.this, nomeDiarista+" contratada", LENGTH_LONG).show();
                    }
                }
                );

                dlg.setNegativeButton("Cancelar", null);
                dlg.show();
            }
        });
    }
    }


