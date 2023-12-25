package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Image(
        painter = (painterResource(id = R.drawable.logo)),
        contentDescription = "Logo",
        modifier = Modifier
            .height(80.dp)
            .width(200.dp)
            .padding(5.dp)
    )
}