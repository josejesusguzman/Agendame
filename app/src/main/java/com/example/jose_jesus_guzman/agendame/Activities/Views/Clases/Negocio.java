package com.example.jose_jesus_guzman.agendame.Activities.Views.Clases;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

import com.example.jose_jesus_guzman.agendame.R;

import java.util.Calendar;

/**
 * Created by jesus on 8/09/16.
 */
public class Negocio {

    private Context context;

    public Negocio(Context context) {
        this.context = context;
    }

    public String convertirNumero(int numero) {
        String num = "";
        if(numero < 10) {
            num = "0" + numero;
        } else {
            num = "" + numero;
        }
        return num;
    }

    public String convertirMes(int mes) {
        String mesLetra = "";
        switch (mes){
            case 1:
                mesLetra = "enero";
                break;
            case 2:
                mesLetra = "febrero";
                break;
            case 3:
                mesLetra = "marzo";
                break;
            case 4:
                mesLetra = "abril";
                break;
            case 5:
                mesLetra = "mayo";
                break;
            case 6:
                mesLetra = "junio";
                break;
            case 7:
                mesLetra = "julio";
                break;
            case 8:
                mesLetra = "agosto";
                break;
            case 9:
                mesLetra = "septiembre";
                break;
            case 10:
                mesLetra = "octubre";
                break;
            case 11:
                mesLetra = "noviembre";
                break;
            case 12:
                mesLetra = "diciembre";
                break;
            default:
                return null;
        }
        return mesLetra;
    }

    public int ponerImagen(String curso){
        int imagen = 0;

        if (curso.equals(context.getResources().getString(R.string.web))) {
            imagen = R.drawable.web;
        } else if (curso.equals(context.getResources().getString(R.string.movil))) {
            imagen = R.drawable.android;
        } else if (curso.equals(context.getResources().getString(R.string.js))) {
            imagen = R.drawable.js;
        } else if (curso.equals(context.getResources().getString(R.string.linux))) {
            imagen = R.drawable.linux;
        } else if (curso.equals(context.getResources().getString(R.string.mysql))) {
            imagen = R.drawable.mysql;
        }

        return imagen;
    }

    //Siete dias antes de la fecha de inicio, el usuario ya se puede inscribir
    public String obtenerEstado(int dia, int mes){
        String estado = null;

        //Obtener la fecha actual del dispositivo
        Calendar calander = Calendar.getInstance();
        int cDay = calander.get(Calendar.DAY_OF_MONTH);
        int cMonth = calander.get(Calendar.MONTH) + 1;
        int cYear = calander.get(Calendar.YEAR);

        if (dia <= 7) {
            estado = (cYear % 4 == 0)
                    ? obtenerStringEstado(mes - 1, cDay, true) //Si el año es biciesto
                    : obtenerStringEstado(mes - 1, cDay, false); //Si el año es normal
        } else {
            if (cDay >= (dia - 7) && cDay < dia && cMonth == mes) { //Si esta entre el dia anterior de inicio de curso y 7 dias anteriores
                estado = "Inscribirse";
                lanzarNotificacion("Fundamentos de diseño Web"); //TODO recibir el nombre del curso y el id
            } else {
                estado = "Proximamente";
            }
        }

        return estado;
    }

    /*
    *dia: es el dia en que se impartira el curso
    * cDay: es el dia actual dle dispositivo
    * isBiciesto: si el año es biciesto o no
    *
     */
    private String obtenerStringEstado(int mes, int cDay, boolean isBiciesto) {
        String estado = null;
        if (mes == 0 //Diciembre del año anterior
                ||mes == 1 //Si los meses tienen 31 dias
                || mes == 3
                || mes == 5
                || mes == 7
                || mes == 8
                || mes == 10
                || mes == 12){
            if (cDay >= 25 && cDay <= 31) { //Si se encuentran dentro de esos 31 dias
                estado = "Inscribirse";
            } else {
                estado = "Proximamente";
            }
        } else if (mes == 4 //Si el mes tiene 30 dias
                || mes == 9
                || mes == 11) {
            if (cDay >= 24 && cDay <= 30) { //Si se encuentran dentro de esos 30 dias
                estado = "Inscribirse";
            } else {
                estado = "Proximamente";
            }
        } else if (mes == 2) { //si es en febrero el curso
            if (isBiciesto){ //Si es biciesto
                if (cDay >= 23 && cDay <= 29) { //Si se encuentran dentro de esos 31 dias
                    estado = "Inscribirse";
                } else {
                    estado = "Proximamente";
                }
            } else { //Si no es biciesto el año
                if (cDay >= 22 && cDay <= 28) { //Si se encuentran dentro de esos 31 dias
                    estado = "Inscribirse";
                } else {
                    estado = "Proximamente";
                }
            }
        }
        return estado;
    }

    private void lanzarNotificacion(String curso){
        int notificationId = 1;

        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLights(Color.GREEN, 3000, 3000) //Led
                .setVibrate(new long[] {1000, 1000, 1000, 1000, 1000})
                .setContentTitle(context.getResources().getString(R.string.app_name))
                .setContentText("Ya puede inscribirse al curso de " + curso); //TODO cambiar por res string

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationCompat.setAutoCancel(true);
        notificationManager.notify(notificationId, notificationCompat.build());
    }

}

/*
if ( cYear % 4 == 0 ) { //año biciesto

        switch (mes - 1) {
        case 0: //Diciembre año anterior
        break;
        case 1: //Enero
        estado = obtenerDia(dia - 7, cDay);
        break;
        case 3: //Marzo
        break;
        case 5: //Mayo
        break;
        case 7: //Julio
        break;
        case 8: //Agosto
        break;
        case 10: //Octubre
        break;
        case 12: //Diciembre
        break;
        }

        } else { //año normal

        }*/