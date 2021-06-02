package edu.ues.fia.eisi.prj2pdm.Funciones1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
}
