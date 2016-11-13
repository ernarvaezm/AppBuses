package com.example.eliecer_narvaez.myapp.models;

import java.util.Timer;

/**
 * Created by Benavides on 12/11/16.
 */

public class Horario {

    private String hora_salida;
    private  int ruta_id;
    private String detalles;
    private int id;

    public Horario() {

    }

    public Horario(String hora_salida, int ruta_id, String detalles, int id) {
        this.hora_salida = hora_salida;
        this.ruta_id = ruta_id;
        this.detalles = detalles;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getRuta_id() {
        return ruta_id;
    }

    public void setRuta_id(int ruta_id) {
        this.ruta_id = ruta_id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return hora_salida;
    }
}
