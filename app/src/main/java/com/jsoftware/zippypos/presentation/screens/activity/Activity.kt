package com.jsoftware.zippypos.presentation.screens.activity

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Activity (){
    Scaffold() { paddingValues ->
        Text("Activity Page", modifier = Modifier.padding(paddingValues))
    }
}