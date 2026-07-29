package com.jsoftware.zippypos.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Screens: NavKey{
    @Serializable data object Home: Screens, NavKey
    @Serializable data object Activity: Screens, NavKey
    @Serializable data object Inventory: Screens, NavKey
    @Serializable data object Profile: Screens, NavKey
}

sealed interface RootNav: NavKey{
    @Serializable data object BottomTab: RootNav, NavKey
}