package com.example.eliecer_narvaez.myapp;

import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MapActivity extends AppCompatActivity {

    GoogleMap googleMap;

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

            LatLng pos = new LatLng(10.336074,-84.432163);
            LatLng pos2=new LatLng(10.344116,-84.432995);
            Marker marc=googleMap.addMarker(new MarkerOptions().position(pos).title("Parada Liceo"));
            Marker marca = googleMap.addMarker(new MarkerOptions().position(pos2).title("Parada Hospital").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

          //  goToLocation(41, 2, 2);

        }catch(Exception e){

        }
    }

    void goToLocation(double lat, double lng, float zoom) {

        LatLng pos = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, zoom);
        googleMap.moveCamera(update);
    }
}
