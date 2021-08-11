package com.example.clean_architecture.domain.usecases

import com.example.clean_architecture.domain.models.UserName

class GetUserNameUseCase {

    fun execute() : UserName {
        return UserName(firstName = "Kiparo",lastName = "Hello")
    }
}