package edu.ues.fia.eisi.prj2pdm.Funciones3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import edu.ues.fia.eisi.prj2pdm.Funciones1.AudioActivity;
import edu.ues.fia.eisi.prj2pdm.Funciones1.CamaraActivity;
import edu.ues.fia.eisi.prj2pdm.Funciones1.GPSActivity;
import edu.ues.fia.eisi.prj2pdm.Funciones1.SpeechActivity;
import edu.ues.fia.eisi.prj2pdm.Funciones1.TextToSpeechActivity;
import edu.ues.fia.eisi.prj2pdm.Funciones1.VideoActivity;
import edu.ues.fia.eisi.prj2pdm.Principal;
import edu.ues.fia.eisi.prj2pdm.R;

public class MiMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ooactivity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Principal.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager=getSupportFragmentManager();
        if (id == R.id.nav_camera) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new mapaweb()).commit();
        } else if (id == R.id.nav_gallery) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new principalJuego()).commit();
        } else if (id == R.id.nav_slideshow) {
            Intent myIntent = new Intent(this, RecordAudio.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_share) {
            Intent myIntent = new Intent(this, Dietas.class);
            startActivity(myIntent);
        }
        else if (id == R.id.nav_audio) {
            Intent intent = new Intent(this, AudioActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_video) {
            Intent intent = new Intent(this, VideoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_camara) {
            Intent intent = new Intent(this, CamaraActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_speech) {
            Intent intent = new Intent(this, SpeechActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_texttospeech) {
            Intent intent = new Intent(this, TextToSpeechActivity.class);//correccion 1
            startActivity(intent);
        }
        else if (id == R.id.nav_gps) {
            Intent intent = new Intent(this, GPSActivity.class);//correccion 1
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
