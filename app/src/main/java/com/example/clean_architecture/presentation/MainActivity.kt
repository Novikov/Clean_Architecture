package com.example.clean_architecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.clean_architecture.R
import com.example.clean_architecture.domain.models.SaveUserNameParam
import com.example.clean_architecture.domain.usecases.GetUserNameUseCase
import com.example.clean_architecture.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            //Клик по кнопке Save data
            val text = dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            //Клик по кнопке Get data
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}