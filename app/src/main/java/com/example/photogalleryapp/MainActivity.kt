package com.example.photogalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.photogalleryapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoGalleryApp()
        }
    }
}@Composable

fun PhotoGalleryApp() {
    var currentImageIndex by remember { mutableIntStateOf(0) }
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = getImageContentDescriptionResId(currentImageIndex)),
            modifier = Modifier.padding(8.dp)
        )
        Image(
            painter = painterResource(id = images[currentImageIndex]),
            contentDescription = stringResource(id = getImageContentDescriptionResId(currentImageIndex)),
            modifier = Modifier
                .size(400.dp)
                .scale(0.8f)
        )

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (currentImageIndex > 0) {
                Button(onClick = { currentImageIndex-- }) {
                    BasicText(text = stringResource(id = R.string.button_previous))
                }
            } else {
                Spacer(modifier = Modifier.size(80.dp))
            }

            if (currentImageIndex < images.size - 1) {
                Button(onClick = { currentImageIndex++ }) {
                    BasicText(text = stringResource(id = R.string.button_next))
                }
            } else {
                Spacer(modifier = Modifier.size(80.dp))
            }
        }
    }
}

@Composable
fun getImageContentDescriptionResId(index: Int): Int {
    return when (index) {
        0 -> R.string.artwork_1_content_description
        1 -> R.string.artwork_2_content_description
        2 -> R.string.artwork_3_content_description
        3 -> R.string.artwork_4_content_description
        4 -> R.string.artwork_5_content_description
        5 -> R.string.artwork_6_content_description
        6 -> R.string.artwork_7_content_description
        7 -> R.string.artwork_8_content_description
        8 -> R.string.artwork_9_content_description
        9 -> R.string.artwork_10_content_description
        else -> R.string.artwork_1_content_description
    }
}

@Preview
@Composable
fun PhotoGalleryAppPreview() {
    PhotoGalleryApp()
}