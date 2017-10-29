package pl.koisuru.film;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;
    private int pozycja = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        videoView = (VideoView)findViewById(R.id.video);

        if (mediaController == null){
            mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
        }
        Intent intent = getIntent();
        if (intent!=null){
            String path = intent.getStringExtra("film");
            videoView.setVideoURI(Uri.parse(path));
            videoView.start();
        }
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(pozycja);
                if (pozycja==0){
                    videoView.start();
                }
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mediaController.setAnchorView(videoView);

                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();




    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tuu", videoView.getCurrentPosition());
        videoView.pause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pozycja = savedInstanceState.getInt("tuu",0);
        videoView.seekTo(pozycja);
    }
}
