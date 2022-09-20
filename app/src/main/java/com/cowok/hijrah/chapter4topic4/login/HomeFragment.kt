package com.cowok.hijrah.chapter4topic4.login

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.cowok.hijrah.chapter4topic4.R
import com.cowok.hijrah.chapter4topic4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var sharedPrefRegis: SharedPreferences
    lateinit var sharedPrefLogin: SharedPreferences
    lateinit var editorLogin: SharedPreferences.Editor
    val shareDataRegis = "dataRegister"
    val shareDataLogin = "dataLogin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefRegis = requireContext().getSharedPreferences(shareDataRegis, MODE_PRIVATE)
        sharedPrefLogin = requireContext().getSharedPreferences(shareDataLogin, MODE_PRIVATE)
        editorLogin = sharedPrefLogin.edit()

        val fullname = sharedPrefRegis.getString("full", "")
        binding.textHello.text = "Selamat Datang, $fullname"

        binding.buttonLogout.setOnClickListener {
            editorLogin.clear()
            editorLogin.apply()

            Toast.makeText(context, "Anda Berhasil Logout", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

}