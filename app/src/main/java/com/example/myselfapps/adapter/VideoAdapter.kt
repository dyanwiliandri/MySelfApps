package com.example.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.databinding.ItemVideoBinding
import com.example.myselfapps.model.VideoData

class VideoAdapter(
    private val videoItems: List<VideoData>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = videoItems[position]
        holder.binding.videoThumbnail.setImageResource(item.thumbnailResId)
        holder.binding.videoTitle.text = item.title
        holder.binding.videoSubtitle.text = item.subtitle

        holder.itemView.setOnClickListener {
            onItemClick(item.youtubeUrl)
        }
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }
}