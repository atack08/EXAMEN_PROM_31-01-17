package com.example.atack08.examen_prom;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Sonidos extends AppCompatActivity {

    private Spinner listaSonidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos);

        listaSonidos = (Spinner)findViewById(R.id.listaSonidos);

        String[] tituloSonidos = {"audio","disparo","explosión"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,tituloSonidos);

        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        listaSonidos.setAdapter(adaptador);


        //ASIGNAMOS ESCUCHADOR
        listaSonidos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //RESCATAMOS LA OPCIÓN ELEGIDA
                Log.d("Sonido", "ENTRA LISTENER");
                String tipoSonido = (String)listaSonidos.getSelectedItem();
                int recurso =  0;

                //SEGÚN LA OPCIÓN ELEGIDA RESCATAMOS UN RECURSO
                if(tipoSonido.equalsIgnoreCase("audio"))
                    recurso = R.raw.audio;
                else if(tipoSonido.equalsIgnoreCase("disparo"))
                    recurso = R.raw.disparo;
                else if (tipoSonido.equalsIgnoreCase("explosión"))
                    recurso = R.raw.explosion;

                //REPRODUCIMOS EL SONIDO
                reproducirSonido(recurso);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    public void reproducirSonido(int recurso){
        MediaPlayer mp = MediaPlayer.create(this, recurso);
        mp.start();
    }

    public void volverSonido(View v){
        finish();
    }
}
