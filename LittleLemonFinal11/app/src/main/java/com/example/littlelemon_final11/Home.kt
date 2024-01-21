package com.example.littlelemon_final11

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Scaffold(topBar = {
            TopAppBar(navController)
        }) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .padding(it)
            ){
                Column {
                    HeroScreen()
                    MenuBar()
                    MenuCard()
                }
            }
        }
    }
}

@Composable
fun TopAppBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_2),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxHeight(0.6f)
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
            .fillMaxHeight(0.47f)
            .background(color = darkGreen)
            .padding(15.dp)
    ) {
        Column {
            Row {
                Column {


                    Text(
                        text = "Little Lemon",
                        style = TextStyle(
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF4CE14),
                            fontFamily = FontFamily(
                                Font(R.font.markazitext_regular)
                            )
                        )
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                    ) {
                        Text(
                            text = "City: Chicago",
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFFFFFFFF),
                                fontFamily = FontFamily(
                                    Font(R.font.markazitext_regular)
                                )
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
                                .align(Alignment.Start)
                                .width(220.dp)
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(start = 30.dp, top = 30.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .border(
                            width = 3.dp,
                            color = Color(0xFF000000),
                        )
                )
            }

            var searchPhrase by remember {
                mutableStateOf("")
            }

            TextField(
                value = searchPhrase,
                onValueChange = {
                    searchPhrase = it
                },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                    .background(Color.White)
                    .height(50.dp)
            )
        }
    }
}

@Composable
fun MenuBar() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxHeight(0.3f)
    ) {
        Text(
            text = "Order for Delivery:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {},

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFAFAFAF)
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
                    containerColor = Color(0xFFAFAFAF)
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
                    containerColor = Color(0xFFAFAFAF)
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
                    containerColor = Color(0xFFAFAFAF)
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
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {

        Card(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(10.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(250.dp)
                    ) {
                        Text(
                            text = "Greek Salad",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
                            fontSize = 16.sp,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "$10.00",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.greek_salad),
                        contentDescription = "Greek Salad",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(10.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(250.dp)
                    ) {
                        Text(
                            text = "Lemon Desert",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Traditional homemade Italian Lemon Ricotta Cake.",
                            fontSize = 16.sp,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "$10.00",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.lemon_dessert),
                        contentDescription = "Lemon Desert",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(10.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(250.dp)
                    ) {
                        Text(
                            text = "Grilled Fish",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
                            fontSize = 16.sp,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "$10.00",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.grilled_fish),
                        contentDescription = "Grilled Fish",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(10.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(250.dp)
                    ) {
                        Text(
                            text = "Pasta",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chili, garlic, basil & salted ricotta cheese.",
                            fontSize = 16.sp,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "$10.00",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.pasta),
                        contentDescription = "Pasta",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(10.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(250.dp)
                    ) {
                        Text(
                            text = "Bruschetta",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Oven-baked bruschetta stuffed with tomatoes and herbs.",
                            fontSize = 16.sp,
                            maxLines = 2,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "$10.00",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.bruschetta),
                        contentDescription = "Bruschetta",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }
        }
    }
}