package com.zenovak.genericmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    Button forwardBut, replayBut, playBut, pauseBut;
    SeekBar seekbar;

    MediaPlayer mediaPlayer;
    Handler handler = new Handler();

    double startTime = 0;
    double finalTime = 0;
    int forwardTime = 5000;
    int backwardTIme = -5000;

    static int oneTimeOnly = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forwardBut = findViewById(R.id.btn_forward);
        replayBut = findViewById(R.id.btn_replay);
        playBut = findViewById(R.id.btn_play);
        pauseBut = findViewById(R.id.btn_pause);
        seekbar = findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create(this, R.raw.snowfall);
        seekbar.setClickable(false);

        playBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Play();
            }
        });
    }

    private void Play(){
        mediaPlayer.start();

        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();

        if (oneTimeOnly == 0) {
            seekbar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }

    }
}