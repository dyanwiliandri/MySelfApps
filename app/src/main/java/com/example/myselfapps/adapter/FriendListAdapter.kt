package com.example.myselfapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myselfapps.databinding.ItemFriendBinding
import com.example.myselfapps.model.FriendData

class FriendListAdapter(private val friends: List<FriendData>,private val context: Context) :
    RecyclerView.Adapter<FriendListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemFriendBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = friends[position]
        Glide.with(context)
            .load(friend.imageResId)
            .circleCrop()
            .into(holder.binding.friendImage)
        holder.binding.friendName.text = friend.name
    }

    override fun getItemCount(): Int {
        return friends.size
    }
}