package io.folb.h_ng.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component

import io.folb.h_ng.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initEthree()
    }

//    private fun initEthree() {
//        val params = EThreeParams(identity = "folb", tokenCallback = )
//    }
}