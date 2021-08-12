package com.example.clean_architecture.data.storage

import com.example.clean_architecture.domain.models.SaveUserNameParam
import com.example.clean_architecture.domain.models.UserName

interface UserStorage {
    fun save(saveParam: SaveUserNameParam): Boolean
    fun get(): UserName
}