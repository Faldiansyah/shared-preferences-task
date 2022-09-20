package com.cowok.hijrah.chapter4topic4.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.cowok.hijrah.chapter4topic4.R
import com.cowok.hijrah.chapter4topic4.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding
    lateinit var sharedPref: SharedPreferences
    val shareDataLogin = "dataLogin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireContext().getSharedPreferences(shareDataLogin, Context.MODE_PRIVATE)

        Handler().postDelayed({
            Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment)
        }, 2000)
    }

}