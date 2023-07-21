package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,NavigationDrawerActivity::class.java))
        },3000)

//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, NavigationDrawerActivity::class.java))
//            finish()
//        },3000)

    }
}