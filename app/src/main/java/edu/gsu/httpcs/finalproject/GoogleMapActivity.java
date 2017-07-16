package edu.gsu.httpcs.finalproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static edu.gsu.httpcs.finalproject.R.id.map;

public class GoogleMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static LatLngBounds gsu1 = new LatLngBounds(new LatLng(33.753433, -84.385907), new LatLng(33.753433, -84.385907));

    @OnClick(R.id.go_to_map)
    public void gotoMap() {
        Intent intent = new Intent(GoogleMapActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.go_to_gsuWebsite)
    public void gotoWebsite(View v) {
        gotoWebsite("http://www.gsu.edu/");
    }

    private void gotoWebsite(String s) {
        Uri uriUri = Uri.parse(s);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUri);
        startActivity(launchBrowser);
    }

    @OnClick(R.id.make_call)
    public void call(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:4044132000"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);

        WebView webview = (WebView)findViewById(R.id.display_website);
        webview.loadUrl("http://www.gsu.edu/");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng gsu = new LatLng(33.753433, -84.385907);
        googleMap.addMarker(new MarkerOptions().position(gsu)
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.7f)
                .snippet("GSU Restaurant")
                .flat(true)
                .zIndex(1.0f)
                .title("GSU"));


        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(gsu));
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gsu1.getCenter(), 16));


    }
}
