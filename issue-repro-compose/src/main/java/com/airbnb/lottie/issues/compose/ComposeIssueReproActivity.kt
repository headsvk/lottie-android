package com.airbnb.lottie.issues.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

class ComposeIssueReproActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }

    @Composable
    fun Content() {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.heart))
        val state = animateLottieCompositionAsState(
            composition = composition,
            iterations = 1,
            clipSpec = LottieClipSpec.Frame(min = 33, max = 42),
        )

        Log.w("LOTTIE", "progress = ${state.progress}, isAtEnd = ${state.isAtEnd}")

        LottieAnimation(
            composition = composition,
            progress = state.progress,
        )
    }
}
