package com.example.eliecer_narvaez.myapp.models;

/**
 * Created by Benavides on 19/10/16.
 */

public class Canton {
    String nombre;
    int id;
    int provincia_id;

    public Canton() {
      
    }

    public Canton(String nombre, int id, int provincia_id) {
        this.nombre = nombre;
        this.id = id;
        this.provincia_id = provincia_id;
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

    public int getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
