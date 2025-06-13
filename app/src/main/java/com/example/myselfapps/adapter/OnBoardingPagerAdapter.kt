package com.example.myselfapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myselfapps.databinding.ViewPager1Binding

class OnBoardingPagerAdapter(private val onBoardingItems: List<OnboardingItem>):RecyclerView.Adapter<OnBoardingPagerAdapter.OnboardingViewHolder>() {

    data class OnboardingItem(
        val lottieRawResId: Int,
        val title: String,
        val description: String,
        val backgroundColor: Int? = null
    )

    inner class OnboardingViewHolder(val binding: ViewPager1Binding) : RecyclerView.ViewHolder(binding.root) {

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ViewPager1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnboardingViewHolder(binding)
    }


    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val currentItem = onBoardingItems[position]

        holder.binding.lottieAnim.setAnimation(currentItem.lottieRawResId)
        holder.binding.title.text = currentItem.title
        holder.binding.text.text = currentItem.description

        currentItem.backgroundColor?.let { color ->
            holder.binding.root.setBackgroundColor(color)
        }
        holder.binding.title.setTextColor(android.graphics.Color.WHITE)
        holder.binding.text.setTextColor(android.graphics.Color.WHITE)
    }

    override fun getItemCount(): Int {
        return onBoardingItems.size
    }
}