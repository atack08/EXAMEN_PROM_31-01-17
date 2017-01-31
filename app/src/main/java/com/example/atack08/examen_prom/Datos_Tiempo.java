package com.example.atack08.examen_prom;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class Datos_Tiempo extends AppCompatActivity {

    private String url;
    private TextView labelHora,labelTemp, labelEstado;
    private TableLayout tabla;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos__tiempo);

        labelHora = (TextView) findViewById(R.id.resultHora);
        labelTemp = (TextView) findViewById(R.id.resultTemp);
        labelEstado = (TextView) findViewById(R.id.resultEstado);
        tabla = (TableLayout) findViewById(R.id.tablaResults);
    }

    public void tiempoVitoria(View v){

        this.url = "http://xml.tutiempo.net/xml/8043.xml";
        CargarXmlTask xmlTask = new CargarXmlTask();

        xmlTask.execute(this.url);


    }

    public void tiempoBilbao(View v){
        this.url = "http://xml.tutiempo.net/xml/8050.xml";

        CargarXmlTask xmlTask = new CargarXmlTask();

        xmlTask.execute(this.url);

    }

    public void tiempoDonosti(View v){
        this.url = "http://xml.tutiempo.net/xml/4917.xml";

        CargarXmlTask xmlTask = new CargarXmlTask();

        xmlTask.execute(this.url);

    }

    //----------TAREA EN CLASE INTERNA
    private class CargarXmlTask extends AsyncTask{

        private Pronostico pronostico;
        @Override
        protected Object doInBackground(Object[] params) {

            String url = (String) params[0];
            SAXXMLParser saxParser = new SAXXMLParser(url);

            pronostico = saxParser.parse();

            Log.e("TAG",pronostico.toString());

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            //HACEMOS LA TABLA VISIBLE
            if(tabla.getVisibility() == View.INVISIBLE)
                tabla.setVisibility(View.VISIBLE);

            labelHora.setText(pronostico.getHora());
            labelEstado.setText(pronostico.getEstado());
            labelTemp.setText(pronostico.getTemperatura());


        }
    }

    public void volver(View v){
        finish();
    }
}
