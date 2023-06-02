package com.example.fitnessapp.presenter.ui.amount_of_exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentAmountOfExerciseBinding


class AmountOfExerciseFragment : Fragment() {

    private lateinit var binding: FragmentAmountOfExerciseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAmountOfExerciseBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.btnReady.setOnClickListener {
            findNavController().navigate(R.id.completeFragment)
        }
    }

}