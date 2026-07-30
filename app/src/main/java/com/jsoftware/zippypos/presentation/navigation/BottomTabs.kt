package com.jsoftware.zippypos.presentation.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.jsoftware.zippypos.presentation.screens.activity.Activity
import com.jsoftware.zippypos.presentation.screens.home.Home
import com.jsoftware.zippypos.presentation.screens.inventory.Inventory
import com.jsoftware.zippypos.presentation.screens.profile.Profile

@Composable
fun BottomTabs(){
    val tabBackStack = rememberNavBackStack(Screens.Home)
    val currentTab = tabBackStack.lastOrNull()

    fun selectTab(screen: Screens) {
        if (currentTab != screen) {
            tabBackStack.clear()
            tabBackStack.add(screen)
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            NavigationBar{
                NavigationBarItem(
                    selected = currentTab == Screens.Home,
                    onClick = {selectTab(Screens.Home) },
                    icon = { Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home"
                    )},
                    label = {Text("Home")}
                )

                NavigationBarItem(
                    selected = currentTab == Screens.Activity,
                    onClick = {selectTab(Screens.Activity) },
                    icon = { Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Activity"
                    )},
                    label = {Text("Activity")}
                )

                NavigationBarItem(
                    selected = currentTab == Screens.Inventory,
                    onClick = {selectTab(Screens.Inventory) },
                    icon = { Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Inventory"
                    )},
                    label = {Text("Inventory")}
                )

                NavigationBarItem(
                    selected = currentTab == Screens.Profile,
                    onClick = {selectTab(Screens.Profile) },
                    icon = { Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile"
                    )},
                    label = {Text("Profile")}
                )
            }

        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = tabBackStack,
            onBack = {
                    if (tabBackStack.size > 1) {
                        tabBackStack.removeLastOrNull()
                    }
            },
            entryProvider = entryProvider {
                entry<Screens.Home> {
                    Home()
                }
                entry<Screens.Activity> {
                    Activity()
                }
                entry<Screens.Inventory> {
                    Inventory()
                }
                entry<Screens.Profile> {
                    Profile()
                }

            }
        )


    }
}