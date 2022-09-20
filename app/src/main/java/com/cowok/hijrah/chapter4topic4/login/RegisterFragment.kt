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
import com.cowok.hijrah.chapter4topic4.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    val shareDataRegis = "dataRegister"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireContext().getSharedPreferences(shareDataRegis, MODE_PRIVATE)
        editor = sharedPref.edit()

        binding.buttonRegister.setOnClickListener {
            val username = binding.editUserRegis.text.toString()
            val fullname = binding.editFullname.text.toString()
            val password = binding.editPassRegis.text.toString()
            val repdPass = binding.editRepass.text.toString()

            if (username != "" && fullname != "" && password != "" && repdPass != ""){
                if (password == repdPass){
                    editor.putString("user", username)
                    editor.putString("full", fullname)
                    editor.putString("pass", password)
                    editor.apply()

                    Toast.makeText(context, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(context, "Konfirmasi Password Anda Salah", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Lengkapi Data Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            }

        }
    }

}