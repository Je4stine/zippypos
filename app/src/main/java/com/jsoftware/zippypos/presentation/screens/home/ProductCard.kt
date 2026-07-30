package com.jsoftware.zippypos.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ProductCard(imageUrl: String){
    Card(
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            AsyncImage(model = imageUrl,
                contentDescription = "Product image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text("Food")
        }
    }

}