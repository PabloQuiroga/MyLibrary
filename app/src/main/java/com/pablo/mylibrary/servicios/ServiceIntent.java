package com.pablo.mylibrary.servicios;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.pablo.mylibrary.MainActivity;
import com.pablo.mylibrary.varios.PersonalNotification;

// TODO http://programandoointentandolo.com/2014/07/iniciar-servicio-android-automaticamente.html
public class ServiceIntent extends IntentService {

    PersonalNotification notification;
    public static final String ACTION_PROGRESO = "com.pablo.mylibrary.servicios.PROGRESO";
    public static final String ACTION_FIN = "com.pablo.mylibrary.servicios.FIN";

    public ServiceIntent(){
        super("ServiceIntent");
    }
    public ServiceIntent(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        int itera = intent.getExtras().getInt("iteraciones");

        for (int i = 0; i < itera; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        //Comunicamos el progreso

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            Intent mIntent = new Intent();
            mIntent.setAction(ACTION_PROGRESO);
            mIntent.putExtra("progreso", i);
            sendBroadcast(mIntent);
        }
        Intent mIntent = new Intent();
        mIntent.setAction(ACTION_FIN);
        sendBroadcast(mIntent);
    }
}
