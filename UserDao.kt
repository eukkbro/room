package abled.tstory.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao{

    @Query("SELECT * FROM user")
    fun getAll() : List<User>
    @Insert
    fun insertAll(vararg users: User)

}