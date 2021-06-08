package edu.ues.fia.eisi.prj2pdm.Funciones3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import edu.ues.fia.eisi.prj2pdm.R;
public class Dietas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietas);
        WebView myWebView = (WebView) findViewById(R.id.webview2);
        myWebView.loadUrl("file:///android_asset/dietas.html");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
