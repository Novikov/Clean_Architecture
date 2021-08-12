package com.example.clean_architecture.data.repository

import com.example.clean_architecture.data.storage.models.User
import com.example.clean_architecture.data.storage.UserStorage
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository

class UserRepositoryImpl(val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    //Для трансформации одних моделей в другие удобно использовать методы-мапперы

    private fun mapToDomain(user: User) = UserName(user.firstName, user.lastName)

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        val user = User(firstName = saveParam.name, lastName = "")
        return user
    }
}