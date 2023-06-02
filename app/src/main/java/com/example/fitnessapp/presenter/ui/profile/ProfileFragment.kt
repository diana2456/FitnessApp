package com.example.fitnessapp.presenter.ui.profile

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.fitnessapp.presenter.util.Preferences
import com.example.fitnessapp.presenter.util.loadImage
import com.example.fitnessapp.R
import com.example.fitnessapp.databinding.FragmentProfileBinding
import com.google.android.material.button.MaterialButton


class ProfileFragment : Fragment() {
    private lateinit var preference: Preferences
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        DialogCustom()
        preference = Preferences(requireContext())
        initListener()
        return binding.root


    }
    private val mGetContent: ActivityResultLauncher<String> =
        registerForActivityResult(
            ActivityResultContracts.GetContent()// вместо байнд использую расширение глайда и сохраняю картинку
        ) { uri ->
            binding.ivAvatap.loadImage(uri.toString())
            Preferences(requireContext()).saveImageUri(uri.toString())
        }
    private fun initListener() {
        binding.ivAvatap.setOnClickListener {
            mGetContent.launch("image/*")
          binding.ivAvatap.loadImage(preference.getImageUri())
        }
    }

    @SuppressLint("MissingInflatedId")
    private fun DialogCustom() {
        binding.btn.setOnClickListener {
            val view = LayoutInflater.from(context).inflate(R.layout.alert_diolog, null)
            val builder = AlertDialog.Builder(context)
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(true)
            val btn = view.findViewById<MaterialButton>(R.id.btn_diolog)
            btn.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        binding.ivAvatap.loadImage(preference.getImageUri())
    }

    override fun onResume() {
        super.onResume()
        binding.ivAvatap.loadImage(preference.getImageUri())
    }
}
