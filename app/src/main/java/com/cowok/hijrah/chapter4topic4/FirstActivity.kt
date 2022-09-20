package com.cowok.hijrah.chapter4topic4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cowok.hijrah.chapter4topic4.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    lateinit var binding: ActivityFirstBinding
    lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shared = getSharedPreferences("USERNAME", Context.MODE_PRIVATE)

        binding.buttonSend.setOnClickListener {
            val user = binding.username.text.toString()
            val addUser = shared.edit()

            addUser.putString("username", user)
            addUser.apply()
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }
}