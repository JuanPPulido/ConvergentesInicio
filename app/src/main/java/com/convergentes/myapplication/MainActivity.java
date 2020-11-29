package com.convergentes.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String ins, tie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        Log.d("TAG", "setTie: " + ins);
        this.ins = ins;
    }

    public String getTie() {
        return tie;
    }

    public void setTie(String tie) {
        Log.d("TAG", "setTie: " + tie);
        this.tie = tie;
    }
}