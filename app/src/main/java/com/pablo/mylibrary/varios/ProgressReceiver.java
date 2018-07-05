package com.pablo.mylibrary.varios;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.pablo.mylibrary.MainActivity;
import com.pablo.mylibrary.servicios.ServiceIntent;

public class ProgressReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ServiceIntent.ACTION_PROGRESO)) {
            int prog = intent.getIntExtra("progreso", 0);
            Toast.makeText(context, "progreso: "+prog, Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(ServiceIntent.ACTION_FIN)) {
            Toast.makeText(context, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
        }
    }
}