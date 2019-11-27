package com.krivosheev.mikhail.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.btnClick
import kotlinx.android.synthetic.main.activity_main.textViewHello

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener {
            textViewHello.text = "NEW TEXT"
        }
    }


    override fun onPostResume() {
        super.onPostResume()
        textViewHello.text = "HelloPostResume"
    }
}
