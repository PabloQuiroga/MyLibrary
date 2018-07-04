package com.pablo.mylibrary.servicios;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.pablo.mylibrary.programados.Alarma;

public class ServicioSimple extends Service {

    private Context ctx;
    Alarma alarma = new Alarma();

    public ServicioSimple(){}
    public ServicioSimple(Context context){
        this.ctx = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        alarma.setAlarm(ctx);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
