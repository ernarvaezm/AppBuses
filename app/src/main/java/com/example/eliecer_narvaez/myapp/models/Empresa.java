package com.example.eliecer_narvaez.myapp.models;

/**
 * Created by Benavides on 5/11/16.
 */

public class Empresa {
    private String nombre;
    private int id;

    public Empresa(String name, int id) {
        this.nombre = name;
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
