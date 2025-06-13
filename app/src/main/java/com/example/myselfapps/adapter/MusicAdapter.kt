package com.example.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.databinding.ItemMusicBinding
import com.example.myselfapps.model.MusicData

class MusicAdapter(private val musicItems: List<MusicData>) :
    RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    private var focusedTitleTextView: TextView? = null

    inner class ViewHolder(val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = musicItems[position]
        holder.binding.musicThumbnail.setImageResource(item.albumArtResId)
        holder.binding.musicTitle.text = item.title
        holder.binding.musicArtist.text = item.artist

        holder.binding.musicTitle.isSelected = false
        holder.itemView.setOnLongClickListener {
            focusedTitleTextView?.isSelected = false
            holder.binding.musicTitle.isSelected = true
            focusedTitleTextView = holder.binding.musicTitle
            true
        }
    }

    override fun getItemCount(): Int {
        return musicItems.size
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.binding.musicTitle.isSelected = false
        if (holder.binding.musicTitle == focusedTitleTextView) {
            focusedTitleTextView = null
        }
    }
}