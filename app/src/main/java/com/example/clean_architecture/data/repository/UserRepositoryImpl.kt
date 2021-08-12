package com.example.clean_architecture.data.repository

import com.example.clean_architecture.data.storage.UserStorage
import com.example.clean_architecture.domain.models.SaveUserNameParam
import com.example.clean_architecture.domain.models.UserName
import com.example.clean_architecture.domain.repository.UserRepository

class UserRepositoryImpl(val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return userStorage.save(saveParam)
    }

    override fun getName(): UserName {
        return userStorage.get()
    }
}