package com.example.eliecer_narvaez.myapp;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;

public class MapActivity extends AppCompatActivity implements OnMarkerClickListener{

    GoogleMap googleMap;
    Marker marc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //clave:AIzaSyCy6f6aaZPQkDtN-CFvjfwmr7Z5teBJoow
        try {

            if(googleMap == null) {
                googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
            }

            googleMap.setMyLocationEnabled(true);
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

            LatLng pos = new LatLng(10.367148,-84.436197);
            LatLng pos2=new LatLng(10.367378,-84.438204);
            LatLng pos3=new LatLng(10.365162,-84.439985);
            LatLng pos4=new LatLng(10.363019,-84.440349);
            LatLng pos5=new LatLng(10.361246,-84.440575);
            LatLng pos6=new LatLng(10.359688,-84.441079);
            LatLng pos7=new LatLng(10.358686,-84.440741);
            LatLng pos8=new LatLng(10.355335,-84.437726);
            LatLng pos9=new LatLng(10.350945,-84.434878);
            LatLng pos10=new LatLng(10.348993,-84.434266);

            LatLng pos11=new LatLng(10.345763,-84.433526);

             marc=googleMap.addMarker(new MarkerOptions().position(pos2).title("COPA") .snippet("This is my spot!"));

            Marker marc1=googleMap.addMarker(new MarkerOptions().position(pos3).title("Parada Lavacar"));
            Marker marc2=googleMap.addMarker(new MarkerOptions().position(pos4).title("Parada Cruce loma Verde"));
            Marker marc3=googleMap.addMarker(new MarkerOptions().position(pos5).title("Parada Cruce"));
            Marker marc4=googleMap.addMarker(new MarkerOptions().position(pos6).title("Parada Super la familia ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            Marker marc5=googleMap.addMarker(new MarkerOptions().position(pos7).title("Parada Cruce"));
            Marker marc6=googleMap.addMarker(new MarkerOptions().position(pos8).title("Parada Nissan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            Marker marc7=googleMap.addMarker(new MarkerOptions().position(pos9).title("Parada ?").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));


            Marker marca = googleMap.addMarker(new MarkerOptions().position(pos11).title("Parada  Siglo XXI").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

          //  goToLocation(41, 2, 2);

        }catch(Exception e){

        }
        googleMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker.getTitle().equals("COPA")){
                    Intent intent = new Intent(MapActivity.this, MyBusActivity.class);
                    startActivity(intent);
                    finish();

                }


            }
        });

    }

    void goToLocation(double lat, double lng, float zoom) {

        LatLng pos = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, zoom);
        googleMap.moveCamera(update);
    }




    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}

