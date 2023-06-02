package com.example.fitnessapp.presenter.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_workout, R.id.navigation_profile, R.id.registrationFragment
            )
        )

        navController.navigate(R.id.navigation_workout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        var list = listOf(
            R.id.registrationFragment,
            R.id.exercisesFragment,
            R.id.musicFragment,
            R.id.completeFragment,
            R.id.restFragment,
            R.id.amountOfExerciseFragment
        )
    }

}

