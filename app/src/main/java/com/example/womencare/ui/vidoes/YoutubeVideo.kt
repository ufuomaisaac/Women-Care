package com.example.womencare.ui.vidoes

import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.womencare.R

@Composable
fun VideoPlayer(context: Context, videoUri: Uri) {
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            prepare()
            //playWhenReady = true
        }
    }

    AndroidView(
        factory = {
            PlayerView(it).apply {
                player = exoPlayer
                useController = true
                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}

@Composable
fun VideoScreen() {
    val context = LocalContext.current
    val rawId_1 = R.raw.eliminating_cervical_cancer
    val rawId_2 = R.raw.video1
    val rawId_3 = R.raw.what_are_the_symptoms_of_cervical_cancer


    val uri_1 = Uri.parse("android.resource://${context.packageName}/$rawId_1")
    val uri_2 = Uri.parse("android.resource://${context.packageName}/$rawId_2")
    val uri_3 = Uri.parse("android.resource://${context.packageName}/$rawId_3")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Health Tips Video", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        VideoPlayer(context, uri_1)

        Spacer(modifier = Modifier.height(16.dp))
        VideoPlayer(context, uri_2)

        Spacer(modifier = Modifier.height(16.dp))
        VideoPlayer(context, uri_3)
        Spacer(modifier = Modifier.height(16.dp))
        VideoPlayer(context, uri_1)
        Spacer(modifier = Modifier.height(16.dp))

        VideoPlayer(context, uri_1)
        Spacer(modifier = Modifier.height(16.dp))
    }
}
