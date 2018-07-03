package com.pablo.mylibrary;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

public class Gps implements LocationListener {

    Context context;
    Activity activity;

    LocationManager manager;
    double latitud, longitud;

    public Gps(Context ctx, Activity act){
        this.context = ctx;
        this.activity = act;

        manager = (LocationManager)act.getSystemService(context.LOCATION_SERVICE);

        initComponents();
    }

    private void initComponents() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    255);
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                //1000*3600, // 1 hora
                1000*5,
                1,
                this);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitud = location.getLatitude();
        longitud = location.getLongitude();

        Toast.makeText(context, "latitud: "+latitud +" longitud: "+longitud, Toast.LENGTH_LONG).show();
        //Log.e("latitud", ""+latitud);//TODO imprime bien
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
