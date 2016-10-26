package com.example.eliecer_narvaez.myapp.models;

/**
 * Created by Benavides on 25/10/16.
 */

public class Ruta {
    String nombre;
    int id;

    public Ruta(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Ruta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
