package com.example.littlelemon_final11

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    var id: Int,
    @SerialName("title")
    var title: String,
    @SerialName("description")
    var description: String,
    @SerialName("price")
    var price: Double,
    @SerialName("image")
    var image: String,
    @SerialName("category")
    var category: String
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
class MenuNetworkData(
    @SerialName("menu")
    var menu: List<MenuItemNetwork>
)