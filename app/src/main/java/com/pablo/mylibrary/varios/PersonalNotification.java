package com.pablo.mylibrary.varios;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

public class PersonalNotification {

    private Context ctx;
    NotificationManager manager;
    private final int ID_NOTIFICATION = 200;
    private final String NOTIFICATION = "Notificacion personalizada";
    private String titulo, mensaje;
    long vibrate[]={0,100,100}; //patron vibracion
    private PendingIntent pendingIntent;

    public PersonalNotification(Context context, String title, String message, PendingIntent pendingIntent){
        this.ctx = context;
        manager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        this.titulo = title;
        this.mensaje = message;
        this.pendingIntent = pendingIntent;
    }
    public PersonalNotification(Context context, String title, String message){
        this.ctx = context;
        manager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        this.titulo = title;
        this.mensaje = message;
    }

    public void lanzar() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                ctx, NOTIFICATION)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(titulo)
                .setContentText(mensaje)
                .setContentIntent(pendingIntent) //activity al pulsar
                .setVibrate(vibrate)
                .setWhen(System.currentTimeMillis());

        manager.notify(ID_NOTIFICATION, builder.build());
    }

    public void detener(){
        manager.cancel(ID_NOTIFICATION);
    }
}
