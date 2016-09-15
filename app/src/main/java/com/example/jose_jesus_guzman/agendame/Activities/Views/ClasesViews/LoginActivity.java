package com.example.jose_jesus_guzman.agendame.Activities.Views.ClasesViews;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Adapters.RecyclerAdapter;
import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.Curso;
import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.CursoCompleto;
import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.Negocio;
import com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl.DBController;
import com.example.jose_jesus_guzman.agendame.Activities.Views.Services.ServicioVinculado;
import com.example.jose_jesus_guzman.agendame.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class LoginActivity extends AppCompatActivity {
    Toolbar toolbar;
    private RecyclerView recyclerViewLista;
    RecyclerAdapter recyclerAdapter;
    private List<Curso> cursoList = new ArrayList<Curso>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        alertarUsuario();

        //Con esta instancia se crea la BD si no existe y se comienza a usar
        DBController dbController = new DBController(this);
        dbController.open(); //abre la bd para que se pueda usar
        llenadoDatos(dbController);

        recyclerViewLista = (RecyclerView) findViewById(R.id.login_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(LoginActivity.this);
        recyclerViewLista.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(cursoList, LoginActivity.this);

        crearLista(dbController);
        recyclerViewLista.setAdapter(recyclerAdapter);


        dbController.close();//Cerrar la BD

        startService(new Intent(getApplicationContext(), ServicioVinculado.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Al presionar acerca de en el menu contextual se dirigira a una nueva activity
        if (item.getItemId() == R.id.action_acerca) {
            startActivity(new Intent(LoginActivity.this, AcercaActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private void alertarUsuario() {
        new AlertDialog.Builder(LoginActivity.this)
                .setTitle(getResources().getString(R.string.app_name))
                .setMessage(getResources().getString(R.string.login_dialog_mensaje))
                .setPositiveButton(getResources().getString(R.string.Si), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    public void llenadoDatos(DBController dbController){
        SharedPreferences pref = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        if (pref.getBoolean("valor", false)) {
            return;
        } else {

            CursoCompleto cursoCompletoWeb = new CursoCompleto(getResources().getString(R.string.web), //Nombre
                    19, //dia inicio //CAMBIO AQUI
                    9, //mes inicio
                    2016, //año inicio
                    23, //dia fin
                    9, //mes fin
                    2016, //año fin
                    14, //hora inicio
                    0, //minutos inicio
                    18, //hora fin
                    0, //minutos fin
                    15, //dia inicio sabado
                    10, //mes inicio sabado
                    2016, //año inicio sabado
                    29, //dia fin sabado
                    10, //mes fin sabado
                    2016, //año fin sabado
                    9, //hora inicio sabado
                    0, //minutos inicio sabado
                    16, //hora fin sabado
                    0, //minutos fin sabado
                    3500, //costo
                    20, //duracion en horas
                    10); //minimos partificipantes

            //Se hace instancia y con esto se crea la BD
            dbController.insetrarDatos(cursoCompletoWeb);

            CursoCompleto cursoCompletoAndroid = new CursoCompleto(getResources().getString(R.string.movil), //Nombre
                    20, //dia inicio
                    9, //mes inicio
                    2016, //año inicio
                    30, //dia fin
                    9, //mes fin
                    2016, //año fin
                    10, //hora inicio
                    0, //minutos inicio
                    14, //hora fin
                    0, //minutos fin
                    8, //dia inicio sabado
                    11, //mes inicio sabado
                    2016, //año inicio sabado
                    29, //dia fin sabado
                    11, //mes fin sabado
                    2016, //año fin sabado
                    10, //hora inicio sabado
                    0, //minutos inicio sabado
                    17, //hora fin sabado
                    0, //minutos fin sabado
                    1500, //costo
                    35, //duracion en horas
                    10); //minimos partificipantes

            //Se hace instancia y con esto se crea la BD
            dbController.insetrarDatos(cursoCompletoAndroid);

            CursoCompleto cursoCompletoJS = new CursoCompleto(getResources().getString(R.string.js), //Nombre
                    31, //dia inicio
                    10, //mes inicio
                    2016, //año inicio
                    11, //dia fin
                    11, //mes fin
                    2016, //año fin
                    10, //hora inicio
                    0, //minutos inicio
                    15, //hora fin
                    0, //minutos fin
                    5, //dia inicio sabado
                    11, //mes inicio sabado
                    2016, //año inicio sabado
                    1, //dia fin sabado
                    12, //mes fin sabado
                    2016, //año fin sabado
                    9, //hora inicio sabado
                    0, //minutos inicio sabado
                    18, //hora fin sabado
                    0, //minutos fin sabado
                    15000, //costo
                    24, //duracion en horas
                    10); //minimos partificipantes

            //Se hace instancia y con esto se crea la BD
            dbController.insetrarDatos(cursoCompletoJS);

            CursoCompleto cursoCompletoLinux = new CursoCompleto(getResources().getString(R.string.linux), //Nombre
                    3, //dia inicio
                    10, //mes inicio
                    2016, //año inicio
                    16, //dia fin
                    10, //mes fin
                    2016, //año fin
                    10, //hora inicio
                    0, //minutos inicio
                    15, //hora fin
                    0, //minutos fin
                    22, //dia inicio sabado
                    10, //mes inicio sabado
                    2016, //año inicio sabado
                    12, //dia fin sabado
                    11, //mes fin sabado
                    2016, //año fin sabado
                    10, //hora inicio sabado
                    0, //minutos inicio sabado
                    18, //hora fin sabado
                    0, //minutos fin sabado
                    1500, //costo
                    70, //duracion en horas
                    10); //minimos partificipantes

            //Se hace instancia y con esto se crea la BD
            dbController.insetrarDatos(cursoCompletoLinux);

            CursoCompleto cursoCompletoMySQL = new CursoCompleto(getResources().getString(R.string.mysql), //Nombre
                    1, //dia inicio
                    10, //mes inicio
                    2016, //año inicio
                    22, //dia fin
                    10, //mes fin
                    2016, //año fin
                    12, //hora inicio
                    0, //minutos inicio
                    16, //hora fin
                    0, //minutos fin
                    30, //dia inicio sabado
                    10, //mes inicio sabado
                    2016, //año inicio sabado
                    20, //dia fin sabado
                    11, //mes fin sabado
                    2016, //año fin sabado
                    12, //hora inicio sabado
                    0, //minutos inicio sabado
                    20, //hora fin sabado
                    0, //minutos fin sabado
                    5500, //costo
                    20, //duracion en horas
                    10); //minimos partificipantes

            //Se hace instancia y con esto se crea la BD
            dbController.insetrarDatos(cursoCompletoMySQL);

            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("valor", true);
            editor.apply();

        }


    }

    private void crearLista(DBController dbController){
        Cursor cursor = dbController.getData();
        String fechaCompeta = "";

        Negocio negocio = new Negocio(LoginActivity.this);

        if (cursor.moveToFirst()) {
            do {
                int idCurso = cursor.getInt(0);
                String nombre = cursor.getString(1);
                int diaInicio = cursor.getInt(2);
                int mesInicio = cursor.getInt(3);
                int anioInicio = cursor.getInt(4);
                int diaFin = cursor.getInt(5);
                int mesFin = cursor.getInt(6);
                int anioFin = cursor.getInt(7);
                fechaCompeta = "Inicio: " + negocio.convertirNumero(diaInicio) + " de "
                        + negocio.convertirMes(mesInicio) + " del " + anioInicio + "\n" +
                        "Fin: " + negocio.convertirNumero(diaFin) + " de "
                        + negocio.convertirMes(mesFin) + " del " + anioFin;

                cursoList.add(new Curso(idCurso,nombre, fechaCompeta,
                        negocio.obtenerEstado(diaInicio, mesInicio)
                                ? getResources().getString(R.string.inscribirse)
                                : getResources().getString(R.string.proximamente),
                        negocio.ponerImagen(nombre)));
                recyclerAdapter.notifyDataSetChanged();
            } while (cursor.moveToNext());
        }
    }



}
