package com.example.eliecer_narvaez.myapp.models;

/**
 * Created by Benavides on 17/10/16.
 */

import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Field;


public  interface ConnectionService {

    /**
     *   @GET("api/cantones/provincia/{id}")
    *Call<List<Canton>> getCantones(
     *@Path("id") int id);
     *@GET("api/provincias")
     *Call<List<Provincia>> getProvincias();
     */


      @GET("api/ruta/horarios/{id}")
    Call<List<Horario>> getHorarios(
            @Path("id") int id);

    @GET("api/paradas/ruta/{id}")
    Call<List<Parada>> getParadas(
            @Path("id") int id);

    @GET("api/buses/parada/{id}")
    Call<List<Bus>> getBuses(
            @Path("id") int id);


    @GET("api/empresas/ruta/{id}")
    Call<List<Empresa>> getEmpresas(
            @Path("id") int id);

    @GET("api/rutas")
    Call<List<Ruta>> getRutas();


    @POST("/api/login")
    Call<Object> log2(@Body User user);

    @POST("/api/register")
    Call<JSONArray> register(@Body User user);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://enigmatic-spire-20255.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
