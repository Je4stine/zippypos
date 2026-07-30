package com.jsoftware.zippypos.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){
    val categories = listOf(
        "All",
        "Popular",
        "Break fast",
        "Lunch",
        "Supper",
        "Sweet"
    )

    val items = listOf(
       "https://www.freepnglogos.com/uploads/food-png/fast-food-transparent-png-pictures-icons-and-png-17.png",
        "https://www.freepnglogos.com/uploads/food-png/fast-food-transparent-png-pictures-icons-and-png-18.png",
        "https://www.freepnglogos.com/uploads/food-png/food-grass-fed-beef-foodservice-products-grass-run-farms-4.png",
        "https://www.freepnglogos.com/uploads/food-png/food-home-nanoosh-20.png",
        "https://www.freepnglogos.com/uploads/food-png/food-plate-png-icons-and-png-backgrounds-33.png",
        "https://www.freepnglogos.com/uploads/food-png/food-png-transparent-images-png-only-5.png",
        "https://www.freepnglogos.com/uploads/food-png/food-traverso-restaurant-pizza-and-italian-cuisine-11.png",
        "https://www.freepnglogos.com/uploads/food-png/download-food-png-file-png-image-pngimg-1.png"
    )

    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFEAF7FB),
        topBar ={
            TopAppBar(
                title = {
                Text("Purchase Management", fontSize = 15.sp)
            },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}){
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                },


                )
        }
    ) { paddingValues ->
        Column() {
        LazyColumn(modifier = Modifier.padding(paddingValues).padding(vertical = 0.dp)) {
          item {
              OutlinedTextField(
                  onValueChange = {},
                  value = "",
                  placeholder = {
                      Text(
                          text = "Search items by name...",
                          fontSize = 14.sp
                      )
                  },
                  leadingIcon = {
                      Icon(Icons.Default.Search, contentDescription = "Search bar", modifier = Modifier.size(17.dp))
                  },
                  trailingIcon = {
                      IconButton(onClick = {}) {
                          Icon(Icons.Default.DocumentScanner, contentDescription = "scan", Modifier.size(17.dp))
                      }
                  },
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(horizontal = 20.dp, vertical = 10.dp)
                      .height(50.dp)
                      .clip(RoundedCornerShape(40.dp))
                      .background(Color.White),
                  shape = RoundedCornerShape(40.dp),
              )
          }

            item {
                LazyRow( modifier = Modifier.padding(vertical = 20.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                    .background(Color.White)
                ) {
                    items(categories.size) { category ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                            .width(80.dp)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFEAF7FB))

                        ){
                            Text(text = categories[category], fontSize = 12.sp, modifier = Modifier.padding(5.dp))
                        }
                    }
                }
            }

        }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(items.size) {item ->
                    ProductCard(imageUrl = items[item])
                }
            }
        }
    }
}

///TO DO. CHANGE LAYOUT TO LAZY GRID WITH SPANS