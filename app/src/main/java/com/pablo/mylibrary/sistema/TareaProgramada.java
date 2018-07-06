package com.pablo.mylibrary.sistema;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import com.pablo.mylibrary.MainActivity;
import com.pablo.mylibrary.servicios.ServiceSimple;
import com.pablo.mylibrary.varios.PersonalNotification;

import java.util.Calendar;

public class TareaProgramada extends BroadcastReceiver{
    int intervalo = 1000*60;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Manager", Toast.LENGTH_LONG).show();
        PersonalNotification personalNotification = new PersonalNotification(context, "Tarea", "Schedule Task");
        personalNotification.lanzar();

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){

            AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

            Intent mIntent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, mIntent, 0);

            // Set the alarm to start at 9:30 a.m.
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 9);
            calendar.set(Calendar.MINUTE, 45);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), calendar.getTimeInMillis(), pendingIntent);

        }else{
            scheduleJob(context);
        }
    }

    public void scheduleJob(Context context){
        Toast.makeText(context, "Schedule Task", Toast.LENGTH_LONG).show();
        PersonalNotification personalNotification = new PersonalNotification(context, "Tarea", "Schedule Task");
        personalNotification.lanzar();
        //Intent intent = new Intent(context, MainActivity.class);
        //JobInfo.Builder builder = new JobInfo.Builder(0, intent);
    }
}
