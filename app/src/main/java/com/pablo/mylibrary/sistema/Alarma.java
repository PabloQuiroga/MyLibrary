package com.pablo.mylibrary.sistema;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.PowerManager;
import android.widget.Toast;

import com.pablo.mylibrary.R;
import com.pablo.mylibrary.varios.PersonalNotification;

public class Alarma extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wakeLock.acquire();

        PersonalNotification personalNotification = new PersonalNotification(context, "Tarea", "Alarma!!!!!!!!!!");
        personalNotification.lanzar();
    }

    public void setAlarma(Context context){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent i = new Intent(context, Alarma.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
            am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 86400, pi); //24hs
        }else{
            scheduleJob(context);
        }
    }
    public void cancelAlarm(Context context){
        Intent intent = new Intent(context, Alarma.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

    public void scheduleJob(Context context){
        Toast.makeText(context, "Schedule Task", Toast.LENGTH_LONG).show();
        PersonalNotification personalNotification = new PersonalNotification(context, "Tarea", "Schedule Task");
        personalNotification.lanzar();
        //Intent intent = new Intent(context, MainActivity.class);
        //JobInfo.Builder builder = new JobInfo.Builder(0, intent);
    }
}
