package com.example.littlelemon_final11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.littlelemon_final11.ui.theme.LittleLemonFinal11Theme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    private suspend fun fetchMenuData(): List<MenuItemNetwork> {
        return httpClient
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body<MenuNetworkData>()
            .menu
    }

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppData::class.java,
            "FinalLittleLemonData"
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val menuItems by database
                .menuDao()
                .getAllItems()
                .observeAsState()

            LaunchedEffect(menuItems) {
                try {
                    val menuData = fetchMenuData()
                    saveMenuData(menuData)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            LittleLemonFinal11Theme {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight(1f)
                ) {
                    Column {
                        Navigation()
                    }
                }
            }
        }
    }

    private fun saveMenuData(menu: List<MenuItemNetwork>) {
        val menuRoom : List<MenuItemRoom> = menu.map { it.toMenuRoom() }
        database.menuDao().insertAllItems(*menuRoom.toTypedArray())

    }
}