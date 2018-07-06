package com.pablo.mylibrary.servicios.sistema;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.pablo.mylibrary.R;
import com.pablo.mylibrary.sistema.Alarma;

public class AlarmService extends Service {

    Alarma alarma = new Alarma();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        alarma.setAlarma(this);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.super_mario_bros_underground);
        mp.start();
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
