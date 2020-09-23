package com.alexxer.crud.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    var readAllData: LiveData<List<User>> = userDao.readAllUserData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}