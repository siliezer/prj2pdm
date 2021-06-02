package edu.ues.fia.eisi.prj2pdm.Funciones2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import edu.ues.fia.eisi.prj2pdm.R;

public class mapaweb extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_mapaweb, container, false);
        WebView myWebView = (WebView) view.findViewById(R.id.webview);
        myWebView.loadUrl("file:///android_asset/index.html");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return view;
    }
}