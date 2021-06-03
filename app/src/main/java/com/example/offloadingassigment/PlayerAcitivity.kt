package com.example.offloadingassigment

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import javax.sql.DataSource

class PlayerAcitivity : AppCompatActivity() {
    private var videoPlayer: SimpleExoPlayer? = null
    lateinit var video_player_view: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_acitivity)
        video_player_view = findViewById(R.id.videoPlayer)
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val url1 = sharedPreference.getString("video", "")
        val url2 = sharedPreference.getString("video", "")
        val url3 = sharedPreference.getString("video", "")
        val url4 = sharedPreference.getString("video", "")

        if (url1 == "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4") {

            initializePlayer(url1)

        } else if (url2 == "https://bestvpn.org/html5demos/assets/dizzy.mp4") {

            initializePlayer(url2)

        } else if (url3 == "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4") {

            initializePlayer(url3)
        }
        else if (url4 == "https://bestvpn.org/html5demos/assets/dizzy.mp4") {

            initializePlayer(url4)
        }
    }


    private fun buildMediaSource(sampleUrl: String?): MediaSource? {
        val dataSourceFactory = DefaultDataSourceFactory(this, "sample")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(sampleUrl))
    }

    private fun initializePlayer(sampleUrl: String?) {
        videoPlayer = SimpleExoPlayer.Builder(this).build()
        video_player_view.player = videoPlayer
        buildMediaSource(sampleUrl)?.let {
            videoPlayer?.prepare(it)
        }
    }

    override fun onResume() {
        super.onResume()
        videoPlayer?.playWhenReady = true
    }

    override fun onStop() {
        super.onStop()
        videoPlayer?.playWhenReady = false
        if (isFinishing) {
            releasePlayer()
        }
    }

    private fun releasePlayer() {
        videoPlayer?.release()
    }


}