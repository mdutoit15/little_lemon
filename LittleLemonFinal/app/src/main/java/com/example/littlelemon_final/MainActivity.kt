package com.example.littlelemon_final

import android.content.SharedPreferences
import android.net.http.HttpResponseCache.install
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon_final.ui.theme.LittleLemonFinalTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.contentnegotiation.JsonContentTypeMatcher
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences("Little Lemon", MODE_PRIVATE)
    }

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database"
        ).build()
    }

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            Json
        }
    }

    private suspend fun fetchMenuData() : List<MenuItemNetwork> {
        return httpClient
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body<MenuNetworkData>()
            .menu
    }

    private fun saveMenuToData(menuItemNetwork: List<MenuItemNetwork>) {
        val menuItemRoom = menuItemNetwork.map { it.menuRoom() }
        database.menuDao().insertAll(*menuItemRoom.toTypedArray())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonFinalTheme {
                val databaseMenu by database
                    .menuDao()
                    .getAll()
                    .observeAsState(emptyList())

                Column {
                    App(sharedPreferences)
                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuDao().isEmpty()) {
                val menuNetwork = fetchMenuData()
                saveMenuToData(menuNetwork)
            }
        }
    }
}

@Composable
fun App(sharedPreferences: SharedPreferences) {
    Column {
        Navigation(sharedPreferences)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItems(menuItem : MenuItemNetwork) {
    Column(
        modifier = Modifier
            .padding(3.dp)
            .height(120.dp)
    ) {
        Text(
            text = menuItem.title,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.karla_regular)),
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(3.dp)
        )
        Row(
            modifier = Modifier
                .height(70.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(250.dp)
            ) {
                Text(
                    text = menuItem.description,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.karla_regular)),
                    ),
                    modifier = Modifier
                        .padding(2.dp)
                        .height(35.dp)
                )
                Text(
                    text = "$ ${menuItem.price}",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.karla_regular)),
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            GlideImage(
                model = menuItem.image,
                contentDescription = "Image",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(100.dp)
                    .height(100.dp),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
fun SearchBar() {

}