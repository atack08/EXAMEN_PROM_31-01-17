package com.example.atack08.examen_prom;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atack08 on 31/1/17.
 */

public class SAXXMLHandler extends DefaultHandler {


    private String tempVal;
    private Pronostico pronosticoTemp;
    private Pronostico pronostico;
    private boolean primerPronstico;

    public SAXXMLHandler() {
        pronosticoTemp = new Pronostico();
        primerPronstico = false;

        Log.d("XML","LLEGA AL CONSTRUCTOR DEL HANDLER");
    }

    public Pronostico getPronostico() {
        return pronostico;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        tempVal = "";
        if(qName.equalsIgnoreCase("hora")){
            pronosticoTemp = new Pronostico();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        tempVal = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        try {
            super.endElement(uri, localName, qName);

            //SOLO COGEMOS EL PRIMER PRONÓSTICO
            if (qName.equalsIgnoreCase("hora")) {
                if (!primerPronstico) {
                    pronostico = pronosticoTemp;
                    primerPronstico = true;
                }
            } else if (qName.equalsIgnoreCase("hora_datos")) {
                pronosticoTemp.setHora(tempVal);

            } else if (qName.equalsIgnoreCase("temperatura")) {
                pronosticoTemp.setTemperatura(tempVal);

            } else if (qName.equalsIgnoreCase("texto")) {
                pronosticoTemp.setEstado(tempVal);

            }

        }catch (SAXException e){
            Log.d("XML",e.getLocalizedMessage());
        }
    }
}
