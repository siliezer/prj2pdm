package edu.ues.fia.eisi.prj2pdm.Funciones1;

import java.util.HashMap;
import java.util.Locale;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.ues.fia.eisi.prj2pdm.R;

public class TextToSpeechActivity extends AppCompatActivity {
    TextToSpeech tts;
    TextView Texto;
    Button BtnPlay;
    Button BtnSave;
    private static final String LOG_TAG_EXTERNAL_STORAGE = "EXTERNAL_STORAGE";
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        Texto = (TextView) findViewById(R.id.edtText2Speech);
        BtnPlay = (Button) findViewById(R.id.btnText2SpeechPlay);
        BtnSave = (Button) findViewById(R.id.btnText2SpeechSave);
        // Check whether this app has write external storage permission or not.
        int writeExternalStoragePermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
// If do not grant write external storage permission.
        if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            // Request user to grant write external storage permission.
            ActivityCompat.requestPermissions(this, new
                            String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
        }
        tts = new TextToSpeech(this, OnInit);
        BtnPlay.setOnClickListener(onClick);
        BtnSave.setOnClickListener(onClick);
    }

    TextToSpeech.OnInitListener OnInit = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            // TODO Auto-generated method stub
            if (TextToSpeech.SUCCESS == status) {
                tts.setLanguage(new Locale("spa", "ESP"));
            } else {
                Toast.makeText(getApplicationContext(), "TTS no disponible",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };
    View.OnClickListener onClick = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.DONUT)
        @SuppressLint("SdCardPath")
        public void onClick(View v) {
            // TODO Auto-generated method stub
            if (v.getId() == R.id.btnText2SpeechPlay) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(Texto.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak(Texto.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            if (v.getId() == R.id.btnText2SpeechSave) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(Texto.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak(Texto.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                }
                HashMap<String, String> myHashRender = new HashMap<String, String>();
                String Texto_tts = Texto.getText().toString();
                String destFileName = Environment.getExternalStorageDirectory() + "/tts1.wav";
                myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, Texto_tts);
                tts.synthesizeToFile(Texto_tts, myHashRender, destFileName);
            }
        }
    };

    public void onDestroy() {
        tts.shutdown();
        super.onDestroy();
    }
}

