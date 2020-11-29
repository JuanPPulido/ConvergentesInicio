package com.convergentes.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instrumento extends AppCompatActivity {

    Datos ma = new Datos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumento);
        getSupportActionBar().setTitle("Intrumento");


        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Instrumento.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }

    public void btn_gui(View view) {
        ma.setIns("gui");
        startActivity(new Intent(getApplicationContext(),Tiempos.class));
    }

    public void btn_bajo(View view) {
        ma.setIns("baj");
        startActivity(new Intent(getApplicationContext(),Tiempos.class));
    }

    public void btn_guardar(View view) {
        ma.setIns("baj");
        startActivity(new Intent(getApplicationContext(),dibujado.class));
    }
}