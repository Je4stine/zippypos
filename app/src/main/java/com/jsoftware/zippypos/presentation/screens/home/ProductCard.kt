package com.jsoftware.zippypos.presentation.screens.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.toBitmap

private val DefaultProductCardColor = Color(0xFFF6F4EF)
@Composable
fun ProductCard(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var extractedCardColor by remember(imageUrl) {
        mutableStateOf(DefaultProductCardColor)
    }

    val animatedCardColor by animateColorAsState(
        targetValue = extractedCardColor,
        label = "cardBackgroundColor"
    )

    val imageRequest = remember(imageUrl) {
        ImageRequest.Builder(context)
            .data(imageUrl)
            .allowHardware(false)
            .build()
    }

    Card(
        modifier = modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
            pressedElevation = 8.dp,
            focusedElevation = 6.dp,
            hoveredElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = animatedCardColor
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(190.dp)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = "Food",
                  fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$12.50",
                )
            }

            AsyncImage(
                model = imageRequest,
                contentDescription = "Product image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(110.dp)
                    .align(Alignment.BottomEnd),
                onSuccess = { success ->
                    val bitmap = success.result.image.toBitmap()

                    Palette.from(bitmap)
                        .maximumColorCount(16)
                        .generate { palette ->

                            val selectedSwatch = palette
                                ?.swatches
                                ?.asSequence()
                                ?.filter { swatch ->
                                    val saturation = swatch.hsl[1]
                                    val lightness = swatch.hsl[2]

                                    saturation > 0.15f &&
                                            lightness in 0.15f..0.92f
                                }
                                ?.maxByOrNull { swatch ->
                                    swatch.population *
                                            (0.5f + swatch.hsl[1])
                                }

                            val extractedColor = selectedSwatch
                                ?.rgb
                                ?.let(::Color)

                            extractedCardColor =
                                if (extractedColor != null) {
                                    lerp(
                                        start = extractedColor,
                                        stop = Color.White,
                                        fraction = 0.82f
                                    )
                                } else {
                                    DefaultProductCardColor
                                }
                        }
                }
            )
        }
    }
}