package com.example.littlelemon_final11

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon_final11.CategoryNames.DEFAULT_CATEGORY
import com.example.littlelemon_final11.CategoryNames.DESSERTS_CATEGORY
import com.example.littlelemon_final11.CategoryNames.MAINS_CATEGORY
import com.example.littlelemon_final11.CategoryNames.SALADS_CATEGORY
import com.example.littlelemon_final11.CategoryNames.STARTERS_CATEGORY

@Composable
fun HomeScreen(navController: NavController) {

    val context = LocalContext.current

    val database by lazy {
        Room.databaseBuilder(
            context.applicationContext,
            AppData::class.java, "LittleLemonDatabase"
        ).build()
    }

    val databaseMenuItems by database
        .menuDao()
        .getAllItems().
        observeAsState(emptyList())

    val orderMenuItems by remember {
        mutableStateOf(false)
    }

    val searchPhrase by remember {
        mutableStateOf("")
    }

    var categorySelected by remember {
        mutableStateOf("")
    }

    var menuItem =
        if (orderMenuItems) databaseMenuItems
            .sortedBy {
                it.title
            } else databaseMenuItems


    Column {
        Scaffold(topBar = {
            TopAppBar(navController)
        }) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .padding(it)
            ){
                item {
                    HeroScreen(selectPhrase = { category ->
                        categorySelected = category
                    })

                    MenuBar(onItemClick = { category ->
                        categorySelected = category
                    })
                }

                if (searchPhrase.isNotEmpty()) {
                    menuItem = databaseMenuItems.filter {
                        it.title.contains(
                            searchPhrase,
                            ignoreCase = true
                        )
                    }
                }

                if (categorySelected.isNotEmpty()) {
                    menuItem = if (categorySelected == DEFAULT_CATEGORY) {
                        databaseMenuItems.sortedBy { it.id }
                    } else {
                        databaseMenuItems.filter {
                            it.category.contains(
                                categorySelected,
                                ignoreCase = true
                            )
                        }
                    }
                }

                this@LazyColumn.menuCard(menuItem = menuItem)
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
fun HeroScreen(selectPhrase: (String) -> Unit) {
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
    if (searchPhrase.isNotEmpty())
        selectPhrase(searchPhrase)
}

@Composable
fun MenuBar(onItemClick: (String) -> Unit) {
    val category = listOf(
        STARTERS_CATEGORY, MAINS_CATEGORY, DESSERTS_CATEGORY, SALADS_CATEGORY
    )

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "Order for Delivery:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    bottom = 10.dp
                )
        )
        LazyRow {
            items(category) {categories ->
                Card(
                    modifier = Modifier
                        .clickable { onItemClick(categories) }
                        .padding(
                            start = 10.dp,
                            end = 10.dp
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFEDEFEE)
                    ),
                ) {
                    Text(
                        text = categories,
                        textAlign = TextAlign.Center,
                        color = Color(0xFFAFAFAF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
fun LazyListScope.menuCard(menuItem: List<MenuItemRoom>) {
    items(menuItem) { menu ->
        Column {
            Card(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .padding(10.dp),
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(250.dp)
                    ) {
                        Text(
                            text = menu.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = menu.description,
                            fontSize = 16.sp,
                            maxLines = 2,
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "%.2f".format(menu.price),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }
                    GlideImage(
                        model = menu.image,
                        contentDescription = "Greek Salad",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Divider(
                        color = Color(0xFFFBDABB),
                        thickness = 2.dp,
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                }
            }
        }
    }
}