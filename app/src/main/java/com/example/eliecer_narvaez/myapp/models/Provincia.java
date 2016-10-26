package com.example.eliecer_narvaez.myapp.models;

import java.util.Date;

/**
 * Created by Benavides on 17/10/16.
 */

public class Provincia {
    String nombre;
    int id;
    String created_at;
    String updated_at;

    public Provincia(String nombre, int id, String created_at, String updated_at) {
        this.nombre = nombre;
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Provincia() {

    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
