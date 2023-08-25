package com.myapplication

import MainView
import WechatLib
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WechatLib.register(this, "wxdab815a00288fddd")

        setContent {
            MainView()
        }
    }
}