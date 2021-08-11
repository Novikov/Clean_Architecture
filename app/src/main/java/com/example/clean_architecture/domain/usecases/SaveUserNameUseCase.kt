package com.example.clean_architecture.domain.usecases

import com.example.clean_architecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam) : Boolean{
        return param.name.isNotEmpty()
    }
}