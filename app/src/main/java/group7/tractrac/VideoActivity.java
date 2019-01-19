package group7.tractrac;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView eventVideo;
    MediaController mCon;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        eventVideo = findViewById(R.id.videoId);
        mCon = new MediaController(this);
        eventVideo.setVideoPath("android.resource://" + getPackageName() +"/" + R.raw.evideo);
        mCon.setAnchorView(eventVideo);
        eventVideo.setMediaController(mCon);
        eventVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                eventVideo.start();
            }
        });
        if(savedInstanceState!=null){
            int currentPos =  savedInstanceState.getInt("current position");
            eventVideo.seekTo(currentPos);
        }
        eventVideo.start();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("current position",eventVideo.getCurrentPosition() );
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            int currentPos =  savedInstanceState.getInt("current position");
            eventVideo.seekTo(currentPos);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
}
