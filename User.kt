package abled.tstory.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val num: Int,
    @ColumnInfo(name = "first_name") val first_name: String?,
    @ColumnInfo(name = "second_name") val second_name: String?
)
