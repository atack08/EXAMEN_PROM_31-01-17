package com.example.atack08.examen_prom;

import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by atack08 on 31/1/17.
 */

public class SAXXMLParser {

    private URL rssUrl;

    public SAXXMLParser(String url) {
        try{
            this.rssUrl = new URL(url);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

    }

    public Pronostico parse() {

            Pronostico pronostico = null;
        try{
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser()
                    .getXMLReader();
            // CREAMOS EL SAXXMLHandler
            SAXXMLHandler saxHandler = new SAXXMLHandler();

           //ASIGANMOS EL MANEJADOR
            xmlReader.setContentHandler(saxHandler);

            //CREAMOS EL INPUT STREAM
            InputStream in = this.getInputStream();

            //APLICAMOS EL PARSER AL INPUT STREAM
            xmlReader.parse(new InputSource(this.getInputStream()));

            //OBTENEMOS EL PRONOSTICO
            pronostico = saxHandler.getPronostico();

        }
        catch (Exception ex) {
            Log.d("XML", "SAXXMLParser: parse() failed");
        }

        return pronostico;
    }


    private InputStream getInputStream() {
        try {
            return rssUrl.openConnection().getInputStream();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
