package com.example.atack08.examen_prom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irDatosAtomicos(View v){
        Intent intent = new Intent(this, Datos_Atomicos.class);
        startActivity(intent);
    }

    public void irTiempo(View v){

        Intent intent = new Intent(this, Datos_Tiempo.class);
        startActivity(intent);

    }

    public void irSonidos(View v){

        Intent intent = new Intent(this, Sonidos.class);
        startActivity(intent);

    }

    //MÉTODO PARA SALIR
    public void salir (View salir){
        finish();
    }
}
