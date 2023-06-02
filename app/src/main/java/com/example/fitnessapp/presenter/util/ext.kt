package com.example.fitnessapp.presenter.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.fitnessapp.R

fun ImageView.loadImage(image : String){
    Glide.with(this).load(image).placeholder(R.drawable.ic_profile).into(this)
}

