package com.alexxer.crud.repository

import androidx.lifecycle.LiveData
import com.alexxer.crud.data.UserDao
import com.alexxer.crud.model.User

class UserRepository(private val userDao: UserDao) {
    var readAllData: LiveData<List<User>> = userDao.readAllUserData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user:User){
        userDao.updateUser(user)
    }
}