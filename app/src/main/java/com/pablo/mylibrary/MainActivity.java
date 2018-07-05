package com.pablo.mylibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pablo.mylibrary.gps.Gps;
import com.pablo.mylibrary.gps.GpsApi;
import com.pablo.mylibrary.servicios.ServiceIntent;
import com.pablo.mylibrary.servicios.ServiceSimple;
import com.pablo.mylibrary.varios.ProgressReceiver;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button, btn2;
    Button btnService, btnService2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_gps);
        btn2 = (Button)findViewById(R.id.btn_gps_api);
        btnService = (Button)findViewById(R.id.btn_serv);
        btnService2 = (Button)findViewById(R.id.btn_serv_2);

        button.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btnService.setOnClickListener(this);
        btnService2.setOnClickListener(this);

        //TODO lo lanza en ambos servicios
        IntentFilter filter = new IntentFilter();
        filter.addAction(ServiceIntent.ACTION_PROGRESO);
        filter.addAction(ServiceIntent.ACTION_FIN);
        ProgressReceiver rcv = new ProgressReceiver();
        registerReceiver(rcv, filter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_gps:{ //lanza el gps
                Gps gps = new Gps(this,this);
                break;
            }
            case R.id.btn_gps_api:{ //lanza el gps que maneja la api de google
                GpsApi gps = new GpsApi(this);
                break;
            }
            case R.id.btn_serv:{
                Intent intent = new Intent(this, ServiceSimple.class);
                startService(intent);
            }
            case R.id.btn_serv_2:{
                Intent intent = new Intent(this, ServiceIntent.class);
                intent.putExtra("iteraciones", 10);
                startService(intent);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //stopService(intent);
    }

}
