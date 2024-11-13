@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.aliaproject.Screen

import android.icu.text.NumberFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aliaproject.R
import java.util.Locale

data class MenuItem(
    val name: String,
    val imageId: Int,
    val description: String,
    val price: Double
)

fun Harga(price: Double): String{
    val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    return format.format(price)
}

val menuItems = listOf(
    MenuItem("Pizza", R.drawable.pizza, "Pizza adalah makanan yang berasal dari Italia " +
            "yang terdiri dari roti pipih yang diberi topping dan dipanggang", 50000.0),
    MenuItem("Hamburger", R.drawable.hamburger, "Hamburger adalah makanan yang terdiri dari " +
            "roti lapis berisi patty daging giling yang dimasak, dan biasanya disajikan dengan " +
            "sayur-sayuran dan saus", 30000.0),
    MenuItem("Tempura", R.drawable.tempura, "Tempura adalah makanan khas Jepang yang terbuat " +
            "dari berbagai jenis bahan seperti sayuran, makanan laut, atau sushi yang dibalut tepung " +
            "dan digoreng", 55000.0),
    MenuItem("Sandwich", R.drawable.sandwich, "Sandwich atau roti lapis adalah makanan yang terdiri " +
            "dari dua atau lebih irisan roti yang diisi dengan berbagai macam isian.", 25000.0),
    MenuItem("Kentang Goreng", R.drawable.kentang, "Kentang goreng adalah makanan ringan yang " +
            "terbuat dari potongan kentang yang digoreng dalam minyak goreng panas.", 45000.0),
    MenuItem("HotDog", R.drawable.hotdog, "Hot dog adalah suatu jenis sosis yang dimasak atau " +
            "diasapi dan memiliki tekstur yang lebih halus serta rasa yang lebih lembut dan basah ", 10000.0),
    MenuItem("Popcorn", R.drawable.popcorn, "Popcorn adalah makanan ringan yang terbuat dari " +
            "biji jagung yang dipanaskan hingga mengembang dan meletup.", 23000.0),
    MenuItem("Mie Goreng", R.drawable.mie, "Mie adalah produk makanan yang terbuat dari tepung" +
            "terigu atau tepung gandum, dengan atau tanpa penambahan bahan-bahan lain", 15000.0),
    MenuItem("Cupcake", R.drawable.cupcake, "Cupcake adalah kue panggang kecil yang manis dengan " +
            "lapisan gula di atasnya.", 5000.0),
    MenuItem("Keju", R.drawable.keju, "Keju merupakan produk olahan susu yang dibuat dengan " +
            "cara mengentalkan susu, sehingga zat-zat padat di dalamnya terpisah.", 25000.0),
    MenuItem("Donat", R.drawable.donat, "Donat adalah makanan ringan berbentuk cincin yang " +
            "digoreng dan terbuat dari adonan tepung terigu, ragi, gula, telur, dan mentega.", 25000.0),
    MenuItem("Teh Boba", R.drawable.milktea, "Milk tea adalah minuman yang merupakan campuran " +
            "teh dan susu dengan komposisi tertentu", 25000.0)
)

@Composable
fun Detail(itemName: String, navController: NavController) {

    val item = menuItems.find { it.name == itemName }

    if (item!= null){

        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(text = item.name,
                        fontFamily = FontFamily.Serif,
                        fontSize = 20.sp) },
                    navigationIcon = {
                        IconButton(onClick = {navController.popBackStack()}) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrowleft),
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column (modifier = Modifier.padding(innerPadding)){
                Image(
                    painter = painterResource(id = item.imageId),
                    contentDescription = item.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(16.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = item.description,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Text(
                    text = "Harga: ${Harga(item.price)}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }else {
        Text(
            text = "Item tidak ditemukan",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewDetail() {
    val navController = rememberNavController()
    Detail(itemName = "Pizza", navController = navController)
}