package com.example.atack08.examen_prom;

/**
 * Created by atack08 on 31/01/17.
 */

public class Elemento {

    private String simbolo,numero,peso,punto,densidad;

    public Elemento(String simbolo, String numero, String peso, String punto, String densidad) {
        this.simbolo = simbolo;
        this.numero = numero;
        this.peso = peso;
        this.punto = punto;
        this.densidad = densidad;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getDensidad() {
        return densidad;
    }

    public void setDensidad(String densidad) {
        this.densidad = densidad;
    }
}
