package com.pablo.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pablo.mylibrary.gps.Gps;
import com.pablo.mylibrary.gps.GpsApi;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_gps);
        btn2 = (Button)findViewById(R.id.btn_gps_api);

        button.setOnClickListener(this);
        btn2.setOnClickListener(this);
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
        }
    }
}
