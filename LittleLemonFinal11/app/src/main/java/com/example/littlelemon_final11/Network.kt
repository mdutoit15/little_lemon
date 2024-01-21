package com.example.littlelemon_final11

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: String,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String
){
    fun toMenuRoom() = MenuItemRoom(
        id,
        title,
        description,
        price,
        image,
        category
    )
}

@Serializable
 data class MenuNetworkData(
    @SerialName("menu")
    val menu: List<MenuItemNetwork>
)