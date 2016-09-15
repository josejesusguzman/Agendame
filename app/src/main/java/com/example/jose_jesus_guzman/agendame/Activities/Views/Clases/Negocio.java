package com.example.jose_jesus_guzman.agendame.Activities.Views.Clases;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.jose_jesus_guzman.agendame.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jesus on 8/09/16.
 */
public class Negocio {
    //En esta clase se puede encontrar la logica del negocio como el lanzamiento de notificaciones y
    //El metodo para determinar si es proximamente o inscribirse en los botones

    private Context context;

    public Negocio(Context context) {
        this.context = context;
    }

    //Si el numero es menor de 10 (tiene una sola cifra) se añade un cero a la derecha
    public String convertirNumero(int numero) {
        String num = "";
        if(numero < 10) {
            num = "0" + numero;
        } else {
            num = "" + numero;
        }
        return num;
    }

    //El mes se combierte a letra para una mayor comodidad de lectura.
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

    //Segun el titulo del curso, sera la imagen que se mandara.
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

    //Siete dias antes de la fecha de inicio y en la fecha de inicio, el usuario ya se puede inscribir
    public boolean obtenerEstado(int dia, int mes){
        boolean estado = false;

        //Obtener la fecha actual del dispositivo
        Calendar calander = Calendar.getInstance();
        int cDay = calander.get(Calendar.DAY_OF_MONTH);
        int cMonth = calander.get(Calendar.MONTH) + 1;
        int cYear = calander.get(Calendar.YEAR);

        if (dia <= 7) { //
            estado = (cYear % 4 == 0)
                    ? obtenerStringEstado(mes - 1, cDay, true) //Si el año es biciesto
                    : obtenerStringEstado(mes - 1, cDay, false); //Si el año es normal
        } else {
            if (cDay >= (dia - 7) && cDay <= dia && cMonth == mes) { //Si esta entre el dia de inicio de curso y 7 dias anteriores
                estado = true;
                lanzarNotificacion("Fundamentos de diseño Web"); //TODO recibir el nombre del curso y el id
            } else {
                estado = false;
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
    private boolean obtenerStringEstado(int mes, int cDay, boolean isBiciesto) {
        boolean estado = false; //TRUE: inscribirse //FALSE: proximamente
        if (mes == 0 //Diciembre del año anterior
                ||mes == 1 //Si los meses tienen 31 dias
                || mes == 3
                || mes == 5
                || mes == 7
                || mes == 8
                || mes == 10
                || mes == 12){
            if (cDay >= 25 && cDay <= 31) { //Si se encuentran dentro de esos 31 dias
                estado = true;
            } else {
                estado = false;
            }
        } else if (mes == 4 //Si el mes tiene 30 dias
                || mes == 9
                || mes == 11) {
            if (cDay >= 24 && cDay <= 30) { //Si se encuentran dentro de esos 30 dias
                estado = true;
            } else {
                estado = false;
            }
        } else if (mes == 2) { //si es en febrero el curso
            if (isBiciesto){ //Si es biciesto
                if (cDay >= 23 && cDay <= 29) { //Si se encuentran dentro de esos 31 dias
                    estado = true;
                } else {
                    estado = false;
                }
            } else { //Si no es biciesto el año
                if (cDay >= 22 && cDay <= 28) { //Si se encuentran dentro de esos 31 dias
                    estado = true;
                } else {
                    estado = false;
                }
            }
        }
        return estado;
    }

    //TODO implementar servicio con asyncTask y que se ejecute al principio la aplicacion
    public void lanzarNotificacion(String curso){
        int notificationId = 1;
        Uri notifySound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION); //Sonido

        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(notifySound)
                .setLights(Color.GREEN, 3000, 3000) //Led
                .setVibrate(new long[] {1000, 1000, 1000, 1000, 1000})
                .setContentTitle(context.getResources().getString(R.string.app_name))
                .setContentText("Ya puede inscribirse al curso de " + curso); //TODO cambiar por res string

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationCompat.setAutoCancel(true);
        notificationManager.notify(notificationId, notificationCompat.build());
    }

    //Se obtiene el dia de la semana segun del numero del dia en la semana
    public String obtenerDiaSemana(int diaSemana) {
        switch (diaSemana){
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miercoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sabado";
            case 7:
                return "Domingo";
            default:
                return "";
        }
    }

    //Se obtiene un string ya con la fecha concatenada y y el dia de la semana
    public String obtenerFechaString(int dia, int mes, int año) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(año - 1900, mes, dia));
        System.out.println(c);
        return obtenerDiaSemana(c.get(Calendar.DAY_OF_WEEK))
                + " " + convertirNumero(dia) + " de " + convertirMes(mes);
    }

    public String obtenerHoraString(int horas) {
        return convertirHora(horas) + " " + obtenerMeridiano(horas);
    }

    //Segun la hora se decide entre am o pm
    private String obtenerMeridiano(int hora) {
        if (hora < 12){
            return "am";
        } else {
            return "pm";
        }
    }

    //Se convierte la hora en formato de 12 horas.
    private int convertirHora(int hora){
        if (hora < 12) {
            return hora;
        } else {
            return hora - 12;
        }

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