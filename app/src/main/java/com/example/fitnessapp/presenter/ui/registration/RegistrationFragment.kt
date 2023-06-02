package com.example.fitnessapp.presenter.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(LayoutInflater.from(context),container,false)
        initView()
        return  binding.root
    }

    private fun initView() {
        binding.btnFurther.setOnClickListener {
            findNavController().navigate(R.id.navigation_profile)
        }
    }

}