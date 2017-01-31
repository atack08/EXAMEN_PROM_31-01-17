package com.example.atack08.examen_prom;

/**
 * Created by atack08 on 31/01/17.
 */

public class Pronostico {

    private String hora,temperatura,estado;

    public Pronostico(String hora, String temperatura, String estado) {
        this.hora = hora;
        this.temperatura = temperatura;
        this.estado = estado;
    }

    public Pronostico(){};

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pronostico{" +
                "hora='" + hora + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
