package com.jsoftware.zippypos.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(){
    Scaffold( modifier = Modifier.padding()) { paddingValues ->
        Text("Home", modifier = Modifier.padding(paddingValues))
    }
}