package com.convergentes.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Locale;

public class Grabar extends AppCompatActivity {

    //MainActivity ma = new MainActivity();

    int sp = 0;

    private MediaRecorder grabacion = null;
    private String archivoSalida = null;
    private Button btn_recorder;

    //ImageView uno = (ImageView) findViewById(R.id.clave);
    //TextView dos = (TextView)findViewById(R.id.contador);

    private String ins = "gui";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabar);
        getSupportActionBar().setTitle("Grabar");

        ImageView uno = (ImageView) findViewById(R.id.clave);

        //ins = ma.getIns();

        Log.d("TAG", "onCreate: " + ins);

        /*if(ins.equals("gui"))
            uno.setImageResource(R.drawable.sol);
        else if(ins.equals("baj"))
            uno.setImageResource(R.drawable.fa);
        */
    }

    public void btn_iniciar(View view) {


        if(sp == 0){
            sp = 1;
            btn_recorder = (Button) findViewById(R.id.grabar_stop);
            final TextView dos = (TextView)findViewById(R.id.contador);
            Log.d("TAG", "btn_iniciar: ");
            CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
                public void onTick(long millisUntilFinished) {
                    dos.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                }

                public void onFinish() {
                    dos.setText("GRABANDO");



                    if(grabacion == null){
                        archivoSalida = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Grabacion.mp3";
                        grabacion = new MediaRecorder();
                        grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
                        grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        grabacion.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
                        grabacion.setOutputFile(archivoSalida);

                        try {
                            grabacion.prepare();
                            grabacion.start();

                        }catch (IOException e){
                        }
                        btn_recorder.setBackgroundResource(R.drawable.detener);
                        Toast.makeText(Grabar.this, "Grabacion Inciada", Toast.LENGTH_SHORT).show();
                    }
                }
            }.start();

        } else if(sp == 1){
            sp = 0;
            final TextView dos = (TextView)findViewById(R.id.contador);
            Log.d("TAG", "btn_pausar: ");
            dos.setText("PAUSADO");
            if(grabacion != null){
                grabacion.stop();
                grabacion.release();
                grabacion = null;
                btn_recorder.setBackgroundResource(R.drawable.inicio);
                Toast.makeText(this, "Grabacion Finalizada", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void btn_reproducir(View view) {
        if(sp == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(archivoSalida);
                mediaPlayer.prepare();
            } catch (IOException e) {
            }

            mediaPlayer.start();
            Toast.makeText(this, "Reproduciendo el Audio", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Deten la grabacion Primero", Toast.LENGTH_SHORT).show();
        }
    }

    public void btn_siguiente(View view) {
        Log.d("TAG", "btn_detener: ");
    }
}