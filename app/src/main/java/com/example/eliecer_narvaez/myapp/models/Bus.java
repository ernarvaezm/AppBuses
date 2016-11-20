package com.example.eliecer_narvaez.myapp.models;

/**
 * Created by Benavides on 20/11/16.
 */

public class Bus {
    private  int id;
    private String placa;
    private int ruta_id;

    public Bus() {

    }

    public Bus(int id, String placa, int ruta_id) {
        this.id = id;
        this.placa = placa;
        this.ruta_id = ruta_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRuta_id() {
        return ruta_id;
    }

    public void setRuta_id(int ruta_id) {
        this.ruta_id = ruta_id;
    }

    @Override
    public String toString() {
        return placa;
    }
}
