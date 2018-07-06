package com.pablo.mylibrary.servicios;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class ServiceIntent extends IntentService {

    public ServiceIntent(){
        super("ServiceIntent");
    }
    public ServiceIntent(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //TODO mostrar mensaje tipo Toast sobre el progreso
        int itera = intent.getExtras().getInt("iteraciones");

        for (int i = 1; i <= itera; i++) {
            Log.e("iteracion", ""+i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"iteracion finalizada!", Toast.LENGTH_SHORT).show();

            }
        });
        Log.e("iteracion", "Finalizado!");
    }

}
