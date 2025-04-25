package com.example.maps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the map fragment to load the map
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) // Notify when the map is ready
    }

    // This method will be called once the map is ready
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Set map to Satellite view
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID

        // Set location and zoom level for Ahmedabad
        val ahmedabad = LatLng(23.0225, 72.5714) // Coordinates for Ahmedabad, India
        mMap.addMarker(MarkerOptions().position(ahmedabad).title("Marker in Ahmedabad"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ahmedabad, 10f))
    }
}
