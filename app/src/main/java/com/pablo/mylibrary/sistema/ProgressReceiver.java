package com.pablo.mylibrary.sistema;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.pablo.mylibrary.MainActivity;
import com.pablo.mylibrary.servicios.ServiceIntent;

public class ProgressReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Desde el Broadcast", Toast.LENGTH_LONG).show();
        //TODO lanzar una notificacion que dirija a la actividad
    }
}