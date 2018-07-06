package com.pablo.mylibrary.sistema;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoStart extends BroadcastReceiver {

    Alarma alarma = new Alarma();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            alarma.setAlarma(context);
        }
    }
}
