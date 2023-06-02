package com.example.fitnessapp.presenter.ui.anim


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.isVisible
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.ActivityAnimationBinding
import com.example.fitnessapp.presenter.ui.activity.main.MainActivity


class AnimationActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAnimationBinding
    private val handler = Handler()
    private lateinit var bigImageRunnable : Runnable
    private lateinit var smallImageRunnable : Runnable



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        anim()
        startImageRotation()
        start()
        setContentView(binding.root)

    }
    fun anim(){
        smallImageRunnable = Runnable {
            binding.ivIcon.setImageResource(R.drawable.icon_big_anim)
            handler.postDelayed(bigImageRunnable, 2000) // Switch to big image after 2 seconds
        }

        bigImageRunnable = Runnable {
            binding.ivIcon.setImageResource(R.drawable.icon_small_anim)
            handler.postDelayed(smallImageRunnable, 2000) // Switch b // ack to small image after 2 seconds
            binding.tvFit.isVisible = true
        }
    }
    private fun startImageRotation() {
        handler.postDelayed(smallImageRunnable, 2000) // Start with small image
    }

    private fun start() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 4300)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Remove callbacks to prevent memory leaks
        handler.removeCallbacks(smallImageRunnable)
        handler.removeCallbacks(bigImageRunnable)
    }
}