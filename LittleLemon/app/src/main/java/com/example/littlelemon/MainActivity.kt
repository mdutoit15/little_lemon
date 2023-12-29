package com.example.littlelemon

import Navigation
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("Little Lemon", MODE_PRIVATE)
    }

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
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
            AppDataBase::class.java,
            "database"
        )
    }

    private val menuItemLiveData = MutableLiveData<List<MenuItemNetwork>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val databaseMenuItems by database
            .menuDao()
            .getAll()
            .observeAsState(emptyList())


        lifecycleScope.launch {
            val menuItems = fetchMenuData()

            runOnUiThread {
                menuItemLiveData.value = menuItems
            }
        }

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column {
                        AppScreen(sharedPreferences)
                    }
                }
            }
        }
    }

    @Composable
    fun AppScreen(
        sharedPreferences: SharedPreferences
    ) {
        Column {
            Navigation(sharedPreferences)
            val items = menuItemLiveData.observeAsState(emptyList())
            MenuItems(items.value)
        }

    }

    @Composable
    fun MenuItems(
        items: List<MenuItemNetwork> = emptyList()
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            LazyColumn {
                itemsIndexed(items) { _, item ->
                    MenuCard(item)
                }
            }
        }
    }
}