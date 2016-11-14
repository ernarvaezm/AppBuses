package com.example.eliecer_narvaez.myapp;
import java.io.Serializable;
import org.apache.http.entity.SerializableEntity;
import java.util.Date;
import org.apache.http.entity.SerializableEntity;

/**
 * Created by Benavides on 13/11/16.
 */

public class Ubicacion  implements Serializable {
    private String id;
    private String latitud;
    private String longitud;
    private String lugar;
    private String fecha;

    public Ubicacion(String pIdBus, String pLatitud, String plongitud, String pLugar, String pFecha) {

        this.id = pIdBus;
        this.latitud = pLatitud;
        this.longitud = plongitud;
        this.lugar = pLugar;
        this.fecha = pFecha;

    }

    public Ubicacion() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
