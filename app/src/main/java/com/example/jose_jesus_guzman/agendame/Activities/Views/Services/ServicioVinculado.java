package com.example.jose_jesus_guzman.agendame.Activities.Views.Services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.jose_jesus_guzman.agendame.Activities.Views.Clases.Negocio;

/**
 * Created by jesus on 11/09/16.
 */
public class ServicioVinculado extends Service {

    ClaseAsincrona claseAsincrona;
    private boolean mRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mRunning = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mRunning) {
            mRunning = true;
            claseAsincrona = new ClaseAsincrona();
            claseAsincrona.execute();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        claseAsincrona = null;
    }

    private class ClaseAsincrona extends AsyncTask<String, String, String> {

        private final static int INTERVALO = 1000 * 60 * 60 * 24; //Cada 30 segundos
        private boolean mostrando;

        @Override
        protected String doInBackground(String... params) {
            while (mostrando) {
                try{
                    publishProgress("curso");
                    Thread.sleep(INTERVALO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mostrando = true;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Negocio negocio = new Negocio(getApplicationContext());
            negocio.lanzarNotificacion(values[0]);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

}
