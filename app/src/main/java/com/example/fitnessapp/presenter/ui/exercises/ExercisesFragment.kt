package com.example.fitnessapp.presenter.ui.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentExercisesBinding



class ExercisesFragment : Fragment() {

    private lateinit var binding: FragmentExercisesBinding
    private val list = arrayListOf<Exercises>()
    private val adapterExercises = AdapterExercises()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentExercisesBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        list.add(Exercises("1. Разжимания кистей","Полезное упражнение для офисной гимнастики, которое разминает все мелкие суставы и связки кисти, улучшает кровообращение рук. Обязательно к выполнению для людей, работающих за компьютером.","Выполните 8-10 разжиманий всего.",R.drawable.gif))
        list.add(Exercises("2. Вращение локтей","Такие вращения хорошо разрабатывают локтевые суставы. Кроме того, это упражнение из офисной гимнастики укрепляет суставы и мышцы плеч, улучшается подвижность и мобильность рук.","Выполните 6-8 вращений назад, затем 6-8 вращений вперед.",R.drawable.gif))
        list.add(Exercises("3. Разжимания кистей","Полезное упражнение для офисной гимнастики, которое разминает все мелкие суставы и связки кисти, улучшает кровообращение рук. Обязательно к выполнению для людей, работающих за компьютером.","Выполните 8-10 разжиманий всего.",R.drawable.gif))
        binding.rv.adapter = adapterExercises
        adapterExercises.addTask(list)

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.restFragment)
        }
    }

}