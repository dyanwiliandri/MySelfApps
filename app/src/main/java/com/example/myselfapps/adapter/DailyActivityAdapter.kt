package com.example.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.databinding.ItemDailyActivityBinding // Sesuaikan nama binding
import com.example.myselfapps.model.DailyData

class DailyActivityAdapter(private val activities: List<DailyData>) :
    RecyclerView.Adapter<DailyActivityAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDailyActivityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDailyActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]
        holder.binding.activityImage.setImageResource(activity.imageResId)
        holder.binding.activityTitle.text = activity.title
        holder.binding.activityTime.text = activity.time
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}