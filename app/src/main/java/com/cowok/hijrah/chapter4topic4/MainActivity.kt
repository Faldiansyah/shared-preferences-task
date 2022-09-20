package com.cowok.hijrah.chapter4topic4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cowok.hijrah.chapter4topic4.databinding.ActivityMainBinding
import com.cowok.hijrah.chapter4topic4.login.LoginActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("STUDENT", Context.MODE_PRIVATE)

        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
        }

        binding.btnView.setOnClickListener {
            viewData()
        }

        binding.btnClear.setOnClickListener {
            clearData()
        }

        binding.buttonToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.buttonToLatihan.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

    }

    fun saveData(){
        var getNim = binding.etInputNim.text.toString()
        var getName = binding.etInputName.text.toString()

        var addData = sharedPrefs.edit()
        addData.putString("nim", getNim)
        addData.putString("name", getName)
        addData.apply()
    }

    fun viewData(){
        binding.tvShowId.text = sharedPrefs.getString("nim", "")
        binding.tvShowName.text = sharedPrefs.getString("name", "")
    }

    fun clearData(){
        var pref = sharedPrefs.edit()
        pref.clear()
        pref.apply()
        binding.tvShowId.text = ""
        binding.tvShowName.text = ""
        binding.etInputNim.text.clear()
        binding.etInputName.text.clear()
    }
}