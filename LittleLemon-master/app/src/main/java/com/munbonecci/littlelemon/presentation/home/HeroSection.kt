package com.munbonecci.littlelemon.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.munbonecci.littlelemon.R

@Composable
fun HeroSection(onPhraseSelected: (String) -> Unit) {
    val darkGreen = Color(0xFF495E57)

    var searchPhrase by remember {
        mutableStateOf("")
    }

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
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFF4CE14),
                            fontFamily = FontFamily(
                                Font(R.font.markazi_text_regular)
                            )
                        ),
                        modifier = Modifier
                            .align(Alignment.Start)
                            .width(220.dp)
                    )

                    Divider(
                        thickness = 2.dp,
                        color = Color(0xFFEE9972),
                        modifier = Modifier
                            .align(Alignment.Start)
                            .width(220.dp)
                    )

                    Text(
                        text = "Chicago",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFFFFFFF),
                            fontFamily = FontFamily(
                                Font(R.font.markazi_text_regular)
                            )
                        ),
                        modifier = Modifier
                            .align(Alignment.Start)
                            .width(220.dp)
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

                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(
                            start = 30.dp,
                            top = 30.dp
                        )
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(
                            width = 2.dp,
                            color = Color(0xFFEE9972),
                        )
                )
            }
        }

        TextField(
            value = searchPhrase,
            onValueChange = {
                searchPhrase = it
            },
            label = { Text("Search") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    tint = Color.Black,
                    contentDescription = stringResource(R.string.search),
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .background(Color.White)
                .height(50.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFFEE9972),
                ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
            ),
        )
    }

    if (searchPhrase.isNotEmpty()) onPhraseSelected(searchPhrase)
}