package com.example.fitnessapp.presenter.ui.exercises

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.databinding.ItemExercisesBinding


class AdapterExercises(): RecyclerView.Adapter<AdapterExercises.WarmHolder>() {

    private var taskList = arrayListOf<Exercises>()

    @SuppressLint("NotifyDataSetChanged")
    fun addTask(list: List<Exercises>) {
        taskList.clear()
        taskList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarmHolder {
        return WarmHolder(
            ItemExercisesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WarmHolder, position: Int) {
        holder.bind(taskList[position])
    }


    override fun getItemCount(): Int = taskList.size

    inner class WarmHolder(private val binding:ItemExercisesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(warm: Exercises) {
           binding.ivGif.setImageResource(warm.img)
            binding.tvDesc.text = warm.desc
            binding.tvName.text = warm.title
            binding.tvQuantity.text = warm.number
        }
    }
}
