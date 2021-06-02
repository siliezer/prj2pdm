package edu.ues.fia.eisi.prj2pdm.Funciones1;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

import edu.ues.fia.eisi.prj2pdm.R;

public class VideoActivity extends AppCompatActivity {

    Button Play;
    Button Stop;
    VideoView video;
    MediaController mediacontrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video=(VideoView) findViewById(R.id.video);
        File f=new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/Download/","video.mp4");
        if (f.exists()){
            Uri uri= Uri.fromFile(f);
            video.setVideoURI(uri);
            mediacontrol=new MediaController(this);
            video.setMediaController(mediacontrol);
            mediacontrol.show();

        }

    }
}
