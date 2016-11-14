package com.example.eliecer_narvaez.myapp.models;

/**
 * Created by Benavides on 13/11/16.
 */

public class Parada {
    private int id;
    private  String nombre;
    private String lat;
    private String lon;
    private  int ruta_id;

    public Parada() {

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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public int getRuta_id() {
        return ruta_id;
    }

    public void setRuta_id(int ruta_id) {
        this.ruta_id = ruta_id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
