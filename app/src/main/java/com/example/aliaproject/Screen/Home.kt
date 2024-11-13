package com.example.aliaproject.Screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aliaproject.R
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip

@Composable
fun Home(context: Context, navController: NavController) {
    val items = listOf(
        Pair(R.drawable.item1, "Pizza"),
        Pair(R.drawable.item2, "Hamburger"),
        Pair(R.drawable.item3, "Tempura"),
        Pair(R.drawable.item4, "Sandwich"),
        Pair(R.drawable.item5, "Kentang Goreng"),
        Pair(R.drawable.item6, "HotDog"),
        Pair(R.drawable.item7, "Popcorn"),
        Pair(R.drawable.item8, "Mie Goreng"),
        Pair(R.drawable.item9, "Cupcake"),
        Pair(R.drawable.item10, "Keju"),
        Pair(R.drawable.item11, "Donut"),
        Pair(R.drawable.item12, "Teh Boba")
    )

    var searchQuery by remember { mutableStateOf("") }

    val filteredItems = items.filter { it.second.contains(searchQuery, ignoreCase = true) }

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50)),
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    backgroundColor = Color.Transparent
                ),
                singleLine = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon",
                        tint = Color.Black
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(0.5.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            items(filteredItems.size) { index ->
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(150.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("detail/${filteredItems[index].second}")
                        },
                    elevation = 5.dp,
                    backgroundColor = Color(0xFFC5D3E8)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Gambar di kiri
                        Image(
                            painter = painterResource(id = filteredItems[index].first),
                            contentDescription = filteredItems[index].second,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                                .padding(end = 16.dp)
                        )
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = filteredItems[index].second,
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Kamu ingin mencoba ${filteredItems[index].second}?",
                                fontSize = 14.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(0.5.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            items(filteredItems.size) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("detail/${filteredItems[index].second}")
                        },
                    elevation = 5.dp,
                    backgroundColor = Color(0xFFC5D3E8)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = filteredItems[index].first),
                            contentDescription = filteredItems[index].second,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                                .padding(end = 16.dp)
                        )
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = filteredItems[index].second,
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Text(
                                text = "Kamu lapar? Ayo beli ${filteredItems[index].second} dengan harga yang terjangkau " +
                                        "dijamin pasti kamu pasti suka.",
                                fontSize = 14.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
