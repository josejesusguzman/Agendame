package com.example.jose_jesus_guzman.agendame.Activities.Views.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Services.ServicioVinculado;

/**
 * Created by jesus on 11/09/16.
 */
public class Receiver extends BroadcastReceiver {
    //Esta clase fue declarada para que el dispositivo pueda ejecutar el servicio al encendido del dispositivo

    @Override //Cuando se inicia el Broadcast Receiver
    public void onReceive(Context context, Intent intent) {
        //Se inicia el servicio para que pueda ejecutarse un Hilo asincrono por largo tiempo
        context.startService(new Intent(context, ServicioVinculado.class));
    }
}
