package com.example.clean_architecture.domain.usecases

import com.example.clean_architecture.domain.models.UserName
import com.example.clean_architecture.domain.repository.UserRepository

class GetUserNameUseCase(private val repository: UserRepository)  {

    fun execute() : UserName {
        return repository.getName()
    }
}