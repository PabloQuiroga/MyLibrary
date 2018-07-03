package com.pablo.mylibrary.gps;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class GpsApi implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Context ctx;
    private Activity act;

    private Location location;
    private GoogleApiClient apiClient;
    private double latitud, longitud;

    public GpsApi(Context context){
        this.ctx = context;

        apiClient = new GoogleApiClient.Builder(ctx)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        apiClient.connect();

        updateCoords();
    }

    private void updateCoords(){
        try {
            if (location.getProvider() != null) {
                latitud = location.getLatitude();
                longitud = location.getLongitude();
                //}
            } else {
                Toast.makeText(ctx, "Ubicacion no activa", Toast.LENGTH_LONG).show();
                return;
            }
        }catch (NullPointerException e){
            Toast.makeText(ctx, "El movil posee desactivada la ubicacion", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        location = LocationServices.FusedLocationApi.getLastLocation(apiClient);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
