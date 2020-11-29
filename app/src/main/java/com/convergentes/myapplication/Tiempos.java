package com.convergentes.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Tiempos extends AppCompatActivity {

    Datos ma = new Datos();

    RadioGroup radioGroup;
    RadioButton radioButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempos);
        getSupportActionBar().setTitle("Intrumento");

        radioGroup = findViewById(R.id.radiogroup);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                ma.setTie((String) radioButton.getText());

                startActivity(new Intent(getApplicationContext(),Grabar.class));
            }
        });
    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        /*ma.setTie("4/4");
        Log.d("TAG", "btn_grabar: " + ma.getTie());*/
    }

/*
    public void btn_grabar(View view) {
        ma.setTie("4/4");
        Log.d("TAG", "btn_grabar: " + ma.getTie());
    }

 */
}