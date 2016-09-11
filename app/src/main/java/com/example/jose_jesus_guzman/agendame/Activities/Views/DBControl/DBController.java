package com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.Curso;
import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.CursoCompleto;

/**
 * Created by jesus on 4/09/16.
 */
public class DBController {

    DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;

    //Constructor para recibir el contexto necesario del activity
    public DBController(Context context) {
        this.context = context;
    }

    public DBController open() {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    //Metodo que cierra la BD para guardar definitivamente los cambios
    public void close() {
        dbHelper.close();
    }

    //SOLO SE EJECUTA UNA SOLA VEZ
    public void insetrarDatos(CursoCompleto cursoCompleto) {
        ContentValues valores = new ContentValues();

        valores.put(DBHelper._NOMBRE_CURSO, cursoCompleto.getNombreCurso());

        valores.put(DBHelper._INICIO_DIA, cursoCompleto.getInicioDia());
        valores.put(DBHelper._INICIO_MES, cursoCompleto.getInicioMes());
        valores.put(DBHelper._INICIO_ANIO, cursoCompleto.getInicioAnio());
        valores.put(DBHelper._FIN_DIA, cursoCompleto.getFinDia());
        valores.put(DBHelper._FIN_MES, cursoCompleto.getFinMes());
        valores.put(DBHelper._FIN_ANIO, cursoCompleto.getFinAnio());

        valores.put(DBHelper._INICIO_HORA, cursoCompleto.getInicioHora());
        valores.put(DBHelper._INICIO_MINUTOS, cursoCompleto.getInicioMinutos());
        valores.put(DBHelper._FIN_HORA, cursoCompleto.getFinHora());
        valores.put(DBHelper._FIN_MINUTOS, cursoCompleto.getFinMinutos());

        valores.put(DBHelper._SAB_INICIO_DIA, cursoCompleto.getSabInicioDia());
        valores.put(DBHelper._SAB_INICIO_MES, cursoCompleto.getSabInicioMes());
        valores.put(DBHelper._SAB_INICIO_ANIO, cursoCompleto.getSabInicioAnio());
        valores.put(DBHelper._SAB_FIN_DIA, cursoCompleto.getSabFinDia());
        valores.put(DBHelper._SAB_FIN_MES, cursoCompleto.getSabFinMes());
        valores.put(DBHelper._SAB_FIN_ANIO, cursoCompleto.getSabFinAnio());

        valores.put(DBHelper._SAB_INICIO_HORA, cursoCompleto.getSabInicioHora());
        valores.put(DBHelper._SAB_INICIO_MINUTOS, cursoCompleto.getSabInicioMinutos());
        valores.put(DBHelper._SAB_FIN_HORA, cursoCompleto.getSabFinHora());
        valores.put(DBHelper._SAB_FIN_MINUTOS, cursoCompleto.getSabFinMinutos());

        valores.put(DBHelper._COSTO_CURSO, cursoCompleto.getCostoCurso());
        valores.put(DBHelper._DURACION_CURSO, cursoCompleto.getDuracionCurso());
        valores.put(DBHelper._APERTURA_CURSO, cursoCompleto.getAperturaCurso());

        db.insert(DBHelper.TABLE_NAME, null, valores);
    }

    public Cursor getData() {
        String[] columnas = new String[]{
            DBHelper._ID_CURSO,
            DBHelper._NOMBRE_CURSO,
            DBHelper._INICIO_DIA,
            DBHelper._INICIO_MES,
            DBHelper._INICIO_ANIO,
            DBHelper._FIN_DIA,
            DBHelper._FIN_MES,
            DBHelper._FIN_ANIO,
            DBHelper._INICIO_HORA,
            DBHelper._INICIO_MINUTOS,
            DBHelper._FIN_HORA,
            DBHelper._FIN_MINUTOS,
            DBHelper._SAB_INICIO_DIA,
            DBHelper._SAB_INICIO_MES,
            DBHelper._SAB_INICIO_ANIO,
            DBHelper._SAB_FIN_DIA,
            DBHelper._SAB_FIN_MES,
            DBHelper._SAB_FIN_ANIO,
            DBHelper._SAB_INICIO_HORA,
            DBHelper._SAB_INICIO_MINUTOS,
            DBHelper._SAB_FIN_HORA,
            DBHelper._SAB_FIN_MINUTOS,
            DBHelper._COSTO_CURSO,
            DBHelper._DURACION_CURSO,
            DBHelper._APERTURA_CURSO
        };

        Cursor cursor = db.query(
                DBHelper.TABLE_NAME,
                columnas,
                null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor getDataById(int idCurso){
        Cursor cursor = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME +
                " WHERE " + dbHelper._ID_CURSO + "=" + idCurso + ";", null);

        if (cursor != null)
            cursor.moveToFirst();

        return cursor;
    }

}
