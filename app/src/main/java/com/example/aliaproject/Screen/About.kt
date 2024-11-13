@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.aliaproject.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aliaproject.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun About() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xffffffff)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF7FA1C3), CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            AboutInfo(label = "Nama", info = "Alia Pramestia Nurdenia")
            Spacer(modifier = Modifier.height(8.dp))
            AboutInfo(label = "Email", info = "alialily782@gmail.com")
            Spacer(modifier = Modifier.height(8.dp))
            AboutInfo(label = "Kampus", info = "Politeknik Negeri Batam")
            Spacer(modifier = Modifier.height(8.dp))
            AboutInfo(label = "Jurusan", info = "Teknik Informatika")

        }
    }
}

@Composable
fun AboutInfo(label: String, info: String) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color (0xFFF0F0F0)
    ){
        Column (
            modifier = Modifier
                .padding(12.dp)
        ){
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = info,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
