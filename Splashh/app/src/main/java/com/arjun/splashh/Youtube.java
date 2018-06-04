package com.arjun.splashh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Youtube extends YouTubeBaseActivity  implements YouTubePlayer.OnInitializedListener {

    static final String GoogleAPi_key ="AIzaSyAiUPRamim0zFOc4_e3CpHVamYKS_VKJgU";
    static final String Youtube_Video ="Ye3JzYnMj74";
    static final String Youtube_playList ="TODO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout linearLayout=(LinearLayout) getLayoutInflater().inflate(R.layout.activity_youtube,null);
        setContentView(linearLayout);
//        Button button  = new Button(this);
//        button.setLayoutParams(new LinearLayout.LayoutParams(200,80));
//        button.setText("button added");
//        linearLayout.addView(button);

        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.addView(playerView);
        playerView.initialize(GoogleAPi_key,this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(!wasRestored){
            youTubePlayer.cueVideo(Youtube_Video);
        }
      //  youTubePlayer.cueVideo(Youtube_Video);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();

        }else{
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };


    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener= new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(Youtube.this, "Playing ok", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoStarted() {
            //Toast.makeText(Youtube.this, "Playing ok", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
