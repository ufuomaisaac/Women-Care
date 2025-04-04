package com.example.womencare.ui.vidoes

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoPlayer(
    videoUri : Uri
) {
    AndroidView(factory = {context ->
        VideoView(context).apply {
            setVideoURI(videoUri)

            val mediaController = MediaController(context)
            mediaController.setAnchorView(this)

            setMediaController(mediaController)

            setOnPreparedListener {
                start()
            }
        }
    }
    )
}

@Composable
fun VideoPlayerScreen() {
    val videoUri = Uri.parse("android.resources://com.example.womencare/raw/video1")
    Column() {
        VideoPlayer(videoUri = videoUri)
    }
}