package com.example.jose_jesus_guzman.agendame.Activities.Views.DBControl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jesus on 4/09/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "CERTIFICACIONES.db";
    static final int DB_VERSION = 1;
     //--------------------------------------------------------------------------------------------
    public static final String TABLE_NAME = "CURSO";
    public static final String _ID_CURSO = "id_curso";
    public static final String _NOMBRE_CURSO = "nombre_curso";

    public static final String _INICIO_DIA = "inicio_dia";
    public static final String _INICIO_MES = "inicio_mes";
    public static final String _INICIO_ANIO = "inicio_anio";
    public static final String _FIN_DIA = "fin_dia";
    public static final String _FIN_MES = "fin_mes";
    public static final String _FIN_ANIO = "fin_anio";

    public static final String _INICIO_HORA = "inicio_hora";
    public static final String _INICIO_MINUTOS = "inicio_minutos";
    public static final String _FIN_HORA = "fin_hora";
    public static final String _FIN_MINUTOS = "fin_minutos";


    public static final String _SAB_INICIO_DIA = "sab_inicio_dia";
    public static final String _SAB_INICIO_MES = "sab_inicio_mes";
    public static final String _SAB_INICIO_ANIO = "sab_inicio_anio";
    public static final String _SAB_FIN_DIA = "sab_fin_dia";
    public static final String _SAB_FIN_MES = "sab_fin_mes";
    public static final String _SAB_FIN_ANIO = "sab_fion_anio";

    public static final String _SAB_INICIO_HORA = "sab_inicio_hora";
    public static final String _SAB_INICIO_MINUTOS = "sab_inicio_minutos";
    public static final String _SAB_FIN_HORA = "sab_fin_hora";
    public static final String _SAB_FIN_MINUTOS = "sab_fin_minutos";

    public static final String _COSTO_CURSO = "costo_curso";
    public static final String _DURACION_CURSO = "duracion_curso";
    public static final String _APERTURA_CURSO = "apertura_curso"; //Cantidad minima de participantes para apertura

    //---------------------------------------------------------------------------------------------

    //Se construye el query para crear la tabla
    String create = "CREATE TABLE "
            + TABLE_NAME
            + " ( "
            + _ID_CURSO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + _NOMBRE_CURSO + " TEXT, "
            + _INICIO_DIA + " INTEGER, "
            + _INICIO_MES + " INTEGER, "
            + _INICIO_ANIO + " INTEGER, "
            + _FIN_DIA + " INTEGER, "
            + _FIN_MES + " INTEGER, "
            + _FIN_ANIO + " INTEGER, "
            + _INICIO_HORA + " INTEGER, "
            + _INICIO_MINUTOS + " INTEGER, "
            + _FIN_HORA + " INTEGER, "
            + _FIN_MINUTOS + " INTEGER, "
            + _SAB_INICIO_DIA + " INTEGER, "
            + _SAB_INICIO_MES + " INTEGER, "
            + _SAB_INICIO_ANIO + " INTEGER, "
            + _SAB_FIN_DIA + " INTEGER, "
            + _SAB_FIN_MES + " INTEGER, "
            + _SAB_FIN_ANIO + " INTEGER, "
            + _SAB_INICIO_HORA + " INTEGER, "
            + _SAB_INICIO_MINUTOS + " INTEGER, "
            + _SAB_FIN_HORA + " INTEGER, "
            + _SAB_FIN_MINUTOS + " INTEGER, "
            + _COSTO_CURSO + " INTEGER, "
            + _DURACION_CURSO + " INTEGER, "
            + _APERTURA_CURSO + " INTEGER );";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        db.execSQL(create);
    }
}
