package com.example.m_littlelemon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m_littlelemon.R
import com.example.m_littlelemon.ui.theme.Black
import com.example.m_littlelemon.ui.theme.DarkGreen
import com.example.m_littlelemon.ui.theme.DarkGrey
import com.example.m_littlelemon.ui.theme.DarkPink
import com.example.m_littlelemon.ui.theme.Green
import com.example.m_littlelemon.ui.theme.Grey
import com.example.m_littlelemon.ui.theme.Pink
import com.example.m_littlelemon.ui.theme.White
import com.example.m_littlelemon.ui.theme.Yellow

@Composable
fun Home() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo",
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 10.dp)
        )
        HeroSpace()
        OrderBar()
        MenuItems()
    }
}

@Composable
fun HeroSpace() {
    val searchbar = remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Black,
                        DarkGreen,
                        Green,
                        DarkGreen,
                        Black
                    )
                )
            )
    ) {
        Text(
            text = "Little Lemon",
            color = Yellow,
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
        )

        Divider(
            thickness = 2.dp,
            color = DarkGreen,
            modifier = Modifier
                .width(200.dp)
                .padding(start = 10.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Chicago",
                    color = Yellow,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
                Text(
                    text = "We are a family owned Mediterranean restaurant, " +
                            "focused on traditional recipes served with a modern twist.",
                    fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
                    fontSize = 20.sp,
                    color = White,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(start = 10.dp)
                        .align(AbsoluteAlignment.Left)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Hero Image",
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxHeight(0.7f)
                    .padding(start = 60.dp)
                    .border(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Yellow,
                                DarkPink
                            )
                        ),
                        shape = RoundedCornerShape(1.dp)
                    )
            )
        }
        TextField(
            value = searchbar.value,
            onValueChange = { searchbar.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = White
                )
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun OrderBar() {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
    ) {
        Text(
            text = "Order for Delivery:",
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(10.dp)
        )

        Row {
            Card(
                backgroundColor = Pink,
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Starter",
                    color = Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
        Divider(
            thickness = 1.dp,
            color = Grey,
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

@Composable
fun MenuItems() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Text(text = "Main Title")
                Row {
                    Column {
                        Text(text = "Price")
                        Text(text = "Dish Discription")
                    }
                    Image(painter = painterResource(
                        id = R.drawable.logo_intro),
                        contentDescription = "Dish Image"
                    )
                }
            }
        }
    }
}