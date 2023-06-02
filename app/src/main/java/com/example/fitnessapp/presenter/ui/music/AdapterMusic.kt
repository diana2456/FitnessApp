package com.example.fitnessapp.presenter.ui.music

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.databinding.ItemMusicBinding

class AdapterMusic(private val onClick:(Int)->Unit): RecyclerView.Adapter<AdapterMusic.WarmHolder>() {

    private var taskList = arrayListOf<Music>()

    @SuppressLint("NotifyDataSetChanged")
    fun addTask(list: List<Music>) {
        taskList.clear()
        taskList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarmHolder {
        return WarmHolder(
            ItemMusicBinding.inflate(
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

    inner class WarmHolder(private val binding:ItemMusicBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(warm: Music) {
            binding.icon.setImageResource(warm.img)
            binding.tvDesc.text = warm.desc
            binding.tvTitle.text = warm.title
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }
    }
}
