package com.example.jose_jesus_guzman.agendame.Activities.Views.ClasesViews;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.Negocio;
import com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl.DBController;
import com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl.DBHelper;
import com.example.jose_jesus_guzman.agendame.R;

import java.util.Calendar;
import java.util.Date;


public class DetalleActivity extends AppCompatActivity {

    Negocio negocio;

    Toolbar toolbar;
    private ImageView imageView;
    private TextView txtCostoCurso;
    private TextView txtFechaRegularCurso;
    private TextView txtHorarioRegular;
    private TextView txtFechaSabatino;
    private TextView txtHorarioSabatino;
    private TextView txtDuracion;
    private TextView txtMinimaParticipantes;
    private Button btnEstado;

    private Bundle bundle;
    private String nombreCurso;
    private String costoCurso;
    private String fechaRegular;
    private String horarioRegular;
    private String fechaSabatino;
    private String horarioSabatino;
    private String duracionCurso;
    private String minimaParticipantes;
    private boolean estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        inicializarComponentes();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bundle = getIntent().getExtras();

        DBController dbController = new DBController(this);
        dbController.open(); //Se abre la BD para poder usarla


        desglozarCursor(dbController.getDataById(bundle.getInt("idCurso")));
        mostrarDatos();
        dbController.close();//Se cierra la BD por seguridad y para guardar los cambios definitivamente

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nos lleva a la pagina web de la empresa.
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://it-okcenter.com/calendario/"));
                startActivity(browserIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(DetalleActivity.this, LoginActivity.class));
        return true;
    }

    //Del cursor recibido obtiene todos los datos y los manda a variables dntro de esta clase.
    private void desglozarCursor(Cursor cursor) {
        negocio = new Negocio(this);
        if (cursor.moveToFirst()) {
            do {
                nombreCurso = cursor.getString(1);
                costoCurso = "Costo: $ " + cursor.getInt(22) + "*";
                fechaRegular = "Fecha del curso regular: De "
                        + negocio.obtenerFechaString(cursor.getInt(2),
                            cursor.getInt(3),
                            cursor.getInt(4))
                        + " a " + negocio.obtenerFechaString(cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7))
                        + " del " + cursor.getInt(4);
                horarioRegular = "Horario: "
                        + negocio.obtenerHoraString(cursor.getInt(8)) + " a "
                    + negocio.obtenerHoraString(cursor.getInt(10));

                fechaSabatino = "Fecha del curso sabatino: De "
                        + negocio.obtenerFechaString(cursor.getInt(12),
                        cursor.getInt(13),
                        cursor.getInt(14))
                        + " a " + negocio.obtenerFechaString(cursor.getInt(15),
                        cursor.getInt(16),
                        cursor.getInt(17))
                        + " del " + cursor.getInt(17);
                horarioSabatino = "Horario: "
                        + negocio.obtenerHoraString(cursor.getInt(18)) + " a "
                        + negocio.obtenerHoraString(cursor.getInt(20));

                duracionCurso = "Duracion: " + cursor.getInt(23) + " horas.";
                minimaParticipantes = "(" + cursor.getInt(24) + ") participantes.";
                estado = negocio.obtenerEstado(cursor.getInt(2), cursor.getInt(3));
            } while (cursor.moveToNext()); //Repite este proceso hasta que ya no tenga más elementos proximos.
        }
    }

    private void inicializarComponentes() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imageView = (ImageView) findViewById(R.id.ImageView);
        txtCostoCurso = (TextView) findViewById(R.id.detalle_txt_costo);
        txtFechaRegularCurso = (TextView) findViewById(R.id.detalle_txt_fechaRegular);
        txtHorarioRegular = (TextView) findViewById(R.id.detalle_txt_horarioRegular);
        txtFechaSabatino = (TextView) findViewById(R.id.detalle_txt_fechaSabatino);
        txtHorarioSabatino = (TextView) findViewById(R.id.detalle_txt_horarioSabatino);
        txtDuracion = (TextView) findViewById(R.id.detalle_txt_duracion);
        txtMinimaParticipantes = (TextView) findViewById(R.id.detalle_txt_minima);
        btnEstado = (Button) findViewById(R.id.detalle_btn_estado);
    }

    private void mostrarDatos() {
        negocio = new Negocio(this);
        //PAsar el contenido de las variables y vaciarlo a los elementos views.
        getSupportActionBar().setTitle(nombreCurso);
        imageView.setImageResource(bundle.getInt("idImagen"));
        txtCostoCurso.setText(costoCurso);
        txtFechaRegularCurso.setText(fechaRegular);
        txtHorarioRegular.setText(horarioRegular);
        txtFechaSabatino.setText(fechaSabatino);
        txtHorarioSabatino.setText(horarioSabatino);
        txtDuracion.setText(duracionCurso);
        txtMinimaParticipantes.append(minimaParticipantes);
        btnEstado.setText((estado)
            ? getResources().getString(R.string.inscribirse)
            : getResources().getString(R.string.proximamente));
    }



    /*fechaCompeta = "Inicio: " + negocio.convertirNumero(diaInicio) + " de "
                        + negocio.convertirMes(mesInicio) + " del " + anioInicio + "\n" +
                        "Fin: " + negocio.convertirNumero(diaFin) + " de "
                        + negocio.convertirMes(mesFin) + " del " + anioFin;
    */
}
