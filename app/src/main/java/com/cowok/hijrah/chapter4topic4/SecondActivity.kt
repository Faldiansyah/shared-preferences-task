package com.cowok.hijrah.chapter4topic4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cowok.hijrah.chapter4topic4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = this.getSharedPreferences("USERNAME", Context.MODE_PRIVATE)

        var getData = sp.getString("username", "")
        binding.textView.setText(getData)

    }
}