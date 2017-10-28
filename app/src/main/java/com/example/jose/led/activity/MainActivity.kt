package com.example.jose.led.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.jose.led.R
import com.example.jose.led.util.WebClient
import com.squareup.okhttp.OkHttpClient

class MainActivity : AppCompatActivity() {

    lateinit var btnTurnOn: Button
    lateinit var httpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initElements()

        btnTurnOn.setOnClickListener {
            val webClient = WebClient()
            webClient.doPostRequest("1")
        }
    }

    fun initElements() {
        btnTurnOn = findViewById(R.id.btnTurnOn)
        httpClient = OkHttpClient()
    }

}
