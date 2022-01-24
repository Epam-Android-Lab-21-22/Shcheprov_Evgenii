package com.example.shcheprov_homeworks.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.shcheprov_homeworks.MainActivity

class LoadingScreenActivity : AppCompatActivity() {
    private val viewModel: LoadingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.initializeApp()
        viewModel.loadingStateLiveData.observe(this, {
            if (it.isInitialized) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}