package com.example.littlelemon_final11

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.littlelemon_final11.ui.theme.LittleLemonFinal11Theme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }

    private val menuItemsLiveData = MutableLiveData<List<MenuItemNetwork>>()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonFinal11Theme {
                Column {
                    Navigation()
                    val items = menuItemsLiveData.observeAsState(emptyList())
                    LazyMenu(items.value)
                }
            }
        }
    }

    private suspend fun fetchMenuData(): List<MenuItemNetwork> {
        val response =
            httpClient
                .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")

        return response.body<MenuNetworkData>().menu
    }

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppData::class.java,
            "Final Little Lemon"
        ).build()
    }

    private suspend fun saveMenuData(menu : List<MenuItemNetwork>) {
        val menuRoom = menu.map { it.toMenuRoom() }
        withContext(Dispatchers.IO) {
            database.menuDao().insertAllItems(*menuRoom.toTypedArray())
        }
    }
}