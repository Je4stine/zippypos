package com.jsoftware.zippypos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jsoftware.zippypos.presentation.navigation.AppNavigation
import com.jsoftware.zippypos.ui.theme.ZippyPOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZippyPOSTheme {

                    AppNavigation()
            }
            }
        }
    }


