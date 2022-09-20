package com.cowok.hijrah.chapter4topic4.login

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.cowok.hijrah.chapter4topic4.R
import com.cowok.hijrah.chapter4topic4.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
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
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefLogin = requireContext().getSharedPreferences(shareDataLogin, 0)
        sharedPrefRegis = requireContext().getSharedPreferences(shareDataRegis, 0)
        editorLogin = sharedPrefLogin.edit()

        binding.buttonLogin.setOnClickListener {
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            val userRegis = sharedPrefRegis.getString("username", "")
            val passRegis = sharedPrefRegis.getString("password", "")

            if (username == userRegis && password == passRegis){
                editorLogin.putString("username", username)
                editorLogin.putString("password", password)
                editorLogin.apply()

                Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
            } else if (username != userRegis || password != passRegis){
                Toast.makeText(context, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Data Tidak Ada", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}