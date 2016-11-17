package com.example.eliecer_narvaez.myapp;

import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eliecer_narvaez.myapp.models.Parada;
import com.example.eliecer_narvaez.myapp.models.ProvinciaService;
import com.example.eliecer_narvaez.myapp.models.Ruta;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MapActivity extends AppCompatActivity implements GoogleMap.OnMarkerClickListener {

    GoogleMap googleMap;
    static HttpClient cliente =new DefaultHttpClient();
    static HttpContext contexto = new BasicHttpContext();
    public static ArrayList<String>	listado;
    Ubicacion objUbicacion = new Ubicacion();
    String ruta_id;

    //Tratando de modificar el evento click en el marcador
    private void setUpMap()
    {
        googleMap.setOnMarkerClickListener(this);
    }
    @Override
    public boolean onMarkerClick (Marker marker) {

        String name= marker.getTitle();

        if (name.equalsIgnoreCase("Chofer Elias"))
        {
            return false;
        }

        return true;
    }
    //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ruta_id = getIntent().getStringExtra("ruta_id");


        //clave:AIzaSyCy6f6aaZPQkDtN-CFvjfwmr7Z5teBJoow
        try {

            if(googleMap == null) {
                googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
            }

            googleMap.setMyLocationEnabled(true);
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


            LatLng pos = new LatLng(10.280413, -84.394573);
            Marker marca = googleMap.addMarker(new MarkerOptions().position(pos).title("Bus"));

            goToLocation(10, -84, 6);
            final String id = "Elias";
            this.getCoordenadas(id);

            LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Localizacion Local = new  Localizacion();
            Local.setMapActivity(this);
            mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);

            getParadas();


        }catch(Exception e){


        }
    }

    public  void getParadas(){

        ProvinciaService gitHubService = ProvinciaService.retrofit.create(ProvinciaService.class);
        Call<List<Parada>> call = gitHubService.getParadas(Integer.valueOf(ruta_id));

        call.enqueue(new Callback<List<Parada>>() {
            @Override
            public void onResponse(Call<List<Parada>> call, retrofit2.Response<List<Parada>> response) {

                for(int i=0; i<response.body().size(); i++){

                    LatLng posBus = new LatLng(Double.parseDouble(response.body().get(i).getLat()), Double.parseDouble(response.body().get(i).getLon()));
                    //LatLng posBus = new LatLng(10.280413, -84.394573);
                    Marker marcaBus = googleMap.addMarker(new MarkerOptions()
                            .position(posBus)
                            .title(response.body().get(i).getNombre())
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_bus_stop)));
                }
            }

            @Override
            public void onFailure(Call<List<Parada>> call, Throwable t) {

            }

        });

    }
    void goToLocation(double lat, double lng, float zoom) {

        LatLng pos = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, zoom);
        googleMap.moveCamera(update);
    }

    public void getCoordenadas(String pId) {

        listado = new ArrayList<String>();
        final String id = pId;

        Thread tr = new Thread(){
            @Override
            public void run(){


                final String resultado = leer(id);

                runOnUiThread(
                        new Runnable() {

                            @Override
                            public void run() {
                                Ubicacion Ubi = obtDatosJSON(resultado);
                                LatLng posBus = new LatLng(Double.parseDouble(Ubi.getLatitud()), Double.parseDouble(Ubi.getLongitud()));
                                //LatLng posBus = new LatLng(10.280413, -84.394573);
                                Marker marcaBus = googleMap.addMarker(new MarkerOptions()
                                        .position(posBus)
                                        .title("Chofer Elias")
                                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                            }
                        });
            }
        };
        tr.start();

        final  Runnable msj = new Runnable() {

            @Override
            public void run() {

                LatLng posBus = new LatLng(Double.parseDouble(objUbicacion.getLatitud()), Double.parseDouble(objUbicacion.getLongitud()));
                Marker marcaBus = googleMap.addMarker(new MarkerOptions()
                        .position(posBus)
                        .title("Chofer Elias")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                return;
            }
        };

    }

    public String leer(String pId){

        HttpClient cliente =new DefaultHttpClient();
        HttpContext contexto = new BasicHttpContext();
        //HttpPost httpPost = new HttpPost("http://192.168.1.5/dbHandlerMerFilt/getCoordenadas.php");
        HttpPost httpPost = new HttpPost("http://escuelacr.esy.es/getCoordenadas.php");

        String resultado=null;

        //try {

        HttpResponse response = null;

        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>(0);
            params.add(new BasicNameValuePair("id", pId));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            response = cliente.execute(httpPost, contexto);
            HttpEntity entity = response.getEntity();
            resultado = EntityUtils.toString(entity, "UTF-8");

        } catch (Exception e) {

        }

        return resultado;

    }

    public Ubicacion obtDatosJSON(String response){
        //esta variable debe ser global final static ********************
        //ArrayList<Consumible> listado= new ArrayList<Consumible>();
        //Ubicacion objUbicacion = new Ubicacion();
        try {

            JSONArray json= new JSONArray(response);
            //Consumible objConsumible = new Consumible();
            //ArrayList<String> list = new ArrayList<String>();


            for (int i=0; i<json.length();i++){
                objUbicacion = new Ubicacion(   json.getJSONObject(i).getString("0"),
                        json.getJSONObject(i).getString("1"),
                        json.getJSONObject(i).getString("2"),
                        json.getJSONObject(i).getString("3"),
                        json.getJSONObject(i).getString("4"));

                //listado.add(list);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return objUbicacion;
    }

    public class Localizacion implements LocationListener {
        MapActivity MapActivity;


        public MapActivity getMapActivity() {
            return MapActivity;
        }

        public void setMapActivity(MapActivity MapActivity) {
            this.MapActivity = MapActivity;
        }

        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion

            loc.getLatitude();
            loc.getLongitude();
            String Text = "Mi ubicacion actual es: " + "\n Lat = "
                    + loc.getLatitude() + "\n Long = " + loc.getLongitude();

            final String id = "Elias";
            getCoordenadas(id);

            //txtLatitud.setText(Text);
            //this.MapActivity.setLocation(loc);
        }

        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            //txtLatitud.setText("GPS Desactivado");
        }

        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            //txtLatitud.setText("GPS Activado");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // Este metodo se ejecuta cada vez que se detecta un cambio en el
            // status del proveedor de localizacion (GPS)
            // Los diferentes Status son:
            // OUT_OF_SERVICE -> Si el proveedor esta fuera de servicio
            // TEMPORARILY_UNAVAILABLE -> Temporalmente no disponible pero se
            // espera que este disponible en breve
            // AVAILABLE -> Disponible
        }

    }
}

