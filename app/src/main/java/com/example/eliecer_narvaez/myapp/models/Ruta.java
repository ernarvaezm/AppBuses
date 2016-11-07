package com.example.eliecer_narvaez.myapp.models;

/**
 * Created by Benavides on 25/10/16.
 */

public class Ruta {
    String nombre;
    int id;
    int empresa_id;

    public Ruta(String nombre, int id ,int empresa_id) {
        this.nombre = nombre;
        this.id = id;
        this.empresa_id=empresa_id;
    }

    public Ruta() {
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
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
