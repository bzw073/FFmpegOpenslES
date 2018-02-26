package com.test.ffmpegopensles;

import android.Manifest;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private MusicPlay musicPlay = new MusicPlay();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE}, 5);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                musicPlay.create();
            }
        }).start();
    }

    public void play(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                musicPlay.play();
            }
        }).start();

    }
    public void pause(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                musicPlay.pause();
            }
        }).start();
    }
    public void stop(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                musicPlay.stop();
            }
        }).start();
    }


}
