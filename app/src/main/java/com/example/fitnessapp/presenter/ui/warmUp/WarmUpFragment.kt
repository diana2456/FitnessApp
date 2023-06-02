package com.example.fitnessapp.presenter.ui.warmUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentWarmUpBinding
import com.example.fitnessapp.presenter.ui.warmUp.Warm


class WarmUpFragment : Fragment() {

    private lateinit var binding : FragmentWarmUpBinding

    private val list = arrayListOf<Warm>()

    private val adapterWarm = AdapterWarm(this::onClick)

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWarmUpBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        list.add(Warm("Разминка для глаз", R.drawable.dfg))
        list.add(Warm("Разминка для шеи", R.drawable.dfg))
        list.add(Warm("Разминка для рук", R.drawable.dfg))
        list.add(Warm("Разминка для ног", R.drawable.dfg))
        list.add(Warm("Разминка для глаз", R.drawable.dfg))
        list.add(Warm("Разминка для шеи", R.drawable.dfg))
        list.add(Warm("Разминка для рук", R.drawable.dfg))
        list.add(Warm("Разминка для ног", R.drawable.dfg))
        list.add(Warm("Разминка для глаз", R.drawable.dfg))
        list.add(Warm("Разминка для шеи", R.drawable.dfg))
        list.add(Warm("Разминка для рук", R.drawable.dfg))
        list.add(Warm("Разминка для ног", R.drawable.dfg))
        binding.rvView.adapter = adapterWarm
        adapterWarm.addTask(list)
    }

    private fun onClick(pos: Int) {
        findNavController().navigate(R.id.exercisesFragment)
    }

}