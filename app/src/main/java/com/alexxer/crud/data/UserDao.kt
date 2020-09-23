package com.alexxer.crud.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.alexxer.crud.model.User

@Dao
interface UserDao {

    @Update
    suspend fun updateUser(user:User)

    @Delete
    suspend fun deleteUser(user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllUserData():LiveData<List<User>>
}