package edu.ues.fia.eisi.prj2pdm.Funciones3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import edu.ues.fia.eisi.prj2pdm.R;
public class Presidentes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presidentes);
        WebView myWebView = (WebView) findViewById(R.id.webview2);
        myWebView.loadUrl("file:///android_asset/presidentes.html");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
