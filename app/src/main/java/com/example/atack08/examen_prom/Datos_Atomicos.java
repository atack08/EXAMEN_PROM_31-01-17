package com.example.atack08.examen_prom;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class Datos_Atomicos extends AppCompatActivity {

    private String TAG="Response";
    private SoapPrimitive resultado;
    private TextView simbolo,numero,peso,punto,densidad;
    private EditText textElemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos__atomicos);

        simbolo = (TextView)findViewById(R.id.labelSimbolo);
        numero = (TextView)findViewById(R.id.labelNumeroAtomico);
        peso = (TextView)findViewById(R.id.labelPesoAtomico);
        punto = (TextView)findViewById(R.id.labelPuntoEbullicion);
        densidad  = (TextView)findViewById(R.id.labelDensidad);

        textElemento = (EditText) findViewById(R.id.textElemento);
    }

    //MÉTODO QUE CONFIGURA EL REQUEST AL WEB SERVICE
    public void pedirDatos(){
        String SOAP_ACTION ="http://www.webserviceX.NET/GetAtomicNumber";

        String METHOD_NAME = "GetAtomicNumber";

        String NAMESPACE = "http://www.webserviceX.NET";

        String URL = "http://www.webservicex.net/periodictable.asmx";

        String elemento = textElemento.getText().toString();

        try{

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("ElementName", elemento);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(request);
            HttpTransportSE transport = new HttpTransportSE(URL);


            transport.call(SOAP_ACTION,soapEnvelope);
            resultado = (SoapPrimitive) soapEnvelope.getResponse();

        }
        catch (Exception ex){
            Log.e(TAG,"ERROR: "+ex.getMessage());
        }
    }

    //MÉTODO PARA FILTRAR EL RESULTADO
    public void filtrarResultado(SoapPrimitive resultado){

        String res = resultado.toString();
        String[] lineas = res.split("\n");


        for(String l: lineas){

            if(l.contains("Symbol")){
                String s = l.substring(l.indexOf('>')+1, l.lastIndexOf('<'));
                Log.e(TAG,s);
                simbolo.setText(s);
            }

             else if(l.contains("AtomicNumber")){
                String s = l.substring(l.indexOf('>')+1, l.lastIndexOf('<'));
                Log.e(TAG,s);
                numero.setText(s);
            }

            else  if(l.contains("AtomicWeight")){
                String s = l.substring(l.indexOf('>')+1, l.lastIndexOf('<'));
                Log.e(TAG,s);
                peso.setText(s);
            }

            else if(l.contains("BoilingPoint")){
                String s = l.substring(l.indexOf('>')+1, l.lastIndexOf('<'));
                Log.e(TAG,s);
                punto.setText(s);
            }

            else if(l.contains("Density")){
                String s = l.substring(l.indexOf('>')+1, l.lastIndexOf('<'));
                Log.e(TAG,s);
                densidad.setText(s);
            }
        }
    }

    public void pedirInfo(View v){
        AsyncCallWS task = new AsyncCallWS();
        task.execute();
    }

    //TAREA ASINCRONA PARA LA CONSULTA AL WEB SERVICE
    public class AsyncCallWS extends AsyncTask {


        @Override
        protected Object doInBackground(Object[] params) {
            Log.i(TAG, "metodo doInBackground");
            pedirDatos();
            return null;

        }

        protected void onPreExecute() { Log.i(TAG, "metodo onPreExecute");
            Log.i(TAG, "metodo onPreExecute");
        }


        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            filtrarResultado(resultado);


        }
    }

    //MÉTODO PARA VOLVER AL MENU PRINCIPAL
    public void volver(View v){
        finish();
    }
}
