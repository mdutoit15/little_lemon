package com.example.littlelemon

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
            )
            Column {
                HeroScreen()
                MenuBar()
                MenuCard()
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
                .align(Alignment.CenterEnd)
                .height(60.dp)
                .padding(top = 5.dp, bottom = 5.dp, end = 10.dp)
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
    val searchBar = remember {
        mutableStateOf(TextFieldValue(""))
    }
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
        }
        TextField(
            value = searchBar.value,
            onValueChange = { searchBar.value = it },
            label = {
                Text(
                    text = "Search",
                    color = Color.White
                )
            },
            modifier = Modifier
                .height(70.dp)
                .width(340.dp)
                .padding(
                    top = 20.dp,
                    start = 5.dp,
                    end = 5.dp
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 16.dp)
                )
        )
    }
}

@Composable
fun MenuBar() {
    val scrollState = rememberScrollState()

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
                onClick = { /*TODO*/ },

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFD9D9D9)
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
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFD9D9D9)
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
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFD9D9D9)
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
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFD9D9D9)
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

@Composable
fun MenuCard() {
    Column(
        modifier = Modifier
            .width(380.dp)
            .padding(10.dp)
    ) {
        Text(
            text = "Main Title",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.karla_regular)),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            ),
            modifier = Modifier
                .width(240.dp)
        )
        Row {
            Column {
                Text(
                    text = "Description",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.karla_regular)),
                        fontSize = 15.sp
                    ),
                    modifier = Modifier
                        .width(260.dp)
                )
                Text(
                    text = "Price",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.karla_regular)),
                        fontSize = 15.sp
                    ),
                    modifier = Modifier
                        .width(260.dp)
                )
            }

            Image(
                painter = painterResource(R.drawable.bruschetta),
                contentDescription = "Dish Image",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}