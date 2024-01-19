package com.example.littlelemon_final11

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class MenuItemRoom(
    @PrimaryKey var id: Int,
    var title: String,
    var description: String,
    var price: Double,
    var image: String,
    var category: String
)

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuItemRoom")
    fun getAllItems(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAllItems(vararg menuItems: MenuItemRoom)

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class AppData : RoomDatabase() {
    abstract fun menuDao() : MenuDao
}