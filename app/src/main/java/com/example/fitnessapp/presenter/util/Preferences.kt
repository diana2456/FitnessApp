package com.example.fitnessapp.presenter.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Preferences(val context :Context) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences("preferences", MODE_PRIVATE)
    fun getImageUri(): String {
        return sharedPref.getString("img", "").toString()
    }

    fun saveImageUri(ImgUri: String) {
        return sharedPref.edit().putString("img", ImgUri).apply()
    }
}