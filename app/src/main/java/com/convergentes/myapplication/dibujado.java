 package com.convergentes.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class dibujado extends AppCompatActivity {

    private LinearLayout contenedor;
    private Spinner spinner;
    private EditText tex;
    private EditText texb;
    private String clave;
    private String compas;
    private String fre[] = {"349,228","440,000","329,628","261,626","293,665","493,883","391,995"};
    private Spinner nombres;
    private String parti;
    private ArrayList<String> part = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujado);
    }

    public void blanco(){
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.blanco);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void clavesol() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.clavesol);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void clavefa() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.clavefa);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void notasol(){
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.sol);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void notado() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.notado);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void notafa() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.ifa);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void notala() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.la);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void notami() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.mi);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void notare() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.re);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void notasi() {
        contenedor = findViewById(R.id.linear);

        //Crea ImageView
        ImageView miImageView = new ImageView(getApplicationContext());

        //Agrega imagen al ImageView.
        miImageView.setImageResource(R.drawable.si);

        //Agrega vistas al contenedor.
        contenedor.addView(miImageView);
    }

    public void crear (View view){
        contenedor = findViewById(R.id.linear);
        contenedor.removeAllViews();
        compas = "4/4";
        parti = "";

        int cl = (int)(Math.random() * 2 + 1);

        if(cl == 1){
            clave = "clavesol";
        }else{
            clave = "clavefa";
        }

        switch (clave){
            case "clavesol":
                clavesol();
                parti = parti + "clavesol";
                break;
            case "clavefa":
                clavefa();
                parti = parti + "clavefa";
                break;
        }

        /*switch (compas){
            case "4/4":
                //cuatro4();
                break;
            case "1/4":
                //un4();
                break;

        }*/

        for (int i=0; i<20; i++){

            String nota = fre[(int)(Math.random() * 6 + 1)];
            parti += "-" + nota ;
            switch (nota) {
                case "blanco":
                    blanco();
                    break;
                case "349,228": //FA
                    notafa();
                    break;
                case "440,000": //LA
                    notala();
                    break;
                case "329,628": //MI
                    notami();
                    break;
                case "261,626": //DO
                    notado();
                    break;
                case "293,665": //RE
                    notare();
                    break;
                case "493,883": //SI
                    notasi();
                    break;
                case "391,995": //SOL
                    notasol();
                    break;
            }
        }
    }

    public void guardar (View view){
        tex = (EditText) findViewById(R.id.nombre);

        Intent intent = new Intent(this,notifi.class);
        intent.putExtra(notifi.EXTRA_MESSAGE,"Partitura: " + tex.getText().toString()/*aqui va el mensaje*/);
        startService(intent);

        parti += "_" + tex.getText().toString();
        part.add(parti);

        names.add(tex.getText().toString());

        spinner();

        parti = "";
        tex.setText("");
    }

    public void spinner(){
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,names));
    }

    public void dibujar (View view){
        contenedor = findViewById(R.id.linear);
        contenedor.removeAllViews();

        spinner = (Spinner)findViewById(R.id.spinner);

        String compa = spinner.getSelectedItem().toString();

        for(int i=0;i<part.size(); i++){

            String [] pn = part.get(i).split("_");

            if(pn[1].equals(compa)){

                i=part.size();

                String [] cp = pn[0].split("-");

                //Clave de partitura
                switch (cp[0]){
                    case "clavesol":
                        clavesol();
                        break;
                    case "clavefa":
                        clavefa();
                        break;
                }

                //Dibujar Notas Base 20
                for (int j=1; j<cp.length;j++) {
                    switch (cp[j]) {
                        case "blanco":
                            blanco();
                            break;
                        case "349,228": //FA
                            notafa();
                            break;
                        case "440,000": //LA
                            notala();
                            break;
                        case "329,628": //MI
                            notami();
                            break;
                        case "261,626": //DO
                            notado();
                            break;
                        case "293,665": //RE
                            notare();
                            break;
                        case "493,883": //SI
                            notasi();
                            break;
                        case "391,995": //SOL
                            notasol();
                            break;
                    }
                }
            }
        }
    }

    public void borrar (View view){
        /*texb = (EditText) findViewById(R.id.nombrebo);

        parti = texb.getText().toString();

        for (int i=0;i<names.size();i++){
            if(parti.equals(names.get(i))){
                i = names.size();
                Log.d("Borrar", " " + i);
                names.remove(i);
                part.remove(i);
            }
        }

        spinner();
        parti = "";
        texb.setText("");*/
    }
}