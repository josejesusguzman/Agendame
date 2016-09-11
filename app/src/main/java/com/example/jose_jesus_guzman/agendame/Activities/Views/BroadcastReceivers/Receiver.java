package com.example.jose_jesus_guzman.agendame.Activities.Views.BroadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Services.ServicioVinculado;

/**
 * Created by jesus on 11/09/16.
 */
public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ServicioVinculado.class));
    }
}
