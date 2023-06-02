package com.example.fitnessapp.presenter.ui.music

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentMusicBinding
import com.example.fitnessapp.presenter.ui.music.AdapterMusic
import com.example.fitnessapp.presenter.ui.music.Music


class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding
    private val adapterMusic = AdapterMusic(this::onClick)
    private val list = arrayListOf<Music>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.rv.adapter = adapterMusic
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        list.add(Music("Звуки природы","Звуки природы",R.drawable.nature))
        adapterMusic.addTask(list)
    }

    private fun onClick(pos: Int) {
        findNavController().navigate(R.id.navigation_workout)
    }

}