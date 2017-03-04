package dheeraj.com.youtubefeed;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.jaedongchicken.ytplayer.YoutubePlayerView;
import com.pierfrancescosoffritti.youtubeplayer.AbstractYouTubeListener;

/**
 * Created by bhatia on 03/03/17.
 */
public class FragRecycler extends RecyclerView.Adapter<FragRecycler.VideoIHolder> {


    String[] VideoID = {"P3mAtvs5Elc", "nCgQDjiotG0", "P3mAtvs5Elc"};
    Context ctx;

    public FragRecycler(Context context) {
        this.ctx = context;
    }

    @Override
    public FragRecycler.VideoIHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_youtube_list, parent, false);
        return new VideoIHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FragRecycler.VideoIHolder holder, final int position) {
        holder.youtubePlayerView.setAutoPlayerHeight(ctx);
        // initialize YoutubePlayerCallBackListener and VideoID
        holder.youtubePlayerView.initialize(VideoID[position], new YoutubePlayerView.YouTubeListener() {

            @Override
            public void onReady() {
                // when player is ready.
            }

            @Override
            public void onStateChange(YoutubePlayerView.STATE state) {
                /**
                 * YoutubePlayerView.STATE
                 *
                 * UNSTARTED, ENDED, PLAYING, PAUSED, BUFFERING, CUED, NONE
                 *
                 */
            }

            @Override
            public void onPlaybackQualityChange(String arg) {
            }

            @Override
            public void onPlaybackRateChange(String arg) {
            }

            @Override
            public void onError(String error) {
            }

            @Override
            public void onApiChange(String arg) {
            }

            @Override
            public void onCurrentSecond(double second) {
                // currentTime callback
            }

            @Override
            public void onDuration(double duration) {
                // total duration
            }

            @Override
            public void logs(String log) {
                // javascript debug log. you don't need to use it.
            }
        });


        // psuse video
        holder.youtubePlayerView.pause();
        // play video when it's ready
        holder.youtubePlayerView.play();
    }

    @Override
    public int getItemCount() {
        return VideoID.length;
    }

    public class VideoIHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        YoutubePlayerView youtubePlayerView ;
        public VideoIHolder(View itemView) {
            super(itemView);
             youtubePlayerView = (YoutubePlayerView)itemView.findViewById(R.id.youtubePlayerView);


        }

        @Override
        public void onClick(View view) {

        }
    }
}
