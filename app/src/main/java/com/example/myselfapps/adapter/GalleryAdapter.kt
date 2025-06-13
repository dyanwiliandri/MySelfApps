package com.example.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.databinding.ItemGalleryBinding
import com.example.myselfapps.model.GalleryData

class GalleryAdapter(private val galleryItems: List<GalleryData>) :
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = galleryItems[position]
        holder.binding.galleryImage.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int {
        return galleryItems.size
    }
}