package edu.ues.fia.eisi.prj2pdm.Funciones1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.ues.fia.eisi.prj2pdm.R;

public class GPSActivity extends AppCompatActivity {
    Button obtenerDir;
    EditText edtlatitud;
    EditText edtlongitud;
    EditText edtaltitud;
    TextView edtdireccion;
    LocationManager locationManager;
    private static final int INITIAL_REQUEST = 1337;
    private static final int LOCATION_REQUEST = INITIAL_REQUEST + 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean permissionGranted = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        if(permissionGranted) {
            // {Some Code}

        } else {
            ActivityCompat.requestPermissions(this, new
                    String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        }
        setContentView(R.layout.activity_gps);
        obtenerDir = (Button) findViewById(R.id.btnObtenerDatosPos);
        edtlatitud = (EditText) findViewById(R.id.edtLatitud);
        edtlongitud = (EditText) findViewById(R.id.edtlongitud);
        edtaltitud = (EditText) findViewById(R.id.edtAltitud);
        edtdireccion = (TextView) findViewById(R.id.edtDireccion);
        obtenerDir.setOnClickListener(onClickDireccion);
        locationManager = (LocationManager)
                this.getSystemService(Context.LOCATION_SERVICE);
    }
    OnClickListener onClickDireccion = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Geocoder g = new Geocoder(getApplicationContext());
            List<Address> ad = null;
            try {
                ad = g.getFromLocation(
                        Double.valueOf(edtlatitud.getText().toString()),
                        Double.valueOf(edtlongitud.getText().toString()), 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ad != null && ad.isEmpty() == false) {
                edtdireccion.setText(ad.get(0).getThoroughfare() + ","
                        + ad.get(0).getSubAdminArea() + ","
                        + ad.get(0).getCountryName());
            }
        }
    };
    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            edtlatitud.setText(String.valueOf(location.getLatitude()));
            edtlongitud.setText(String.valueOf(location.getLongitude()));
            edtaltitud.setText(String.valueOf(location.getAltitude()));
        }
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        public void onStatusChanged(String provider, int status, Bundle extras)
        {
            // TODO Auto-generated method stub
        }
    };
    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean canAccessLocation() {
        return (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == checkSelfPermission(perm));
    }
    private void doLocationThing() {
        Toast.makeText(this, "Localizacion ", Toast.LENGTH_SHORT).show();
    }
    private void bzzzt() {
        Toast.makeText(this, "Bs", Toast.LENGTH_LONG).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[]
            permissions, int[] grantResults) {
        switch (requestCode) {
            case LOCATION_REQUEST:
                if (canAccessLocation()) {
                    doLocationThing();
                } else {
                    bzzzt();
                }
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            // ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            // public void onRequestPermissionsResult(int requestCode,String[] permissions,

            // int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
                0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                0, 0, locationListener);
    }
}
