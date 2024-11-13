package com.example.aliaproject.Screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.aliaproject.ui.theme.Button

@ExperimentalMaterial3Api
@Composable
fun List(context: Context, navController: NavController) {

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
        Pair(R.drawable.item11, "Donat"),
        Pair(R.drawable.item12, "Teh Boba")
    )
    var searchQuery by remember { mutableStateOf("") }

    val filteredItems = items.filter { it.second.contains(searchQuery, ignoreCase = true) }

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
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

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {

            items(items.size) { index ->

                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(285.dp)
                        .padding(10.dp)
                        .clickable {
                            Toast
                                .makeText(context, items[index].second, Toast.LENGTH_SHORT)
                                .show()
                        },
                    elevation = 5.dp,
                    backgroundColor = Color(0xFFC5D3E8)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = (painterResource(id = items[index].first)),
                            contentDescription = items[index].second,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                        )
                        Text(
                            text = items[index].second,
                            fontSize = 18.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                        Button(
                            onClick = {
                                navController.navigate("detail/${items[index].second}")
                            },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier.padding(top = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Button
                            )
                        ) {
                            Text(
                                text = "Lihat Detail",
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.W300
                            )
                        }
                    }
                }
            }
        }
    }
}