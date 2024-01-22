package com.munbonecci.littlelemon.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.munbonecci.littlelemon.R
import com.munbonecci.littlelemon.core.navigation.Profile

@Composable
fun HomeHeader(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .width(180.dp)
                .align(Alignment.Center)
        )

        IconButton(
            onClick = {
                navController.navigate(Profile.route)
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Menu Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(35.dp)
                    .height(35.dp)
                    .padding(end = 5.dp)
            )
        }
    }
}