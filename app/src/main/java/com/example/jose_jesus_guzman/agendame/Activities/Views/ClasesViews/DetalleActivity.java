package com.example.jose_jesus_guzman.agendame.Activities.Views.ClasesViews;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.Negocio;
import com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl.DBController;
import com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl.DBHelper;
import com.example.jose_jesus_guzman.agendame.R;


public class DetalleActivity extends AppCompatActivity {

    Toolbar toolbar;
    private ImageView imageView;

    private Bundle bundle;
    private String nombreCurso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        inicializarComponentes();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bundle = getIntent().getExtras();

        DBController dbController = new DBController(this);
        dbController.open();


        desglozarCursor(dbController.getDataById(bundle.getInt("idCurso")));
        mostrarDatos();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(DetalleActivity.this, LoginActivity.class));
        return true;
    }

    private void desglozarCursor(Cursor cursor) {
        String fechaCompeta = "";
        Negocio negocio = new Negocio(DetalleActivity.this);

        if (cursor.moveToFirst()) {
            do {
                nombreCurso = cursor.getString(1);
            } while (cursor.moveToNext());
        }
    }

    private void inicializarComponentes() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imageView = (ImageView) findViewById(R.id.ImageView);
    }

    private void mostrarDatos() {
        getSupportActionBar().setTitle(nombreCurso);
        imageView.setImageResource(bundle.getInt("idImagen"));
    }


}
