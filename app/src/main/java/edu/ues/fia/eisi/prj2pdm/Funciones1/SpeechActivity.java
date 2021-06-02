package edu.ues.fia.eisi.prj2pdm.Funciones1;

import java.util.ArrayList;
import java.util.Locale;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import edu.ues.fia.eisi.prj2pdm.R;

public class SpeechActivity extends AppCompatActivity implements OnClickListener
{
    ListView lv;
    static final int check=1111;
    Button Voice;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        Voice=(Button) findViewById(R.id.bvoice);
        lv =(ListView) findViewById(R.id.lvVoiceReturn);
        Voice.setOnClickListener(this);
    }
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.bvoice) {
            // Si entramos a dar clic en el boton
            Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hable ahora ");
            startActivityForResult(i, check);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        // TODO Auto-generated method stub
        if (requestCode==check && resultCode==RESULT_OK){
            ArrayList<String> results =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            lv.setAdapter(new
                    ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,results));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void onDestroy(){
        super.onDestroy();
    }
}
