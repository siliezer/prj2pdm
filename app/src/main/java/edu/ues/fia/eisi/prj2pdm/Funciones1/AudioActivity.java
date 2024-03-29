package edu.ues.fia.eisi.prj2pdm.Funciones1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

import edu.ues.fia.eisi.prj2pdm.R;

public class AudioActivity extends AppCompatActivity {

    MediaPlayer Media;
    Button Play;
    Button Stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        Play=(Button) findViewById(R.id.play);
        Stop=(Button) findViewById(R.id.stop);
        Play.setOnClickListener(onClick);
        Stop.setOnClickListener(onClick);
        Media=MediaPlayer.create(getApplicationContext(), R.raw.music);
        Toast.makeText(this, "¡Selecciona la dieta para informarte!", Toast.LENGTH_LONG).show();
    }
    View.OnClickListener onClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
// TODO Auto-generated method stub
            if (v.getId()==R.id.play){
                if (Media.isPlaying()){
                    Media.pause();
                    Play.setText("Play");
                }
                else{
                    Media.start();
                    Play.setText("Pause");
                }
            }
            else{
                Media.stop();
                Play.setText("Play");
                try{
                    Media.prepare();
                }
                catch(IllegalStateException e){
                    e.printStackTrace();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    };

    public void myMetodo(View v){
        RadioGroup rbg=(RadioGroup)findViewById(R.id.grupo);
        switch(rbg.getCheckedRadioButtonId()){
            case R.id.radiobutton1:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music); break;
            case R.id.radiobutton2:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music1); break;
            case R.id.radiobutton3:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music2); break;
            case R.id.radiobutton4:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music3); break;
            case R.id.radiobutton5:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music4); break;
            case R.id.radiobutton6:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music5); break;
            case R.id.radiobutton7:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music6); break;
            case R.id.radiobutton8:
                Media = MediaPlayer.create(getApplicationContext(), R.raw.music7); break;
        }
    }
}
