package com.pablo.mylibrary.servicios;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.pablo.mylibrary.MainActivity;
import com.pablo.mylibrary.R;
import com.pablo.mylibrary.varios.PersonalNotification;

//maneja solicitudes de inicio simultáneas
public class ServiceSimple extends Service {

    PersonalNotification notification;
    MediaPlayer mp;

    public ServiceSimple() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "servicio creado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "servicio iniciado", Toast.LENGTH_SHORT).show();

        mp = MediaPlayer.create(this, R.raw.marcha_peronista);
        mp.start();

        Intent mIntent = new Intent(this, MainActivity.class); //intent para la notificacion
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);

        notification = new PersonalNotification(this, "Servicio Simple", "Servicio iniciado", pendingIntent);
        notification.lanzar();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Servicio onBind!", Toast.LENGTH_SHORT).show();
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Servicio destruído!", Toast.LENGTH_SHORT).show();
    }
}
