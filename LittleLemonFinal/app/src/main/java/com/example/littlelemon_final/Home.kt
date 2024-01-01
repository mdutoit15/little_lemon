package com.example.littlelemon_final

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Scaffold(topBar = {
            TopAppBar(navController)
        }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ){
                Column {
                    HeroScreen()
                    MenuBar()
                }
            }
        }
    }
}
@Composable
fun TopAppBar(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth(.32f)
                .align(Alignment.Center)
        )

        IconButton(
            onClick = {
                navController.navigate(Profile.route)
            },
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(.22f)
                .align(Alignment.CenterEnd)
                .padding(start = 5.dp, top = 5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Menu Icon"
            )
        }
    }
}


@Composable
fun HeroScreen() {
    val darkGreen = Color(0xFF495E57)

    Column(
        modifier = Modifier
            .height(320.dp)
            .fillMaxSize()
            .background(color = darkGreen)
            .padding(
                start = 25.dp,
                top = 10.dp,
            )
    ) {
        Column {
            Text(
                text = "Little Lemon",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFF4CE14),
                    fontFamily = FontFamily(
                        Font(R.font.markazitext_regular)
                    )
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Column()
                {
                    Text(
                        text = "Chicago",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFFFFFFF),
                            fontFamily = FontFamily(Font(R.font.markazitext_regular))
                        )
                    )

                    Text(
                        text = "We are a family owned Mediterranean restaurant, " +
                                "focused on traditional recipes " +
                                "served with a modern twist.",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.karla_regular)),
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFFFFFFF),
                        ),
                        modifier = Modifier
                            .width(190.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "Hero Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(130.dp)
                        .height(155.dp)
                        .padding(start = 10.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFF4CE14),
                        )
                )
            }

            val searchPhrase = remember {
                mutableStateOf(TextFieldValue(""))
            }

            TextField(
                value = searchPhrase.value,
                onValueChange = { searchPhrase.value = it },
                placeholder = {
                    Text(
                        text = "Search"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                },
                modifier = Modifier
                    .height(70.dp)
                    .width(340.dp)
                    .padding(top = 20.dp, start = 5.dp, end = 5.dp)
            )
        }
    }
}

@Composable
fun MenuBar() {
    val scrollState = rememberScrollState()

    val menuDatabase : List<MenuItemNetwork>

    Column {
        Text(
            text = "Order for Delivery:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    start = 10.dp
                )
        )
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {},

                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFD9D9D9)
                ),

                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )

            ) {
                Text(
                    text = "Starters"
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFD9D9D9)
                ),
                modifier = Modifier
                    .padding(
                        end = 10.dp
                    )
            ) {
                Text(
                    text = "Mains"
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFD9D9D9)
                ),
                modifier = Modifier
                    .padding(
                        end = 10.dp
                    )
            ) {
                Text(
                    text = "Desserts"
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFD9D9D9)
                ),
                modifier = Modifier
                    .padding(
                        end = 10.dp
                    )
            ) {
                Text(
                    text = "Sides"
                )
            }
        }
    }
}

