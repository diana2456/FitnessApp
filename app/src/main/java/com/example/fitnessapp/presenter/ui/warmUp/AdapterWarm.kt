package com.example.fitnessapp.presenter.ui.warmUp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.databinding.ItemTypesOfExercisesBinding

class AdapterWarm(private val onClick:(Int)-> Unit): RecyclerView.Adapter<AdapterWarm.WarmHolder>() {

    private var taskList = arrayListOf<Warm>()

    @SuppressLint("NotifyDataSetChanged")
    fun addTask(list: List<Warm>) {
        taskList.clear()
        taskList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarmHolder {
        return WarmHolder(
            ItemTypesOfExercisesBinding.inflate(
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

    inner class WarmHolder(private val binding:ItemTypesOfExercisesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(warm: Warm) {
            binding.ivImg.setImageResource(warm.img)
            binding.tvTitle.text = warm.title
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
        }
    }
}
